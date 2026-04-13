package com.pm.patientservice.mapper;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.model.Patient;

import java.time.LocalDate;

public class PatientMapper {
    public static PatientResponseDTO toDTO (Patient patient)
    {
        PatientResponseDTO patientDTo= new PatientResponseDTO();
        patientDTo.setId(patient.getId().toString());
        patientDTo.setName(patient.getName());
        patientDTo.setAddress(patient.getAddress());
        patientDTo.setEmail(patient.getEmail());
        patientDTo.setDateOfBirth(patient.getDateOfBirth().toString());
        return patientDTo;
    }
    public static Patient toModel(PatientRequestDTO patientRequestDTO)
    {
        Patient patient = new Patient();
        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        patient.setRegisterDate(LocalDate.parse(patientRequestDTO.getRegisteredDate()));
        return patient;

    }
}
