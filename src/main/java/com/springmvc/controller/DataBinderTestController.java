package com.springmvc.controller;

import com.springmvc.demo.PhoneNumber;
import com.springmvc.demo.model.DataBinderTestModel;
import com.springmvc.demo.model.FormatterModel;
import com.springmvc.demo.model.PhoneNumberModel;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * Created by xujinchao on 2016/4/12.
 */
@Controller
public class DataBinderTestController {

    @RequestMapping(value = "/dataBind")
    public String test(DataBinderTestModel command) {

        //输出command对象看看是否绑定正确
        System.out.println(command);
//        model.addAttribute("dataBinderTest", command);
        return "bind/success";
    }

    /*模型对象字段的数据解析/格式化*/
    @RequestMapping(value = "/format1")
    public String test1(@ModelAttribute("model") FormatterModel formatModel) {
        return "format1";
    }

    /*功能处理方法参数级别的数据解析：*/
    @RequestMapping(value = "/format2")
    public String test2(
            @PhoneNumber @RequestParam("phoneNumber") PhoneNumberModel phoneNumber,
            @DateTimeFormat(pattern="yyyy-MM-dd") @RequestParam("date") Date date) {
        System.out.println(phoneNumber);
        System.out.println(date);
        return "format2";
    }
}
