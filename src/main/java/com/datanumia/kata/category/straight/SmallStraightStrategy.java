package com.datanumia.kata.category.straight;

import com.datanumia.kata.category.CategoryStrategy;
import com.datanumia.kata.utils.ListUtils;

import java.util.List;

public final class SmallStraightStrategy implements CategoryStrategy {
    @Override
    public int calculateScore(List<Integer> diceList) {
        var isSmallStraight = ListUtils.sort(diceList).equals(List.of(1, 2, 3, 4, 5));
        return isSmallStraight ? 15 : 0;
    }
}
