package edu.mamontova.task9jwtimpl.auth;/*
  @author tanus
  @project task9-jwt-impl
  @class AuthenticationRequest
  @version 1.0.0
  @since 22.11.2025 - 22.52
*/


import lombok.Data;

@Data
public class AuthenticationRequest {
    private String email;
    private String password;
}
