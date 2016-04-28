package com.springmvc.controller.user;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xujinchao on 2015/11/3.
 */

public class LoginController implements Controller {




    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("passward");

        ModelAndView mv = new ModelAndView();
        //添加模型数据可以是任意的POJO对象
        mv.addObject("message", "Login Success!" + username + ", with " + password);

        //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
        mv.setViewName("success");
        return mv;
    }
}
