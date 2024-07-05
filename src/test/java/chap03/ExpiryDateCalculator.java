package chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {

    public LocalDate expiryDateCalculator(PayData payData){

        return payData.billingDate().plusMonths(1);
    }

}
