package com.sharkey.music.gigservice.repositories;

import com.sharkey.music.gigservice.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
