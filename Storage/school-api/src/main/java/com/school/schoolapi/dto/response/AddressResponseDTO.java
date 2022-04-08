package com.school.schoolapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressResponseDTO {
    private Long id;
    private String country;
    private String state;
    private String street;
    private Long number;
    private String postalCode;
}
