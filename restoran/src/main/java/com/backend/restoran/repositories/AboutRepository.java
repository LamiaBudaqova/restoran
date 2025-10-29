package com.backend.restoran.repositories;

import com.backend.restoran.models.About;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AboutRepository extends JpaRepository<About, Long> {
}
