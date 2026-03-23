package escuelaing.tdse.secure_app.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // Usuario de prueba (simula base de datos)
    private final String storedUser = "admin";
    private final String storedPasswordHash = encoder.encode("1234");

    public boolean authenticate(String username, String password) {
        return username.equals(storedUser) &&
               encoder.matches(password, storedPasswordHash);
    }
}
