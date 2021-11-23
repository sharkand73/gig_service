package com.sharkey.music.gigservice.repositories;


import com.sharkey.music.gigservice.models.Gig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GigRepository extends JpaRepository<Gig, Long> {
}
