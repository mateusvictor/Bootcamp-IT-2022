package com.school.schoolapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressRequestDTO {
    private String country;
    private String state;
    private String street;
    private Long number;
    private String postalCode;
}
