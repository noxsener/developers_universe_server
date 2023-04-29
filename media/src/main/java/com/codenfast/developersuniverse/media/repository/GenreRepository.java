package com.codenfast.developersuniverse.media.repository;

import com.codenfast.developersuniverse.common.entity.music.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, String>, GenreRepositoryCustom {
}
