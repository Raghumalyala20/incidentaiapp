package com.mycomp.incidentai.model;

public class IncidentResponse {
    private String summary;
    private String impact;
    private String impactedSystems;
    private String nextActions;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public String getImpactedSystems() {
        return impactedSystems;
    }

    public void setImpactedSystems(String impactedSystems) {
        this.impactedSystems = impactedSystems;
    }

    public String getNextActions() {
        return nextActions;
    }

    public void setNextActions(String nextActions) {
        this.nextActions = nextActions;
    }
}