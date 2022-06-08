package com.proplant.backend.domaines.account.mappers;

import com.proplant.backend.domaines.account.repository.entity.Admin;
import com.proplant.backend.domaines.account.repository.entity.AppRole;
import com.proplant.backend.domaines.account.web.dto.AdminRequestDTO;
import com.proplant.backend.domaines.account.web.dto.AdminResponseDTO;
import com.proplant.backend.domaines.account.web.dto.AppRoleRequestDTO;
import com.proplant.backend.domaines.account.web.dto.AppRoleResponseDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-08T13:29:42+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AdminResponseDTO userToUserDTO(Admin user) {
        if ( user == null ) {
            return null;
        }

        AdminResponseDTO adminResponseDTO = new AdminResponseDTO();

        return adminResponseDTO;
    }

    @Override
    public Admin userRequestDtoToUser(AdminRequestDTO userRequestDTO) {
        if ( userRequestDTO == null ) {
            return null;
        }

        Admin admin = new Admin();

        return admin;
    }

    @Override
    public AppRoleResponseDTO roleToRoleDTO(AppRole role) {
        if ( role == null ) {
            return null;
        }

        AppRoleResponseDTO appRoleResponseDTO = new AppRoleResponseDTO();

        return appRoleResponseDTO;
    }

    @Override
    public AppRole roleRequestDtoToRole(AppRoleRequestDTO roleRequestDTO) {
        if ( roleRequestDTO == null ) {
            return null;
        }

        AppRole appRole = new AppRole();

        return appRole;
    }
}
