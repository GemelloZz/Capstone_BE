package capstone.it.demo.dto;

import capstone.it.demo.promozioni.Promozioni;
import capstone.it.demo.promozioniLineaFissa.PromozioniLineaFissa;
import capstone.it.demo.telefoni.Telefoni;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class PromozioneClienteDTO {

    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String telefono;
    private String telefonoLineaFissa;
    private String citta;
    private String indirizzo;
    private String avatar;
    private String dataDiNascita;
    private Set<Promozioni> promozioni;
    private List<Telefoni> telefoni;
    private List<PromozioniLineaFissa> promozioniLineaFissa;


}
