package capstone.it.demo.promozioniLineaFissa;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PromozioniLineaFissaService {

    private final PromozioniLineaFissaRepository promozioniLineaFissaRepository;

    public List<PromozioniLineaFissa> getAllPromozioniLineaFissa() {
        List<PromozioniLineaFissa> promozioniLineaFissa= promozioniLineaFissaRepository.findAll();
        return promozioniLineaFissa;
    }

    public Optional<PromozioniLineaFissa> findById(Long id) {
        Optional<PromozioniLineaFissa> promozioniLineaFissa = promozioniLineaFissaRepository.findById(id);
        return promozioniLineaFissa;
    }

    public PromozioniLineaFissa createPromozioniLineaFissa(PromozioniLineaFissa promozioniLineaFissa) {
        return promozioniLineaFissaRepository.save(promozioniLineaFissa);
    }

    public void deletePromozioniLineaFissa(Long id) {
        promozioniLineaFissaRepository.deleteById(id);
    }
}

