package ucsal.ted_auth_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucsal.ted_auth_service.model.Role;
import ucsal.ted_auth_service.service.AuthService;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody RegisterRequest request) {
        String token = service.register(request.nome(), request.email(), request.senha(), request.role());
        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest request) {
        String token = service.login(request.email(), request.senha());
        return ResponseEntity.ok(Map.of("token", token));
    }

    public record RegisterRequest(String nome, String email, String senha, Role role) {}
    public record LoginRequest(String email, String senha) {}
}