package com.proplant.backend.domaines.archive.mappers;

import com.proplant.backend.domaines.archive.repository.entity.Archive;
import com.proplant.backend.domaines.archive.web.dto.ArchiveRequestDTO;
import com.proplant.backend.domaines.archive.web.dto.ArichveResponseDTO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-08T15:55:36+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class ArchiveMapperImpl implements ArchiveMapper {

    @Override
    public ArichveResponseDTO archiveToArchiveDTO(Archive archive) {
        if ( archive == null ) {
            return null;
        }

        ArichveResponseDTO arichveResponseDTO = new ArichveResponseDTO();

        return arichveResponseDTO;
    }

    @Override
    public Archive archiveRequestDtoToArchive(ArchiveRequestDTO archiveRequestDTO) {
        if ( archiveRequestDTO == null ) {
            return null;
        }

        Archive archive = new Archive();

        return archive;
    }
}
