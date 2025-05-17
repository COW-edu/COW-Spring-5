package model;

import java.util.List;

public class Lotto implements MModel<List<Integer>> {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> getData() {
        return numbers;
    }
}
