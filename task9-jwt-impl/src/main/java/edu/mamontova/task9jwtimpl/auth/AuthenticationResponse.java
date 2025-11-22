package edu.mamontova.task9jwtimpl.auth;/*
  @author tanus
  @project task9-jwt-impl
  @class AuthenticationResponse
  @version 1.0.0
  @since 22.11.2025 - 22.52
*/


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationResponse {
    private String token;
}
