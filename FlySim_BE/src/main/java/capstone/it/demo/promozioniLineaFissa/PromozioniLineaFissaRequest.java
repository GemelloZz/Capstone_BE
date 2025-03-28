package capstone.it.demo.promozioniLineaFissa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromozioniLineaFissaRequest {

    @NotBlank(message = "Campo obbligatorio")
    private String nome;
    @NotBlank(message = "Campo obbligatorio")
    private String descrizione;
    @NotBlank(message = "Campo obbligatorio")
    private PromozioniLineaFissaEnum stato;
    @NotNull
    private String minuti;
    @NotNull
    private String giga;
    @NotNull
    private Double prezzo;
}
