package stockmarket;

import company.Investor;

import java.util.Date;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public abstract class Order {
    protected Stock stock;
    protected Date date = new Date();
    protected Investor investor;
    protected long lots;
    protected double price;
    protected boolean buy;

    public Order(Stock stock, Investor investor, long lots, double price, boolean buy) {
        this.stock = stock;
        this.investor = investor;
        this.lots = lots;
        this.price = price;
        this.buy = buy;
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
    }

    public boolean isDeal() {
        return lots == 0;
    }
}
