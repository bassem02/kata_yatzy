package com.datanumia.kata.category.pairs;

import com.datanumia.kata.category.CategoryStrategy;
import com.datanumia.kata.utils.ListUtils;

import java.util.Comparator;
import java.util.List;

public class PairStrategy implements CategoryStrategy {
    @Override
    public int calculateScore(List<Integer> dice) {
        var highestPairDice = ListUtils.filterPairStream(dice)
            .max(Comparator.naturalOrder())// highest dice
            .orElse(0); // if no pair is found
        return highestPairDice * 2;
    }
}
