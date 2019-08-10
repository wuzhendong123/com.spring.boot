package com.spring.boot.web;

import com.spring.boot.web.respone.R;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-06-02 16:33
 **/
@Controller
@RequestMapping("/bulid")
public class BulidController {
    @RequestMapping(value="/bulid")
    public String upload(HttpServletRequest request) throws IOException {

        return  "tool/build";
    }

}
