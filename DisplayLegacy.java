package meteo.adapter;
/**
 * Classe "legacy" - Adaptee del pattern Adapter.
 * Questo display  non può essere modificato:
 */
public class DisplayLegacy {
    private double valore;
    public DisplayLegacy() {
        this.valore = 32.0; // 0 °C in Fahrenheit
    }
    /**
     * Metodo con interfaccia incompatibile:
     * accetta gradi Fahrenheit invece di Celsius.
     */
    public void mostraFahrenheit(double fahrenheit) {
        this.valore = fahrenheit;
        System.out.println("[DISPLAY LEGACY] Temperatura: "
                + fahrenheit + " °F");
    }
    public double getValore() {
        return valore;
    }
}