package com.sharkey.music.gigservice.repositories;

import com.sharkey.music.gigservice.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
