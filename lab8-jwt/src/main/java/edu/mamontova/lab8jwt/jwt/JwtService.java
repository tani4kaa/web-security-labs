package edu.mamontova.lab8jwt.jwt;/*
  @author tanus
  @project lab8-jwt
  @class JwtService
  @version 1.0.0
  @since 22.11.2025 - 20.58
*/

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JwtService {

    private static final String SECRET_KEY =
            "my-super-secret-key-my-super-secret-key-1234567890abcd";


    private Key getSigningKey() {
        byte[] keyBytes = SECRET_KEY.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String email) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("fullName", "John Lennon");
        claims.put("authorities", List.of("USER"));

        long now = System.currentTimeMillis();

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + 1000 * 60 * 60))
                .signWith(getSigningKey(), SignatureAlgorithm.HS384)
                .compact();
    }
}
