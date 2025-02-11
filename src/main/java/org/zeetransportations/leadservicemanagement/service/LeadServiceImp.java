package org.zeetransportations.leadservicemanagement.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.zeetransportations.leadservicemanagement.dto.CustomerDTO;
import org.zeetransportations.leadservicemanagement.entity.Lead;
import org.zeetransportations.leadservicemanagement.repository.LeadRepository;

import java.util.NoSuchElementException;
import java.util.Optional;
@Slf4j
@Service
public class LeadServiceImp implements LeadService {

    @Autowired
    private LeadRepository leadRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Value("${customer.service.url}") // Injects the value from properties file
    private String customerServiceUrl;


    public Lead postLeadInfo(Lead lead){
        lead.setStatus("Open");
        return leadRepository.save(lead);
    }
    public Lead getLeadById(Integer leadId){
        Optional<Lead> leadOptional = leadRepository.findById(leadId);
        if(leadOptional.isEmpty()){  // check if customer data exist on Database
            throw new NoSuchElementException();
        }
        log.info("Lead information retrieved from database");
        return leadOptional.get();
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
        lead1.setCustomFields(lead.getCustomFields());
        lead1.setFirstName(lead.getFirstName());
        lead1.setLastName(lead.getLastName());

        Lead saveLeadInfo = leadRepository.save(lead1);

        return saveLeadInfo;

    }

    public Lead convertLeadToCustomer(Integer leadId) {
        Lead lead = getLeadById(leadId);


        CustomerDTO customerDTO = new CustomerDTO(
                lead.getFirstName(),
                lead.getLastName(),
                lead.getEmail(),
                lead.getPhone(),
                lead.getCompany(),
                lead.getCustomFields().getIndustry()
        );


        // Make a POST request using RestTemplate
        restTemplate.postForObject(customerServiceUrl, customerDTO, Void.class);
        log.info("Lead converted to customer");
        // Update lead status to "Converted"
        lead.setStatus("Converted");
        return leadRepository.save(lead);
    }



}
