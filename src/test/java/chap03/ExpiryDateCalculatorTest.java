package chap03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

public class ExpiryDateCalculatorTest {

    @Test
    void 만원_납부하면_한달_뒤가_만료일이_됨() {
        assertExpiryDate(LocalDate.of(2019, 03, 01), 10_000, LocalDate.of(2019, 04, 01));
        assertExpiryDate(LocalDate.of(2019, 04, 05), 10_000, LocalDate.of(2019, 05, 05));
    }

    @Test
    void 납부일과_한달_뒤_일자가_같지_않음(){
        assertExpiryDate(LocalDate.of(2019,01,31),10_000,LocalDate.of(2019,02,28));
        assertExpiryDate(LocalDate.of(2019,05,30),10_000,LocalDate.of(2019,06,30));
        assertExpiryDate(LocalDate.of(2020,01,30),10_000,LocalDate.of(2020,02,29));
    }

    private void assertExpiryDate(LocalDate billingDate, int payAmount, LocalDate expectedExpiryDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate realExpiryDate = cal.expiryDateCalculator(new PayData(billingDate, payAmount));
        assertEquals(expectedExpiryDate, realExpiryDate);
    }

}
