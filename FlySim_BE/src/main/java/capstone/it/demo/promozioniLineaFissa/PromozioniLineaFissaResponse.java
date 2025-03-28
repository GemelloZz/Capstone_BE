package capstone.it.demo.promozioniLineaFissa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromozioniLineaFissaResponse {

    private Long id;
    private String descrizione;
    private String minuti;
    private String giga ;
    private Double prezzo;
    private PromozioniLineaFissaEnum promozioniLineaFissaEnum;
}
