package com.codegames.renaissancecoders.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebhookForwardingService {

    private final RestTemplate restTemplate;
    private final String timesheetApiUrl = ""; //tempo url here

    public WebhookForwardingService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public void forward(String source, Object payload) {
        Object timesheetEntry = mapRequiredFieldsFromAPI(source, payload);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> timesheetEntryDraftRequest = new HttpEntity<>(timesheetEntry, headers);

        restTemplate.postForEntity(timesheetApiUrl, timesheetEntryDraftRequest, String.class);
    }

    private Object mapRequiredFieldsFromAPI(String source, Object payload) {
        // Add logic to transform payload based on the source
        return switch (source.toLowerCase()) {
            case "jira" -> mapFromJira(payload);
            case "git" -> mapFromGit(payload);
            case "teams" -> mapFromTeams(payload);
            default -> payload;
        };
    }

    /*****************************************************
     ** Fetch only required info from the huge metadata**
     *****************************************************/
    private Object mapFromJira(Object payload) {
        // Convert or extract only the fields you need from Jira webhook
        return null;/* your custom DTO */
    }

    private Object mapFromGit(Object payload) {
        return null;/* your custom DTO */
    }

    private Object mapFromTeams(Object payload) {
        return null;/* your custom DTO */
    }
}

