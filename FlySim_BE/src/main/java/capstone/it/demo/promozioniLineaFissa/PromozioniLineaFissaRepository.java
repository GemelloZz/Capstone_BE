package capstone.it.demo.promozioniLineaFissa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PromozioniLineaFissaRepository extends JpaRepository<PromozioniLineaFissa, Long> {

    public PromozioniLineaFissa findByNome(String Nome);
    public Optional<PromozioniLineaFissa> findById(Long id);
}
