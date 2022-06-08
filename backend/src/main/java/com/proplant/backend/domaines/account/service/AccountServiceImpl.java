package com.proplant.backend.domaines.account.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.proplant.backend.domaines.account.repository.dao.AppRoleRepository;
import com.proplant.backend.domaines.account.mappers.AccountMapper;
import com.proplant.backend.domaines.account.repository.dao.AdminRepository;
import com.proplant.backend.domaines.account.repository.entity.AppRole;
import com.proplant.backend.domaines.account.repository.entity.AppUser;
import com.proplant.backend.domaines.account.repository.entity.Register;
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
    private AppRoleRepository appRoleRepository;
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
        return accountMapper.roleToRoleDTO(appRoleRepository.save(role));
    }

    @Override
    public void addRoleToAdmin(String username, String roleName) {
        AppRole role = appRoleRepository.findByRoleName(roleName);
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
        appRoleRepository.deleteAll();
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

    @Override
    public Admin registerAdmin(Register register) {
        Admin admin = new Admin();
        admin.setEmail(register.getEmail());
        admin.setLastname(register.getLastname());
        admin.setUsername(register.getUsername());
        admin.setPersonalNumber(register.getPersonalNumber());
        admin.setPassword(register.getPassword());
        return admin;
    }

    @Override
    public AppUser registerUser(Register register) {
        AppUser appUser = new AppUser();
        appUser.setEmail(register.getEmail());
        appUser.setLastname(register.getLastname());
        appUser.setUsername(register.getUsername());
        appUser.setPassword(register.getPassword());
        return appUser;
    }

}
