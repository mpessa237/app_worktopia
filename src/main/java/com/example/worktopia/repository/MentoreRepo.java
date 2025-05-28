package com.example.worktopia.repository;


import com.example.worktopia.entity.Mentore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MentoreRepo extends JpaRepository<Mentore, Integer> {

    Optional<Mentore> findByEmail(String email);

    Optional<Mentore> findByFirstnameAndLastname(String firstname, String lastname);

    @Query("select m from Mentore m where m.email = :email")
    Optional<Mentore> fetchByEmail(@Param("email") String email);

    @Query("select m from Mentore m where m.firstname = :firstname and m.lastname = :lastname")
    Optional<Mentore> rechercher(@Param("firstname") String firstname, @Param("lastname") String lastname);

}
