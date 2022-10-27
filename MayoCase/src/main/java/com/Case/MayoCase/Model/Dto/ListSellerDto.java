package com.Case.MayoCase.Model.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ListSellerDto {
    private UUID id;
    @NotBlank(message = "Name is Mandatory")
    private String name;
    @CPF
    @NotBlank(message = "CPF is Mandatory")
    private String cpf;
    @Email
    @NotBlank(message = "Email is Mandatory")
    private String email;
}
