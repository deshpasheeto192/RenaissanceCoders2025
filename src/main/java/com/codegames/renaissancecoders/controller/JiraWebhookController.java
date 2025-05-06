package com.codegames.renaissancecoders.controller;

import com.codegames.renaissancecoders.service.WebhookForwardingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/webhook/jira")
public class JiraWebhookController {

    @Autowired
    private WebhookForwardingService forwardingService;

    @Value("${jira.webhook.secret}")
    private String secret;

    //webhooks are always post request, because it is sending us the data (not requesting it)
    @PostMapping
    public ResponseEntity<String> receiveJiraWebhook(@RequestBody Map<String, Object> payload) {
        // Optional: log or inspect the payload
        System.out.println("Received Jira webhook: " + payload);

        // Optional: filter event types, extract issue keys, etc.
        /*try {
            String endpoint = String.format("https://renaissancecoders.com/rest/webhooks/webhook1", secret);
            HttpRequest response = HttpRequest.newBuilder()
                    .uri(new URI(endpoint))
                    .timeout(Duration.ofSeconds(120))
                    .POST(HttpRequest.BodyPublishers.ofString(null))
                    .build();
            System.out.println("Jira webhook endpoint: " + response.toString());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }*/
        forwardingService.forward("jira", payload);
        return ResponseEntity.ok("Jira webhook received");
    }

    private boolean isValidSecret(String receivedSecret) {
        return receivedSecret != null && !receivedSecret.isEmpty();
    }
}
