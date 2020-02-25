package com.example.demod.repository;

import com.example.demod.model.Freeboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreeboardRepository extends JpaRepository<Freeboard, Long> {

    Freeboard findByFreeId(Long freeId);
}
