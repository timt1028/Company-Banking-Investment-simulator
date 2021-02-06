package company;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static java.math.RoundingMode.FLOOR;
import static java.util.stream.Collectors.toMap;
import static utils.Moneys.$;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class CoFounding {
    private String companyName;
    private Map<Investor, BigDecimal> investments = new HashMap<>();

    public static CoFounding companyName(String companyName) {
        return new CoFounding(companyName);
    }

    public CoFounding(String companyName) {
        this.companyName = companyName;
    }

    public CoFounding cofounder(Investor investor, BigDecimal cash) {
        investments.put(investor, cash);
        return this;
    }

    public Company startup() {
        var shares = investments.entrySet().stream()
                .collect(toMap(Map.Entry::getKey,
                        e -> e.getValue().divide($(10), FLOOR).longValue()));
        Capital capital = new Capital(shares);
        return new Company(companyName, capital);
    }
}
