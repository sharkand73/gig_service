package com.sharkey.music.gigservice.repositories;


import com.sharkey.music.gigservice.models.Gig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GigRepository extends JpaRepository<Gig, Long> {
    //public List<Gig> findByStartTimeYear(int year);
}
