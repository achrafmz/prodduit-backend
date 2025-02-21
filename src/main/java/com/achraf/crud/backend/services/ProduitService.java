package com.achraf.crud.backend.services;

import com.achraf.crud.backend.models.Produit;
import com.achraf.crud.backend.repositorys.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }



    public Produit addProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public Produit updateProduit(Long id, Produit produit) {
        if (produitRepository.existsById(id)) {
            produit.setId(id);
            return produitRepository.save(produit);
        }
        return null;
    }

    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }
    public Produit updateProduit(Produit produit) {
        return produitRepository.save(produit); // Save the updated product
    }

    public Optional<Produit> getProduitById(Long id) {
        return produitRepository.findById(id);
    }
}
