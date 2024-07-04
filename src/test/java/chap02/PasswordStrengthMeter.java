package chap02;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String s){
        // 길이 8 미만 -조건 2개 충족
        if(s.length()<8){
            return PasswordStrength.NORMAL;
        }

        //숫자 포함 X - 조건 2개 충족
        boolean containsNum = false;
        for(char ch : s.toCharArray()){
            if(ch >='0' && ch<='9'){
                containsNum = true;
                break;
            }
        }
        if(!containsNum) return PasswordStrength.NORMAL;

        // 조건 3개 모두 충족
        return PasswordStrength.STRONG;
    }


}
