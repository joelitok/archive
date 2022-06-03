package com.proplant.backend.domaines.archive.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proplant.backend.domaines.archive.repository.entity.Archive;

public interface ArchiveRepository extends JpaRepository<Archive, Long> {
    
}
