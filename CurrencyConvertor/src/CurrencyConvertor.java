class CurrencyConverter {
    private final double conversionRate;

    public CurrencyConverter(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public double convertToEuro(double chfAmount) {
        return chfAmount * conversionRate;
    }

    public double convertToChf(double euroAmount) {
        return euroAmount / conversionRate;
    }
}