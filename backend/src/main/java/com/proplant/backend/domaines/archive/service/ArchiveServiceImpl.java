package com.proplant.backend.domaines.archive.service;

import java.util.List;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.proplant.backend.domaines.archive.mappers.ArchiveMapper;
import com.proplant.backend.domaines.archive.repository.dao.ArchiveRepository;
import com.proplant.backend.domaines.archive.repository.entity.Archive;
import com.proplant.backend.domaines.archive.web.dto.ArchiveRequestDTO;
import com.proplant.backend.domaines.archive.web.dto.ArichveResponseDTO;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class ArchiveServiceImpl implements ArchiveService{
    private final ArchiveRepository archiveRepository;
    private final ArchiveMapper archiveMapper;

    @Override
    public ArichveResponseDTO getArchives(Long id) {
       Archive archive = archiveRepository.findById(id).orElse(null);
       if(archive==null) throw new RuntimeException("Archive not found");
        return archiveMapper.archiveToArchiveDTO(archive);
    }

    
    @Override
    public List<ArichveResponseDTO> listArchives() {
        List<Archive> archives = archiveRepository.findAll();
        return archives.stream().map((res)->archiveMapper.archiveToArchiveDTO(res)).collect(Collectors.toList());
    }

    
    @Override
    public ArichveResponseDTO newArchive(ArchiveRequestDTO archiveRequestDTO) {
        Archive archive =archiveMapper.archiveRequestDtoToArchive(archiveRequestDTO);
        archive.setId(archiveRequestDTO.getId());
        archive.setName(archiveRequestDTO.getName());
        Archive saveArchive =archiveRepository.save(archive);
        return archiveMapper.archiveToArchiveDTO(saveArchive);
    }


    @Override
    public void deleteArchive(Long id) {
    archiveRepository.deleteById(id);  
    }

    
    
}
