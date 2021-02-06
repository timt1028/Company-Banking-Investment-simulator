package company;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;
import static utils.Moneys.$;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Investor {
    private String name;
    private BigDecimal cash;
    private Map<Company, Long> shares = new HashMap<>();

    public Investor(String name, BigDecimal cash) {
        this.name = name;
        this.cash = cash;
    }

    public void addLots(Company company, long lots) {
        addShares(company, Lots.toShares(lots));
    }

    public void removeLots(Company company, long lots) {
        removeShares(company, Lots.toShares(lots));
    }

    public void addShares(Company company, long shares) {
        this.shares.put(company,
                this.shares.getOrDefault(company, 0L) + shares);
    }

    public void removeShares(Company company, long shares) {
        if (this.shares.containsKey(company)) {
            long own = this.shares.get(company);
            if (own < shares) {
                throw new IllegalStateException(format("%s's selling shares (%d) can't be higher than how many he owns (Company %s) (%d).",
                        name, shares, company.getName(), own));
            }
            this.shares.put(company, own - shares);
            if (own == shares) {
                this.shares.remove(company);
            }
        }
        throw new IllegalStateException(format("%s doesn't own the %s's shares.",
                name, company.getName()));
    }

    public void earn(double cash) {
        this.cash = this.cash.add($(cash));
    }

    public void cost(double cash) {
        this.cash = this.cash.subtract($(cash));
    }

    public BigDecimal getCash() {
        return cash;
    }
}

