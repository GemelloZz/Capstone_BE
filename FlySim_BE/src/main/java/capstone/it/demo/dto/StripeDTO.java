package capstone.it.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StripeDTO {

    @NotNull
    @Positive
    private Long amount;

    @NotBlank
    private String promozioneId;

    @NotBlank
    private String userId;
}
