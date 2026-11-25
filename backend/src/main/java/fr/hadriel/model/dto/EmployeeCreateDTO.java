package fr.hadriel.model.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeCreateDTO {
    private String firstName;
    private String lastName;
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dateOfHire;
    private boolean administrator;
    private String password;
}
