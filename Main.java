package meteo;

import meteo.domain.StazioneMeteo;
import meteo.observer.DisplayTemperatura;
import meteo.observer.AvvisoCaldo;
import meteo.adapter.DisplayLegacy;
import meteo.adapter.AdapterLegacy;

public class Main {

    public static void main(String[] args) {

        // Creazione del Subject (StazioneMeteo)
        StazioneMeteo stazione = new StazioneMeteo();

        // Creazione degli osservatori concreti (Observer)
        DisplayTemperatura display1 = new DisplayTemperatura("Display Principale");
        AvvisoCaldo avviso = new AvvisoCaldo(30.0); // soglia a 30 gradi

        // Creazione dell'adapter per il display legacy (Adapter)
        DisplayLegacy legacy = new DisplayLegacy();
        AdapterLegacy adapter = new AdapterLegacy(legacy);

        // Registrazione degli osservatori nella stazione
        stazione.aggiungi(display1);
        stazione.aggiungi(avviso);
        stazione.aggiungi(adapter); // l'adapter si comporta come un Osservatore

        System.out.println("=== Simulazione Sistema Meteo ===\n");

        System.out.println("-- Temperatura: 22 °C --");
        stazione.setTemperatura(22.0);

        System.out.println("\n-- Temperatura: 35 °C --");
        stazione.setTemperatura(35.0);

        System.out.println("\n-- Temperatura: 28 °C --");
        stazione.setTemperatura(28.0);

        System.out.println("\n-- Rimozione Display Principale --");
        stazione.rimuovi(display1);
        stazione.setTemperatura(40.0);
    }
}