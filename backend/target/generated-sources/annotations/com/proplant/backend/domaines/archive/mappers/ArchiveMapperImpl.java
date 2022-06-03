package com.proplant.backend.domaines.archive.mappers;

import com.proplant.backend.domaines.archive.repository.entity.Archive;
import com.proplant.backend.domaines.archive.web.dto.ArchiveRequestDTO;
import com.proplant.backend.domaines.archive.web.dto.ArichveResponseDTO;
import java.util.Arrays;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-03T13:45:02+0200",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 1.4.100.v20220318-0906, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class ArchiveMapperImpl implements ArchiveMapper {

    @Override
    public ArichveResponseDTO archiveToArchiveDTO(Archive archive) {
        if ( archive == null ) {
            return null;
        }

        ArichveResponseDTO arichveResponseDTO = new ArichveResponseDTO();

        arichveResponseDTO.setDescription( archive.getDescription() );
        byte[] file = archive.getFile();
        if ( file != null ) {
            arichveResponseDTO.setFile( Arrays.copyOf( file, file.length ) );
        }
        arichveResponseDTO.setId( archive.getId() );
        byte[] image = archive.getImage();
        if ( image != null ) {
            arichveResponseDTO.setImage( Arrays.copyOf( image, image.length ) );
        }
        arichveResponseDTO.setName( archive.getName() );
        arichveResponseDTO.setType( archive.getType() );

        return arichveResponseDTO;
    }

    @Override
    public Archive archiveRequestDtoToArchive(ArchiveRequestDTO archiveRequestDTO) {
        if ( archiveRequestDTO == null ) {
            return null;
        }

        Archive archive = new Archive();

        archive.setDescription( archiveRequestDTO.getDescription() );
        byte[] file = archiveRequestDTO.getFile();
        if ( file != null ) {
            archive.setFile( Arrays.copyOf( file, file.length ) );
        }
        archive.setId( archiveRequestDTO.getId() );
        byte[] image = archiveRequestDTO.getImage();
        if ( image != null ) {
            archive.setImage( Arrays.copyOf( image, image.length ) );
        }
        archive.setName( archiveRequestDTO.getName() );
        archive.setType( archiveRequestDTO.getType() );

        return archive;
    }
}
