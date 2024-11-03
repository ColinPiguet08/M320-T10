import enums.Position;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerBuild {
    private String playerName;
    private double height;
    private Position position;
    private Map<String, Attribute> attributes = new HashMap<>();
    private List<Badge> badges = new ArrayList<>();

    public PlayerBuild(String playerName, Position position, double height) {
        this.playerName = playerName;
        this.position = position;
        this.height = height;
        initializeAttributes();
    }

    private void initializeAttributes() {
        String[] attributeNames = {
                // Finishing
                "Layup",
                "Dunk",
                // Shooting
                "Mid Range",
                "3 Point",
                // Playmaking
                "Passing",
                "Ball Handle",
                "Speed With Ball",
                // Defense
                "On Ball Defense",
                "Steal",
                "Block",
                // Physicals
                "Speed",
                "Vertical",
                "Strength"
        };
        for (String attributeName : attributeNames) {
            attributes.put(attributeName, new Attribute(attributeName, 25, 100));
        }
    }

    public String getPlayerName() {
        return playerName;
    }
    public Map<String, Attribute> getAttributes() {
        return attributes;
    }

    public Position getPosition() {
        return position;
    }

    public double getHeight() {
        return height;
    }

    public List<Badge> getBadges() {
        return badges;
    }


}
