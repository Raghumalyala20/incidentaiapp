package com.mycomp.incidentai.client;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LLMClient {
    @Value("${llm.api.url}")
    private String apiUrl;
    @Value("${llm.api.key}")    
    private String apiKey;
    @Value("${llm.model.name}")
    private String modelName;
    @Value("${llm.temperature}")
    private float temperature;
    @Value("${llm.max.tokens}")
    private int maxTokens;
    private final RestTemplate restTemplate = new RestTemplate();
    public String invokeLLMService(String prompt) {
        // Placeholder for LLM service invocation logic
        Map<String, Object> requestBody = new HashMap<>();
        List<Map<String, String>> messages = new ArrayList<>();
        Map<String, String> userMessage = new HashMap<>();
        userMessage.put("role", "user");
        userMessage.put("content", prompt);
        messages.add(userMessage);
        requestBody.put("messages", messages);
        requestBody.put("model", modelName);
        requestBody.put("temperature", temperature);
        requestBody.put("max_tokens", maxTokens);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<Map> response = restTemplate.postForEntity(apiUrl, entity, Map.class);
        Map<String, Object> responseBody = response.getBody();
        List<Map<String, Object>> choices = (List<Map<String, Object>>) responseBody.get("choices");
        Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
        String outputContStringent = (String) message.get("content");
        return outputContStringent;
    }
}
