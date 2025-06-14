package com.example.worktopia.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetenceRespDTO {
    private Integer CompetencyId;
    private String nom;
    private String description;

    public Integer getCompetencyId() {
        return CompetencyId;
    }

    public void setCompetencyId(Integer competencyId) {
        CompetencyId = competencyId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
