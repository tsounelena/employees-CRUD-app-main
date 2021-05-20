package com.tsoun.employees.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "surname")
    @NotBlank(message = "surname is required field")
    private String surname;

    @Column(name = "name")
    @NotBlank(message = "name is required field")
    private String name;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "position")
    private String position;

    @Column(name = "birthday")
    @Past(message = "please use pattern dd.mm.yyyy")
    private LocalDate birthday;

    @Column(name = "mobile_phone")
    @NotBlank(message = "mobile phone is required field")
    private String mobilePhone;

    @Column(name = "email")
    @Email(message = "email is not correct")
    private String email;

    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;

    public Employee(@NotBlank(message = "surname is required field") String surname,
            @NotBlank(message = "name is required field") String name, String middleName, String position,
            @Past(message = "please use pattern dd.mm.yyyy") LocalDate birthday,
            @NotBlank(message = "mobile phone is required field") String mobilePhone,
            @Email(message = "email is not correct") String email, Department department) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.position = position;
        this.birthday = birthday;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.department = department;
    }
}
