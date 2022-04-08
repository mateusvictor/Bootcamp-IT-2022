package com.school.schoolapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String email;
    private List<AddressResponseDTO> addresses;
}
