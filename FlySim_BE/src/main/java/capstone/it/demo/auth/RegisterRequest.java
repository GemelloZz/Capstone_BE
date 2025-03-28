package capstone.it.demo.auth;

import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Set;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String telefonoLineaFissa;
    private String cap;
    private String telefono;
    private String Citta;
    private LocalDate dataDiNascita;
    private String indirizzo;
    private Set<Role> roles;
}
