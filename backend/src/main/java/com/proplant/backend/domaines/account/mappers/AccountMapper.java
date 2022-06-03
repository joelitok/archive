package com.proplant.backend.domaines.account.mappers;

import com.proplant.backend.domaines.account.repository.entity.AppRole;
import com.proplant.backend.domaines.account.repository.entity.Admin;
import com.proplant.backend.domaines.account.web.dto.AppRoleRequestDTO;
import com.proplant.backend.domaines.account.web.dto.AppRoleResponseDTO;
import com.proplant.backend.domaines.account.web.dto.AdminRequestDTO;
import com.proplant.backend.domaines.account.web.dto.AdminResponseDTO;

import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AccountMapper {

AdminResponseDTO userToUserDTO(Admin user);

Admin userRequestDtoToUser(AdminRequestDTO userRequestDTO);

AppRoleResponseDTO roleToRoleDTO(AppRole role);

AppRole roleRequestDtoToRole(AppRoleRequestDTO roleRequestDTO);
    
}
