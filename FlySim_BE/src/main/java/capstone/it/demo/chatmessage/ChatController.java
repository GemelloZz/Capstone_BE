package capstone.it.demo.chatmessage;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "http://localhost:3000" ,  allowCredentials = "true")
@Tag(name = "Chat API", description = "API per il chatbot interattivo")
public class ChatController {

    private final Map<String, Integer> chatSessions = new ConcurrentHashMap<>();

    @PostMapping("/send")
    @Operation(summary = "Invia un messaggio al chatbot")
    public ResponseEntity<ChatResponse> handleMessage(
            @RequestBody String userInput,
            HttpSession session) {

        String sessionId = session.getId();
        int currentStep = chatSessions.getOrDefault(sessionId, 0);

        ChatResponse response = new ChatResponse();

        if (userInput.matches("\\d+")) {
            int choice = Integer.parseInt(userInput);
            response = processNumericChoice(choice, currentStep);

            // Resetta il passo se la scelta non è valida
            if (response.getMessage().contains("non valida")) {
                chatSessions.put(sessionId, 0);
            } else {
                chatSessions.put(sessionId, currentStep + 1);
            }
        } else {
            response.setMessage("Per favore seleziona un'opzione numerica:");
            response.setOptions(getOptionsForStep(currentStep));
        }
        System.out.println("Risposta inviata al frontend: " + response);
        return ResponseEntity.ok(response);
    }

    private ChatResponse processNumericChoice(int choice, int currentStep) {
        ChatResponse response = new ChatResponse();

        switch(currentStep) {
            case 0:
                return handleMainMenu(choice);
            case 1:
                return handleProductInfoMenu(choice);
            case 2:
                return handleTechnicalSupportMenu(choice);
            default:
                response.setMessage("Sessione non valida. Ripartiamo dall'inizio.");
                response.setOptions(getOptionsForStep(0));
                return response;
        }
    }

    private ChatResponse handleMainMenu(int choice) {
        ChatResponse response = new ChatResponse();

        switch(choice) {
            case 1:
                response.setMessage("Seleziona la categoria di prodotti:");
                response.setOptions(Arrays.asList(
                        "1. Telefoni",
                        "2. Promozioni Linea Fissa",
                        "3. Promozioni Linea Mobile",
                        "4. Torna al menu principale"
                ));
                break;
            case 2:
                response.setMessage("Seleziona il tipo di assistenza:");
                response.setOptions(Arrays.asList(
                        "1. Problemi tecnici",
                        "2. Informazioni contratti",
                        "3. Torna al menu principale"
                ));
                break;
            case 3:
                response.setMessage("Un operatore ti contatterà a breve. Vuoi lasciare un messaggio?");
                response.setOptions(Arrays.asList(
                        "1. Sì, voglio lasciare un messaggio",
                        "2. No, aspetterò il contatto"
                ));
                break;
            default:
                response.setMessage("Scelta non valida. Per favore seleziona un'opzione corretta.");
                response.setOptions(getOptionsForStep(0));
        }

        return response;
    }

    private ChatResponse handleProductInfoMenu(int choice) {
        ChatResponse response = new ChatResponse();

        switch(choice) {
            case 1:
                response.setMessage("Ti reindirizzo alla pagina dei telefoni...");
                response.setRedirectUrl("/prodotti/telefoni");
                break;
            case 2:
                response.setMessage("Ti reindirizzo alla pagina delle promozioni linea fissa...");
                response.setRedirectUrl("/promozioni/linea-fissa");
                break;
            case 3:
                response.setMessage("Ti reindirizzo alla pagina delle promozioni linea mobile...");
                response.setRedirectUrl("/promozioni/linea-mobile");
                break;
            case 4:
                response.setMessage("Torno al menu principale:");
                response.setOptions(getOptionsForStep(0));
                break;
            default:
                response.setMessage("Scelta non valida. Per favore seleziona un'opzione corretta.");
                response.setOptions(getOptionsForStep(1));
        }

        return response;
    }

    private ChatResponse handleTechnicalSupportMenu(int choice) {
        ChatResponse response = new ChatResponse();

        switch(choice) {
            case 1:
                response.setMessage("Ti reindirizzo alla pagina di supporto tecnico...");
                response.setRedirectUrl("/assistenza/tecnica");
                break;
            case 2:
                response.setMessage("Ti reindirizzo alla pagina delle informazioni contrattuali...");
                response.setRedirectUrl("/assistenza/contratti");
                break;
            case 3:
                response.setMessage("Torno al menu principale:");
                response.setOptions(getOptionsForStep(0));
                break;
            default:
                response.setMessage("Scelta non valida. Per favore seleziona un'opzione corretta.");
                response.setOptions(getOptionsForStep(1));
        }

        return response;
    }

    private List<String> getOptionsForStep(int step) {
        switch(step) {
            case 0:
                return Arrays.asList(
                        "1. Informazioni su prodotti",
                        "2. Assistenza tecnica",
                        "3. Parlare con un operatore"
                );
            case 1:
                return Arrays.asList(
                        "1. Telefoni",
                        "2. Promozioni Linea Fissa",
                        "3. Promozioni Linea Mobile",
                        "4. Torna al menu principale"
                );
            case 2:
                return Arrays.asList(
                        "1. Problemi tecnici",
                        "2. Informazioni contratti",
                        "3. Torna al menu principale"
                );
            default:
                return List.of("1. Torna al menu principale");
        }
    }
}