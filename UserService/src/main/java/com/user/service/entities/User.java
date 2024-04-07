package com.user.service.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="micro_users")
public class User {

    @Id
    @Column(name="ID")
    private String userId;

    @Column(name = "FNAME", length = 20)
    private String firstName;

    @Column(name = "LNAME",length = 20)
    private String lastName;

    @Column(name = "GENDER",length = 6)
    private String gender;

    @Column(name = "MOBILE_NUMBER", length = 10)
    private String phoneNumber;

    @Column(name = "ADDRESS", length = 255)
    private String address;

    @Column(name = "EMAIL", length = 40)
    private String email;

    @Column(name = "ABOUT", length = 255)
    private String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();
}
