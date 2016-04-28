package com.springmvc.controller.old;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * AbstractController继承了WebContentGenerator 缓存控制功能，并提供了可选的会话
 * 串行化访问功能。而且提供了handleRequestInternal 方法，因此我们应该在具体的控制器类中实现
 * handleRequestInternal方法，而不再是handleRequest。
 * User: jinchao.xu
 * Date: 14-12-19
 * Time: 上午11:04
 */
public class HelloController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

//        response.getWriter().write("Hello world!");
        //如果想直接在该处理器/控制器写响应可以通过返回null告诉DispatcherServlet自己已经写出响应了，
//        不需要它进行视图解析

        //直接通过response写响应!
        //点击后再次请求当前页面
        response.getWriter().write("<a href=''>this</a>");
        return null;
    }

    //一个Controller就对应一个Request  太细碎
}
