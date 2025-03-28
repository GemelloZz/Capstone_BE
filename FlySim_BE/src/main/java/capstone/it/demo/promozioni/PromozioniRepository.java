package capstone.it.demo.promozioni;

import capstone.it.demo.auth.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PromozioniRepository extends JpaRepository<Promozioni, Long> {

    public Optional<Promozioni> findById(Long id);
    public Promozioni findByNome(String Nome);


}
