import java.util.Map;

public class AttributeLogic {
    public PlayerBuild initializeAttributeCaps(PlayerBuild playerBuild, double height) {
        switch (playerBuild.getPosition()) {
            case POINT_GUARD:
                setPointGuardAttributeCaps(playerBuild, height);
                break;
            case SHOOTING_GUARD:
                setShootingGuardAttributeCaps(playerBuild, height);
                break;
            case SMALL_FORWARD:
                setSmallForwardAttributeCaps(playerBuild, height);
                break;
            case POWER_FORWARD:
                setPowerForwardAttributeCaps(playerBuild, height);
                break;
            case CENTER:
                setCenterAttributeCaps(playerBuild, height);
                break;
        }
        return playerBuild;
    }

    private void setPointGuardAttributeCaps(PlayerBuild playerBuild, double height) {
        Map<String, Attribute> attributes = playerBuild.getAttributes();
        attributes.get("Layup").setCap(90);
        attributes.get("Dunk").setCap((height < 6.0) ? 75 : 96);
        attributes.get("Mid Range").setCap(99);
        attributes.get("3 Point").setCap(99);
        attributes.get("Passing").setCap(99);
        attributes.get("Ball Handle").setCap((height < 6.3) ? 99 : 92);
        attributes.get("Speed With Ball").setCap((height < 6.5) ? 94 : 86);
        attributes.get("On Ball Defense").setCap(75);
        attributes.get("Steal").setCap(99);
        attributes.get("Block").setCap((height < 6.5) ? 60 : 75);
        attributes.get("Speed").setCap((height < 6.0) ? 95 : 85);
        attributes.get("Vertical").setCap(80);
        attributes.get("Strength").setCap((height < 6.0) ? 50 : 60);
    }

    private void setShootingGuardAttributeCaps(PlayerBuild playerBuild, double height) {
        Map<String, Attribute> attributes = playerBuild.getAttributes();
        attributes.get("Layup").setCap(85);
        attributes.get("Dunk").setCap(80);
        attributes.get("Mid Range").setCap(90);
        attributes.get("3 Point").setCap(95);
        attributes.get("Passing").setCap(80);
        attributes.get("Ball Handle").setCap(85);
        attributes.get("Speed With Ball").setCap(90);
        attributes.get("On Ball Defense").setCap(80);
        attributes.get("Steal").setCap(85);
        attributes.get("Block").setCap(60);
        attributes.get("Speed").setCap((height < 6.5) ? 88 : 80);
        attributes.get("Vertical").setCap(85);
        attributes.get("Strength").setCap((height < 6.0) ? 55 : 65);
    }

    private void setSmallForwardAttributeCaps(PlayerBuild playerBuild, double height) {
        Map<String, Attribute> attributes = playerBuild.getAttributes();
        attributes.get("Layup").setCap(80);
        attributes.get("Dunk").setCap(85);
        attributes.get("Mid Range").setCap(85);
        attributes.get("3 Point").setCap(85);
        attributes.get("Passing").setCap(75);
        attributes.get("Ball Handle").setCap(80);
        attributes.get("Speed With Ball").setCap(85);
        attributes.get("On Ball Defense").setCap(85);
        attributes.get("Steal").setCap(75);
        attributes.get("Block").setCap((height > 6.7) ? 80 : 70);
        attributes.get("Speed").setCap((height < 6.5) ? 82 : 75);
        attributes.get("Vertical").setCap(85);
        attributes.get("Strength").setCap((height < 6.5) ? 60 : 70);
    }

    private void setPowerForwardAttributeCaps(PlayerBuild playerBuild, double height) {
        Map<String, Attribute> attributes = playerBuild.getAttributes();
        attributes.get("Layup").setCap(85);
        attributes.get("Dunk").setCap(90);
        attributes.get("Mid Range").setCap(80);
        attributes.get("3 Point").setCap(75);
        attributes.get("Passing").setCap(65);
        attributes.get("Ball Handle").setCap(70);
        attributes.get("Speed With Ball").setCap(65);
        attributes.get("On Ball Defense").setCap(90);
        attributes.get("Steal").setCap(70);
        attributes.get("Block").setCap(85);
        attributes.get("Speed").setCap(70);
        attributes.get("Vertical").setCap(80);
        attributes.get("Strength").setCap(75);
    }

    private void setCenterAttributeCaps(PlayerBuild playerBuild, double height) {
        Map<String, Attribute> attributes = playerBuild.getAttributes();
        attributes.get("Layup").setCap(85);
        attributes.get("Dunk").setCap(95);
        attributes.get("Mid Range").setCap(70);
        attributes.get("3 Point").setCap(65);
        attributes.get("Passing").setCap(60);
        attributes.get("Ball Handle").setCap(55);
        attributes.get("Speed With Ball").setCap(55);
        attributes.get("On Ball Defense").setCap(95);
        attributes.get("Steal").setCap(65);
        attributes.get("Block").setCap(95);
        attributes.get("Speed").setCap(65);
        attributes.get("Vertical").setCap(75);
        attributes.get("Strength").setCap(85);
    }
}
