package com.esprit.examen.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;

public class OperateurServiceImplTest {
	
	@InjectMocks
	OperateurService operateurService;
	
	@Mock
	OperateurRepository operateurRepository;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testRetrieveAllOperateurs() {
		List<Operateur> list = new ArrayList<Operateur>();
		list.add(new Operateur(1L, "Operateur 1", "11111111"));
		list.add(new Operateur(2L, "Operateur 2", "22222222"));
		list.add(new Operateur(3L, "Operateur 3", "33333333"));
		
		when(operateurRepository.findAll()).thenReturn(list);
		
		List<Operateur> operateurList = operateurService.retrieveAllOperateurs();
		
		assertEquals(3, operateurList.size());
		verify(operateurRepository, times(1)).findAll();
	}
	
	@Test
	public void testRetrieveOperateur() {
		Operateur operateur = new Operateur(1L, "Operateur 1", "11111111");
		
		when(operateurRepository.findById(1L)).thenReturn(Optional.of(operateur));
		
		Operateur operateurResult = operateurService.retrieveOperateur(1L);
		
		assertEquals("Operateur 1", operateurResult.getNom());
		verify(operateurRepository, times(1)).findById(1L);
	}
}
