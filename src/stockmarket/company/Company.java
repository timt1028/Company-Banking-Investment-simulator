package stockmarket.company;

import java.util.HashSet;
import java.util.Set;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Company {
    private Set<Investor> investors = new HashSet<>();
    private String name;
    private Capital capital;

    public Company(String name, Capital capital) {
        this.name = name;
        this.capital = capital;
    }

    public void divest(Investor investor, long share) {

    }

    public void invest(Investor investor, long share) {
        capital.invest(investor, share);
    }

    public long getShares(Investor investor) {
        return capital.getShares(investor);
    }

    public long getLots(Investor investor) {
        return capital.getLots(investor);
    }
    public Long getTotalShares() {
        return capital.getTotalShares();
    }

    public Long getTotalLots() {
        return capital.getTotalLots();
    }


    public String getName() {
        return name;
    }
}
