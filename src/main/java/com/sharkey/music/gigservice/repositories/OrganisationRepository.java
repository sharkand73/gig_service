package com.sharkey.music.gigservice.repositories;

import com.sharkey.music.gigservice.models.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationRepository extends JpaRepository<Organisation, Long> {
}
