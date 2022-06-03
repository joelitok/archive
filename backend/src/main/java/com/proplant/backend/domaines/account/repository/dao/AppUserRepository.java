package com.proplant.backend.domaines.account.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proplant.backend.domaines.account.repository.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long>{
    public AppUser findByUsername(String username);
}
