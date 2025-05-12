package com.example.worktopia.controller;

import com.example.worktopia.entity.Competency;
import com.example.worktopia.service.Competency.CompetencyService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompetencyController {
    private final CompetencyService competencyService;

    public CompetencyController(CompetencyService competencyService) {
        this.competencyService = competencyService;
    }
    @PostMapping(path = "comptency/add")
    @ResponseBody
    public ResponseEntity<Competency> addCompetency(@Valid @RequestBody Competency competency){
        return ResponseEntity
                .status(201)
                .body(this.competencyService.addCompetency(competency));

    }
    @GetMapping(path = "comptency/get_by_id/{competencyId}")
    public ResponseEntity<Competency> getCompetencyById(@PathVariable Integer competencyId){
        return ResponseEntity
                .status(200)
                .body(this.competencyService.getCompetencyById(competencyId));

    }
    @GetMapping(path = "competency/get_all competency")
    public ResponseEntity<List<Competency>> getAllCompetency(){
        return ResponseEntity
                .ok(this.competencyService.getAllCompetency());
    }
    @PutMapping(path = "competency/update_by_id/{competency}")
    public ResponseEntity<Competency> updateCompetencyById( @Valid @RequestBody Competency competency, @PathVariable Integer competencyId){
        return ResponseEntity
                .ok(this.competencyService.updateCompetency(competency, competencyId));
    }
    @DeleteMapping(path = "competency/delete_by_id/{competencyId}")
    public ResponseEntity<String> deleteLocationById(@PathVariable Integer competencyId){
        this.competencyService.deleteCompetency(competencyId);
        return ResponseEntity
                .status(202)
                .body("Delete successfully");
    }
}


