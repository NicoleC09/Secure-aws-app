package escuelaing.tdse.secure_app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import escuelaing.tdse.secure_app.model.User;
import escuelaing.tdse.secure_app.service.AuthService;

@RestController
@CrossOrigin(origins = "*" )
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        if (authService.authenticate(user.getUsername(), user.getPassword())) {
            return "Login successful ✅";
        } else {
            return "Invalid credentials ❌";
        }
    }
}
