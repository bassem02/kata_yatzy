package com.datanumia.kata.category;

import com.datanumia.kata.utils.ListUtils;

import java.util.List;

public final class FullHouseStrategy implements CategoryStrategy {
    @Override
    public int calculateScore(List<Integer> diceList) {
        var threeOfKind = diceList.stream().filter(x -> ListUtils.diceFrequency(diceList, x) == 3).findFirst().orElse(0);
        if (threeOfKind == 0) { // stop if there is no three of a kind
            return 0;
        }
        var twoOfKind = diceList.stream().filter(x -> ListUtils.diceFrequency(diceList, x) == 2).findFirst().orElse(0);
        if (twoOfKind == 0) { // stop if there is no two of a kind
            return 0;
        }
        return ListUtils.sum(diceList);
    }
}
