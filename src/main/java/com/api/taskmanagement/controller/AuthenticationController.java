package com.api.taskmanagement.controller;

import com.api.taskmanagement.controller.dto.auth.AuthenticationDataDTO;
import com.api.taskmanagement.controller.dto.auth.RegisterUserDTO;
import com.api.taskmanagement.controller.dto.auth.RegisterUserListDTO;
import com.api.taskmanagement.controller.dto.auth.TokenJwtDTO;
import com.api.taskmanagement.model.User;
import com.api.taskmanagement.service.AuthenticationService;
import com.api.taskmanagement.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final AuthenticationManager manager;
    private final AuthenticationService authService;
    private final TokenService tokenService;

    @Autowired
    public AuthenticationController(AuthenticationManager manager, TokenService tokenService, AuthenticationService authService) {
        this.manager = manager;
        this.tokenService = tokenService;
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenJwtDTO> login(@RequestBody @Valid AuthenticationDataDTO dto) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(dto.username(), dto.password());
        var authentication = manager.authenticate(token);
        var tokenJwt = tokenService.generateToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenJwtDTO(tokenJwt));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterUserListDTO> register(@RequestBody @Valid RegisterUserDTO dto, UriComponentsBuilder uriBuilder) {
        RegisterUserListDTO registeredUser = authService.register(dto);

        URI uri = uriBuilder.path("/api/auth/login").buildAndExpand().toUri();

        return ResponseEntity.created(uri).build();
    }
}
