package com.example.worktopia.repository;

import com.example.worktopia.entity.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenceRepo extends JpaRepository<Competence, Integer> {
}
