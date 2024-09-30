/**
 * Die Klasse Film repräsentiert ein spezifisches Medium vom Typ Film.
 * Sie erweitert die Klasse Medien und fügt zusätzliche Informationen wie den Regisseur hinzu.
 */
public class Film extends Medien {
    private String regisseur;

    /**
     * Konstruktor zum Erstellen eines neuen Filmobjekts.
     *
     * @param titel     Der Titel des Films.
     * @param jahr      Das Erscheinungsjahr des Films.
     * @param regisseur Der Regisseur des Films.
     */
    public Film(String titel, int jahr, String regisseur) {
        super(titel, jahr);
        this.regisseur = regisseur;
    }

    /**
     * Überschreibt die Methode {@code printInfo()} der Basisklasse Medien.
     * Gibt neben dem Titel und Jahr auch den Regisseur des Films in der Konsole aus.
     */
    @Override
    public void printInfo() {
        super.printInfo();  // Ruft die printInfo() Methode der Basisklasse auf
        System.out.println("Regisseur: " + regisseur);
    }
}
