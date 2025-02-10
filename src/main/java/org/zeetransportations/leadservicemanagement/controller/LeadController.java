package org.zeetransportations.leadservicemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zeetransportations.leadservicemanagement.entity.Lead;
import org.zeetransportations.leadservicemanagement.service.LeadService;


@RestController
@RequestMapping("/leads")
public class LeadController {
    @Autowired
    private LeadService leadService;

    @PostMapping("/create")
    public ResponseEntity<?> postLeadInfo(@RequestBody Lead lead){
        Lead lead1 = leadService.postLeadInfo(lead);
        return new ResponseEntity<>(lead1, HttpStatus.OK);

    }
    @PutMapping("/convert/{leadId}")
    public ResponseEntity<?> putLeadInfo(@PathVariable int leadId, @RequestBody Lead lead){
        Lead lead1 = leadService.putLeadInfo(leadId, lead);

        return new ResponseEntity<>(lead1, HttpStatus.OK);
    }
}
