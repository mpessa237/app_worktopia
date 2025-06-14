package com.example.worktopia.mapper;


import com.example.worktopia.dto.CompetenceReqDTO;
import com.example.worktopia.dto.CompetenceRespDTO;
import com.example.worktopia.dto.MentorReqDTO;
import com.example.worktopia.dto.MentorRespDTO;
import com.example.worktopia.entity.Competence;
import com.example.worktopia.entity.Mentor;
import org.springframework.stereotype.Component;

@Component
public class CompetenceMapper {

    public Competence toEntity(CompetenceReqDTO competenceReqDTO){
        Competence competence = new Competence();
        competence.setNom(competenceReqDTO.getNom());
        competence.setDescription(competenceReqDTO.getDescription());

        return competence;
    }

    public CompetenceRespDTO toDTO(Competence competence){
        CompetenceRespDTO competenceRespDTO = new CompetenceRespDTO();
        competenceRespDTO.setNom(competence.getNom());
        competenceRespDTO.setDescription(competence.getDescription());

        return competenceRespDTO;
    }
}
