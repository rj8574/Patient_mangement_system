package com.pm.patientservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@Table ( name = "Paitent")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NonNull
    private String name;
    @NonNull
    @Email
    @Column(unique = true)
    private String email;
    @NonNull
    private String address;
    @NonNull
    private LocalDate dateOfBirth;
    @NonNull
    @Column(name = "registered_date")
    private LocalDate registerDate;


}
