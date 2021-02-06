package stockmarket;

import company.Investor;

import java.util.Date;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Order {
    protected Stock stock;
    protected Date date = new Date();
    protected Investor investor;
    protected long lots;
    protected double price;
    protected boolean buy;

    private Order(Stock stock, Investor investor, long lots, double price, boolean buy) {
        this.stock = stock;
        this.investor = investor;
        this.lots = lots;
        this.price = price;
        this.buy = buy;
    }

    public static OrderBuilder buy() {
        return new OrderBuilder(true);
    }

    public static OrderBuilder sell() {
        return new OrderBuilder(false);
    }

    public static class OrderBuilder {
        private boolean buy;
        protected Investor investor;
        protected long lots;
        protected double price;
        private Stock stock;

        public OrderBuilder(boolean buy) {
            this.buy = buy;
        }

        public OrderBuilder investor(Investor investor) {
            this.investor = investor;
            return this;
        }

        public OrderBuilder stock(Stock stock) {
            this.stock = stock;
            return this;
        }

        public OrderBuilder lots(long lots) {
            this.lots = lots;
            return this;
        }

        public OrderBuilder price(double price) {
            this.price = price;
            return this;
        }

        public Order build() {
            return new Order(stock, investor, lots, price, buy);
        }
    }

    public Stock getStock() {
        return stock;
    }

    public Investor getInvestor() {
        return investor;
    }

    public long getLots() {
        return lots;
    }

    public double getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }

    public boolean isBuy() {
        return buy;
    }

    public boolean isSell() {
        return !buy;
    }

    public void deal(Order order) {
        if (order.lots <= this.lots) {
            this.lots -= order.lots;
            order.lots = 0;
        } else {
            order.lots -= this.lots;
            this.lots = 0;
        }

        // TODO price
    }

    public boolean isCompleted() {
        return lots == 0;
    }
}
