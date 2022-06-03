package com.proplant.backend.domaines.archive.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.proplant.backend.domaines.archive.service.ArchiveService;
import com.proplant.backend.domaines.archive.web.api.ArchiveApi;
import com.proplant.backend.domaines.archive.web.dto.ArchiveRequestDTO;
import com.proplant.backend.domaines.archive.web.dto.ArichveResponseDTO;

@RequestMapping("/archive")
@RestController
public class ArchiveRestController implements ArchiveApi{
     Logger logger = LoggerFactory.getLogger(ArchiveRestController.class);
    @Autowired
    private ArchiveService archiveService;

    @Override
    public ResponseEntity<ArichveResponseDTO> getArchives(Long archiveId) {
        logger.info("get Archive");
       return ResponseEntity.ok(archiveService.getArchives(archiveId));
    }

    @Override
    public ResponseEntity<List<ArichveResponseDTO>> listArchives() {
        logger.info("list all Archives");
        return ResponseEntity.ok(archiveService.listArchives());
    }

    @Override
    public ResponseEntity<ArichveResponseDTO> newArchive(ArchiveRequestDTO ArchiveRequestDTO){
        logger.info("add new Archive");
        return ResponseEntity.ok(archiveService.newArchive(ArchiveRequestDTO));
    }

    @Override
    public ResponseEntity<Void> deleteArchive(Long archiveId) {
        logger.info("delete Archive");
    archiveService.deleteArchive(archiveId);
    return null;
    }
  
}
