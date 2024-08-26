import java.util.Scanner;
import java.util.UUID;

public class Bankschalter {
    public static void main(String[] args) {
        Konto k1 = new Konto("32893295", 200.00);
        Konto k2 = new Konto("21435133", 300.00);
        Konto k3 = new Konto("28972356", 100.00);
        UUID.randomUUID()
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Wähle eine Option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "saldo":
                    System.out.println("Saldo Konto 1: " + k1.getSaldo());
                    System.out.println("Saldo Konto 2: " + k2.getSaldo());
                    break;
                case "einzahlen":
                    System.out.println("Betrag einzahlen auf Konto 1:");
                    double einzahlenBetrag = scanner.nextDouble();
                    scanner.nextLine();
                    k1.einzahlen(einzahlenBetrag);
                    break;
                case "abheben":
                    System.out.println("Betrag abheben von Konto 1:");
                    double abhebenBetrag = scanner.nextDouble();
                    scanner.nextLine();
                    k1.abheben(abhebenBetrag);
                    break;
                case "überweisen":
                    System.out.println("Betrag von Konto 1 auf Konto 2 überweisen:");
                    double ueberweisenBetrag = scanner.nextDouble();
                    scanner.nextLine();
                    k1.ueberweisen(k2, ueberweisenBetrag);
                    break;
                case "exit":
                    exit = true;
                    break;
                case "help":
                    System.out.println("========================");
                    System.out.println("Verfügbare Commands: ");
                    System.out.println("saldo");
                    System.out.println("einzahlen");
                    System.out.println("abheben");
                    System.out.println("überweisen");
                    System.out.println("help");
                    System.out.println("exit");
                    System.out.println("========================");
                    break;
                default:
                    System.out.println("Ungültige Option. ");
                    break;
            }
        }
        scanner.close();
    }
}
