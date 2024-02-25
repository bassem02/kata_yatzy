package com.datanumia.kata.category;

import java.util.List;

public final class YatzyStrategy implements CategoryStrategy{
    @Override
    public int calculateScore(List<Integer> diceList) {
        var isAllSameValue = diceList.stream()
            .distinct()
            .count() == 1;
        return isAllSameValue ? 50 : 0;
    }
}
