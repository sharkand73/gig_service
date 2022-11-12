package com.sharkey.music.gigservice.repositories;

import com.sharkey.music.gigservice.models.BookingGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;
import java.util.List;

public interface BookingGroupRepository extends JpaRepository<BookingGroup, Long> {
    List<BookingGroup> findBookingGroupByArchived(boolean isArchived);
}
