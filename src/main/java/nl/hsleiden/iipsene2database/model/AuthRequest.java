package nl.hsleiden.iipsene2database.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AuthRequest {
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @NotBlank
    @Size(max = 120)
    private String password;

    public AuthRequest() {

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
