package capstone.it.demo.telefoni;

import com.cloudinary.Cloudinary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TelefoniService {
    private final TelefoniRepository telefoniRepository;
    private final Cloudinary cloudinary;



    public Iterable<Telefoni> getAllTelefoni() {
        Iterable<Telefoni> telefoni = telefoniRepository.findAll();
        return telefoni;
    }

    public Optional<Telefoni> findById(Long id) {
        Optional<Telefoni> telefoni = telefoniRepository.findById(id);
        return telefoni;
    }





    public void deleteTelefoni(Long id) {
        telefoniRepository.deleteById(id);
    }

    public Telefoni createTelefoni(Telefoni telefoni) {
        return telefoniRepository.save(telefoni);
    }
}
