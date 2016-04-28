package com.springmvc.controller;

import com.springmvc.controller.support.validator.UserModelValidator;
import com.springmvc.demo.model.UserModel;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by xujinchao on 2016/4/26.
 */
public class RegisterSimpleFormController {

    private UserModelValidator validator = new UserModelValidator();

    @ModelAttribute("user") //① 暴露表单引用对象为模型数据
    public UserModel getUser() {
        return new UserModel();
    }

    @RequestMapping(value = "/validator", method = RequestMethod.GET)
    public String showRegisterForm() { //② 表单展示
        return "validate/registerAndValidator";
    }

    @RequestMapping(value = "/validator", method = RequestMethod.POST)
    public String submitForm(
            @ModelAttribute("user") UserModel user,
            Errors errors) { //③ 表单提交
        validator.validate(user, errors); //1 调用UserModelValidator的validate方法进行        验证
        if (errors.hasErrors()) { //2如果有错误再回到表单展示页面
            return showRegisterForm();
        }

        return "redirect:/success";
    }
}
