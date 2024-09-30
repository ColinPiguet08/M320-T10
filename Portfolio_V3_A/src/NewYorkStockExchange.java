public class NewYorkStockExchange implements StockExchange {
    @Override
    public double getPrice(String stockName) {
        switch (stockName) {
            case "Microsoft":
                return 100.00;
            case "Apple":
                return 150.00;
            default:
                return 0.0;
        }
    }
}
