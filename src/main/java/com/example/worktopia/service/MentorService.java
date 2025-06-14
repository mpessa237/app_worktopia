package com.example.worktopia.service;

import com.example.worktopia.dto.MentorReqDTO;
import com.example.worktopia.dto.MentorRespDTO;
import com.example.worktopia.entity.Mentor;
import com.example.worktopia.mapper.MentorMapper;
import com.example.worktopia.repository.MentorRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorService {
    private final MentorRepo mentorRepo;
    private final MentorMapper mentorMapper;

    public MentorService(MentorRepo mentorRepo, MentorMapper mentorMapper) {
        this.mentorRepo = mentorRepo;
        this.mentorMapper = mentorMapper;
    }

    public MentorRespDTO addMentor(MentorReqDTO mentorReqDTO){
        Mentor mentor = mentorMapper.toEntity(mentorReqDTO);
        Mentor saved = mentorRepo.save(mentor);
        return this.mentorMapper.toDTO(saved);
    }

    public MentorRespDTO findMentorById(Integer mentorId){
        Mentor mentor = mentorRepo.findById(mentorId)
                .orElseThrow(()-> new EntityNotFoundException("mentor not found!!"));
        return mentorMapper.toDTO(mentor);
    }

    public List<Mentor> getAllMentor(){
        return this.mentorRepo.findAll();
    }

    //public MentorRespDTO findByNom(String nom){
       // Mentor mentor = mentorRepo.findByNom(nom)
          //      .orElseThrow(()-> new EntityNotFoundException("mentor not found!!"));
       // return mentorMapper.toDTO(mentor);
    //}

    public Mentor updateMentor(Mentor mentor,Integer mentorId){
        Optional<Mentor>mentorOptional = this.mentorRepo.findById(mentorId);

        if (mentorOptional.isEmpty())
            throw new EntityNotFoundException("mentor not found!!");
        if (mentor.getNom()!=null)
            mentorOptional.get().setNom(mentor.getNom());
        if (mentor.getPrenom()!= null)
            mentorOptional.get().setPrenom(mentor.getPrenom());
        return this.mentorRepo.saveAndFlush(mentorOptional.get());
    }

    public void delete(Integer mentorId) {
        Mentor mentor = mentorRepo.findById(mentorId)
                .orElseThrow(() -> new EntityNotFoundException("mentor not found!!"));
        mentorRepo.delete(mentor);
    }

}
