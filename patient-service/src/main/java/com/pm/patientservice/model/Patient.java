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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NonNull String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public @NonNull String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public @NonNull String getAddress() {
        return address;
    }

    public void setAddress(@NonNull String address) {
        this.address = address;
    }

    public @NonNull LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NonNull LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public @NonNull LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(@NonNull LocalDate registerDate) {
        this.registerDate = registerDate;
    }




}
