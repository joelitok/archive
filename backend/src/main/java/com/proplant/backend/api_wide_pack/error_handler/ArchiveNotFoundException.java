package com.proplant.backend.api_wide_pack.error_handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ArchiveNotFoundException extends RuntimeException {
    
    public ArchiveNotFoundException(String message){
        super(message);
    }
    

}
