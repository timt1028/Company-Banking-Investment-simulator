package stockmarket.company;

import java.math.BigDecimal;
import java.util.Map;

import static stockmarket.utils.Moneys.$;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Capital {
    private Map<Investor, Long> shares;
    private long stockValue;

    public Capital(Map<Investor, Long> shares) {
        this.shares = shares;
    }

    public long getShares(Investor investor) {
        return shares.get(investor);
    }

    public long getLots(Investor investor) {
        return getShares(investor) / 1000;
    }

    public void setStockValue(long stockValue) {
        this.stockValue = stockValue;
    }

    public BigDecimal getValue() {
        return $(stockValue).multiply($(getTotalShares()));
    }

    public long getTotalLots() {
        return getTotalShares() / 1000;
    }

    public long getTotalShares() {
        return shares.values().stream()
                .mapToLong(L -> L)
                .sum();
    }

    public void invest(Investor investor, long share) {
        shares.put(investor, shares.getOrDefault(investor, 0L)
                + share);
    }


}
