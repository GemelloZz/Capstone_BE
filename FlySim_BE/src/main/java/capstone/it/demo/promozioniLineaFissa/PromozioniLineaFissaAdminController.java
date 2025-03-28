package capstone.it.demo.promozioniLineaFissa;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/promozioniLineaFissa")
@RequiredArgsConstructor
public class PromozioniLineaFissaAdminController {

    private final PromozioniLineaFissaService promozioniLineaFissaService;

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deletePromozioniLineaFissa(@PathVariable Long id) {
        try {
            promozioniLineaFissaService.deletePromozioniLineaFissa(id);
            return ResponseEntity.ok("Promozione linea fissa eliminata con successo");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Errore nell'eliminare la promozione linea fissa: " + e.getMessage());
        }
    }



    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> addPromozioneLineaFissa(
            @RequestBody PromozioniLineaFissa promozioneLineaFissa) {
        try {
            promozioniLineaFissaService.createPromozioniLineaFissa(promozioneLineaFissa);
            return ResponseEntity.ok("Promozione linea fissa aggiunta con successo");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Errore nell'aggiungere la promozione linea fissa: " + e.getMessage());
        }
    }
}