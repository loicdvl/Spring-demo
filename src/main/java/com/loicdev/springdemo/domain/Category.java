package com.loicdev.springdemo.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import org.hibernate.envers.Audited;
import org.springframework.data.history.RevisionMetadata;

@Entity
@Audited
@Data
@Table(name = "category", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Category {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@NotBlank
	@Column(name = "name")
    private String name;

    @Transient
    private RevisionMetadata<Integer> editVersion;
}
