package com.proplant.backend.domaines.archive.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.proplant.backend.domaines.archive.mappers.ArchiveMapper;
import com.proplant.backend.domaines.archive.repository.dao.ArchiveRepository;
import com.proplant.backend.domaines.archive.repository.entity.Archive;
import com.proplant.backend.domaines.archive.web.dto.ArchiveRequestDTO;
import com.proplant.backend.domaines.archive.web.dto.ArichveResponseDTO;


@Service
@Transactional
public class ArchiveServiceImpl implements ArchiveService{


    private final ArchiveRepository archiveRepository;
    private final ArchiveMapper archiveMapper;
    public static final String UPLOADED_FOLDER_FILES="./uploads/files";
    public static final String UPLOADED_FOLDER_IMAGES="./uploads/images";


    public ArchiveServiceImpl(ArchiveRepository archiveRepository, 
           ArchiveMapper archiveMapper) {
        this.archiveRepository = archiveRepository;
        this.archiveMapper = archiveMapper;
    }

    @Override
    public void saveFileUpload(byte[] file, byte[] image) throws IOException {
        if (file.length!=0) {
            byte[] bytesFiles = file;
            byte[] bytesImages = image;
            Path pathFiles = Paths.get(UPLOADED_FOLDER_FILES+file);
            Path pathImages = Paths.get(UPLOADED_FOLDER_IMAGES +image);
            Files.write(pathFiles, bytesFiles);
            Files.write(pathImages, bytesImages);
        }
    }

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
    public ArichveResponseDTO newArchive(ArchiveRequestDTO archiveRequestDTO){
        Archive archive =archiveMapper.archiveRequestDtoToArchive(archiveRequestDTO);
        archive.setId(archiveRequestDTO.getId());
        archive.setName(archiveRequestDTO.getName());
        archive.setFile(archiveRequestDTO.getFile());
        archive.setImage(archiveRequestDTO.getImage());
        archive.setDescription(archiveRequestDTO.getDescription());
        archive.setType(archiveRequestDTO.getType());
        
        //enregistrer le fichier dans un dossier
        try {
            saveFileUpload(archiveRequestDTO.getFile(), archiveRequestDTO.getImage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Archive saveArchive =archiveRepository.save(archive);
        return archiveMapper.archiveToArchiveDTO(saveArchive);
    }


    @Override
    public void deleteArchive(Long id) {
    archiveRepository.deleteById(id);  
    }
   
    
}
