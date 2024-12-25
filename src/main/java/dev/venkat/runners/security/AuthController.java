package dev.venkat.runners.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private static Logger logger = LoggerFactory.getLogger(AuthController.class.getName());

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO user) throws Exception {
        UserDTO createdUser = userService.create(new UserDTO(null, user.username(), user.password()));
        logger.info("User {}, {}, {} registered successfully", createdUser.id(), createdUser.username(), createdUser.password());
        return ResponseEntity.ok().body("User registered successfully. You can login now with valid credentials to get the token.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> createToken(@RequestBody UserDTO user) throws Exception {
        logger.info("User {} logging in...", user.username());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.username(), user.password()));
        logger.info("User {} logged in successfully", user.username());
        return ResponseEntity.ok().body(jwtUtil.generateToken(user.username()));
    }
}