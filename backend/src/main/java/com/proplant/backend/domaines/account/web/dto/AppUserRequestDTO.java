package com.proplant.backend.domaines.account.web.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AppUserRequestDTO {
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
}
