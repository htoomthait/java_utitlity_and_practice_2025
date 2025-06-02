package info.htoomaungthait.ems_backend.controller;

import info.htoomaungthait.ems_backend.dto.AuthRequest;
import info.htoomaungthait.ems_backend.util.JwtUtil;
import info.htoomaungthait.ems_backend.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtil;

    private static final Logger logger = Logger.getLogger(AuthController.class.getName());




    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;


    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );


            String token = jwtUtil.generateToken(request.getUsername());
            logger.info("user login successful for user : " + request.getUsername());
            return  ResponseUtil.success(new AuthResponse(request.getUsername(), token));

        } catch (Exception e) {
            logger.warning(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }


    }
}

class AuthResponse {
    private String username;
    private String accessToken;

    public AuthResponse(String username, String accessToken) {
        this.username = username;
        this.accessToken = accessToken;
    }
    // getter


    public String getUsername() {
        return username;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
