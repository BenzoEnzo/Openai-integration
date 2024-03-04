package pl.benzo.enzo.openai.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private String lastName;
    private BigDecimal pesel;
    private BigDecimal phoneNumber;
    private String mail;
    private String password;
    private Integer age;
    private BigDecimal salary;

}
