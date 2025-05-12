package com.example.worktopia.repository;

import com.example.worktopia.entity.Competency;
import com.example.worktopia.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompetencyRepo extends JpaRepository<Competency, Integer> {
    Optional<Competency> findByName(String nom);

    @Query("select m from Competency m where m.name like %:name%")
    Optional<Competency> fetchByName(@Param("nom") String name);
}
