package com.datanumia.kata.category;

import com.datanumia.kata.utils.ListUtils;

import java.util.List;

public class FullHouseStrategy implements CategoryStrategy {
    @Override
    public int calculateScore(List<Integer> dice) {
        var threeOfKind = dice.stream().filter(x -> ListUtils.diceFrequency(dice, x) == 3).findFirst().orElse(0);
        if (threeOfKind == 0) { // stop if there is no three of a kind
            return 0;
        }
        var twoOfKind = dice.stream().filter(x -> ListUtils.diceFrequency(dice, x) == 2).findFirst().orElse(0);
        if (twoOfKind == 0) { // stop if there is no two of a kind
            return 0;
        }
        return ListUtils.sum(dice);
    }
}
