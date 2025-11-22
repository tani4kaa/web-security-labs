package edu.mamontova.lab8jwt.auth;/*
  @author tanus
  @project lab8-jwt
  @class AuthenticationController
  @version 1.0.0
  @since 22.11.2025 - 20.59
*/

import edu.mamontova.lab8jwt.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final JwtService jwtService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        String token = jwtService.generateToken(request.getEmail());

        return ResponseEntity.ok(new AuthenticationResponse(token));
    }
}
