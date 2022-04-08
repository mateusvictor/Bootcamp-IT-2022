package com.school.schoolapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentRequestDTO {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String email;
    private List<AddressRequestDTO> addresses;
}
