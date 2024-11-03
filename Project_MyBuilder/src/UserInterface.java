import java.util.Scanner;
import enums.Position;

public class UserInterface {
    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Player Name:");
        String playerName = scanner.nextLine();

        System.out.println("Choose Position: 1. Point Guard 2. Shooting Guard 3. Small Forward 4. Power Forward 5. Center");
        Position position = Position.values()[scanner.nextInt() - 1];

        System.out.println("Enter height in cm:");
        double height = scanner.nextDouble();

        PlayerBuild player = new PlayerBuild(playerName, position, height);

        System.out.println("Player created: " + playerName + ", Position: " + position + ", Height: " + height + " cm");
    }
}
