package com.example.worktopia.controller;


import com.example.worktopia.common.ApiResponse;
import com.example.worktopia.dto.CompetenceReqDTO;
import com.example.worktopia.dto.CompetenceRespDTO;
import com.example.worktopia.dto.MentorReqDTO;
import com.example.worktopia.dto.MentorRespDTO;
import com.example.worktopia.entity.Competence;
import com.example.worktopia.entity.Mentor;
import com.example.worktopia.service.CompetenceService;
import com.example.worktopia.service.MentorService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competence")
public class CompetenceController {
    private final CompetenceService competenceService;

    public CompetenceController(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }

    @PostMapping("save")
    public ResponseEntity<ApiResponse> save(@RequestBody @Validated CompetenceReqDTO competenceReqDTO){
        var competence = competenceService.addCompetence(competenceReqDTO);
        return ResponseEntity.ok(new ApiResponse("saved successfully",competence.getNom()));
    }

    @GetMapping("get_by_id/{competenceId}")
    public ResponseEntity<ApiResponse> getById(@PathVariable Integer competenceId){
        return ResponseEntity.ok(new ApiResponse("saved successfully",this.competenceService.findCompetenceById(competenceId)));
    }


    // @GetMapping("/{nom}")
    //public ResponseEntity<CompetenceRespDTO> getNom(@PathVariable String nom){
    // return ResponseEntity.ok(this.competenceService.findByNom(nom));
    // }

    @GetMapping("getall")
    public ResponseEntity<ApiResponse> getAll(){
        return ResponseEntity.ok(new ApiResponse("all competence found",this.competenceService.getAllCompetence()));

    }

    @PutMapping("edit/{competenceId}")
    public ResponseEntity<ApiResponse> update(@RequestBody Competence competence, @PathVariable Integer competenceId){
        return ResponseEntity.ok(new ApiResponse("all competence found",this.competenceService.updateCompetence(competence, competenceId)));
    }

    @DeleteMapping("delete/{competenceId}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Integer competenceId){
        competenceService.delete(competenceId);
        return ResponseEntity.ok(new ApiResponse("delete successfully", null));
    }
}
