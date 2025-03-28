package capstone.it.demo.promozioniLineaFissa;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/promozioniLineaFissa")
@RequiredArgsConstructor
public class PromozioniLineaFissaController {

    private final PromozioniLineaFissaService promozioniLineaFissaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<PromozioniLineaFissa> getAllPromozioniLineaFissa() {
        return promozioniLineaFissaService.getAllPromozioniLineaFissa();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<PromozioniLineaFissa> getPromozioniLineaFissaById(@PathVariable Long id) {
        return promozioniLineaFissaService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PromozioniLineaFissa createPromozioniLineaFissa(@RequestBody PromozioniLineaFissa promozioniLineaFissa) {
        return promozioniLineaFissaService.createPromozioniLineaFissa(promozioniLineaFissa);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePromozioniLineaFissa(@PathVariable Long id) {
        promozioniLineaFissaService.deletePromozioniLineaFissa(id);
    }

}
