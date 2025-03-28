package capstone.it.demo.telefoni;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelefoniResponse {
    private String Marca;
    private String Modello;
    private int NumeroSeriale;
    private int Memoria;
    private String imgUrl;
}
