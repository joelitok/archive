package com.proplant.backend.domaines.account.web.controller;

import java.security.Principal;
import java.util.List;

import com.proplant.backend.domaines.account.mappers.AccountMapper;
import com.proplant.backend.domaines.account.repository.entity.Admin;
import com.proplant.backend.domaines.account.repository.entity.Register;
import com.proplant.backend.domaines.account.service.AccountService;
import com.proplant.backend.domaines.account.web.api.AccountApi;
import com.proplant.backend.domaines.account.web.dto.AdminResponseDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@RestController
public class AccountRestController implements AccountApi {
  Logger logger = LoggerFactory.getLogger(AccountRestController.class);

  @Autowired
  private AccountService accountService;

  @Autowired
  private AccountMapper accountMapper;

  @Override
  public ResponseEntity<AdminResponseDTO> register(final Register register) {
    logger.info("register new user");
    if (!register.getPassword().equals(register.getRepassword()))
      throw new RuntimeException("You must confirm your password");
    AdminResponseDTO user = accountService.findUserByUsername(register.getUsername());
    if (user != null)
    throw new RuntimeException("this  use already exist");
    Admin admin = accountService.registerAdmin(register);
    accountService.saveAdmin(admin);
    accountService.addRoleToAdmin(register.getUsername(), "USER");
    return ResponseEntity.ok(accountMapper.userToUserDTO(admin));
  }

  @Override
  public ResponseEntity<AdminResponseDTO> profile(final Principal principal) {
    logger.info("get user profile");
    AdminResponseDTO appUser = accountService.findUserByUsername(principal.getName());
    return ResponseEntity.ok(appUser);
  }

  @Override
  public ResponseEntity<List<AdminResponseDTO>> getAllUsers() {
    logger.info("get all Admins");
    return ResponseEntity.ok(accountService.allAdmins());
  }

  @Override
  public ResponseEntity<AdminResponseDTO> getAllUsers(String username) {
    logger.info("list all users by username");
    return ResponseEntity.ok(accountService.findUserByUsername(username));
  }

  @Override
  public ResponseEntity<List<AdminResponseDTO>> getAllUsersSortByParam(String contextId, String dirdId) {
    logger.info("sort users");
    return null;
  }

}
