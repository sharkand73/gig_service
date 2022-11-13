package com.sharkey.music.gigservice.repositories;


import com.sharkey.music.gigservice.models.Gig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GigRepository extends JpaRepository<Gig, Long> {
    @Query("from GIG where YEAR(startTime)=?1")
    List<Gig> findByYear(int year);
}
