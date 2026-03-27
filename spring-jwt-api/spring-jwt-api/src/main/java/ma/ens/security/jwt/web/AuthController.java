package ma.ens.security.jwt.web;

import ma.ens.security.jwt.jwt.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtil tokenService;

    public AuthController(AuthenticationManager authManager, JwtUtil tokenService) {
        this.authManager = authManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public Map<String, String> authenticate(@RequestBody Map<String, String> credentials) {

        String user = credentials.get("username");
        String pass = credentials.get("password");

        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(user, pass);

        authManager.authenticate(authToken);

        String jwt = tokenService.generateToken(user);

        Map<String, String> result = new LinkedHashMap<>();
        result.put("username", user);
        result.put("type", "Bearer");
        result.put("token", jwt);

        return result;
    }
}