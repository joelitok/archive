package com.proplant.backend.utils;

import com.proplant.backend.domaines.account.service.AccountService;
import com.proplant.backend.domaines.archive.mappers.ArchiveMapper;
import com.proplant.backend.domaines.archive.repository.dao.ArchiveRepository;
import com.proplant.backend.domaines.archive.repository.entity.Archive;
import com.proplant.backend.domaines.archive.service.ArchiveService;
import com.proplant.backend.domaines.archive.web.dto.ArchiveRequestDTO;
import com.proplant.backend.domaines.archive.web.dto.ArichveResponseDTO;

import org.springframework.http.ResponseEntity;

public class LoadDataDB{
    public final ArchiveService ArchiveService;
    public final AccountService accountService;
    public final ArchiveMapper ArchiveMapper;
    public final ArchiveRepository ArchiveRepository;

    public LoadDataDB(
    ArchiveService archiveService, 
    AccountService accountService,
    ArchiveMapper archiveMapper,
    ArchiveRepository archiveRepository
    ) {
        this.ArchiveService = archiveService;
        this.accountService = accountService;
        this.ArchiveMapper = archiveMapper;
        this.ArchiveRepository = archiveRepository;
    }

    
    /*public ResponseEntity<ArichveResponseDTO> loadArchiveDB(ArchiveRequestDTO archiveRequestDTO){
            Archive archive =archiveMapper.archiveRequestDtoToArchive(archiveRequestDTO);
            archive.setName(archiveRequestDTO.getName());
            Archive saveArchive = archiveRepository.save(archive);
            return ResponseEntity.ok(archiveMapper.archiveToArchiveDTO(saveArchive));
  
    }*/
}
