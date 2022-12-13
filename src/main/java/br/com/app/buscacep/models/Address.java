package br.com.app.buscacep.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "street")
    private String street;
    @Column(name = "district")
    private String district;
    @Column(name = "complement")
    private String complement;
    @Column(name = "number")
    private Integer number;
    @Column(name = "postal_code")
    @Pattern(regexp = "[0-9]{5}-[0-9]{3}")
    private String postalCode;

    @ManyToOne
    @ElementCollection(targetClass = Person.class)
    private Person person;
}
