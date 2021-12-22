package nl.hsleiden.iipsene3database.controller;

import nl.hsleiden.iipsene3database.model.AuthRequest;
import nl.hsleiden.iipsene3database.security.JwtUtil;
import nl.hsleiden.iipsene3database.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Takes care of mapping request data to the defined request handler method.
 * @author Vincent Severin, Hicham El Faquir, Ryan Bhola, Bruno Seriese
 */
@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthService authService;

    /**
     * Creates a JWT for the user and returns it.
     * Login / JWT is needed to do anything else than GET requests.
     * @param authRequest Contains email and password.
     * @return The JWT for that session.
     * @throws Exception Throws Exception if the login details are wrong.
     * @author Vincent Severin, Hicham El Faquir, Ryan Bhola, Bruno Seriese
     */
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<String> login(@Valid @RequestBody AuthRequest authRequest) throws Exception {
        authService.authenticate(authRequest.getEmail(), authRequest.getPassword());
        return new ResponseEntity<>(jwtUtil.generateToken(authRequest.getEmail()), HttpStatus.OK);
    }
}
