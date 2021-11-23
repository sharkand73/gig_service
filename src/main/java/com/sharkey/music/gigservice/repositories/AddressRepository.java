package com.sharkey.music.gigservice.repositories;

import com.sharkey.music.gigservice.models.Address;
import com.sharkey.music.gigservice.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
