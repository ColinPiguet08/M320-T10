import java.util.Map;
import java.util.Scanner;
import enums.Position;

public class UserInterface {
    private static final int TOTAL_POINTS = 780;

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

        int heightCm = -1;
        while (heightCm == -1) {
            System.out.println("Enter height in centimeters (e.g., 193):");
            if (scanner.hasNextInt()) {
                heightCm = scanner.nextInt();
                scanner.nextLine();

                if (!position.isWithinHeightRange(heightCm)) {
                    System.out.println("Height out of range for " + position + " (" + position.getMinHeightCm() + " - " + position.getMaxHeightCm() + " cm). Try again.");
                    heightCm = -1;
                }
            } else {
                System.out.println("Invalid input. Please enter a valid height in centimeters.");
                scanner.nextLine();
            }
        }

        PlayerBuild player = new PlayerBuild(playerName, position, heightCm);
        AttributeLogic attributeLogic = new AttributeLogic();
        attributeLogic.initializeAttributeCaps(player, heightCm);

        System.out.println("Player created: " + playerName + ", Position: " + position + ", Height: " + heightCm + " cm");

        setAttributePoints(scanner, player);
        System.out.println("Attribute allocation complete. Player details: " + player);
    }

    private void setAttributePoints(Scanner scanner, PlayerBuild player) {
        Map<String, Attribute> attributes = player.getAttributes();

        int remainingPoints = TOTAL_POINTS;
        while (remainingPoints > 0) {
            System.out.println("You have " + remainingPoints + " points remaining.");
            for (Map.Entry<String, Attribute> entry : attributes.entrySet()) {
                Attribute attribute = entry.getValue();
                int value = -1;
                while (value < 0 || value > attribute.getCap() || (remainingPoints - value) < 0) {
                    System.out.println("Enter value for " + attribute.getName() + " (max " + attribute.getCap() + "):");
                    value = scanner.hasNextInt() ? scanner.nextInt() : -1;
                    scanner.nextLine();

                    if (value < 0 || value > attribute.getCap() || (remainingPoints - value) < 0) {
                        System.out.println("Invalid value. Please enter a value between 0 and " + attribute.getCap() + " and within remaining points.");
                    }
                }
                attribute.setValue(value);
                remainingPoints -= value;
                System.out.println("Remaining points: " + remainingPoints);
            }

            if (remainingPoints > 0) {
                System.out.println("Points not fully allocated. Please adjust your inputs.");
            }
        }

        for (Map.Entry<String, Attribute> entry : attributes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getValue());
        }
    }
}
