package br.com.app.buscacep.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @NotNull
    private UUID id;
    @NotEmpty(message = "Name cannot be null or empty.")
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
    @PastOrPresent(message = "Birthdate cannot be future.")
    @Column(name = "birthdate")
    private Date dateOfBirth;

    @Column(name = "cpf", unique = true, length = 11)
    @CPF(message = "Enter a valid CPF", groups = CPF.class)
    private String cpf;
    @Email
    private String email;
    @ElementCollection(targetClass = Address.class)
    @OneToMany
    private List<Address> addresses;


}

