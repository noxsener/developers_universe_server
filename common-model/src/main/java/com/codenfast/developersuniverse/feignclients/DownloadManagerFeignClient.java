package com.codenfast.developersuniverse.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DOWNLOAD-MANAGER", path = "mail")
public interface DownloadManagerFeignClient {

    @GetMapping(value = "/template/{templateName}",produces = MediaType.TEXT_PLAIN_VALUE)
    ResponseEntity<String> getTemplate(@PathVariable String templateName);

}