import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse MedienVerwaltung verwaltet eine Liste von Medienobjekten.
 * Sie bietet Methoden zum Hinzufügen, Suchen, Löschen und Drucken der Medien.
 */
public class MedienVerwaltung {
    private List<Medien> medienListe;

    /**
     * Konstruktor der Klasse MedienVerwaltung.
     * Initialisiert eine leere Liste von Medien.
     */
    public MedienVerwaltung() {
        this.medienListe = new ArrayList<>();
    }

    /**
     * Fügt ein Medienobjekt zur Verwaltung hinzu.
     *
     * @param medien Das Medienobjekt, das hinzugefügt werden soll.
     */
    public void hinzufuegen(Medien medien) {
        medienListe.add(medien);
    }

    /**
     * Druckt die Informationen aller gespeicherten Medienobjekte.
     * Ruft für jedes Medienobjekt die Methode {@code printInfo()} auf.
     */
    public void druckeMedien() {
        for (Medien medien : medienListe) {
            medien.printInfo();
        }
    }

    /**
     * Sucht nach einem Medienobjekt anhand des Titels und druckt die Informationen,
     * wenn ein passendes Medienobjekt gefunden wird.
     *
     * @param titel Der Titel des gesuchten Medienobjekts.
     */
    public void sucheMedien(String titel) {
        for (Medien medien : medienListe) {
            if (medien.titel.equalsIgnoreCase(titel)) {
                medien.printInfo();
                return;
            }
        }
        System.out.println("Medien nicht gefunden.");
    }

    /**
     * Löscht ein Medienobjekt aus der Verwaltung, wenn der Titel übereinstimmt.
     *
     * @param titel Der Titel des zu löschenden Medienobjekts.
     */
    public void loescheMedien(String titel) {
        for (Medien medien : medienListe) {
            if (medien.titel.equalsIgnoreCase(titel)) {
                medienListe.remove(medien);
                System.out.println("Medien \"" + titel + "\" wurde gelöscht.");
                return;
            }
        }
        System.out.println("Medien nicht gefunden.");
    }
}
