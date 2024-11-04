package enums;

public enum Position {
    POINT_GUARD(175, 198),
    SHOOTING_GUARD(188, 203),
    SMALL_FORWARD(193, 210),
    POWER_FORWARD(198, 213),
    CENTER(203, 218);

    private final int minHeightCm;
    private final int maxHeightCm;

    Position(int minHeightCm, int maxHeightCm) {
        this.minHeightCm = minHeightCm;
        this.maxHeightCm = maxHeightCm;
    }

    public int getMinHeightCm() {
        return minHeightCm;
    }

    public int getMaxHeightCm() {
        return maxHeightCm;
    }

    public boolean isWithinHeightRange(int heightCm) {
        return heightCm >= minHeightCm && heightCm <= maxHeightCm;
    }
}
