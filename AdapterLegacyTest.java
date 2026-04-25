package meteo;

import meteo.adapter.DisplayLegacy;
import meteo.adapter.AdapterLegacy;
import meteo.domain.StazioneMeteo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test #3 - AdapterLegacy (pattern Adapter).
 * Verifica la corretta conversione Celsius -> Fahrenheit
 * e l'integrazione dell'adapter con la StazioneMeteo.
 */
public class AdapterLegacyTest {

    private DisplayLegacy legacy;
    private AdapterLegacy adapter;

    @BeforeEach
    void setUp() {
        legacy = new DisplayLegacy();
        adapter = new AdapterLegacy(legacy);
    }

    @Test
    void testConversioneZeroGradi() {
        // 0 °C = 32 °F
        double risultato = adapter.converti(0.0);
        assertEquals(32.0, risultato, 0.001);
    }

    @Test
    void testConversioneCentoGradi() {

        double risultato = adapter.converti(100.0);
        assertEquals(212.0, risultato, 0.001);
    }

    @Test
    void testConversioneTrentaGradi() {

        double risultato = adapter.converti(30.0);
        assertEquals(86.0, risultato, 0.001);
    }

    @Test
    void testConversioneTemperaturaNegatviva() {
        // -40 °C = -40 °F (punto di incontro delle scale)
        double risultato = adapter.converti(-40.0);
        assertEquals(-40.0, risultato, 0.001);
    }

    @Test
    void testAdapterAggiornaDisplayLegacy() {

        adapter.aggiorna(100.0);
        assertEquals(212.0, legacy.getValore(), 0.001);
    }

    @Test
    void testAdapterComportaComesOsservatore() {
        // L'adapter deve poter essere registrato come Osservatore nella stazione
        StazioneMeteo stazione = new StazioneMeteo();
        assertDoesNotThrow(() -> stazione.aggiungi(adapter));
        stazione.setTemperatura(0.0);
        // Dopo notifica, il legacy deve mostrare 32°F
        assertEquals(32.0, legacy.getValore(), 0.001);
    }

    @Test
    void testAdapterRiferimentoLegacyCorretto() {
        // L'adapter deve contenere il riferimento al display legacy passato
        assertSame(legacy, adapter.getLegacy());
    }
}