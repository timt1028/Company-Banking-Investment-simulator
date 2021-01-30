package stockmarket.company;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Stock {
    private String id;
    private Company company;
    private double dealPrice = 10;

    public Stock(String id, Company company) {
        this.id = id;
        this.company = company;
    }

    public String getId() {
        return id;
    }

    public Company getCompany() {
        return company;
    }

    public double getDealPrice() {
        return dealPrice;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s 總量: %s 成交價: %.3f", id, company.getName(), company.getTotalLots(), dealPrice);
    }
}
