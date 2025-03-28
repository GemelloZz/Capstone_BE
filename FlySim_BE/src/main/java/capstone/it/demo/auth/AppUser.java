package capstone.it.demo.auth;

import capstone.it.demo.promozioni.Promozioni;
import capstone.it.demo.promozioniLineaFissa.PromozioniLineaFissa;
import capstone.it.demo.telefoni.Telefoni;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "telefono",  unique = true)
    private String telefono;

    @Column(name = "telefono_linea_fissa",  unique = true)
    private String telefonoLineaFissa;

    @Column(name = "Città")
    private String Città;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "cap")
    private String cap;

    @Column(name="datadinascita")
    private String dataDiNascita;


    @Column(nullable = true)
    private String avatar;


    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;


    @OneToMany
    @Column(name = "promozioni_id")
    private Set<Promozioni> promozioni = new HashSet<>();

    @OneToMany
    @Column(name = "telefoni_id")
    private List<Telefoni> telefoni;

    @OneToMany
    @Column(name = "promozioni_linea_fissa_id")
    private List<PromozioniLineaFissa> promozioniLineaFissa;
}
