package com.example.spingsecurity.repository;

import com.example.spingsecurity.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegionRepository extends JpaRepository <Region, Long> {
    Optional<Object> findByName(String name);
}
