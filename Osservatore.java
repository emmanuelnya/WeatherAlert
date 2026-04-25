package meteo.observer;

/**
 * Interfaccia del pattern Observer.
 * Ogni osservatore concreto deve implementare questo metodo
 * per ricevere gli aggiornamenti dalla StazioneMeteo.
 */
public interface Osservatore {
    void aggiorna(double temperatura);
}
