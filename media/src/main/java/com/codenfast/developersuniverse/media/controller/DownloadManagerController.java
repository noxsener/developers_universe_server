package com.codenfast.developersuniverse.media.controller;

import com.codenfast.developersuniverse.common.converter.EntityMapper;
import com.codenfast.developersuniverse.common.converter.EntityToDto;
import com.codenfast.developersuniverse.common.entity.media.Media;
import com.codenfast.developersuniverse.entitydto.media.MediaDto;
import com.codenfast.developersuniverse.media.service.DownloadManagerService;
import com.codenfast.developersuniverse.model.CodenfastException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletionException;
import java.util.stream.Collectors;

@RequestMapping(path = "download-manager")
@RestController
@lombok.RequiredArgsConstructor
@Slf4j
public class DownloadManagerController {

    private final DownloadManagerService downloadManagerService;

    @PostMapping("/add-download-queue")
    public ResponseEntity<MediaDto> addDownloadQueue(@RequestBody MediaDto media) {
        try {
            EntityToDto<MediaDto> entityToDto = new EntityToDto<>();
            Media mediaResult = downloadManagerService.addDownloadQueue(EntityMapper.INSTANCE.map(media));
            return new ResponseEntity<>(entityToDto.convertToDto(mediaResult, MediaDto.class), HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PostMapping("/generate-media-from-url")
    public ResponseEntity<MediaDto> generateMediaFromUrl(@RequestBody MediaDto media) {
        try {
            EntityToDto<MediaDto> entityToDto = new EntityToDto<>();
            Media mediaResult = downloadManagerService.generateMediaFromUrl(EntityMapper.INSTANCE.map(media));
            List<String> propertyList = Arrays.asList("id", "artist", "name", "downloadedUrl", "description", "mimeType", "zipMimeType",
                    "size", "fileName", "status.id", "status.name", "partialDownloadSupport", "mediaImage.id", "mediaImage.name",
                    "mediaImage.downloadedUrl", "downloadIntent.id", "downloadIntent.name");
            return new ResponseEntity<>(entityToDto.convertToDto(mediaResult, MediaDto.class, propertyList), HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PostMapping("/download-media")
    public ResponseEntity<MediaDto> downloadMedia(@RequestBody MediaDto media) {
        try {
            return new ResponseEntity<>(downloadManagerService.downloadingProcess(EntityMapper.INSTANCE.map(media)), HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @DeleteMapping("/id/{id}/cancel")
    public ResponseEntity<Void> cancelMedia(@PathVariable String id) {
        try {
            downloadManagerService.cancelMedia(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @PutMapping("/id/{id}/retry-download-process/")
    public ResponseEntity<Void> retryMedia(@PathVariable String id) {
        try {
            downloadManagerService.retryMedia(id);
            return ResponseEntity.ok().build();
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @GetMapping
    public ResponseEntity<List<MediaDto>> waitingMediaList() {
        try {
            List<Media> mediaList = downloadManagerService.waitingMediaList();
            EntityToDto<MediaDto> entityToDto = new EntityToDto<>();
            List<MediaDto> mediaDtoList = mediaList.stream().map(mediaResult -> {
                try {
                    return entityToDto.convertToDto(mediaResult, MediaDto.class);
                } catch (CodenfastException e) {
                    throw new CompletionException(e);
                }
            }).collect(Collectors.toList());
            return new ResponseEntity<>(mediaDtoList, HttpStatus.OK);
        } catch (CodenfastException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }
}
