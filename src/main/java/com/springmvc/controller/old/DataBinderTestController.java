package com.springmvc.controller.old;

import com.springmvc.demo.model.DataBinderTestModel;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 数据绑定
 * User: jinchao.xu
 * Date: 14-12-24
 * Time: 下午12:16
 */
public class DataBinderTestController extends AbstractCommandController {
    public DataBinderTestController() {
        setCommandClass(DataBinderTestModel.class); //设置命令对象
        setCommandName("dataBinderTest");//设置命令对象的名字
    }

    @Override
    protected ModelAndView handle(HttpServletRequest req, HttpServletResponse resp, Object
            command, BindException errors) throws Exception {
//输出command对象看看是否绑定正确
        System.out.println(command);
        return new ModelAndView("success").addObject("dataBinderTest",  command);
    }

   /*
    for test webdatabinder
    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
            throws Exception {
        super.initBinder(request, binder);
        //注册自定义的属性编辑器
        //1、日期
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        CustomDateEditor dateEditor = new CustomDateEditor(df, true);
        //表示如果命令对象有Date类型的属性，将使用该属性编辑器进行类型转换
        binder.registerCustomEditor(Date.class, dateEditor);
        //自定义的电话号码编辑器
        binder.registerCustomEditor(PhoneNumberModel.class, new PhoneNumberEditor());
    }*/


}
