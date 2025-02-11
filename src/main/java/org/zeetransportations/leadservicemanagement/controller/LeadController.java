package org.zeetransportations.leadservicemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zeetransportations.leadservicemanagement.entity.Lead;
import org.zeetransportations.leadservicemanagement.service.LeadServiceImp;

import java.util.NoSuchElementException;


@RestController
@RequestMapping("/leads")
public class LeadController {
    @Autowired
    private LeadServiceImp leadServiceImp;

    @PostMapping("/create")
    public ResponseEntity<?> postLeadInfo(@RequestBody Lead lead){
        Lead lead1 = leadServiceImp.postLeadInfo(lead);
        return new ResponseEntity<>(lead1, HttpStatus.OK);

    }
    @PutMapping("/update/{leadId}")
    public ResponseEntity<?> putLeadInfo(@PathVariable int leadId,@RequestBody Lead lead){
        Lead lead1 = null;
        try{
             lead1 = leadServiceImp.putLeadInfo(leadId,lead);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("no Lead data found to be updated", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(lead1, HttpStatus.OK);
    }

    @PutMapping("/convert/{leadId}")
    public ResponseEntity<?> convertLeadToCustomerInfo(@PathVariable int leadId){
        Lead lead1 = null;
        try{
            lead1 = leadServiceImp.convertLeadToCustomer(leadId);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("no Lead data found to be updated", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(lead1, HttpStatus.OK);
    }
}
