package enums;

public enum Position {
    POINT_GUARD(5.9, 6.6),
    SHOOTING_GUARD(6.2, 6.8),
    SMALL_FORWARD(6.4, 6.10),
    POWER_FORWARD(6.6, 7.0),
    CENTER(6.8, 7.2);

    private final double minHeight;
    private final double maxHeight;

    Position(double minHeight, double maxHeight) {
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    public double getMinHeight() {
        return minHeight;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public boolean isWithinHeightRange(double height) {
        return height >= minHeight && height <= maxHeight;
    }
}