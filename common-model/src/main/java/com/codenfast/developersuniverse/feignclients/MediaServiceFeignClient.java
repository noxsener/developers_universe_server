package com.codenfast.developersuniverse.feignclients;

import com.codenfast.developersuniverse.configs.FeignClientConfig;
import com.codenfast.developersuniverse.entitydto.download.DownloadIntentDto;
import com.codenfast.developersuniverse.entitydto.download.DownloadStatusDto;
import com.codenfast.developersuniverse.entitydto.media.InvoiceLicenceDto;
import com.codenfast.developersuniverse.entitydto.media.MediaDownloadSourceDto;
import com.codenfast.developersuniverse.entitydto.media.MediaDto;
import com.codenfast.developersuniverse.entitydto.music.GenreDto;
import com.codenfast.developersuniverse.entitydto.music.MediaGenreDto;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.model.TableModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(configuration = FeignClientConfig.class ,name = "MEDIA")
public interface MediaServiceFeignClient {

    @GetMapping(path = "id/{id}")
    ResponseEntity<MediaDto> mediaServiceGetMedia(@PathVariable String id);

    @PostMapping("media/save")
    ResponseEntity<MediaDto> mediaServiceSave(@RequestBody MediaDto dto);

    @PutMapping("media/update")
    ResponseEntity<MediaDto> mediaServiceUpdate(@RequestBody MediaDto dto);
    @DeleteMapping("media/delete/{id}")
    ResponseEntity<Boolean> mediaServiceDelete(@PathVariable String id);
    @PostMapping("media/grid")
    ResponseEntity<List<MediaDto>> mediaServiceGrid(@RequestBody RequestGrid requestGrid);
    @PostMapping("media/grid-table-model")
    ResponseEntity<TableModel<MediaDto>> mediaServiceGridTableModel(@RequestBody RequestGrid requestGrid);


    @PostMapping("download-intent/save")
    ResponseEntity<DownloadIntentDto> downloadIntentServiceSave(@RequestBody DownloadIntentDto dto);
    @PutMapping("download-intent/update")
    ResponseEntity<DownloadIntentDto> downloadIntentServiceUpdate(@RequestBody DownloadIntentDto dto);
    @DeleteMapping("download-intent/delete/{id}")
    ResponseEntity<Boolean> downloadIntentServiceDelete(@PathVariable String id);
    @PostMapping("download-intent/grid")
    ResponseEntity<List<DownloadIntentDto>> downloadIntentServiceGrid(@RequestBody RequestGrid requestGrid);
    @PostMapping("download-intent/grid-table-model")
    ResponseEntity<TableModel<DownloadIntentDto>> downloadIntentServiceGridTableModel(@RequestBody RequestGrid requestGrid);

    @PostMapping( "invoice-licence/save")
    ResponseEntity<InvoiceLicenceDto> invoiceLicenceServiceSave(@RequestBody InvoiceLicenceDto dto);
    @PutMapping("invoice-licence/update")
    ResponseEntity<InvoiceLicenceDto> invoiceLicenceServiceUpdate(@RequestBody InvoiceLicenceDto dto);
    @DeleteMapping("invoice-licence/delete/{id}")
    ResponseEntity<Boolean> invoiceLicenceServiceDelete(@PathVariable String id);
    @PostMapping("invoice-licence/grid")
    ResponseEntity<List<InvoiceLicenceDto>> invoiceLicenceServiceGrid(@RequestBody RequestGrid requestGrid);
    @PostMapping("invoice-licence/grid-table-model")
    ResponseEntity<TableModel<InvoiceLicenceDto>> invoiceLicenceServiceGridTableModel(@RequestBody RequestGrid requestGrid);

    @PostMapping("download-status/save")
    ResponseEntity<DownloadStatusDto> downloadStatusServiceSave(@RequestBody DownloadStatusDto dto);
    @PutMapping("download-status/update")
    ResponseEntity<DownloadStatusDto> downloadStatusServiceUpdate(@RequestBody DownloadStatusDto dto);
    @DeleteMapping("download-status/delete/{id}")
    ResponseEntity<Boolean> downloadStatusServiceDelete(@PathVariable String id);
    @PostMapping("download-status/grid")
    ResponseEntity<List<DownloadStatusDto>> downloadStatusServiceGrid(@RequestBody RequestGrid requestGrid);
    @PostMapping("download-status/grid-table-model")
    ResponseEntity<TableModel<DownloadStatusDto>> downloadStatusServiceGridTableModel(@RequestBody RequestGrid requestGrid);

    @PostMapping("media-download-source/save")
    ResponseEntity<MediaDownloadSourceDto> mediaDownloadSourceServiceSave(@RequestBody MediaDownloadSourceDto dto);
    @PutMapping("media-download-source/update")
    ResponseEntity<MediaDownloadSourceDto> mediaDownloadSourceServiceUpdate(@RequestBody MediaDownloadSourceDto dto);
    @DeleteMapping("media-download-source/delete/{id}")
    ResponseEntity<Boolean> mediaDownloadSourceServiceDelete(@PathVariable String id);
    @PostMapping("media-download-source/grid")
    ResponseEntity<List<MediaDownloadSourceDto>> mediaDownloadSourceServiceGrid(@RequestBody RequestGrid requestGrid);
    @PostMapping("media-download-source/grid-table-model")
    ResponseEntity<TableModel<MediaDownloadSourceDto>> mediaDownloadSourceServiceGridTableModel(@RequestBody RequestGrid requestGrid);

    @PostMapping("download-manager/add-download-queue")
    ResponseEntity<MediaDto> downloadManagerAddDownloadQueue(@RequestBody MediaDto media);
    @PostMapping("download-manager/generate-media-from-url")
    ResponseEntity<MediaDto> downloadManagerGenerateMediaFromUrl(@RequestBody MediaDto media);
    @PostMapping("download-manager/download-media")
    ResponseEntity<MediaDto> downloadManagerDownloadMedia(@RequestBody MediaDto media);
    @DeleteMapping("download-manager/id/{id}/cancel")
    ResponseEntity<Void> downloadManagerCancelMedia(@PathVariable String id);
    @PutMapping("download-manager/retry-download-process/{id}")
    ResponseEntity<Void> downloadManagerRetryMedia(@PathVariable String id);
    @GetMapping
    ResponseEntity<List<MediaDto>> downloadManagerWaitingMediaList();

    @PostMapping("genre/save")
    ResponseEntity<GenreDto> genreServiceSave(@RequestBody GenreDto dto);
    @PutMapping("genre/update")
    ResponseEntity<GenreDto> genreServiceUpdate(@RequestBody GenreDto dto);
    @DeleteMapping("genre/delete/{id}")
    ResponseEntity<Boolean> genreServiceDelete(@PathVariable String id);
    @PostMapping("genre/grid")
    ResponseEntity<List<GenreDto>> genreServiceGrid(@RequestBody RequestGrid requestGrid);
    @PostMapping("genre/grid-table-model")
    ResponseEntity<TableModel<GenreDto>> genreServiceGridTableModel(@RequestBody RequestGrid requestGrid);

    @PostMapping("media-genre/save")
    ResponseEntity<MediaGenreDto> mediaGenreServiceSave(@RequestBody MediaGenreDto dto);
    @PutMapping("media-genre/update")
    ResponseEntity<MediaGenreDto> mediaGenreServiceUpdate(@RequestBody MediaGenreDto dto);
    @DeleteMapping("media-genre/delete/{id}")
    ResponseEntity<Boolean> mediaGenreServiceDelete(@PathVariable String id);
    @PostMapping("media-genre/grid")
    ResponseEntity<List<MediaGenreDto>> mediaGenreServiceGrid(@RequestBody RequestGrid requestGrid);
    @PostMapping("media-genre/grid-table-model")
    ResponseEntity<TableModel<MediaGenreDto>> mediaGenreServiceGridTableModel(@RequestBody RequestGrid requestGrid);

}
