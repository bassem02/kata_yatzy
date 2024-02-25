package com.datanumia.kata.category.straight;

import com.datanumia.kata.category.CategoryStrategy;
import com.datanumia.kata.utils.ListUtils;

import java.util.List;

public class SmallStraightStrategy implements CategoryStrategy {
    @Override
    public int calculateScore(List<Integer> dice) {
        var isSmallStraight = ListUtils.sort(dice).equals(List.of(1, 2, 3, 4, 5));
        return isSmallStraight ? 15 : 0;
    }
}
