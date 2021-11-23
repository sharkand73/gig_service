package com.sharkey.music.gigservice.repositories;

import com.sharkey.music.gigservice.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
