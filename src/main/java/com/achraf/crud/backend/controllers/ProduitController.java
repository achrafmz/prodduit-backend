package com.achraf.crud.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.achraf.crud.backend.models.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produits")
@CrossOrigin(origins = "http://localhost:3000")  // React runs on port 3000 by default
public class ProduitController {

    @Autowired
    private com.achraf.crud.backend.services.ProduitService produitService;

    // Récupérer tous les produits
    @GetMapping
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    // Récupérer un produit par ID
    @GetMapping("/{id}")
    public Optional<Produit> getProduitById(@PathVariable Long id) {
        return produitService.getProduitById(id);
    }

    // Ajouter un produit
    @PostMapping
    public Produit addProduit(@RequestBody Produit produit) {
        return produitService.addProduit(produit);
    }

    // Mettre à jour un produit

    @PutMapping("/{id}")
    public Produit updateProduit(@PathVariable Long id, @RequestBody Produit produit) {
        // Récupérer le produit existant
        Optional<Produit> existingProduitOptional = produitService.getProduitById(id);

        // Vérifier si le produit existe, sinon lever une exception
        if (!existingProduitOptional.isPresent()) {
            throw new RuntimeException("Product not found with id " + id); // Handle error if product doesn't exist
        }

        // Extraire le produit existant
        Produit existingProduit = existingProduitOptional.get();

        // Mettre à jour les champs du produit
        existingProduit.setNom(produit.getNom());
        existingProduit.setDescription(produit.getDescription());
        existingProduit.setPrix(produit.getPrix());

        // Enregistrer le produit mis à jour
        return produitService.updateProduit(existingProduit); // Update product in the service layer
    }

    // Supprimer un produit
    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
    }
}
