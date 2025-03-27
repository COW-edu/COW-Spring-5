package lotto.global;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import lotto.global.Constant.ValidatorConstant;

public class Validator{

    public static void checkNoBlank(String str) throws IllegalArgumentException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException(ValidatorConstant.NO_BLANK);
        }
    }

    public static void checkNumber(String str) throws IllegalArgumentException{
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidatorConstant.NUMBER);
        }
    }

    public static void checkUnitMoney(int gold, int unit) throws IllegalArgumentException {
        if (gold % unit != 0) {
            throw new IllegalArgumentException(unit + ValidatorConstant.UNIT_MONEY);
        }
    }
    public static void checkDuplication(int[] array, int count) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<count; i++){
            if(map.containsKey(array[i])){
                throw new IllegalArgumentException(ValidatorConstant.DUPLICATION);
            }
        }
    }

    public static void checkRange(int number, int min, int max) {
        if(number<min||number>max){
            throw new IllegalArgumentException(min+ValidatorConstant.RANGE_MIN+max+ValidatorConstant.RANGE_MAX);
        }
    }

    public static void checkCounnt(StringTokenizer token, int count) {
        if(token.countTokens()!=count){
            throw new IllegalArgumentException(count+ValidatorConstant.COUNT);
        }
    }
    public static void checkBonusDuplicate(int[] correctLotto,int bonus) {
        if(Arrays.stream(correctLotto).anyMatch(x -> x == bonus)){
            throw new IllegalArgumentException(ValidatorConstant.BONUS_DUPLICATE);
        }
    }
}