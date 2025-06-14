package com.example.worktopia.repository;

import com.example.worktopia.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MentorRepo extends JpaRepository<Mentor,Integer> {
   // Optional<Mentor> findByNom(String nom);
}
