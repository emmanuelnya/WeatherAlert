package meteo.adapter;

import meteo.observer.Osservatore;

/**
 * Classe Adapter del pattern Adapter.
 * Adatta DisplayLegacy (che usa Fahrenheit) all'interfaccia
 * Osservatore (che usa Celsius), senza modificare DisplayLegacy.
 *
 * Implementa Osservatore -> può essere registrato in StazioneMeteo.
 * Contiene un DisplayLegacy -> delega la visualizzazione ad esso.
 */
public class AdapterLegacy implements Osservatore {

    private DisplayLegacy legacy;

    public AdapterLegacy(DisplayLegacy legacy) {
        this.legacy = legacy;
    }

    @Override
    public void aggiorna(double celsius) {
        double fahrenheit = converti(celsius);
        legacy.mostraFahrenheit(fahrenheit);
    }

    public double converti(double celsius) {
        return celsius * 9.0 / 5.0 + 32.0;
    }
    public DisplayLegacy getLegacy() {
        return legacy;
    }
}