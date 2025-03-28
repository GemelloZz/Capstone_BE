package capstone.it.demo.promozioni;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromozioniRequest {

    @NotBlank(message = "Campo obbligatorio")
    private String nome;
    @NotBlank(message = "Campo obbligatorio")
    private String descrizione;
    @NotBlank(message = "Campo obbligatorio")
    private PromozioniEnum stato;
    @NotNull(message = "Campo obbligatorio")
    private int minuti;
    @NotNull(message = "Campo obbligatorio")
    private int giga;
    @NotBlank (message = "Campo obbligatorio")
    private double prezzo;
    @NotBlank(message = "Campo obbligatorio")
    private int messaggi;
}
