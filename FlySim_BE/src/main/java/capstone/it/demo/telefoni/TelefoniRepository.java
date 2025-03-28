package capstone.it.demo.telefoni;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TelefoniRepository extends JpaRepository < Telefoni, Long> {

    public Optional<Telefoni> findById(Long id);
    public Telefoni findByNumeroSeriale(int numeroSeriale);
    public Telefoni findByMarca(String marca);
}
