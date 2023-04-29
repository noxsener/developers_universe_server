package com.codenfast.developersuniverse.common.converter;

import com.codenfast.developersuniverse.common.entity.OfflineDbInfo;
import com.codenfast.developersuniverse.common.entity.download.DownloadIntent;
import com.codenfast.developersuniverse.common.entity.download.DownloadPart;
import com.codenfast.developersuniverse.common.entity.download.DownloadStatus;
import com.codenfast.developersuniverse.common.entity.earchive.ElectronicArchive;
import com.codenfast.developersuniverse.common.entity.earchive.ElectronicArchiveProperty;
import com.codenfast.developersuniverse.common.entity.earchive.ElectronicArchivePropertyValue;
import com.codenfast.developersuniverse.common.entity.media.InvoiceLicence;
import com.codenfast.developersuniverse.common.entity.media.Media;
import com.codenfast.developersuniverse.common.entity.media.MediaDownloadSource;
import com.codenfast.developersuniverse.common.entity.music.Genre;
import com.codenfast.developersuniverse.common.entity.music.MediaGenre;
import com.codenfast.developersuniverse.common.entity.user.*;
import com.codenfast.developersuniverse.entitydto.OfflineDbInfoDto;
import com.codenfast.developersuniverse.entitydto.download.DownloadIntentDto;
import com.codenfast.developersuniverse.entitydto.download.DownloadPartDto;
import com.codenfast.developersuniverse.entitydto.download.DownloadStatusDto;
import com.codenfast.developersuniverse.entitydto.earchvive.ElectronicArchiveDto;
import com.codenfast.developersuniverse.entitydto.earchvive.ElectronicArchivePropertyDto;
import com.codenfast.developersuniverse.entitydto.earchvive.ElectronicArchivePropertyValueDto;
import com.codenfast.developersuniverse.entitydto.media.InvoiceLicenceDto;
import com.codenfast.developersuniverse.entitydto.media.MediaDownloadSourceDto;
import com.codenfast.developersuniverse.entitydto.media.MediaDto;
import com.codenfast.developersuniverse.entitydto.music.GenreDto;
import com.codenfast.developersuniverse.entitydto.music.MediaGenreDto;
import com.codenfast.developersuniverse.entitydto.user.*;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@SuppressWarnings("squid:S1214")
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface EntityMapper {
    EntityMapper INSTANCE = Mappers.getMapper(EntityMapper.class);

    DownloadIntent map(DownloadIntentDto value);
    DownloadPart map(DownloadPartDto value);
    DownloadStatus map(DownloadStatusDto value);
    MediaDownloadSource map(MediaDownloadSourceDto value);
    Media map(MediaDto value);
    MediaGenre map(MediaGenreDto value);
    Genre map(GenreDto value);
    InvoiceLicence map(InvoiceLicenceDto value);
    ElectronicArchive map (ElectronicArchiveDto value);
    ElectronicArchiveProperty map (ElectronicArchivePropertyDto value);
    ElectronicArchivePropertyValue map (ElectronicArchivePropertyValueDto value);

    DownloadIntentDto map(DownloadIntent value);
    DownloadPartDto map(DownloadPart value);
    DownloadStatusDto map(DownloadStatus value);
    MediaDownloadSourceDto map(MediaDownloadSource value);
    MediaDto map(Media value);
    MediaGenreDto map(MediaGenre value);
    GenreDto map(Genre value);
    InvoiceLicenceDto map(InvoiceLicence value);

    Auth map(AuthorizationDto value);
    RoleAuth map(RoleAuthorizationDto value);
    Role map(RoleDto value);
    UserAuth map(UserAuthorizationDto value);
    User map(UserDto value);
    UserRole map(UserRoleDto value);

    AuthorizationDto map(Auth value);
    RoleAuthorizationDto map(RoleAuth value);
    RoleDto map(Role value);
    UserAuthorizationDto map(UserAuth value);
    UserDto map(User value);
    UserRoleDto map(UserRole value);

    ElectronicArchiveDto map (ElectronicArchive value);
    ElectronicArchivePropertyDto map (ElectronicArchiveProperty value);
    ElectronicArchivePropertyValueDto map (ElectronicArchivePropertyValue value);

    OfflineDbInfo map(OfflineDbInfoDto value);
    OfflineDbInfoDto map(OfflineDbInfo value);
}
