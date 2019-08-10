package com.spring.boot.web;

import org.apache.catalina.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FileDownloadController {
	Logger log = LoggerFactory.getLogger(getClass());
private CacheManager cacheManager;
	@RequestMapping(value="/file_donload")
	public void test(@RequestParam("fileName")String fileName,HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		log.info("sesion id {} ",session.getId());
		URL url=Thread.currentThread().getContextClassLoader().getResource("file/"+fileName);
		File file=new File(url.getPath());
		try {
			downloadExistsFile(request,response,file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ;
//		return mqProperties.toString();
	}

	private void downloadExistsFile(HttpServletRequest request,
									HttpServletResponse response, File proposeFile) throws IOException,
			FileNotFoundException {
		HttpSession session=request.getSession();
		log.debug("下载文件路径：" + proposeFile.getPath());
		long fSize = proposeFile.length();
		// 下载
		response.setContentType("application/octet-stream");
		String isoFileName =proposeFile.getName();
		response.setHeader("Accept-Ranges", "bytes");
		response.setHeader("Content-Length", String.valueOf(fSize));
		response.setHeader("Content-Disposition", "attachment; filename="
				+ isoFileName);
		long pos = 0;
		int byteLength=0;
		if (null != request.getHeader("Range")) {
			// 断点续传
			response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
			try {
				String ranges[]=request.getHeader("Range").replaceAll("bytes=", "").split("-");
				pos = Long.parseLong(ranges[0]);
				byteLength = Integer.parseInt(ranges[1]);
			} catch (NumberFormatException e) {
				log.error(request.getHeader("Range") + " is not Number!");
				pos = 0;
			}
		}else{

			byteLength=1024;
		}


		ServletOutputStream out = response.getOutputStream();
		BufferedOutputStream bufferOut = new BufferedOutputStream(out);
		InputStream inputStream = new FileInputStream(proposeFile);
		String contentRange = new StringBuffer("bytes ").append(
				new Long(pos).toString()).append("-").append(
				new Long(byteLength-1).toString()).append("/").append(
				new Long(fSize).toString()).toString();
		response.setHeader("Content-Range", contentRange);
		log.debug("Content-Range", contentRange);
		inputStream.skip(pos);
		byte[] buffer = new byte[byteLength];
		int length = 0;
		while ((length = inputStream.read(buffer, 0, buffer.length)) != -1) {
			bufferOut.write(buffer, 0, length);
		}
		bufferOut.flush();
		bufferOut.close();
		out.close();
		inputStream.close();
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		Thread.currentThread().getContextClassLoader().getResourceAsStream("/resources/file/img.tar.gz");
		System.out.println(Thread.currentThread().getContextClassLoader().getResource("file/img.tar.gz"));;
		System.out.println(FileDownloadController.class.getResource("application.properties"));;
		URL url=Thread.currentThread().getContextClassLoader().getResource("file/rrrrr.zip");

		File file =new File(url.getPath());
		InputStream inputStream=new FileInputStream(file);
		byte[] buffer = new byte[5*1024*1024];
		int length = 0;
	int count=0;
	List<byte[]> li=new ArrayList();
		while ((length = inputStream.read(buffer, 0, buffer.length)) != -1) {
			System.out.println("length:"+length);
				byte [] b=new byte[length];
				li.add(b);
			System.out.println(" memory:"+Runtime.getRuntime().freeMemory());
			System.out.println("count:"+count++);
			Thread.sleep(200);
		//	bufferOut.write(buffer, 0, length);
		}

	}

}
