package com.example.worktopia.service.Competency;

import com.example.worktopia.entity.Competency;
import com.example.worktopia.entity.Mentor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CompetencyService {
    Competency addCompetency(Competency competency);
    List<Competency> getAllCompetency();
    Page<Mentor> getMentor(int offset, int pageSize);
    Competency getCompetencyById(Integer competency);
    Competency updateCompetency(Competency competency, Integer competencyId);
    void deleteCompetency(Integer competencyId);
}
