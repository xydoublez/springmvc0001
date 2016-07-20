package com.springapp.mvc;

import com.springapp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 第二个控制器即处理器
 * 1)处理器一定要添加注释@Controller
 * 2)若映射为GET方法，但方法没有@ResponseBody注解，则会报404错误
 * 3）若报406错误，则是因为jackson相关包没有引入
 */
@Controller
@RequestMapping("/test")
public class Hello2Controller {

    @RequestMapping(method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public User GetMethod(){
        User user = new User();
        user.setName("李志强");
        user.setSex("男");
        user.setAge(26);
        return user;

    }
}
