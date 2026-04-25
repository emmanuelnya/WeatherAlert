package meteo;

import meteo.domain.StazioneMeteo;
import meteo.observer.DisplayTemperatura;
import meteo.observer.AvvisoCaldo;
import meteo.adapter.DisplayLegacy;
import meteo.adapter.AdapterLegacy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test #1 - StazioneMeteo e pattern Observer.
 * Verifica la corretta registrazione degli osservatori
 * e la propagazione delle notifiche.
 */
public class StazioneMeteoTest {

    private StazioneMeteo stazione;
    private DisplayTemperatura display;
    private AvvisoCaldo avviso;

    @BeforeEach
    void setUp() {
        stazione = new StazioneMeteo();
        display = new DisplayTemperatura("Test Display");
        avviso = new AvvisoCaldo(30.0);
    }

    @Test
    void testTemperaturaIniziale() {
        // La temperatura iniziale deve essere 0.0
        assertEquals(0.0, stazione.getTemperatura());
    }

    @Test
    void testAggiungiOsservatore() {
        stazione.aggiungi(display);
        assertEquals(1, stazione.getNumeroOsservatori());
    }

    @Test
    void testRimuoviOsservatore() {
        stazione.aggiungi(display);
        stazione.aggiungi(avviso);
        stazione.rimuovi(display);
        assertEquals(1, stazione.getNumeroOsservatori());
    }

    @Test
    void testNotificaAggiornaDisplay() {
        // Dopo setTemperatura, il display deve ricevere il valore aggiornato
        stazione.aggiungi(display);
        stazione.setTemperatura(25.0);
        assertEquals(25.0, display.getUltimaTemperatura());
    }

    @Test
    void testNotificaMultipliOsservatori() {
        // Entrambi gli osservatori devono ricevere la notifica
        stazione.aggiungi(display);
        stazione.aggiungi(avviso);
        stazione.setTemperatura(35.0);
        // Display aggiornato
        assertEquals(35.0, display.getUltimaTemperatura());

        assertTrue(avviso.isAvvisoAttivo()); // avviso attivo
    }

    @Test
    void testNessunOsservatoreRegistrato() {
        // Non deve lanciare eccezioni se non ci sono osservatori
        assertDoesNotThrow(() -> stazione.setTemperatura(20.0));
    }

    @Test
    void testOsservatoreNonRiceveDopoRimozione() {
        stazione.aggiungi(display);
        stazione.setTemperatura(20.0);
        stazione.rimuovi(display);
        stazione.setTemperatura(99.0);
        // Il display non deve essere aggiornato dopo la rimozione
        assertEquals(20.0, display.getUltimaTemperatura());
    }
}