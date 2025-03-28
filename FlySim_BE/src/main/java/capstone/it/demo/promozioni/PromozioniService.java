package capstone.it.demo.promozioni;

import capstone.it.demo.auth.AppUser;
import capstone.it.demo.auth.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import capstone.it.demo.dto.PromozioneClienteDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PromozioniService {
    private final AppUserRepository appUserRepository;
    private final PromozioniRepository promozioniRepository;

    public Iterable<Promozioni> getAllPromozioni() {
        Iterable<Promozioni> promozioni = promozioniRepository.findAll();
        return promozioni;
    }

    public Optional<Promozioni> findById(Long id) {
        return promozioniRepository.findById(id);
    }



    public Promozioni createPromozioni(Promozioni promozioni) {
        return promozioniRepository.save(promozioni);
    }

    public void deletePromozioni(Long id) {
        promozioniRepository.deleteById((long) Math.toIntExact(id));
    }


    public void updatePromozione(Long id, Promozioni promozione) {
        promozioniRepository.save(promozione);
    }


}
