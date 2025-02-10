package org.zeetransportations.leadservicemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zeetransportations.leadservicemanagement.entity.Lead;
import org.zeetransportations.leadservicemanagement.repository.LeadRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;

    public Lead postLeadInfo(Lead lead){
        return leadRepository.save(lead);
    }

    public Lead putLeadInfo(int leadId, Lead lead){
        Optional<Lead> leadOptional = leadRepository.findById(leadId);
        if (leadOptional.isEmpty()){
            throw new NoSuchElementException();
        }

        Lead lead1 = leadOptional.get();

        lead1.setCompany(lead.getCompany());
        lead1.setEmail(lead.getEmail());
        lead1.setPhone(lead.getPhone());
        lead1.setSource(lead.getSource());
        lead1.setLeadCustomFields(lead.getLeadCustomFields());
        lead1.setFirstName(lead.getFirstName());
        lead1.setLastName(lead.getLastName());

        Lead saveLeadInfo = leadRepository.save(lead1);
        return saveLeadInfo;

    }

}
