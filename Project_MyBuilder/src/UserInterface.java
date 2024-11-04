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
        AttributeLogic attributeLogic = new AttributeLogic();
        attributeLogic.initializeAttributeCaps(player, height);

        System.out.println("Player created: " + playerName + ", Position: " + position + ", Height: " + height + " ft");

        setAttributePoints(scanner, player);
        System.out.println("You have completed your build. Player details: " + player);
        displayAttributes(player);
    }

    private void setAttributePoints(Scanner scanner, PlayerBuild player) {
        Map<String, Attribute> attributes = player.getAttributes();

        int remainingPoints = TOTAL_POINTS;
        while (remainingPoints > 0) {
            System.out.println("\nYou have " + remainingPoints + " points remaining.");
            for (Map.Entry<String, Attribute> entry : attributes.entrySet()) {
                Attribute attribute = entry.getValue();

                // If no points are left, break out of the loop
                if (remainingPoints <= 0) {
                    System.out.println("No points remaining. Attribute allocation is complete.");
                    return;
                }

                int value = -1;
                while (value < 0 || value > attribute.getCap() || (remainingPoints - value) < 0) {
                    System.out.println("Enter value for " + attribute.getName() + " (max " + attribute.getCap() + ", current: " + attribute.getValue() + "):");
                    value = scanner.hasNextInt() ? scanner.nextInt() : -1;
                    scanner.nextLine();

                    if (value < 0 || value > attribute.getCap() || (remainingPoints - value) < 0) {
                        System.out.println("Invalid value. Please enter a value between 0 and " + attribute.getCap() + " and within remaining points.");
                    }
                }
                attribute.setValue(value);
                remainingPoints -= value;
                System.out.println("Updated " + attribute.getName() + " to " + value + ". Remaining points: " + remainingPoints);
            }

            if (remainingPoints > 0) {
                System.out.println("Points not fully allocated. Please adjust your inputs.");
            }
        }

        System.out.println("All points allocated.");
    }

    public void displayAttributes(PlayerBuild player) {
        System.out.println("\n--- Current Attribute Status ---");
        Map<String, Attribute> attributes = player.getAttributes();

        for (Map.Entry<String, Attribute> entry : attributes.entrySet()) {
            Attribute attribute = entry.getValue();
            System.out.println(attribute.getName() + ": " + attribute.getValue() + "/" + attribute.getCap());
        }
    }
}