package com.codegames.renaissancecoders.controller;

import com.codegames.renaissancecoders.service.WebhookForwardingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/webhook/teams")
public class TeamsWebhookController {

    @Autowired
    private WebhookForwardingService forwardingService;

    //webhooks are always post request, because it is sending us the data (not requesting it)
    @PostMapping
    public ResponseEntity<Map<String, Object>> receiveTeamsWebhook(@RequestBody Map<String, Object> payload) {
        System.out.println("Received Teams webhook: " + payload);

        // Forward the payload to your target API
        forwardingService.forward("teams", payload);

        // Send a response message back to Teams
        Map<String, Object> response = Map.of(

        );
        return ResponseEntity.ok(response);
    }
}