package ExchangeRate;

import java.math.BigDecimal;
import java.util.*;


public class ExchangeRate {
    final static public Map<String, BigDecimal> rate=new HashMap<String,BigDecimal>(){{
        put("BYN",BigDecimal.valueOf(3.29));
        put("EUR", BigDecimal.valueOf(0.92108));
        put("RUB",BigDecimal.valueOf(96.09));
        put("AUD",BigDecimal.valueOf(1.49));
        put("CUD",BigDecimal.valueOf(1.38));
    }};
   public static void SimpleCost(BigDecimal a){
        for(Map.Entry<String,BigDecimal>entry:rate.entrySet()){
            String currencyName= entry.getKey();
            BigDecimal currencyCost=entry.getValue();
            System.out.println(String.format("%s USD в %s: %s",a,currencyName,a.multiply(currencyCost)));
        }
    }

    public static void main(String[]args) {
       System.out.print("ВВЕДИТЕ ЛЮБУЮ СУММУ В USD:");
       BigDecimal usd=new BigDecimal(new Scanner(System.in).next());
       SimpleCost(usd);
    }
}
