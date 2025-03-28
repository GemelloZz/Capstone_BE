package capstone.it.demo.lineaFissa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class   LineaFissaService {

    private final LineaFissaRepository lineaFissaRepository;

    public List<LineaFissa> getAllLineaFissa() {
        List<LineaFissa> lineaFissa = lineaFissaRepository.findAll();
        return lineaFissa;
    }

    public Optional<LineaFissa> findById(Long id) {
        Optional<LineaFissa> lineaFissa = lineaFissaRepository.findById(id);
        return lineaFissa;
    }

    public LineaFissa createLineaFissa(LineaFissa lineaFissa) {

        return lineaFissaRepository.save(lineaFissa);
    }

    public void deleteLineaFissa(Long id) {
        lineaFissaRepository.deleteById(id);
    }
}
