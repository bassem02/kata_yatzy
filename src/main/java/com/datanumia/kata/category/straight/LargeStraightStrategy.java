package com.datanumia.kata.category.straight;

import com.datanumia.kata.category.CategoryStrategy;
import com.datanumia.kata.utils.ListUtils;

import java.util.List;

public final class LargeStraightStrategy implements CategoryStrategy {
    @Override
    public int calculateScore(List<Integer> diceList) {
        var isLargeStraight = ListUtils.sort(diceList).equals(List.of(2, 3, 4, 5, 6));
        return isLargeStraight ? 20 : 0;
    }
}
