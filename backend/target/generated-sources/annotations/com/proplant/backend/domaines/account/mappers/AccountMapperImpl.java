package com.proplant.backend.domaines.account.mappers;

import com.proplant.backend.domaines.account.repository.entity.Admin;
import com.proplant.backend.domaines.account.repository.entity.AppRole;
import com.proplant.backend.domaines.account.web.dto.AdminRequestDTO;
import com.proplant.backend.domaines.account.web.dto.AdminResponseDTO;
import com.proplant.backend.domaines.account.web.dto.AppRoleRequestDTO;
import com.proplant.backend.domaines.account.web.dto.AppRoleResponseDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-03T12:49:10+0200",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.100.v20220318-0906, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AdminResponseDTO userToUserDTO(Admin user) {
        if ( user == null ) {
            return null;
        }

        AdminResponseDTO adminResponseDTO = new AdminResponseDTO();

        adminResponseDTO.setEmail( user.getEmail() );
        adminResponseDTO.setId( user.getId() );
        adminResponseDTO.setLastname( user.getLastname() );
        adminResponseDTO.setPassword( user.getPassword() );
        Collection<AppRole> collection = user.getRoles();
        if ( collection != null ) {
            adminResponseDTO.setRoles( new ArrayList<AppRole>( collection ) );
        }
        adminResponseDTO.setUsername( user.getUsername() );

        return adminResponseDTO;
    }

    @Override
    public Admin userRequestDtoToUser(AdminRequestDTO userRequestDTO) {
        if ( userRequestDTO == null ) {
            return null;
        }

        Admin admin = new Admin();

        admin.setEmail( userRequestDTO.getEmail() );
        admin.setId( userRequestDTO.getId() );
        admin.setLastname( userRequestDTO.getLastname() );
        admin.setPassword( userRequestDTO.getPassword() );
        List<AppRole> list = userRequestDTO.getRoles();
        if ( list != null ) {
            admin.setRoles( new ArrayList<AppRole>( list ) );
        }
        admin.setUsername( userRequestDTO.getUsername() );

        return admin;
    }

    @Override
    public AppRoleResponseDTO roleToRoleDTO(AppRole role) {
        if ( role == null ) {
            return null;
        }

        AppRoleResponseDTO appRoleResponseDTO = new AppRoleResponseDTO();

        appRoleResponseDTO.setDescription( role.getDescription() );
        appRoleResponseDTO.setId( role.getId() );
        appRoleResponseDTO.setRoleName( role.getRoleName() );

        return appRoleResponseDTO;
    }

    @Override
    public AppRole roleRequestDtoToRole(AppRoleRequestDTO roleRequestDTO) {
        if ( roleRequestDTO == null ) {
            return null;
        }

        AppRole appRole = new AppRole();

        appRole.setDescription( roleRequestDTO.getDescription() );
        appRole.setId( roleRequestDTO.getId() );
        appRole.setRoleName( roleRequestDTO.getRoleName() );

        return appRole;
    }
}
