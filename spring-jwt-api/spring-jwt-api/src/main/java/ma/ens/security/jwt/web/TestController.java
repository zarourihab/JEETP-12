package ma.ens.security.jwt.web;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/user")
    public String user() {
        return "Hello USER";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Hello ADMIN";
    }
}
