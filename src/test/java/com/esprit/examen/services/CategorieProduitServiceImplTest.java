package com.esprit.examen.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.esprit.examen.services.CategorieProduitServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.repositories.CategorieProduitRepository;
@RunWith(MockitoJUnitRunner.class)
public class CategorieProduitServiceImplTest {

    @InjectMocks
    CategorieProduitServiceImpl categorieProduitService;

    @Mock
    CategorieProduitRepository categorieProduitRepository;
    @Test
    public void retrieveAllCategorieProduitsTest() {
        List<CategorieProduit> expectedCategorieProduits = new ArrayList<>();
        Mockito.when(categorieProduitRepository.findAll()).thenReturn(expectedCategorieProduits);
        List<CategorieProduit> actualCategorieProduits = categorieProduitService.retrieveAllCategorieProduits();
        assertEquals(actualCategorieProduits,expectedCategorieProduits);
    }
    @Test
    public void testRetrieveAllCategorieProduits() {
        List<CategorieProduit> categorieProduits = new ArrayList<CategorieProduit>();
        categorieProduits.add(new CategorieProduit());

        when(categorieProduitRepository.findAll()).thenReturn(categorieProduits);

        List<CategorieProduit> result = categorieProduitService.retrieveAllCategorieProduits();

        assertNotNull(result);
        assertEquals(1, result.size());
    }
    @Test
    public void testAddCategorieProduit() {
        CategorieProduit cp = new CategorieProduit();
        cp.setCodeCategorie("new category");

        when(categorieProduitRepository.save(cp)).thenReturn(cp);

        CategorieProduit result = categorieProduitService.addCategorieProduit(cp);

        assertNotNull(result);
        assertEquals("new category", result.getCodeCategorie());
    }
    @Test
    public void addCategorieProduitTest() {
        CategorieProduit expectedCategorieProduit = new CategorieProduit();
        expectedCategorieProduit.setIdCategorieProduit(3l);
        expectedCategorieProduit.setCodeCategorie("categorie3");

        Mockito.when(categorieProduitRepository.save(expectedCategorieProduit)).thenReturn(expectedCategorieProduit);
        CategorieProduit actualCategorieProduit = categorieProduitService.addCategorieProduit(expectedCategorieProduit);
        assertEquals(actualCategorieProduit,expectedCategorieProduit);
    }
    @Test
    public void testDeleteCategorieProduit() {
        Long id = 1L;

        doNothing().when(categorieProduitRepository).deleteById(id);

        categorieProduitService.deleteCategorieProduit(id);

        verify(categorieProduitRepository).deleteById(id);
    }
    @Test
    public void testUpdateCategorieProduit() {
        CategorieProduit cp = new CategorieProduit();
        cp.setCodeCategorie("category1");
        cp.setIdCategorieProduit(1L);

        when(categorieProduitRepository.save(cp)).thenReturn(cp);

        CategorieProduit result = categorieProduitService.updateCategorieProduit(cp);

        assertNotNull(result);
        assertEquals("category1", result.getCodeCategorie());
    }
    @Test
    public void testRetrieveCategorieProduit() {
        CategorieProduit cp = new CategorieProduit();
        cp.setCodeCategorie("category1");
        cp.setIdCategorieProduit(1L);

        when(categorieProduitRepository.findById(1L)).thenReturn(Optional.of(cp));

        CategorieProduit result = categorieProduitService.retrieveCategorieProduit(1L);

        assertNotNull(result);
    }
}
