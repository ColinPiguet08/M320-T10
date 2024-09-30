public class ZurichStockExchange implements StockExchange {
    @Override
    public double getPrice(String stockName) {
        switch (stockName) {
            case "Microsoft":
                return 120.00;
            case "Apple":
                return 180.00;
            default:
                return 0.0;
        }
    }
}
