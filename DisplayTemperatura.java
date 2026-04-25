package meteo.observer;

/**
 * Osservatore concreto #1 - pattern Observer.
 * Mostra semplicemente la temperatura attuale in gradi Celsius.
 */
public class DisplayTemperatura implements Osservatore {
    private double ultimaTemperatura;
    private String nome;
    public DisplayTemperatura(String nome) {
        this.nome = nome;
        this.ultimaTemperatura = 0.0;
    }

    @Override
    public void aggiorna(double temperatura) {
        this.ultimaTemperatura = temperatura;
        mostra();
    }
    public void mostra() {
        System.out.println("[" + nome + "] Temperatura attuale: "
                + ultimaTemperatura + " °C");
    }
    public double getUltimaTemperatura() {
        return ultimaTemperatura;
    }
    public String getNome() {
        return nome;
    }
}