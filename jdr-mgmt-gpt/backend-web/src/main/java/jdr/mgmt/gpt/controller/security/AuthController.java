package jdr.mgmt.gpt.controller.security;

import jdr.mgmt.be.common.model.JwtToken;
import jdr.mgmt.gpt.be.security.service.CustomUserDetailsService;
import jdr.mgmt.gpt.be.security.service.JwtTokenService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthenticationManager manager;
    private final JwtTokenService jwtService;
    private CustomUserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<JwtToken> login(@RequestBody User authRequest) {
        manager.authenticate(new UsernamePasswordAuthenticationToken(
                authRequest.getUsername(), authRequest.getPassword()));

        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        String accessToken = jwtService.generateAccessToken(userDetails.getUsername(), new HashMap<>());
        String refreshToken = jwtService.generateRefreshToken(userDetails.getUsername());

        return ResponseEntity.ok(new JwtToken(accessToken, refreshToken));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtToken> refresh(@RequestBody JwtToken refrestRequest) {
        String username = jwtService.extractUsername(refrestRequest.getRefreshToken());

        if (!jwtService.isTokenValid(refrestRequest.getRefreshToken(), username)) {
            return ResponseEntity.status(403).build();
        }

        String newAccessToken = jwtService.generateAccessToken(username, new HashMap<>());

        return ResponseEntity.ok(new JwtToken(newAccessToken, refrestRequest.getRefreshToken()));
    }
}