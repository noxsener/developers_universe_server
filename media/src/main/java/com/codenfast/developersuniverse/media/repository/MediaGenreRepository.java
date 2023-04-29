package com.codenfast.developersuniverse.media.repository;

import com.codenfast.developersuniverse.common.entity.music.MediaGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaGenreRepository extends JpaRepository<MediaGenre, String>, MediaGenreRepositoryCustom {
}
