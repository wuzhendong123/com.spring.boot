package com.spring.boot.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.TempBatch;
import com.spring.boot.mapper.TempBatchMapper;
import com.spring.boot.service.TempBatchService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 临时批次 服务实现类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-24
 */
@Service
public class TempBatchServiceImpl extends ServiceImpl<TempBatchMapper, TempBatch> implements TempBatchService {
        @Override
        public Page<TempBatch> selectPageByTempBatch(Page<TempBatch> pagePg, TempBatch obj) {
        pagePg.setRecords( this.baseMapper.selectPageByTempBatch(pagePg,obj));
        return pagePg;
        }

        @Override
        public void createTempByRequest(HttpServletRequest request) throws IOException {
                //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
                CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                        request.getSession().getServletContext());
                //检查form中是否有enctype="multipart/form-data"
                if(multipartResolver.isMultipart(request)){
                        //将request变成多部分request
                        MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
                        //获取multiRequest 中所有的文件名
                        Iterator iter=multiRequest.getFileNames();
                        while(iter.hasNext()){
                                //一次遍历所有文件
                                String key=iter.next().toString();
                                MultipartFile file=multiRequest.getFile(key);
                                if(file!=null){
                                        createTempByInputStream(file.getInputStream(),request.getParameter("batchNo") );
                                }

                        }

                }
        }
        public void createTempByInputStream(InputStream inputStream,String batchNo) throws IOException {
                BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
                List<TempBatch> li=new LinkedList<TempBatch>();

                       String str=null;
                       while((str=br.readLine())!=null&&!"".equals(str)){
                           TempBatch tempBatch=new TempBatch();
                           tempBatch.setBacthNo(batchNo);
                           tempBatch.setMark(str);
                           li.add(tempBatch);
                       }


               this.insertBatch(li,10000);

        }
}
