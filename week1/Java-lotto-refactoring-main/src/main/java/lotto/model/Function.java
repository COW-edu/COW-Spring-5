package lotto.model;

import java.util.List;

public class Function {
    public static int getSameCount(List<Integer> list, int[] array) {
        int sameCount = (int)list.stream()
        .filter(num -> java.util.Arrays.stream(array)
        .anyMatch(x -> x == num)).count();
        return sameCount;
    }
}
