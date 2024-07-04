package chap02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.chap02.PasswordStrength;
import org.example.chap02.PasswordStrengthMeter;
import org.junit.jupiter.api.Test;

public class PasswordStrengthMeterTest {
    PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expStr) {
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr, result);
    }

    @Test
    void meetsAllCriteria_Then_Strong(){
        // 모든 규칙을 충족하는 경우
        // 첫 번째 테스트 선택 기준 : 암호 검사 기능에서 가장 쉽거나 가장 예외적인 것
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
        assertStrength("abc1!Add", PasswordStrength.STRONG);
    }

    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal(){
        // 문자열 길이가 8 미만 , 나머지 2개의 조건은 충족
        assertStrength("ab12!@A",PasswordStrength.NORMAL);
        assertStrength("Ab12!c", PasswordStrength.NORMAL);
    }

    @Test
    void meetsOtherCriteria_except_for_number_Then_Normal(){
        //숫자 포함 X , 나머지 2개 조건 충족
        assertStrength("ab!@ABqwer",PasswordStrength.NORMAL);
    }

    @Test
    void nullInput_Then_Invalid(){
        //값이 없는 경우
        assertStrength(null,PasswordStrength.INVALID);
    }

    @Test
    void emptyInput_Then_Invalid(){
        //빈 문자열
        assertStrength("",PasswordStrength.INVALID);
    }

    @Test
    void meetsOtherCriteria_except_for_Uppercase_Normal() {
        //대문자 포함 X, 나머지 2개 조건 충족
        assertStrength("ab12!@df",PasswordStrength.NORMAL);
    }

    @Test
    void meetsOnlyLengthCriteria_Then_Weak(){
        //문자열 길이가 8이상만 만족, 조건 1개 만족
        assertStrength("abdefghi",PasswordStrength.WEAK);
    }

    @Test
    void meetsOnlyNumCriteria_Then_Weak(){
        // 숫자만 포함 - 조건 1개 충족
        assertStrength("12345",PasswordStrength.WEAK);
    }

    @Test
    void meetsOnlyUppercaseCriteria_Then_Weak(){
        assertStrength("ABASD",PasswordStrength.WEAK);
    }

    @Test
    void meetsNoCriteria_Then_Weak(){
        assertStrength("abc",PasswordStrength.WEAK);
    }
}