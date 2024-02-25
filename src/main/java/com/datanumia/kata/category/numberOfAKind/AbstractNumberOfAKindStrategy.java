package com.datanumia.kata.category.numberOfAKind;

import com.datanumia.kata.Dice;
import com.datanumia.kata.category.CategoryStrategy;
import com.datanumia.kata.utils.ListUtils;

import java.util.List;

public abstract class AbstractNumberOfAKindStrategy implements CategoryStrategy {
    private final Dice dice;

    public AbstractNumberOfAKindStrategy(Dice dice) {
        this.dice = dice;
    }

    @Override
    public int calculateScore(List<Integer> diceList) {
        return diceList.stream()
            .filter(x -> ListUtils.getNumberFrequency(diceList, x) >= dice.getValue())
            .distinct()
            .findFirst()
            .orElse(0)
            * dice.getValue();
    }
}
