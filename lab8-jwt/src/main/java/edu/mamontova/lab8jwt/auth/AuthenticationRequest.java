package edu.mamontova.lab8jwt.auth;/*
  @author tanus
  @project lab8-jwt
  @class AuthenticationRequest
  @version 1.0.0
  @since 22.11.2025 - 20.57
*/

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String email;
    private String password;
}