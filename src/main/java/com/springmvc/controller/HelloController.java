package com.springmvc.controller;

import com.springmvc.demo.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Spring 2.5之后
 * 通过实现Controller接口来定义
 * User: jinchao.xu
 * Date: 14-12-17
 * Time: 下午3:51
 */
@Controller
public class HelloController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/hello")
    public ModelAndView hello() {
        //1、收集参数、验证参数
        //2、绑定参数到命令对象
        //3、将命令对象传入业务对象进行业务处理
        //4、选择下一个页面
        ModelAndView mv = new ModelAndView();
        //添加模型数据可以是任意的POJO对象
        mv.addObject("message", "Snell in Hello");
        //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
        mv.setViewName("home");
        return mv;
    }

    @RequestMapping(value="/validate/hello")
    public String validate(@Valid @ModelAttribute("user") UserModel user, Errors errors) {
        if(errors.hasErrors()) {
            return "validate/error";
        }
        return "redirect:/success";
    }

    /*当我们在一个功能处理方法上需要验证多个模型对象时，需要通过如下形式来获取验证结果：
    * 每一个模型对象后边都需要跟一个Errors或BindingResult对象来保存验证结果，其方法体内
    * 部可以使用这两个验证结果对象来选择出错时跳转的页面*/
    @RequestMapping("/validate/multi")
    public String multi(
            @Valid @ModelAttribute("a") UserModel a, BindingResult aErrors,
            @Valid @ModelAttribute("b") UserModel b, BindingResult bErrors) {
        if(aErrors.hasErrors()) { //如果a模型对象验证失败
            return "validate/error";
        }
        if(bErrors.hasErrors()) { //如果a模型对象验证失败
            return "validate/error";
        }
        return "redirect:/success";
    }
    /**
     * 在错误页面，需要针对不同的模型来显示错误消息：
     <form:form commandName="a">
     <form:errors path="*" cssStyle="color:red"></form:errors><br/>
     </form:form>
     <form:form commandName="b">
     <form:errors path="*" cssStyle="color:red"></form:errors><br/>
     </form:form>
     */
}
