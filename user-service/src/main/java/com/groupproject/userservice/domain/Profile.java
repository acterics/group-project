package com.groupproject.userservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @OneToOne(mappedBy = "userId")
    private User user;

    private String firstName;
    private String lastName;

    private String gender;
    private String phone;
}
