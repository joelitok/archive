package com.proplant.backend.domaines.account.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.proplant.backend.domaines.account.repository.dao.RoleRepository;
import com.proplant.backend.domaines.account.mappers.AccountMapper;
import com.proplant.backend.domaines.account.repository.dao.AdminRepository;
import com.proplant.backend.domaines.account.repository.entity.AppRole;
import com.proplant.backend.domaines.account.web.dto.AdminResponseDTO;
import com.proplant.backend.domaines.account.web.dto.AppRoleResponseDTO;
import com.proplant.backend.domaines.account.repository.entity.Admin;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private AdminRepository adminRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private AccountMapper accountMapper;

    @Override
    public AdminResponseDTO saveAdmin(Admin admin) {
        String hashPW = bCryptPasswordEncoder.encode(admin.getPassword());
        admin.setPassword(hashPW);
        return accountMapper.userToUserDTO(adminRepository.save(admin));
    }

    @Override
    public AppRoleResponseDTO saveRole(AppRole role) {
        return accountMapper.roleToRoleDTO(roleRepository.save(role));
    }

    @Override
    public void addRoleToAdmin(String username, String roleName) {
        AppRole role = roleRepository.findByRoleName(roleName);
        Admin admin = adminRepository.findByUsername(username);
        admin.getRoles().add(role);
    }

    @Override
    public AdminResponseDTO findUserByUsername(String username) {
        return accountMapper.userToUserDTO(adminRepository.findByUsername(username));
    }

    @Override
    public void deleteAdmins() {
        adminRepository.deleteAll();
    }

    @Override
    public void deleteRoles() {
        roleRepository.deleteAll();
    }

    @Override
    public List<AdminResponseDTO> allAdmins() {
        List<Admin> admins = adminRepository.findAll();
        List<AdminResponseDTO> adminResponseDTOs = new ArrayList<>();
        for (Admin admin : admins) {
            adminResponseDTOs.add(accountMapper.userToUserDTO(admin));
        }
        return adminResponseDTOs;
    }

}
