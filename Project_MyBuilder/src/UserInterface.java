import java.util.Map;
import java.util.Scanner;
import enums.Position;
import Exceptions.InvalidAttributeValueException;

public class UserInterface {
    private static final int TOTAL_POINTS = 455;
    private static final int MIN_ATTRIBUTE_VALUE = 25;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Welcome to the Player Builder!");
            System.out.print("Please enter your player's name: ");
            String playerName = scanner.nextLine();

            Position position = selectPosition(scanner);
            int heightCm = getHeight(scanner, position);

            PlayerBuild player = new PlayerBuild(playerName, position, heightCm);
            AttributeLogic attributeLogic = new AttributeLogic();
            attributeLogic.initializeAttributeCaps(player, heightCm);

            System.out.println("\nPlayer created! Name: " + playerName + ", Position: " + position + ", Height: " + heightCm + " cm\n");

            allocateAttributePoints(scanner, player);
            System.out.println("\nYou have completed your build!\n");
            displayAttributes(player);
        } catch (InvalidAttributeValueException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private Position selectPosition(Scanner scanner) {
        Position position = null;
        while (position == null) {
            System.out.println("\nPlease choose a position:");
            System.out.println("1. Point Guard  2. Shooting Guard  3. Small Forward  4. Power Forward  5. Center");
            System.out.print("Enter the number corresponding to your choice: ");
            int positionChoice = scanner.hasNextInt() ? scanner.nextInt() : -1;
            scanner.nextLine();

            if (positionChoice >= 1 && positionChoice <= Position.values().length) {
                position = Position.values()[positionChoice - 1];
            } else {
                System.out.println("Invalid choice. Please select a number between 1 and " + Position.values().length + ".");
            }
        }
        return position;
    }

    private int getHeight(Scanner scanner, Position position) {
        int heightCm = -1;
        while (heightCm == -1) {
            System.out.print("Enter your player's height in centimeters (e.g., 193): ");
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
        return heightCm;
    }

    private void allocateAttributePoints(Scanner scanner, PlayerBuild player) throws InvalidAttributeValueException {
        Map<String, Attribute> attributes = player.getAttributes();

        int remainingPoints = TOTAL_POINTS;
        while (remainingPoints > 0) {
            System.out.println("\nPoints remaining: " + remainingPoints);

            for (Map.Entry<String, Attribute> entry : attributes.entrySet()) {
                Attribute attribute = entry.getValue();

                if (remainingPoints <= 0) {
                    System.out.println("All points allocated!");
                    return;
                }

                int value = -1;
                while (value < MIN_ATTRIBUTE_VALUE || value > attribute.getCap() || (remainingPoints - (value - attribute.getValue())) < 0) {
                    System.out.print("Set value for " + attribute.getName() + " (Min: " + MIN_ATTRIBUTE_VALUE + ", Max: " + attribute.getCap() + ", Current: " + attribute.getValue() + "): ");
                    value = scanner.hasNextInt() ? scanner.nextInt() : -1;
                    scanner.nextLine();

                    int pointsRequired = value - attribute.getValue();

                    if (value < MIN_ATTRIBUTE_VALUE || value > attribute.getCap() || pointsRequired < 0 || remainingPoints - pointsRequired < 0) {
                        throw new InvalidAttributeValueException(
                                "Invalid value for " + attribute.getName() + ". Value must be between " + MIN_ATTRIBUTE_VALUE + " and " + attribute.getCap() +
                                        ", and you need enough remaining points. Remaining points: " + remainingPoints
                        );
                    }
                }

                int pointsUsed = value - attribute.getValue();
                attribute.setValue(value);
                remainingPoints -= pointsUsed;
                System.out.println(attribute.getName() + " set to " + value + ". Remaining points: " + remainingPoints);
            }

            if (remainingPoints > 0) {
                System.out.println("Not all points have been allocated. Please adjust your attributes to use all points.");
            }
        }
        System.out.println("All points successfully allocated.");
    }

    public void displayAttributes(PlayerBuild player) {
        System.out.println("\n--- Final Player Attributes ---");
        System.out.printf("%-20s %-10s %-10s\n", "Attribute", "Value", "Cap");

        Map<String, Attribute> attributes = player.getAttributes();
        for (Map.Entry<String, Attribute> entry : attributes.entrySet()) {
            Attribute attribute = entry.getValue();
            System.out.printf("%-20s %-10d %-10d\n", attribute.getName(), attribute.getValue(), attribute.getCap());
        }

        if (player.getAttribute("3 Point").getValue() > 79 || player.getAttribute("Mid Range").getValue() > 79) {
            Badge shootingBadge = new ShootingBadge();
            player.getBadges().add(shootingBadge);
            System.out.println("\nYour Build has the following Badge: " + shootingBadge.getName() + " - " + shootingBadge.getDescription());
        }
        System.out.println("--------------------------------------");
    }
}
