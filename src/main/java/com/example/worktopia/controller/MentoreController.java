package com.example.worktopia.controller;

import com.example.worktopia.dto.Mentore.MentoreReqDTO;
import com.example.worktopia.dto.Mentore.MentoreRespDTO;
import com.example.worktopia.entity.Mentore;
import com.example.worktopia.service.Mentore.MentoreService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MentoreController {
    public final MentoreService mentoreService;

    public MentoreController(MentoreService mentoreService) {
        this.mentoreService = mentoreService;
    }

    @PostMapping(path = "mentores/add")
    public ResponseEntity<MentoreRespDTO> addMentore(@Valid @RequestBody MentoreReqDTO mentoreReqDTO){

        return ResponseEntity
                .status(201)
                .body(this.mentoreService.addMentore(mentoreReqDTO));
    }

    @GetMapping(path = "Mentores/get_all")
    public ResponseEntity<List<Mentore>> getMentores(){

        return ResponseEntity
                .status(200)
                .body(this.mentoreService.getMentores());
    }

    @GetMapping(path = "mentores/get_all/{offset}/{pageSize}")
    public ResponseEntity<Page<MentoreRespDTO>> getMentores(@PathVariable int offset, @PathVariable int pageSize){

        return ResponseEntity
                .status(200)
                .body(this.mentoreService.getMentores(offset, pageSize));
    }

    @GetMapping(path = "mentores/get_by_id/{mentoreId}")
    public ResponseEntity<Mentore> getMentoreById(@PathVariable Integer mentoreId){

        return ResponseEntity
                .status(200)
                .body(this.mentoreService.getMentoreById(mentoreId));
    }

    @GetMapping(path = "mentores/get_by_email{email}")
    public ResponseEntity<Mentore> getMentoreByEmail(@PathVariable String email){

        return ResponseEntity
                .status(200)
                .body(this.mentoreService.getMentoreByEmail(email));
    }

    @GetMapping(path = "mentores/get_by_firstname_lastname{firstname}{lastname}")
    public ResponseEntity<Mentore> getMentoreByFirstnameAndLastname(@PathVariable String firstname, @PathVariable String lastname){

        return ResponseEntity
                .status(200)
                .body(this.mentoreService.getMentoreByFirstnameAndLastname(firstname, lastname));
    }

    @PutMapping(path = "mentores/update_by_id/{mentoreId}")
    public ResponseEntity<Mentore> updateMentoreById(@PathVariable Integer mentoreId, @Valid @RequestBody  Mentore mentore){

        return ResponseEntity
                .status(202)
                .body(this.mentoreService.updateMentore(mentore,mentoreId));
    }

    @DeleteMapping(path = "mentores/delete_by_id/{mentoreId}")
    public ResponseEntity<String> deleteMentoreById(@PathVariable Integer mentoreId){
        this.mentoreService.deleteMentore(mentoreId);
        return ResponseEntity
                .status(202)
                .body("Deleted successfully !");
    }
}
