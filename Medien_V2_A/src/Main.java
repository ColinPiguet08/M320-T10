import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MedienVerwaltung verwaltung = new MedienVerwaltung();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Medien hinzufügen");
            System.out.println("2. Medien drucken");
            System.out.println("3. Medien suchen");
            System.out.println("4. Medien löschen");
            System.out.println("5. Beenden");

            System.out.print("Bitte wählen Sie eine Option: ");
            String auswahl = scanner.nextLine();

            switch (auswahl) {
                case "1":
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
                    verwaltung.druckeMedien();
                    break;

                case "3":
                    System.out.print("Titel: ");
                    String suchTitel = scanner.nextLine();
                    verwaltung.sucheMedien(suchTitel);
                    break;

                case "4":
                    System.out.print("Titel: ");
                    String loeschTitel = scanner.nextLine();
                    verwaltung.loescheMedien(loeschTitel);
                    break;

                case "5":
                    System.out.println("Programm beendet.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Ungültige Option. Bitte erneut versuchen.");
            }
        }
    }
}
