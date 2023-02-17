package com.esprit.examen.services;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class OperateurServiceImplTest {

    @Mock
    private OperateurRepository operateurRepository;

    @InjectMocks
    private OperateurServiceImpl operateurService;

    @Before
   public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRetrieveAllOperateurs() {
        // Given
        Operateur o1 = new Operateur();
        o1.setIdOperateur(1l);
        Operateur o2 = new Operateur();
        o1.setIdOperateur(2l);
        when(operateurRepository.findAll()).thenReturn(Arrays.asList(o1, o2));

        // When
        List<Operateur> operateurs = operateurService.retrieveAllOperateurs();

        // Then
        assertEquals(2, operateurs.size());
    }

    @Test
    public void testAddOperateur() {
        // Given
        Operateur o = new Operateur();
        o.setIdOperateur(1l);
        when(operateurRepository.save(any(Operateur.class))).thenReturn(o);

        // When
        Operateur savedOperateur = operateurService.addOperateur(o);

        // Then
        assertNotNull(savedOperateur);
        verify(operateurRepository, times(1)).save(o);
    }

    @Test
    public void testDeleteOperateur() {
        // Given
        Long id = 1L;

        // When
        operateurService.deleteOperateur(id);

        // Then
        verify(operateurRepository, times(1)).deleteById(id);
    }

    @Test
    public void testUpdateOperateur() {
        // Given
        Operateur o = new Operateur();
        o.setIdOperateur(1l);
        when(operateurRepository.save(any(Operateur.class))).thenReturn(o);

        // When
        Operateur updatedOperateur = operateurService.updateOperateur(o);

        // Then
        assertNotNull(updatedOperateur);
        verify(operateurRepository, times(1)).save(o);
    }

    @Test
    public void testRetrieveOperateur() {
        // Given
        Long id = 1L;

        Operateur o = new Operateur();
        o.setIdOperateur(1l);
        when(operateurRepository.findById(id)).thenReturn(Optional.of(o));

        // When
        Operateur retrievedOperateur = operateurService.retrieveOperateur(id);

        // Then
        assertNotNull(retrievedOperateur);
        verify(operateurRepository, times(1)).findById(id);
    }
    @Test
    public void testRetrieveOperateur2() {
        // Given
        Long id = 2L;

        Operateur o = new Operateur();
        o.setIdOperateur(1l);
        when(operateurRepository.findById(id)).thenReturn(Optional.of(o));

        // When
        Operateur retrievedOperateur = operateurService.retrieveOperateur(id);

        // Then
        assertNotNull(retrievedOperateur);
        verify(operateurRepository, times(1)).findById(id);
    }
}
