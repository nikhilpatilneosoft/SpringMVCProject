package com.panchalprogrammingacademy;

import Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.UserService;
import org.springframework.jdbc.core.JdbcTemplate;

@Controller
public class HelloController {

    private final UserService userService;

    public HelloController() {
        this.userService = new UserService(new JdbcTemplate());
    }

    @RequestMapping(value = "/hello_world", method = RequestMethod.GET)
    public String printHelloWorld(ModelMap modelMap){

        // add attribute to load modelMap
        modelMap.addAttribute("message",
                "Hello World and Welcome to Spring MVC!");

        // return the name of the file to be loaded "hello_world.jsp"
        return "hello_world";
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.GET)
    public String register(){
        return "registerUser";
    }

    @RequestMapping(value = "/savedUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user){
        //userService.insertData(user);
        System.out.println("this is my saved user");
        return "success";
    }
}