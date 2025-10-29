package com.backend.restoran.repositories;

import com.backend.restoran.models.ServiceFeature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceFeatureRepository extends JpaRepository<ServiceFeature, Long> {
}
