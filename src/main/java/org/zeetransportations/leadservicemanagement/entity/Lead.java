package org.zeetransportations.leadservicemanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
@Table(name="Lead_Table")
@Entity
@Data
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer leadId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String company;
    private String source;
    @Embedded
    private CustomFields customFields;
    private String status;  // New, Contacted, Interested, Converted

}
