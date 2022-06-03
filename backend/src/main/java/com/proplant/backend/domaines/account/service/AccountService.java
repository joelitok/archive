package com.proplant.backend.domaines.account.service;

import com.proplant.backend.domaines.account.repository.entity.AppRole;
import com.proplant.backend.domaines.account.web.dto.AdminResponseDTO;
import com.proplant.backend.domaines.account.web.dto.AppRoleResponseDTO;

import java.util.List;

import com.proplant.backend.domaines.account.repository.entity.Admin;

public interface AccountService{
    public AdminResponseDTO saveAdmin(Admin admin);
    public AppRoleResponseDTO saveRole(AppRole role);
    public void addRoleToAdmin(String adminname,String roleName);
    public AdminResponseDTO findUserByUsername(String adminname);
    public void deleteAdmins();
    public void deleteRoles();
    public List<AdminResponseDTO> allAdmins();
}
