package org.zeetransportations.leadservicemanagement.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class LeadCustomFields {
    private Integer leadScore;
    private String industry;
}
