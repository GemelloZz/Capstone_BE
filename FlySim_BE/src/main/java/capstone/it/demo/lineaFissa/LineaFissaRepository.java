package capstone.it.demo.lineaFissa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LineaFissaRepository extends JpaRepository<LineaFissa, Long> {
    public LineaFissa findByNumero(int numero);
}
