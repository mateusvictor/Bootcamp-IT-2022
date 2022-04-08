package com.school.schoolapi.model.mapper;

import com.school.schoolapi.dto.request.AddressRequestDTO;
import com.school.schoolapi.dto.request.StudentRequestDTO;
import com.school.schoolapi.model.Address;
import com.school.schoolapi.model.Student;

import java.util.List;
import java.util.stream.Collectors;

public class ModelMapper {
    public static Student studentDTOToEntity(StudentRequestDTO studentDTO){
        Student student = new Student(null, studentDTO.getFirstName(), studentDTO.getLastName(),
                studentDTO.getBirthDate(), studentDTO.getEmail(), null);

        List<Address> addressList = addressDTOToEntity(studentDTO.getAddresses(), student);
        student.setAddresses(addressList);

        return student;
    }

    public static List<Address> addressDTOToEntity(List<AddressRequestDTO> addressDTOList, Student student){
        return addressDTOList.stream()
                .map(dto -> addressDTOToEntity(dto, student))
                .collect(Collectors.toList());
    }

    public static Address addressDTOToEntity(AddressRequestDTO addressDTO, Student student){
        return new Address(null, addressDTO.getCountry(), addressDTO.getState(), addressDTO.getStreet(),
                addressDTO.getNumber(), addressDTO.getPostalCode(), student);
    }
}
