package meteo.observer;

/**
 * Osservatore concreto #2 - pattern Observer.
 * Emette un avviso quando la temperatura supera una soglia definita.
 */
public class AvvisoCaldo implements Osservatore {

    private double soglia;
    private boolean avvisoAttivo;
    public AvvisoCaldo(double soglia) {
        this.soglia = soglia;
        this.avvisoAttivo = false;
    }

    @Override
    public void aggiorna(double temperatura) {
        if (temperatura > soglia) {
            this.avvisoAttivo = true;
            System.out.println("[AVVISO CALDO] Temperatura " + temperatura
                    + " °C supera la soglia di " + soglia + " °C!");
        } else {
            this.avvisoAttivo = false;
            System.out.println("[AVVISO CALDO] Temperatura nella norma: "
                    + temperatura + " °C");
        }
    }
    public boolean isAvvisoAttivo() {
        return avvisoAttivo;
    }
    public double getSoglia() {
        return soglia;
    }
}