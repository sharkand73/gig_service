package com.sharkey.music.gigservice.repositories;

import com.sharkey.music.gigservice.models.Details;
import com.sharkey.music.gigservice.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailsRepository extends JpaRepository<Details, Long> {
}
