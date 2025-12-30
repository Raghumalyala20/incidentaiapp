package com.mycomp.incidentai.service;

import org.springframework.stereotype.Component;

import com.mycomp.incidentai.model.IncidentRequest;

@Component
public class PromptBuilder {
    public String buildPrompt(IncidentRequest request) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("You are an AI assistant specialized in telecom incident management.\n");
        prompt.append("Analyze the following incident report:\n\n");
        prompt.append(request.getIncidentText()).append("\n\n");
        prompt.append("Severity: ").append(request.getSeverity()).append("\n");
        prompt.append("Domain: ").append(request.getDomain()).append("\n");
        prompt.append("Provide a summary, impact analysis, affected systems, and recommended next actions.");
        prompt.append("\nFormat the response in JSON with keys: summary, impact_analysis, affected_systems, recommended_actions.\n");
        prompt.append("Ensure the tone is ").append(request.getTone()).append(".\n");
        prompt.append("Token limit: 1024 tokens.");
        return prompt.toString();
    }

}
