import java.util.Scanner;
import enums.Position;

public class UserInterface {
    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Player Name:");
        String playerName = scanner.nextLine();

        Position position = null;
        while (position == null) {
            System.out.println("Choose Position: 1. Point Guard 2. Shooting Guard 3. Small Forward 4. Power Forward 5. Center");
            int positionChoice = scanner.hasNextInt() ? scanner.nextInt() : -1;
            scanner.nextLine();

            if (positionChoice >= 1 && positionChoice <= Position.values().length) {
                position = Position.values()[positionChoice - 1];
            } else {
                System.out.println("Invalid choice. Please select a number between 1 and " + Position.values().length + ".");
            }
        }

        double height = -1;
        while (height == -1) {
            System.out.println("Enter height in feet (e.g., 6.4):");
            if (scanner.hasNextDouble()) {
                height = scanner.nextDouble();
                scanner.nextLine();

                if (!position.isWithinHeightRange(height)) {
                    System.out.println("Height out of range for " + position + " (" + position.getMinHeight() + " - " + position.getMaxHeight() + " ft). Try again.");
                    height = -1;
                }
            } else {
                System.out.println("Invalid input. Please enter a valid height.");
                scanner.nextLine();
            }
        }

        PlayerBuild player = new PlayerBuild(playerName, position, height);
        System.out.println("Player created: " + playerName + ", Position: " + position + ", Height: " + height + " ft");
    }
}


