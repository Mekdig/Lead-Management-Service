package org.zeetransportations.leadservicemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
@AllArgsConstructor
@Data
public class CustomerDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String company;
    private String industry;


}