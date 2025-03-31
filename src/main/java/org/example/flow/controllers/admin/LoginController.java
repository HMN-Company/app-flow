package org.example.flow.controllers.admin;


import org.example.flow.services.impl.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {


    private final UserDetailService userDetailService;

    public LoginController(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @GetMapping("")
    public String login() {
        return "admin/login";
    }





}
