import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private final List<Stock> stocks = new ArrayList<>();

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public double getPortfolioValue(StockExchange exchange) {
        double totalValue = 0.0;
        for (Stock stock : stocks) {
            double price = exchange.getPrice(stock.getName());
            totalValue += price * stock.getQuantity();
        }
        return totalValue;
    }
}
