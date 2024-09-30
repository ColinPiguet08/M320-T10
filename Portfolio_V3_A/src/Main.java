public class Main {
    public static void main(String[] args) {
        Portfolio portfolio = new Portfolio();

        portfolio.addStock(new Stock("Microsoft", 3));
        portfolio.addStock(new Stock("Apple", 5));

        StockExchange newYork = new NewYorkStockExchange();
        StockExchange zurich = new ZurichStockExchange();

        double newYorkValue = portfolio.getPortfolioValue(newYork);
        System.out.println("New York: " + newYorkValue);

        double zurichValue = portfolio.getPortfolioValue(zurich);
        System.out.println("Zurich: " + zurichValue);
    }
}
