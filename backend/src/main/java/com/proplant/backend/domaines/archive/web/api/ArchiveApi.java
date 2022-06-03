package com.proplant.backend.domaines.archive.web.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import com.proplant.backend.api_wide_pack.error_handler.ApiErrorDto;
import com.proplant.backend.domaines.archive.repository.entity.Archive;
import com.proplant.backend.domaines.archive.web.dto.ArchiveRequestDTO;
import com.proplant.backend.domaines.archive.web.dto.ArichveResponseDTO;

import org.springframework.http.ResponseEntity;

public interface ArchiveApi {
    @Operation(summary = "Request to get a new Archive")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Rssource get successful",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Archive.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request - Invalid request or validation failed.",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorDto.class))),
        @ApiResponse(responseCode = "404", description = "No content found",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorDto.class)))})
    @GetMapping(path = "/{archiveId}", produces = {APPLICATION_JSON_VALUE})
    ResponseEntity<ArichveResponseDTO> getArchives(@Parameter(in = ParameterIn.PATH, required = true)  @PathVariable Long archiveId);  

    @Operation(summary = "Request to get list Archive")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Archive get successful",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Archive.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request - Invalid request or validation failed.",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorDto.class))),
        @ApiResponse(responseCode = "404", description = "No content found",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorDto.class)))})
    @GetMapping(path = "/all", produces = {APPLICATION_JSON_VALUE})
    ResponseEntity<List<ArichveResponseDTO>> listArchives();


    @Operation(summary = "Request to post a new Archive ")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Archive post successful",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Archive.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request - Invalid request or validation failed.",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorDto.class))),
        @ApiResponse(responseCode = "404", description = "No content found",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorDto.class)))})
    @PostMapping(path = "/new", produces = {APPLICATION_JSON_VALUE})
    ResponseEntity<ArichveResponseDTO> newArchive(@RequestBody ArchiveRequestDTO archiveRequestDTO);  



@Operation(summary = "Request to delete a new Archive ")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Archive delete successful",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Archive.class))),
        @ApiResponse(responseCode = "400", description = "Bad Request - Invalid request or validation failed.",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorDto.class))),
        @ApiResponse(responseCode = "404", description = "No content found",
            content = @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = ApiErrorDto.class)))})
    @PostMapping(path = "/delete/{archiveId}", produces = {APPLICATION_JSON_VALUE})
    ResponseEntity<Void> deleteArchive(@PathVariable Long archiveId); 

    
}
