package com.mycomp.incidentai.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mycomp.incidentai.client.LLMClient;
import com.mycomp.incidentai.model.IncidentRequest;
import com.mycomp.incidentai.model.IncidentResponse;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

@Service
public class IncidentService {

    private final PromptBuilder promptBuilder;
    private final LLMClient llmClient;
    public IncidentService(PromptBuilder promptBuilder, LLMClient llmClient) {
        this.promptBuilder = promptBuilder;
        this.llmClient = llmClient;
    }
    public IncidentResponse processIncident(IncidentRequest request) {
        // Placeholder for processing logic
        if(request == null || request.getIncidentText() == null) {
            throw new IllegalArgumentException("Invalid incident request");
        }
        String prompt = promptBuilder.buildPrompt(request);
        String llmResponse = llmClient.invokeLLMService(prompt);
        ObjectMapper mapper = new ObjectMapper();
        String cleanResponse = llmResponse.replace("```json", "").replace("```", "").trim();
        JsonNode root= mapper.readTree(cleanResponse);
        IncidentResponse response = new IncidentResponse();
        response.setSummary(root.path("summary").asText(null));
        response.setImpact(root.path("impact_analysis").asText(null));
        List<String> systems = new ArrayList<>();
        root.path("affected_systems").forEach(node -> systems.add(node.asText()));
        response.setImpactedSystems(String.join(", ", systems));
        List<String> actions = new ArrayList<>();
        root.path("recommended_actions").forEach(node -> actions.add(node.asText()));
        response.setNextActions(String.join(", ", actions));
        return response;
    }
}
