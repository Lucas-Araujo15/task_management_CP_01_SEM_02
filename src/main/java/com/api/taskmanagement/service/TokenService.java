package com.api.taskmanagement.service;

import com.api.taskmanagement.model.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class TokenService {
    private String passwordToken;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(passwordToken);
            return JWT.create()
                    .withIssuer("API FIAP")
                    .withSubject(user.getUsername())
                    .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao gerar o token");
        }
    }

    public String getSubject(String tokenJwt) {
        Algorithm algorithm = Algorithm.HMAC256(passwordToken);

        return JWT.require(algorithm)
                .withIssuer("API FIAP")
                .build()
                .verify(tokenJwt)
                .getSubject();
    }
}
