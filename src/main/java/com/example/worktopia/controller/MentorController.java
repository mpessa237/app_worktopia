package com.example.worktopia.controller;

import com.example.worktopia.entity.Mentor;
import com.example.worktopia.service.Mentor.MentorService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MentorController {
    private final MentorService mentorService;

    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }
    @PostMapping(path = "mentor/add")
    @ResponseBody
    public ResponseEntity<Mentor> addMentor(@Valid @RequestBody Mentor mentor){
        return ResponseEntity
                .ok(this.mentorService.addMentor(mentor));


    }
    @GetMapping(path = "mentor/get_all mentor")
    public ResponseEntity<List<Mentor>>getAllMentor(){
        return ResponseEntity
                .ok(this.mentorService.getAllMentor());
    }
    @GetMapping(path = "mentor/get_by/{nom}")
    public ResponseEntity<Mentor> getMentorByNom(@PathVariable String nom){
        return ResponseEntity
                .status(200)
                .body(this.mentorService.getMentorByNom(nom));
    }
    @GetMapping(path = "mentor/get_all/{offset}/{pageSize}")
    public ResponseEntity<Page<Mentor>> getMentor(@PathVariable int offset, @PathVariable int pageSize){
        return ResponseEntity
                .ok(this.mentorService.getMentor(offset, pageSize));
    }
    @PutMapping(path = "mentor/update_by_id/{mentorId}")
    public ResponseEntity<Mentor> updateMentorById(@Valid @RequestBody Mentor mentor, @PathVariable Integer mentorId){
        return ResponseEntity
                .ok(this.mentorService.getMentorById(mentorId));
    }
    @DeleteMapping(path = "mentor/delete_by_id/{mentorId}")
    public ResponseEntity<String> deleteMentorById(@PathVariable Integer mentor){
        this.mentorService.deleteMentor(mentor);
        return ResponseEntity
                .ok("le mentor à été supprimer avec succès");
    }
}



