package meteo;

import meteo.observer.AvvisoCaldo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test #2 - AvvisoCaldo (ConcreteObserver).
 * Verifica che l'avviso si attivi solo quando
 * la temperatura supera la soglia configurata.
 */
public class AvvisoCaldoTest {

    private AvvisoCaldo avviso;

    @BeforeEach
    void setUp() {
        avviso = new AvvisoCaldo(30.0);
    }

    @Test
    void testSogliaCorretta() {
        assertEquals(30.0, avviso.getSoglia());
    }

    @Test
    void testAvvisoInizialmenteDisattivo() {
        assertFalse(avviso.isAvvisoAttivo());
    }

    @Test
    void testAvvisoAttivoSopraLaSoglia() {
        avviso.aggiorna(35.0);
        assertTrue(avviso.isAvvisoAttivo());
    }

    @Test
    void testAvvisoNonAttivoSottoLaSoglia() {
        avviso.aggiorna(25.0);
        assertFalse(avviso.isAvvisoAttivo());
    }

    @Test
    void testAvvisoNonAttivoEsattamenteAllaSoglia() {
        // Con temperatura = soglia l'avviso NON deve scattare (condizione >)
        avviso.aggiorna(30.0);
        assertFalse(avviso.isAvvisoAttivo());
    }

    @Test
    void testAvvisoCambiaStatoCorrectamente() {
        avviso.aggiorna(35.0);   // attivo
        assertTrue(avviso.isAvvisoAttivo());
        avviso.aggiorna(20.0);   // disattivo
        assertFalse(avviso.isAvvisoAttivo());
    }

    @Test
    void testTemperatureNegative() {
        avviso.aggiorna(-10.0);
        assertFalse(avviso.isAvvisoAttivo());
    }
}