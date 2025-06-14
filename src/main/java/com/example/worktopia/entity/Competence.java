package com.example.worktopia.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "competence")
public class Competence {
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

