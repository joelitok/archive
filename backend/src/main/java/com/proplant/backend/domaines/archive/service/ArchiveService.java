package com.proplant.backend.domaines.archive.service;

import java.util.List;

import com.proplant.backend.domaines.archive.web.dto.ArchiveRequestDTO;
import com.proplant.backend.domaines.archive.web.dto.ArichveResponseDTO;

public interface ArchiveService{

    ArichveResponseDTO getArchives(Long id);
    
    List<ArichveResponseDTO> listArchives();
    
    ArichveResponseDTO newArchive(ArchiveRequestDTO archiveRequestDTO);

    void deleteArchive(Long id);
    
}
