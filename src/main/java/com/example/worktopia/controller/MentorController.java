package com.example.worktopia.controller;


import com.example.worktopia.dto.MentorReqDTO;
import com.example.worktopia.dto.MentorRespDTO;
import com.example.worktopia.entity.Mentor;
import com.example.worktopia.service.MentorService;
import com.example.worktopia.common.ApiResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/mentor")
public class MentorController {
    private final MentorService mentorService;

    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> save(@RequestBody @Validated MentorReqDTO mentorReqDTO){
        var mentor = mentorService.addMentor(mentorReqDTO);
        return ResponseEntity.ok(new ApiResponse("saved successfully",mentor.getNom()));
    }

    @GetMapping("get_by_id/{mentorId}")
    public ResponseEntity<MentorRespDTO> getById(@PathVariable Integer mentorId){
        return ResponseEntity.ok(this.mentorService.findMentorById(mentorId));
    }


   // @GetMapping("/{nom}")
    //public ResponseEntity<MentorRespDTO> getNom(@PathVariable String nom){
       // return ResponseEntity.ok(this.mentorService.findByNom(nom));
   // }

    @GetMapping("/getall")
    public ResponseEntity<ApiResponse> getAll(){
        return ResponseEntity.ok(new ApiResponse("all mentors found", this.mentorService.getAllMentor()));

    }

    @PutMapping("/edit/{mentorId}")
    public ResponseEntity<Mentor> update(@RequestBody Mentor mentor, @PathVariable Integer mentorId){
        return ResponseEntity.ok(this.mentorService.updateMentor(mentor, mentorId));
    }

    @DeleteMapping("delete/{mentorId}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Integer mentorId){
        mentorService.delete(mentorId);
        return ResponseEntity.ok(new ApiResponse("delete successfully", null));
    }

}
