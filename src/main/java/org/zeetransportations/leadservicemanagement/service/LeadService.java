package org.zeetransportations.leadservicemanagement.service;

import org.zeetransportations.leadservicemanagement.entity.Lead;

public interface LeadService {
    Lead putLeadInfo(int leadId, Lead lead);
    Lead postLeadInfo(Lead lead);
}
