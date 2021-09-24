package com.loicdev.springdemo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.loicdev.springdemo.api.validator.EnumNamePattern;
import org.hibernate.annotations.NaturalId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Role {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    @EnumNamePattern(regexp = "ROLE_USER|ROLE_ADMIN", message = "Valeurs acceptées : ROLE_USER, ROLE_ADMIN")
    private RoleName name;
}