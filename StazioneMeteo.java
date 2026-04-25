package meteo.domain;

import meteo.observer.Osservatore;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Subject del Observer.
 * La StazioneMeteo mantiene una lista di osservatori e
 * li notifica automaticamente ogni volta che la temperatura cambia.
 */
public class StazioneMeteo {
    private double temperatura;
    private List<Osservatore> osservatori;
    public StazioneMeteo() {
        this.osservatori = new ArrayList<>();
        this.temperatura = 0.0;
    }

    public void aggiungi(Osservatore o) {
        osservatori.add(o);
    }
    public void rimuovi(Osservatore o) {
        osservatori.remove(o);
    }
    public void notifica() {
        for (Osservatore o : osservatori) {
            o.aggiorna(temperatura);
        }
    }

    /**
     * Imposta una nuova temperatura e notifica
     * automaticamente tutti gli osservatori.
     */
    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
        notifica();
    }
    public double getTemperatura() {
        return temperatura;
    }
    public int getNumeroOsservatori() {
        return osservatori.size();
    }
}