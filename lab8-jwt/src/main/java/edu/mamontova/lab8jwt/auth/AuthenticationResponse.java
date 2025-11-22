package edu.mamontova.lab8jwt.auth;/*
  @author tanus
  @project lab8-jwt
  @class AuthenticationResponse
  @version 1.0.0
  @since 22.11.2025 - 20.58
*/

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationResponse {
    private String token;
}
