package com.datanumia.kata.category;

import java.util.List;

public class YatzyStrategy implements CategoryStrategy{
    @Override
    public int calculateScore(List<Integer> dice) {
        var isAllSameValue = dice.stream()
            .distinct()
            .count() == 1;
        return isAllSameValue ? 50 : 0;
    }
}
