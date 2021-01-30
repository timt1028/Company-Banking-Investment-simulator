package tests;

import org.junit.Before;
import stockmarket.company.CoFounding;
import stockmarket.company.Company;
import stockmarket.company.Investor;
import stockmarket.company.StockMarket;

import static utils.Randoms.nextSymbol;
import static utils.Moneys.$;

public class StockMarketTest {
    Investor Waterball = new Investor("Waterball", $("1000000000"));
    Investor Chaoyu = new Investor("Chaoyu", $("300000000"));
    Investor Fang = new Investor("Fang", $("500000"));

    Investor[] investors = {Waterball, Chaoyu, Fang};

    StockMarket stockMarket;
//        Company[] companies = {
//                new Company("昭妤水果攤", $("100000000")),
//                new Company("冠冠有限公司", $("1000000000")),
//                new Company("方政文的臥底集團", $("3000000")),
//                new Company("華總大當鋪", $("400000000")),
//                new Company("羅生門", $("999999999")),
//                new Company("提姆豹子頭", $("15000000")),
//                new Company("旭哥的尿布店", $("75000000")),
//                new Company("台中的金錢冠宇豹", $("1234567890")),
//                new Company("王甯的建中公校", $("500000000"))

    @Before
    public void setup() {
        stockMarket = new StockMarket();
        Company company = CoFounding.companyName("昭妤水果攤")
                .invest(Waterball, $(700000))
                .invest(Chaoyu, $(300000))
                .startup();
        stockMarket.initialPublicOffering(company, nextSymbol(3));
        stockMarket.printStocks();
    }
}
