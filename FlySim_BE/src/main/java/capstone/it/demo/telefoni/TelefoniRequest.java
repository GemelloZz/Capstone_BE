package capstone.it.demo.telefoni;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Richiesta per creare un telefono con immagine")
public class TelefoniRequest {

    @NotBlank(message = "Marca è obbligatoria")
    @Schema(description = "Marca del telefono", example = "Apple")
    private String marca;

    @NotBlank(message = "Modello è obbligatorio")
    @Schema(description = "Modello del telefono", example = "iPhone 13")
    private String modello;

    @NotNull(message = "Numero di serie è obbligatorio")
    @Schema(description = "Numero di serie del telefono", example = "123456789")
    private Integer numeroSeriale;

    @NotNull(message = "Memoria è obbligatoria")
    @Schema(description = "Capacità di memoria in GB", example = "128")
    private Integer memoria;

    @Schema(description = "Immagine del telefono", type = "string", format = "binary")
    private String imgUrl;

}
