package org.smartbilling.web;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRegistrationForm {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Lastname is required")
    private String lastName;

    @NotBlank @Email(message = "Enter a valid email")
    private String email;

    @NotNull
    @Min(value = 18, message = "You must be 18+")
    private Integer age;

    @NotNull(message = "Province is required")
    private Long provinceId;


}
