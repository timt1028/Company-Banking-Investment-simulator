
import company.CoFounding;
import company.Company;
import company.Investor;
import org.junit.Before;
import org.junit.Test;
import stockmarket.Order;
import stockmarket.Stock;
import stockmarket.StockMarket;

import static org.junit.Assert.*;
import static utils.Moneys.$;
import static utils.Randoms.nextSymbol;

public class StockMarketTest {
    Investor Waterball = new Investor("Waterball", $("1000000000"));
    Investor Chaoyu = new Investor("Chaoyu", $("300000000"));
    Investor Fang = new Investor("Fang", $("500000"));

    Investor[] investors = {Waterball, Chaoyu, Fang};

    StockMarket stockMarket;
    Stock stock;

    @Before
    public void setup() {
        stockMarket = new StockMarket();
        Company company = CoFounding.companyName("昭妤水果攤")
                .cofounder(Waterball, $(700000))
                .cofounder(Chaoyu, $(300000))
                .startup();
        stock = stockMarket.initialPublicOffering(company, nextSymbol(3));
        stockMarket.printStocks();
    }

    @Test
    public void GivenNoSellOrders_WhenBuy_OrderShouldNotBeCompleted() {
        Order order = Order.buy()
                .investor(Fang)
                .stock(stock)
                .lots(10)
                .price(stock.getDealPrice() - 5)  // He wants to save $5.
                .build();
        stockMarket.transaction(order);
        assertFalse(order.isCompleted());
    }

    @Test
    public void GivenOneSellOrderWith20Lots_WhenBuy10Lots_OrderShouldBeCompleted() {
        givenOneSellOrder(20, stock.getDealPrice() + 3);

        Order order = Order.buy()
                .investor(Fang)
                .stock(stock)
                .lots(10)
                .price(stock.getDealPrice() - 5)  // He wants to save $5.
                .build();
        stockMarket.transaction(order);
        assertTrue(order.isCompleted());
    }


    @Test
    public void GivenOneSellOrderWith20Lots_WhenBuy30Lots_OrderShouldNotBeCompleted() {
        givenOneSellOrder(20, stock.getDealPrice() + 3);

        Order order = Order.buy()
                .investor(Fang)
                .stock(stock)
                .lots(30)
                .price(stock.getDealPrice() - 5)  // He wants to save $5.
                .build();
        stockMarket.transaction(order);
        assertFalse(order.isCompleted());
        assertEquals(10, order.getLots());
    }

    private void givenOneSellOrder(long lots, double price) {
        Order order = Order.sell()
                .investor(Waterball)
                .stock(stock)
                .lots(lots)
                .price(price)
                .build();
        stockMarket.transaction(order);
    }
}
