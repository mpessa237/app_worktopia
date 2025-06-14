package com.example.worktopia.dto;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetenceReqDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CompetencyId;
    @NotEmpty(message = "le nom est obligatoire")
    @Column(nullable = false)
    @NotEmpty(message = "ce champs ne doit pas être vide")
    @Length(min = 3, message = "ce champs doit contenir au moin 3 caractère")
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
