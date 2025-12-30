package com.mycomp.incidentai.model;

public class IncidentRequest {
    
    private String incidentText;
    private String severity;
    private String domain;
    private String tone;

    public String getIncidentText() {
        return incidentText;
    }

    public void setIncidentText(String incidentText) {
        this.incidentText = incidentText;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getTone() {
        return tone;
    }

    public void setTone(String tone) {
        this.tone = tone;
    }
   
}
