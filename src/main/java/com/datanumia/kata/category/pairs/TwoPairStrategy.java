package com.datanumia.kata.category.pairs;

import com.datanumia.kata.category.CategoryStrategy;
import com.datanumia.kata.utils.ListUtils;

import java.util.List;

public class TwoPairStrategy implements CategoryStrategy {
    @Override
    public int calculateScore(List<Integer> dice) {
        var pairDiceList = ListUtils.filterPairStream(dice).distinct().toList(); // distinct is used to handle the case when a pair is also present 3 times
        if (pairDiceList.size() == 2) { // there is two pair
            return ListUtils.sum(pairDiceList) * 2;
        } else { // less than two pair
            return 0;
        }
    }
}