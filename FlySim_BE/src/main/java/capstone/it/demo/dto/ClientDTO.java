package capstone.it.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientDTO {
    private String clientSecret;
    public void PaymentIntentResponse(String clientSecret) {

        this.clientSecret = clientSecret;
    }
}
