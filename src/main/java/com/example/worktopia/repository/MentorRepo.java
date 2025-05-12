package com.example.worktopia.repository;

import com.example.worktopia.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MentorRepo extends JpaRepository<Mentor,Integer> {
    Optional<Mentor> findByNom(String nom);

    @Query("select m from Mentor m where m.nom like %:nom%")
    Optional<Mentor> fetchByNom(@Param("nom") String nom);
}
