package com.example.worktopia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "mentorés")
public class Mentore {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mentoreId;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @Temporal(TemporalType.DATE)
    private Date updatedAt;
    private Boolean status;

    @OneToOne
    Location location;
}
