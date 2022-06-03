package com.proplant.backend.domaines.archive.web.dto;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ArchiveRequestDTO{
    
    private Long id;

    private String name;
    private String description;
    private byte[] image;
    private byte[] file;
    private String type;

}
