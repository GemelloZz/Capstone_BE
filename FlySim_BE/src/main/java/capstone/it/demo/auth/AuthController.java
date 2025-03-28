package capstone.it.demo.auth;

import capstone.it.demo.dto.PromozioneClienteDTO;
import capstone.it.demo.promozioni.Promozioni;
import capstone.it.demo.promozioni.PromozioniRepository;
import capstone.it.demo.promozioni.PromozioniService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AppUserService appUserService;
    private final PromozioniService promozioniService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        appUserService.registerUser(registerRequest.getUsername(), registerRequest.getPassword(), registerRequest.getFirstName(), registerRequest.getLastName(), registerRequest.getEmail(), registerRequest.getTelefonoLineaFissa(), registerRequest.getCap(), registerRequest.getTelefono(), registerRequest.getCitta(), registerRequest.getIndirizzo(), registerRequest.getRoles() != null ? registerRequest.getRoles() : Set.of(Role.ROLE_USER));
        return ResponseEntity.ok("Registrazione avvenuta con successo");
    }


    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        String token = appUserService.authenticateUser(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        );
        return ResponseEntity.ok(new AuthResponse(token));
    }
    @PostMapping("/createAdmin")
    public ResponseEntity<String> createAdmin(@RequestBody RegisterRequest registerRequest) {
        // Creazione manuale di un amministratore
        Set<Role> roles = Set.of(Role.ROLE_ADMIN);

        appUserService.registerUser(
                registerRequest.getUsername(),
                registerRequest.getPassword(),
                registerRequest.getFirstName(),
                registerRequest.getLastName(),
                registerRequest.getEmail(),
                registerRequest.getTelefonoLineaFissa(),
                registerRequest.getCap(),
                registerRequest.getTelefono(),
                registerRequest.getCitta(),
                registerRequest.getIndirizzo(),
                roles
        );

        return ResponseEntity.ok("Admin creato con successo");
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<PromozioneClienteDTO> getUserById(@PathVariable String username) {
        AppUser user = appUserService.findByUsername(username);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }


        PromozioneClienteDTO userDTO = new PromozioneClienteDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getTelefono(),
                user.getTelefonoLineaFissa(),
                user.getCittà(),
                user.getDataDiNascita(),
                user.getIndirizzo(),
                user.getAvatar(),
                user.getPromozioni(),
                user.getTelefoni(),
                user.getPromozioniLineaFissa()


        );

        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/user/{username}/promozioni/{promozioneId}")
    public ResponseEntity<String> addPromozioneToUser(@PathVariable String username, @PathVariable Long promozioneId) {
        try {
            appUserService.addPromozioneToUser(username, promozioneId);
            return ResponseEntity.ok("Promozione aggiunta con successo all'utente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Errore durante l'aggiunta della promozione e del telefono : " + e.getMessage());
        }
    }


    @PostMapping("/user/{username}/telefoni/{telefonoId}")
    public ResponseEntity<String> addTelefonoToUser(@PathVariable String username, @PathVariable Long telefonoId) {
        try {
            appUserService.addTelefoniToUser(username, telefonoId);
            return ResponseEntity.ok("Telefono aggiunto con successo all'utente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Errore durante l'aggiunta della promozione e del telefono : " + e.getMessage());
        }


    }
    @PostMapping ("/user/{username}/promozioniLineaFissa/{promozioneLineaFissaId}")
    public ResponseEntity<String> addPromozioniLineaFissaToUser(@PathVariable String username, @PathVariable Long promozioneLineaFissaId) {
        try {
            appUserService.addPromozioniLineaFissaToUser(username, promozioneLineaFissaId);
            return ResponseEntity.ok("Promozione aggiunta con successo all'utente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Errore durante l'aggiunta della promozione e del telefono : " + e.getMessage());
        }
    }

    @DeleteMapping("/user/{username}/promozioni/{promozioneId}")
    public ResponseEntity<String> removePromozioneFromUser(@PathVariable String username, @PathVariable Long promozioneId) {
        try {
            appUserService.removePromozioneFromUser(username, promozioneId);
            return ResponseEntity.ok("Promozione rimossa con successo dall'utente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Errore durante la rimozione della promozione e del telefono : " + e.getMessage());
        }
    }

    @DeleteMapping("/user/{username}/promozioniLineaFissa/{promozioneLineaFissaId}")
    public ResponseEntity<String> removePromozioniLineaFissaFromUser(@PathVariable String username, @PathVariable Long promozioneLineaFissaId) {
        try {
            appUserService.removePromozioniLineaFissaFromUser(username, promozioneLineaFissaId);
            return ResponseEntity.ok("Promozione rimossa con successo dall'utente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Errore durante la rimozione della promozione e del telefono : " + e.getMessage());
    }
    }

}















