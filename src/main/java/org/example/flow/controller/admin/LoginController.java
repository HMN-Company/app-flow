package org.example.flow.controller.admin;


import org.example.flow.services.impl.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserDetailService userDetailService;

    @GetMapping()
    public String login() {
        return "admin/login";
    }





}
