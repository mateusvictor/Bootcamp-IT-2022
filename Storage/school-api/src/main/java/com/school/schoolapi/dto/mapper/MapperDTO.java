package com.school.schoolapi.dto.mapper;

import com.school.schoolapi.dto.response.AddressResponseDTO;
import com.school.schoolapi.dto.response.StudentResponseDTO;
import com.school.schoolapi.model.Address;
import com.school.schoolapi.model.Student;

import java.util.List;
import java.util.stream.Collectors;

public class MapperDTO {
    public static StudentResponseDTO studentToDTO(Student student){
        return new StudentResponseDTO(student.getId(), student.getFirstName(), student.getLastName(), student.getBirthDate(),
                student.getEmail(), addressToDTO(student.getAddresses()));
    }

    public static List<StudentResponseDTO> studentToDTO(List<Student> studentList){
        return studentList.stream()
                .map(MapperDTO::studentToDTO)
                .collect(Collectors.toList());
    }

    public static AddressResponseDTO addressToDTO(Address address){
        return new AddressResponseDTO(address.getId(), address.getCountry(), address.getState(), address.getStreet(),
                address.getNumber(), address.getPostalCode());
    }

    public static List<AddressResponseDTO> addressToDTO(List<Address> addressList){
        return addressList.stream()
                .map(MapperDTO::addressToDTO)
                .collect(Collectors.toList());
    }
}
