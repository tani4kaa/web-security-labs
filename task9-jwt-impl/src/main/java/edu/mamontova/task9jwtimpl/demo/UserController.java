package edu.mamontova.task9jwtimpl.demo;/*
  @author tanus
  @project task9-jwt-impl
  @class UserController
  @version 1.0.0
  @since 22.11.2025 - 22.53
*/


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @GetMapping("/hello")
    public String userHello() {
        return "Hello, USER!";
    }
}
