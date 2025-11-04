package edu.mamontova.task4_csrf;/*
  @author tanus
  @project task4_CSRF
  @class CsrfController
  @version 1.0.0
  @since 04.11.2025 - 21.55
*/


import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsrfController {

    @GetMapping("/csrf")
    public CsrfToken csrf(CsrfToken token) {
       
        return token; // заодно поверне JSON з полем "token" — зручно для Postman
    }
}
