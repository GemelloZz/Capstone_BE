package capstone.it.demo.promozioni;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromozioniResponse {

    private int id;
    private String nome;
    private String descrizione;
    private int minuti;
    private int giga ;
    private int messaggi;
    private double prezzo;
    private PromozioniEnum promozioniEnum;
}
