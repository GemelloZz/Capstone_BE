package capstone.it.demo.lineaFissa;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineaFissaRequest {

    @NotNull(message = "Il numero è obbligatorio")
    private String numero;
    @NotNull(message = "Il provider è obbligatorio")
    private String provider;
}
