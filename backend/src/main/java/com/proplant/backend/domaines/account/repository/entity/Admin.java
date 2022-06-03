package com.proplant.backend.domaines.account.repository.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor @NoArgsConstructor 
@Entity
public class Admin {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
    @Valid
	private String username;

	@NotNull
    @Valid
    private String lastname;

	@NotNull
    @Valid
    private String email;

	@NotNull
    @Valid
	private String password;
    
	@NotNull
    @Valid
	private String personalNumber;

	@ManyToMany(fetch=FetchType.EAGER)
    private Collection<AppRole> roles = new ArrayList<>(); 
}