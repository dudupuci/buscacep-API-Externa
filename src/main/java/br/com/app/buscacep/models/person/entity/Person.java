package br.com.app.buscacep.models.person.entity;

import br.com.app.buscacep.models.address.entity.Address;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
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
    private UUID id;
    @NotEmpty(message = "Name cannot be null or empty.")
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;

    @Column(name = "registration_time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime registrationTime = LocalDateTime.now();
    @Column(name = "cpf", unique = true, length = 11)
    @CPF
    private String cpf;
    @Email
    @Column(name = "email")
    private String email;
    @OneToMany
    @JsonIgnore
    private List<Address> addresses;


}

