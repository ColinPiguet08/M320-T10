import enums.Position;
import enums.BuildName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerBuild {
    private String playerName;
    private double height;
    private Position position;
    private BuildName buildName;
    private Map<String, Attribute> attributes = new HashMap<>();
    private List<Badge> badges = new ArrayList<>();

    public PlayerBuild(String playerName, Position position, BuildName buildName, double height) {
        this.playerName = playerName;
        this.position = position;
        this.buildName = buildName;
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

    public Map<String, Attribute> getAttributes() {
        return attributes;
    }

    public Position getPosition() {
        return position;
    }

    public BuildName getBuildName() {
        return buildName;
    }

    public double getHeight() {
        return height;
    }

    public List<Badge> getBadges() {
        return badges;
    }
}
