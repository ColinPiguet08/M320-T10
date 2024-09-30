/**
 * Die Klasse Buch repräsentiert ein spezifisches Medium vom Typ Buch.
 * Sie erweitert die Klasse Medien und fügt zusätzliche Informationen wie den Autor hinzu.
 */
public class Buch extends Medien {
    private String autor;

    /**
     * Konstruktor zum Erstellen eines neuen Buchobjekts.
     *
     * @param titel Der Titel des Buches.
     * @param jahr  Das Erscheinungsjahr des Buches.
     * @param autor Der Autor des Buches.
     */
    public Buch(String titel, int jahr, String autor) {
        super(titel, jahr);
        this.autor = autor;
    }

    /**
     * Überschreibt die Methode {@code printInfo()} der Basisklasse Medien.
     * Gibt neben dem Titel und Jahr auch den Autor des Buches in der Konsole aus.
     */
    @Override
    public void printInfo() {
        super.printInfo();  // Ruft die printInfo() Methode der Basisklasse auf
        System.out.println("Autor: " + autor);
    }
}
