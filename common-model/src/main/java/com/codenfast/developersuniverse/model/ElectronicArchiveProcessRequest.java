package com.codenfast.developersuniverse.model;

import com.codenfast.developersuniverse.entitydto.earchvive.ElectronicArchiveDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ElectronicArchiveProcessRequest {
    ElectronicArchiveLoginModel electronicArchiveLoginModel;
    ElectronicArchiveDto folder;
    ElectronicArchiveDto file;
}
