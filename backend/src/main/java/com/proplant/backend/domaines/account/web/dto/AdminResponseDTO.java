package com.proplant.backend.domaines.account.web.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.proplant.backend.domaines.account.repository.entity.AppRole;

import lombok.Data;

@Data
public class AdminResponseDTO {
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
	
	private List<AppRole> roles = new ArrayList<>(); 
 }
