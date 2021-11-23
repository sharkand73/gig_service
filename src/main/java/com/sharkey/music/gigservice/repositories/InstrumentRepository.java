package com.sharkey.music.gigservice.repositories;

import com.sharkey.music.gigservice.models.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
}
