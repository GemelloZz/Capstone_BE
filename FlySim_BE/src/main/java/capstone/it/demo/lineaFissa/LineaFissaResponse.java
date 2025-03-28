package capstone.it.demo.lineaFissa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineaFissaResponse {

    private Long id;
    private String numeroTelefono;
    private String numeroLineaFissa;
}
