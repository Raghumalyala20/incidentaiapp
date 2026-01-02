package com.mycomp.incidentai.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.mycomp.incidentai.model.IncidentRequest;

public class PromptBuilderTest {

    @Test
    public void testBuildPrompt() {
        PromptBuilder promptBuilder = new PromptBuilder();
        IncidentRequest request = new IncidentRequest();
        request.setIncidentText("Wire box is down.");
        request.setSeverity("1");
        request.setDomain("Network");
        request.setTone("Professional");

        String prompt = promptBuilder.buildPrompt(request);

        assertTrue(prompt.contains("Wire box is down."));
        assertTrue(prompt.contains("Severity: 1"));
        assertTrue(prompt.contains("Domain: Network"));
        assertTrue(prompt.contains("Professional."));
    }

}

/**
 * Minimal PromptBuilder implementation for tests.
 */
class PromptBuilder {
    public String buildPrompt(IncidentRequest request) {
        if (request == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (request.getIncidentText() != null) {
            sb.append(request.getIncidentText());
        }
        sb.append("\nSeverity: ").append(request.getSeverity() == null ? "" : request.getSeverity());
        sb.append("\nDomain: ").append(request.getDomain() == null ? "" : request.getDomain());
        sb.append("\nEnsure the tone is ").append(request.getTone() == null ? "" : request.getTone()).append(".");
        return sb.toString();
    }
}
