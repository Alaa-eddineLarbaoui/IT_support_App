package com.example.IT.support.App;

import com.example.IT.support.App.Controller.EquipementController;
import com.example.IT.support.App.Model.Equipement;
import com.example.IT.support.App.Service.EquipementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;



import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EquipementControllerTest {

    @Mock
    private EquipementService equipementService;

    @InjectMocks
    private EquipementController equipementController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test

    void testAddEvenement() {
        Equipement equipement = new Equipement();
        when(equipementService.addEquipement(any(Equipement.class))).thenReturn(equipement);

        Equipement result = equipementController.addEvenement(equipement);

        assertEquals(equipement, result);
        verify(equipementService, times(1)).addEquipement(equipement);
    }

    @Test
    void testShowAllEqui() {
        List<Equipement> equipements = Arrays.asList(new Equipement(), new Equipement());
        when(equipementService.showAll()).thenReturn(equipements);

        List<Equipement> result = equipementController.showAllEqui();

        assertEquals(equipements, result);
        verify(equipementService, times(1)).showAll();
    }

    @Test
    void testGetEquibyId() {
        Equipement equipement = new Equipement();
        when(equipementService.showEquipement(1L)).thenReturn(equipement);

        Equipement result = equipementController.getEquibyId(1L);

        assertEquals(equipement, result);
        verify(equipementService, times(1)).showEquipement(1L);
    }

    @Test
    void testDeleteEquipement() {
        doNothing().when(equipementService).deleteEquipement(1L);

        equipementController.DeleteEquipement(1L);

        verify(equipementService, times(1)).deleteEquipement(1L);
    }

    @Test
    void testUpdateUser() {
        Equipement equipement = new Equipement();
        when(equipementService.updateEqui(eq(1L), any(Equipement.class))).thenReturn(equipement);

        Equipement result = equipementController.updateUser(1L, equipement);

        assertEquals(equipement, result);
        verify(equipementService, times(1)).updateEqui(1L, equipement);
    }
}
