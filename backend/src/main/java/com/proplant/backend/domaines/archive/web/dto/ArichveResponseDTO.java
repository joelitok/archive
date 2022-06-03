package com.proplant.backend.domaines.archive.web.dto;



import lombok.Data;

@Data
public class ArichveResponseDTO {
    private Long id;
    
    private String name;
    private String description;
    private byte[] image;
    private byte[] file;
    private String type;
}
