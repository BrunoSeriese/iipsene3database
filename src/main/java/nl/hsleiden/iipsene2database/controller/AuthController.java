package nl.hsleiden.iipsene2database.controller;

import nl.hsleiden.iipsene2database.model.AuthRequest;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
            );
        } catch (Exception exception) {
            throw new Exception("invalid user");
        }
/*        return jwtUtil.generateToken(authRequest.getEmail());*/
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @PostMapping("/test")
    public ResponseEntity<String> test(@RequestBody String name) {
        return new ResponseEntity<>("Hello" + name, HttpStatus.OK);
    }
}
