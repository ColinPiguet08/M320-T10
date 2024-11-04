public class RatingCalculator {
    private static RatingCalculator instance;

    private RatingCalculator() {}

    public static synchronized RatingCalculator getInstance() {
        if (instance == null) {
            instance = new RatingCalculator();
        }
        return instance;
    }

    public int calculateOverall(PlayerBuild playerBuild) {
        // Methode implementieren
        return 0;
    }
}
