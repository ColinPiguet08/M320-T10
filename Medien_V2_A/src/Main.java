import java.util.Scanner;

/**
 * Die Klasse Main stellt das Hauptprogramm zur Verwaltung von Medien dar.
 * Sie bietet ein Menü für den Benutzer, um Medien hinzuzufügen, anzuzeigen, zu suchen und zu löschen.
 */
public class Main {

    /**
     * Der Einstiegspunkt des Programms. Stellt ein Menü bereit, um mit der Medienverwaltung zu interagieren.
     *
     * @param args Standard-Eingabeparameter für die main-Methode (nicht verwendet).
     */
    public static void main(String[] args) {
        MedienVerwaltung verwaltung = new MedienVerwaltung();
        Scanner scanner = new Scanner(System.in);

        // Hauptmenü-Schleife, um wiederholt Benutzereingaben zu verarbeiten
        while (true) {
            System.out.println("\n1. Medien hinzufügen");
            System.out.println("2. Medien drucken");
            System.out.println("3. Medien suchen");
            System.out.println("4. Medien löschen");
            System.out.println("5. Beenden");

            System.out.print("Bitte wählen Sie eine Option: ");
            String auswahl = scanner.nextLine();

            // Verarbeitet die Benutzerauswahl
            switch (auswahl) {
                case "1":
                    // Hinzufügen eines neuen Mediums (Buch oder Film)
                    System.out.print("Medienart (Buch/Film): ");
                    String typ = scanner.nextLine();
                    System.out.print("Titel: ");
                    String titel = scanner.nextLine();
                    System.out.print("Jahr: ");
                    int jahr = Integer.parseInt(scanner.nextLine());

                    if (typ.equalsIgnoreCase("Buch")) {
                        System.out.print("Autor: ");
                        String autor = scanner.nextLine();
                        Buch buch = new Buch(titel, jahr, autor);
                        verwaltung.hinzufuegen(buch);
                    } else if (typ.equalsIgnoreCase("Film")) {
                        System.out.print("Regisseur: ");
                        String regisseur = scanner.nextLine();
                        Film film = new Film(titel, jahr, regisseur);
                        verwaltung.hinzufuegen(film);
                    } else {
                        System.out.println("Ungültige Medienart.");
                    }
                    break;

                case "2":
                    // Drucken aller gespeicherten Medien
                    verwaltung.druckeMedien();
                    break;

                case "3":
                    // Suchen eines Mediums nach Titel
                    System.out.print("Titel: ");
                    String suchTitel = scanner.nextLine();
                    verwaltung.sucheMedien(suchTitel);
                    break;

                case "4":
                    // Löschen eines Mediums nach Titel
                    System.out.print("Titel: ");
                    String loeschTitel = scanner.nextLine();
                    verwaltung.loescheMedien(loeschTitel);
                    break;

                case "5":
                    // Beenden des Programms
                    System.out.println("Programm beendet.");
                    scanner.close();
                    return;

                default:
                    // Ungültige Benutzerauswahl
                    System.out.println("Ungültige Option. Bitte erneut versuchen.");
            }
        }
    }
}
