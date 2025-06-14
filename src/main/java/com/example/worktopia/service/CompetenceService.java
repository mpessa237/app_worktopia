package com.example.worktopia.service;

import com.example.worktopia.dto.CompetenceReqDTO;
import com.example.worktopia.dto.CompetenceRespDTO;
import com.example.worktopia.dto.MentorReqDTO;
import com.example.worktopia.dto.MentorRespDTO;
import com.example.worktopia.entity.Competence;
import com.example.worktopia.entity.Mentor;
import com.example.worktopia.mapper.CompetenceMapper;
import com.example.worktopia.mapper.MentorMapper;
import com.example.worktopia.repository.CompetenceRepo;
import com.example.worktopia.repository.MentorRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetenceService {

    private final CompetenceRepo competenceRepo;
    private final CompetenceMapper competenceMapper;

    public CompetenceService(CompetenceRepo competenceRepo, CompetenceMapper competenceMapper) {
        this.competenceRepo = competenceRepo;
        this.competenceMapper = competenceMapper;
    }


    public CompetenceRespDTO addCompetence(CompetenceReqDTO competenceReqDTO){
        Competence competence = competenceMapper.toEntity(competenceReqDTO);
        Competence saved = competenceRepo.save(competence);
        return this.competenceMapper.toDTO(saved);
    }

    public CompetenceRespDTO findCompetenceById(Integer competenceId){
        Competence competence = competenceRepo.findById(competenceId)
                .orElseThrow(()-> new EntityNotFoundException("competence not found!!"));
        return competenceMapper.toDTO(competence);
    }

    public List<Competence> getAllCompetence(){
        return this.competenceRepo.findAll();
    }

    //public MentorRespDTO findByNom(String nom){
    // Mentor mentor = mentorRepo.findByNom(nom)
    //      .orElseThrow(()-> new EntityNotFoundException("mentor not found!!"));
    // return mentorMapper.toDTO(mentor);
    //}

    public Competence updateCompetence(Competence competence,Integer competenceId){
        Optional<Competence> competenceOptional = this.competenceRepo.findById(competenceId);

        if (competenceOptional.isEmpty())
            throw new EntityNotFoundException("competence not found!!");
        if (competence.getNom()!=null)
            competenceOptional.get().setNom(competence.getNom());
        if (competence.getDescription()!=null)
            competenceOptional.get().setDescription(competence.getDescription());


        return this.competenceRepo.saveAndFlush(competenceOptional.get());
    }

    public void delete(Integer competenceId) {
        Competence competence = competenceRepo.findById(competenceId)
                .orElseThrow(() -> new EntityNotFoundException("competence not found!!"));
        competenceRepo.delete(competence);
    }
}
