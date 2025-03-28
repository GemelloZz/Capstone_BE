package capstone.it.demo.telefoni;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "telefoni")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Telefoni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotBlank
    private String marca;
    @Column
    @NotBlank
    private String modello;
    @Column
    @NotNull
    private int numeroSeriale;
    @Column
    @NotNull
    private int memoria;
    @Column
    @NotBlank
    private String imgUrl;




}
