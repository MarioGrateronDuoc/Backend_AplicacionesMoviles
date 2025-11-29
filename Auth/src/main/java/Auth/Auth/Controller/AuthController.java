package Auth.Auth.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String,String> body) {
        String username = body.get("username");
        String password = body.get("password");
        // Stub: validate credentials (replace with real logic)
        if ("user".equals(username) && "pass".equals(password)) {
            return ResponseEntity.ok(Map.of("token", "<fake-jwt-token>"));
        }
        return ResponseEntity.status(401).body(Map.of("error", "invalid_credentials"));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String,String> body) {
        // Stub: store user in user-service (call via REST) in real setup
        return ResponseEntity.ok(Map.of("status", "registered", "username", body.get("username")));
    }
}
