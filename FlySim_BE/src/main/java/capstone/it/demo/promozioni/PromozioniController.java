package capstone.it.demo.promozioni;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/promozioni")
@RequiredArgsConstructor
public class PromozioniController {

    private final PromozioniService promozioniService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Promozioni> getAllPromozioni() {
        return promozioniService.getAllPromozioni();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Optional<Promozioni>> getPromozioniById(@PathVariable Long id) {
        return Optional.ofNullable(promozioniService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Promozioni createPromozioni(@RequestBody Promozioni promozioni) {
        return promozioniService.createPromozioni(promozioni);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePromozioni(@PathVariable Long id) {
        promozioniService.deletePromozioni(id);
    }





}
