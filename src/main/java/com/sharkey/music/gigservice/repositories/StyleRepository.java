package com.sharkey.music.gigservice.repositories;

import com.sharkey.music.gigservice.models.Skill;
import com.sharkey.music.gigservice.models.Style;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StyleRepository extends JpaRepository<Style, Long> {
}
