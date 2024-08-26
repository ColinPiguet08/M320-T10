import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            CurrencyConverter converter = new CurrencyConverter(0.92);

            System.out.println("Wählen Sie die Umrechnung:");
            System.out.println("1. CHF in Euro");
            System.out.println("2. Euro in CHF");
            System.out.print("Geben Sie Ihre Wahl ein (1 oder 2): ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Geben Sie den Betrag in CHF ein: ");
                double chfAmount = scanner.nextDouble();
                double euroAmount = converter.convertToEuro(chfAmount);
                System.out.println(chfAmount + " CHF sind " + euroAmount + " Euro");
            } else if (choice == 2) {
                System.out.print("Geben Sie den Betrag in Euro ein: ");
                double euroAmount = scanner.nextDouble();
                double chfAmount = converter.convertToChf(euroAmount);
                System.out.println(euroAmount + " Euro sind " + chfAmount + " CHF");
            } else {
                System.out.println("Ungültige Wahl. Bitte starten Sie das Programm neu und wählen Sie 1 oder 2.");
            }
        }
    }
}