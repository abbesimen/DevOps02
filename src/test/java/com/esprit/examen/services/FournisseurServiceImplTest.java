package com.esprit.examen.services;
import static org.junit.Assert.assertEquals;


import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.DetailFournisseurRepository;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.SecteurActiviteRepository;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class FournisseurServiceImplTest {

    @Mock
    private FournisseurRepository fournisseurRepository;

    @Mock
    private DetailFournisseurRepository detailFournisseurRepository;

    @Mock
    private ProduitRepository produitRepository;

    @Mock
    private SecteurActiviteRepository secteurActiviteRepository;

    @InjectMocks
    private FournisseurServiceImpl fournisseurService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRetrieveAllFournisseurs() {
        // Given
        List<Fournisseur> expectedFournisseurs = new ArrayList<>();
        expectedFournisseurs.add(new Fournisseur());
        expectedFournisseurs.add(new Fournisseur());

        when(fournisseurRepository.findAll()).thenReturn(expectedFournisseurs);

        // When
        List<Fournisseur> actualFournisseurs = fournisseurService.retrieveAllFournisseurs();

        // Then
        assertEquals(expectedFournisseurs, actualFournisseurs);
        verify(fournisseurRepository, times(1)).findAll();
    }

    @Test
    public void testAddFournisseur() {
        // Given
        Fournisseur fournisseur = new Fournisseur();
        DetailFournisseur detailFournisseur = new DetailFournisseur();
        fournisseur.setDetailFournisseur(detailFournisseur);

        when(fournisseurRepository.save(fournisseur)).thenReturn(fournisseur);

        // When
        Fournisseur actualFournisseur = fournisseurService.addFournisseur(fournisseur);

        // Then
        assertEquals(fournisseur, actualFournisseur);
        verify(fournisseurRepository, times(1)).save(fournisseur);
    }

    @Test
    public void testUpdateFournisseur() {
        // Given
        Fournisseur fournisseur = new Fournisseur();
        DetailFournisseur detailFournisseur = new DetailFournisseur();
        detailFournisseur.setDateDebutCollaboration(new Date());
        fournisseur.setDetailFournisseur(detailFournisseur);

        when(detailFournisseurRepository.save(detailFournisseur)).thenReturn(detailFournisseur);
        when(fournisseurRepository.save(fournisseur)).thenReturn(fournisseur);

        // When
        Fournisseur actualFournisseur = fournisseurService.updateFournisseur(fournisseur);

        // Then
        assertEquals(fournisseur, actualFournisseur);
        verify(detailFournisseurRepository, times(1)).save(detailFournisseur);
        verify(fournisseurRepository, times(1)).save(fournisseur);
    }

    @Test
    public void testDeleteFournisseur() {
        Long fournisseurId = 1L;
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setIdFournisseur(fournisseurId);

        when(fournisseurRepository.findById(fournisseurId)).thenReturn(Optional.of(fournisseur));

        fournisseurService.deleteFournisseur(fournisseurId);

        Optional<Fournisseur> deletedFournisseur = fournisseurRepository.findById(fournisseurId);
        assertFalse(!deletedFournisseur.isPresent());
    }
}
