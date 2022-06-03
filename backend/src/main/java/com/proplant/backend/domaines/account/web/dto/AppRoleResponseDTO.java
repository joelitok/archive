package com.proplant.backend.domaines.account.web.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AppRoleResponseDTO {
private Long id;

    @NotNull
    @Valid
    private String roleName;

    @NotNull
    @Valid
    private String description;   
}
