package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ①处理器的通用映射前缀（父路径）：表示该处理器只处理匹配“/customers/**”的请求；
 * ②对类级别的@RequestMapping进行窄化，表示showForm可处理匹配“/customers/** /create”且请求方法为
 *“GET”的请求；
 * ③对类级别的@RequestMapping进行窄化，表示submit可处理匹配“/customers/** /create”且请求方法为“POST”的请求。
 */
@Controller
@RequestMapping("/customers/**") //①处理器的通用映射前缀
public class RequestMethodController {
    @RequestMapping(value = "/create", method = RequestMethod.GET)//②类级别的@RequestMapping窄化
    public String showForm() {
        System.out.println("===============GET");
        return "customer/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    //③类级别的@RequestMapping窄化

    public String submit() {
        System.out.println("================POST");
        return "redirect:/success";
    }
}