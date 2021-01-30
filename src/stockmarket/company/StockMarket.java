package stockmarket.company;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static java.util.Comparator.comparing;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class StockMarket {
    private Map<String, Stock> stocks = new HashMap<>();
    private PriorityQueue<Order> buyOrders =
            new PriorityQueue<>(comparing(Order::getPrice).reversed().thenComparing(Order::getDate));
    private PriorityQueue<Order> sellOrders =
            new PriorityQueue<>(comparing(Order::getPrice).thenComparing(Order::getDate));

    public void buy(Order order) {
        buyOrders.add(order);
        matchTransaction(order);
    }

    public void sell(Order order) {
        sellOrders.add(order);
        matchTransaction(order);
    }

    public void initialPublicOffering(Company company, String stockSymbol) {
        if (stocks.containsKey(stockSymbol)) {
            throw new IllegalArgumentException("Stock symbol must not be duplicate.");
        }
        stocks.put(stockSymbol, new Stock(stockSymbol, company));
    }

    private void matchTransaction(Order newOrder) {
        var orders = newOrder.isBuy() ? sellOrders : buyOrders;
        orders.stream()
                .takeWhile(o -> !newOrder.isDeal())
                .forEach(newOrder::deal);
        orders.removeIf(Order::isDeal);
        if (!newOrder.isDeal()) {
            appendPendingOrder(newOrder);
        }
    }

    private void appendPendingOrder(Order newOrder) {
        if (newOrder.isBuy()) {
            buyOrders.add(newOrder);
        } else {
            sellOrders.add(newOrder);
        }
    }

    public Collection<Stock> getStocks() {
        return stocks.values();
    }

    public void printStocks() {
        getStocks().forEach(System.out::println);
    }

}
