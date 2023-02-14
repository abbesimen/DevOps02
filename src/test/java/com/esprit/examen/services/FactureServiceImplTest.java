package com.esprit.examen.services;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.esprit.examen.entities.Produit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.DetailFacture;
import com.esprit.examen.entities.Facture;
import com.esprit.examen.repositories.DetailFactureRepository;
import com.esprit.examen.repositories.FactureRepository;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.repositories.OperateurRepository;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.services.FactureServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class FactureServiceImplTest {

    @Mock
    private FactureRepository factureRepository;

    @Mock
    private OperateurRepository operateurRepository;

    @Mock
    private DetailFactureRepository detailFactureRepository;

    @Mock
    private FournisseurRepository fournisseurRepository;

    @Mock
    private ProduitRepository produitRepository;

    @InjectMocks
    private FactureServiceImpl factureService;

    @Test
    public void testAddDetailsFacture() {
        Facture facture = new Facture();
        facture.setIdFacture(1L);

        DetailFacture detail1 = new DetailFacture();
        detail1.setIdDetailFacture(1L);
        detail1.setQteCommandee(2);
        detail1.setPourcentageRemise(10);

        DetailFacture detail2 = new DetailFacture();
        detail2.setIdDetailFacture(2L);
        detail2.setQteCommandee(3);
        detail2.setPourcentageRemise(5);

        Set<DetailFacture> detailsFacture = new HashSet<>();
        detailsFacture.add(detail1);
        detailsFacture.add(detail2);


        factureService.addFacture(facture);

        assertEquals(2, 2);
    }

    private Produit getMockProduit(Long id, Float prix) {
        Produit produit = new Produit();
        produit.setIdProduit(id);
        produit.setPrix(prix);
        return produit;
    }

    @Test
    public void testCancelFacture() {
        Facture facture = new Facture();
        facture.setIdFacture(1L);

        when(factureRepository.findById(1L)).thenReturn(java.util.Optional.of(facture));

        factureService.cancelFacture(1L);

        assertEquals(true, facture.getArchivee());
    }

    @Test
    public void testRetrieveFacture() {
        Facture facture = new Facture();
        facture.setIdFacture(1L);

        when(factureRepository.findById(1L)).thenReturn(java.util.Optional.of(facture));

        Facture retrievedFacture = factureService.retrieveFacture(1L);

        assertEquals(facture.getIdFacture(), retrievedFacture.getIdFacture());
    }

}

