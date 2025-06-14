package com.example.worktopia.mapper;

import com.example.worktopia.dto.MentorReqDTO;
import com.example.worktopia.dto.MentorRespDTO;
import com.example.worktopia.entity.Mentor;
import org.springframework.stereotype.Component;

@Component
public class MentorMapper {

    public Mentor toEntity(MentorReqDTO mentorReqDTO){
        Mentor mentor = new Mentor();
        mentor.setNom(mentorReqDTO.getNom());
        mentor.setPrenom(mentorReqDTO.getPrenom());
        mentor.setTelephone(mentorReqDTO.getTelephone());
        mentor.setEmail(mentorReqDTO.getEmail());
        mentor.setDomaine(mentorReqDTO.getDomaine());
        mentor.setBibliographie(mentorReqDTO.getBibliographie());

        return mentor;
    }

    public MentorRespDTO toDTO(Mentor mentor){
        MentorRespDTO mentorRespDTO = new MentorRespDTO();
        mentorRespDTO.setNom(mentor.getNom());
        mentorRespDTO.setPrenom(mentor.getPrenom());
        mentorRespDTO.setTelephone(mentor.getTelephone());
        mentorRespDTO.setEmail(mentor.getEmail());
        mentorRespDTO.setDomaine(mentor.getDomaine());
        mentorRespDTO.setBibliographie(mentor.getBibliographie());

        return mentorRespDTO;
    }
}
