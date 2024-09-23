import java.util.ArrayList;
import java.util.List;

public class MedienVerwaltung {
    private List<Medien> medienListe;

    public MedienVerwaltung() {
        this.medienListe = new ArrayList<>();
    }

    public void hinzufuegen(Medien medien) {
        medienListe.add(medien);
    }

    public void druckeMedien() {
        for (Medien medien : medienListe) {
            medien.printInfo();
        }
    }

    public void sucheMedien(String titel) {
        for (Medien medien : medienListe) {
            if (medien.titel.equalsIgnoreCase(titel)) {
                medien.printInfo();
                return;
            }
        }
        System.out.println("Medien nicht gefunden.");
    }

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
