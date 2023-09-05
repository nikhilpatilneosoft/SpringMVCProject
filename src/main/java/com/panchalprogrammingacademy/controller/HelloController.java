package com.panchalprogrammingacademy.controller;


import com.panchalprogrammingacademy.Model.User;
import com.panchalprogrammingacademy.service.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@NoArgsConstructor
public class HelloController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/registerUser", method = RequestMethod.GET)
    public String register(){
        return "registerUser";
    }

    @RequestMapping(value = "/savedUser", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user){
        userService.createUser(user);
        System.out.println("this is my saved user");
        return "success";
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public String getUser(@ModelAttribute User user){
        System.out.println(user.getId());
        User user1 = userService.getUserById(user.getId());
        System.out.println(user1);
        return "success";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute User user){
        User updateUser = userService.updateUser(user);
        System.out.println(updateUser);
        return "success";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public String deleteUser(@RequestParam Integer id){
        System.out.println("delete user called" + id);
        userService.deleteUser(id);
        System.out.println("User deleted succesfully.");
        return "success";
    }
}