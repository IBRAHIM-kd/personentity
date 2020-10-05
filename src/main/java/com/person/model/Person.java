package com.person.model;

/**
 * Create a REST API to expose CRUD operation on a "person" entity. The "person" must have the following properties:
 * id
 * name (required)
 * surname (required)
 * age
 * sex
 * birthday
 * email
 * contacts (a list of people)
 * created
 * modified
 * @author  IBRAHIM ABDULLAH
 * @version 1.0
 * @since   2020-10-03
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;


import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "person")
@Data
@EqualsAndHashCode(callSuper = true)
public class Person extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "Surname is required")
    private String surname;
    private Integer age;
    private String sex;
    @Column(name = "birth_day")
    private LocalDate birthday;
    @Pattern(regexp = "(\\+27|0)[0-9]{9}")
    private String phone;
    private String email;
    private String contacts;

  }






