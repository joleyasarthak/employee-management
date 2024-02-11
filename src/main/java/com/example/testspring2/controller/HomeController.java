package com.example.testspring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

//    @GetMapping("/user")
//    public User getUser(){
//        User user = new User();
//        user.setId("1");
//        user.setName("Sarthak");
//        user.setEmailId("sarthakjoleya@gmail.com");
//        return user;
//    }
//
//    @GetMapping("/clicked")
////    @ResponseBody
//    public String clicked(){
//        return "<h1>Hello World!</h1>";
//    }
//
//    @GetMapping("/{id}")
//    public String pathVariable(@PathVariable String id){
//        return "The Path Variable is: " + id;
//    }
//
//    @GetMapping("/req")
//    public String reqParams(@RequestParam() String name, @RequestParam(name = "email",
//            required = false, defaultValue = "") String emailId){
//        return "Hi " + name + ". Your Email is: " + emailId;
//    }
}
