package com.achraf.crud.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "produit") // Nom de la table en BD
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String description;
    private double prix;

    // Constructeurs
    public Produit() {}

    public Produit(String nom, String description, double prix) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }
}
