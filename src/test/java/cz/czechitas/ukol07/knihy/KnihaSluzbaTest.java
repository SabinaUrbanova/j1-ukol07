package cz.czechitas.ukol07.knihy;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import cz.czechitas.ukol07.KnihaSluzba;

import java.io.IOException;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.List;


class KnihaSluzbaTest {

    @Test
    void vratVsechnyKnihy() throws IOException {
        //implementuje test metody vratVsechnyKnihy
        KnihaSluzba knihaSluzba  = new KnihaSluzba();
        Integer pocetKnih = 14;
        assertFalse(knihaSluzba.vratVsechnyKnihy().isEmpty(), "Metoda něco vrací.");
        assertEquals(pocetKnih, knihaSluzba.vratVsechnyKnihy().size());
    }

    @Test
    void vratKnihyAutora() throws IOException {
        //implementuje test metody vratKnihyAutora
        KnihaSluzba knihaSluzba  = new KnihaSluzba();
        String autorNulaVysledku = "John Ronald Reuel Tolkien";
        String autorVicVysledku = "Božena Němcová";
        assertEquals(4, knihaSluzba.vratKnihyAutora(autorVicVysledku).size());
        assertEquals(0, knihaSluzba.vratKnihyAutora(autorNulaVysledku).size());
        assertTrue(knihaSluzba.vratKnihyAutora(autorNulaVysledku).isEmpty());
    }

    @Test
    void vratKnihyRok() throws IOException {
        //implementuje test metody vratKnihyRok
        KnihaSluzba knihaSluzba  = new KnihaSluzba();
        Integer rokNulaVysledku = 2024;
        Integer rokVicVysledku = 1856;
        assertEquals(2, knihaSluzba.vratKnihyRok(rokVicVysledku).size());
        assertEquals(0, knihaSluzba.vratKnihyRok(rokNulaVysledku).size());
    }

}