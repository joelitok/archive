package com.proplant.backend.domaines.archive.mappers;

import org.mapstruct.Mapper;

import com.proplant.backend.domaines.archive.repository.entity.Archive;
import com.proplant.backend.domaines.archive.web.dto.ArchiveRequestDTO;
import com.proplant.backend.domaines.archive.web.dto.ArichveResponseDTO;

@Mapper(componentModel = "spring")
public interface ArchiveMapper{
    ArichveResponseDTO archiveToArchiveDTO(Archive archive);
    Archive archiveRequestDtoToArchive(ArchiveRequestDTO archiveRequestDTO);
}
