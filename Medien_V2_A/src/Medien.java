/**
 * Die Klasse Medien stellt ein generisches Medium dar, das einen Titel und ein Erscheinungsjahr besitzt.
 * Sie dient als Basisklasse für spezifische Medientypen wie Buch oder Film.
 */
public class Medien {
    protected String titel;
    protected int jahr;

    /**
     * Konstruktor zum Erstellen eines neuen Medienobjekts.
     *
     * @param titel Der Titel des Mediums.
     * @param jahr  Das Erscheinungsjahr des Mediums.
     */
    public Medien(String titel, int jahr) {
        this.titel = titel;
        this.jahr = jahr;
    }

    /**
     * Gibt die Informationen des Mediums in der Konsole aus.
     * Zeigt den Titel und das Erscheinungsjahr an.
     */
    public void printInfo() {
        System.out.println("Titel: " + titel + ", Jahr: " + jahr);
    }
}
