package pl.benzo.enzo.openai.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Type;
import java.math.BigDecimal;

@Entity
@Table(name = "USERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private BigDecimal pesel;
    private BigDecimal phoneNumber;
    private String mail;
    private String password;
    private Integer age;
    private BigDecimal salary;
}
