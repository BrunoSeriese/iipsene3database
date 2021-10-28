package nl.hsleiden.iipsene2database.controller;

import nl.hsleiden.iipsene2database.model.AuthRequest;
import nl.hsleiden.iipsene2database.security.JwtUtil;
import nl.hsleiden.iipsene2database.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<String> login(@Valid @RequestBody AuthRequest authRequest) throws Exception {
        authService.authenticate(authRequest.getEmail(), authRequest.getPassword());
        return new ResponseEntity<>(jwtUtil.generateToken(authRequest.getEmail()), HttpStatus.OK);
    }
}
