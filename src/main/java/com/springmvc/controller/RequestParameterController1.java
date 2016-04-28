package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * Spring 3.1版本之前
 */
@Controller
@RequestMapping("/parameter1") //①处理器的通用映射前缀
public class RequestParameterController1 {
    //②进行类级别的@RequestMapping窄化
    //表示请求中有“create”的参数名且请求方法为“GET”即可匹配，如可匹配的请求URL“http://×××/parameter1?create”；
    @RequestMapping(params = "create", method = RequestMethod.GET)
    public String showForm() {
        System.out.println("===============showForm");
        return "parameter/create";
    }

    /**
     * //请求参数不包含 create参数名
     @RequestMapping(params="!create", method=RequestMethod.GET)//进行类级别的@RequestMapping窄化
     * @return
     */
    //③进行类级别的@RequestMapping窄化
    @RequestMapping(params = "create", method = RequestMethod.POST)
    public String submit() {
        System.out.println("================submit");
        return "redirect:/success";
    }

    //=========================请求数据中指定参数名=值===========================

    /**
     * //请求参数submitFlag 不等于 create
     @RequestMapping(params="submitFlag!=create", method=RequestMethod.GET)
     * @return
     */
    //②进行类级别的@RequestMapping窄化
    @RequestMapping(params="submitFlag=create", method=RequestMethod.GET)
    public String showForm2() {
        System.out.println("===============showForm");
        return "parameter/create";
    }
    //③进行类级别的@RequestMapping窄化
    @RequestMapping(params="submitFlag=create", method=RequestMethod.POST)
    public String submit2() {
        System.out.println("===============submit");
        return "redirect:/success";
    }

    //@RequestMapping(params={"test1", "test2=create"}) 组合使用是“且”的关系!!
    //@RequestMapping(value="/header/test4", headers = "Accept=application/json")：表示请求的URL必须为
//    “/header/test4” 且 请求头中必须有“Accept =application/json”参数即可匹配



    @RequestMapping(value = "/request/ContentType", method = RequestMethod.POST,
            headers = "Content-Type=application/json")
    public String request2(HttpServletRequest request) throws IOException {
        //①表示请求的内容区数据为json数据
        InputStream is = request.getInputStream();
        byte bytes[] = new byte[request.getContentLength()];
        is.read(bytes);
        //②得到请求中的内容区数据（以CharacterEncoding解码）
        //此处得到数据后你可以通过如json-lib转换为其他对象
        String jsonStr = new String(bytes, request.getCharacterEncoding());
        System.out.println("json data：" + jsonStr);
        return "success";
    }


    //    响应头的内容类型，表示发送到客户端的内容数据类型，和请求头的内容类型类似，只是方向相反。
    @RequestMapping("/response/ContentType")
    public void response1(HttpServletResponse response) throws IOException {
        //①表示响应的内容区数据的媒体类型为html格式，且编码为utf-8(客户端应该以utf-8解码)
        response.setContentType("text/html;charset=utf-8");
        //②写出响应体内容
        response.getWriter().write("<font style='color:red'>hello</font>");
    }


    @RequestMapping(value = "/response/ContentType", headers = "Accept=application/json")
    public void response2(HttpServletResponse response) throws IOException {
        //①表示响应的内容区数据的媒体类型为json格式，且编码为utf-8(客户端应该以utf-8解码)
        response.setContentType("application/json;charset=utf-8");
        //②写出响应体内容
        String jsonData = "{\"username\":\"zhang\", \"password\":\"123\"}";
        response.getWriter().write(jsonData);
    }

    @RequestMapping(value = "/response/ContentType", headers = "Accept=application/xml")
    public void response3(HttpServletResponse response) throws IOException {
        //①表示响应的内容区数据的媒体类型为xml格式，且编码为utf-8(客户端应该以utf-8解码)
        response.setContentType("application/xml;charset=utf-8");
        //②写出响应体内容
        String xmlData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        xmlData += "<user><username>zhang</username><password>123</password></user>";
        response.getWriter().write(xmlData);
    }
}