

package capstone.it.demo.stripeconf;

import capstone.it.demo.stripeconf.StripeService;
import capstone.it.demo.dto.StripeDTO;
import capstone.it.demo.dto.ClientDTO;
import com.stripe.exception.StripeException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class StripePaymentController {

    private final StripeService stripeService;

    public StripePaymentController(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @PostMapping("/create-payment-intent")
    public ClientDTO createPaymentIntent(
            @RequestBody StripeDTO request) throws StripeException {

        String clientSecret = stripeService.createPaymentIntent(
                request.getAmount(),
                request.getPromozioneId(),
                request.getUserId()
        );

        return new ClientDTO(clientSecret);
    }
}