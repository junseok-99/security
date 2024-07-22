package com.test.security.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "member")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;
}
