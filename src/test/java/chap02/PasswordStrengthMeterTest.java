package chap02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PasswordStrengthMeterTest {

    @Test
    void meetsAllCriteria_Then_Strong(){
        // 모든 규칙을 충족하는 경우
        // 첫 번째 테스트 선택 기준 : 암호 검사 기능에서 가장 쉽거나 가장 예외적인 것

        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@AB");
        assertEquals(PasswordStrength.STRONG,result);

        PasswordStrength result2 = meter.meter("abc1!Add");
        assertEquals(PasswordStrength.STRONG,result2);
    }

    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal(){
        // 문자열 길이가 8 미만 , 나머지 2개의 조건은 충족

        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@A");
        assertEquals(PasswordStrength.NORMAL, result);

        PasswordStrength result2 = meter.meter("Ab12!c");
        assertEquals(PasswordStrength.NORMAL,result2);
    }

    @Test
    void meetsOtherCriteria_except_for_number_Then_Normal(){
        //숫자 포함 X , 나머지 2개 조건 충족
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab!@ABqwer");
        assertEquals(PasswordStrength.NORMAL,result);
    }

}