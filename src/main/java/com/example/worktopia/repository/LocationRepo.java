package com.example.worktopia.repository;

import com.example.worktopia.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepo extends JpaRepository<Location, Integer> {

}
