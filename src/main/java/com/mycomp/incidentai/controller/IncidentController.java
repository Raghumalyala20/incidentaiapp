package com.mycomp.incidentai.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycomp.incidentai.model.IncidentRequest;
import com.mycomp.incidentai.model.IncidentResponse;
import com.mycomp.incidentai.service.IncidentService;


@RestController
public class IncidentController {

@Autowired
private IncidentService incidentService;

@PostMapping("/incidents/summary")
public IncidentResponse handleIncident(@RequestBody IncidentRequest request) {
    
    return incidentService.processIncident(request);
}
}    

