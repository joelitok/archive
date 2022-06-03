package com.proplant.backend.domaines.account.web.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class AppRoleRequestDTO {
private Long id;

    @NotNull
    @Valid
    private String roleName;

    @NotNull
    @Valid
    private String description;

}
