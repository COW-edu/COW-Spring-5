package lotto.global;

public class Constant {

    public static class ValidatorConstant{
        public static final String NO_BLANK = "공백을 입력하셨습니다.";
        public static final String NUMBER = "숫자를 입력해주세요.";
        public static final String UNIT_MONEY = "원 단위로 입력해주세요.";
        public static final String DUPLICATION = "중복된 숫자가 있습니다.";
        public static final String RANGE_MIN= "부터 ";
        public static final String RANGE_MAX= "까지의 숫자를 입력해주세요.";
        public static final String COUNT = "개의 숫자를 입력해주세요.";
        public static final String BONUS_DUPLICATE = "로또 번호와 중복되는 번호입니다.";
    }

    public static class LottoConstant{
        public static final int LOTTO_COUNT = 6;
        public static final int LOTTO_MIN = 1;
        public static final int LOTTO_MAX = 45;
    }

    public static class ControllerConstant{
        public static final String INPUT_MONEY = "구입금액을 입력해주세요";
        public static final String INPUT_CORRECTNUMBER = "당첨 번호를 입력해주세요";
        public static final String INPUT_BONUSNUMBER = "보너스 번호를 입력해주세요";
    }
    
}
