package com.datanumia.kata.category.numbers;

import com.datanumia.kata.Dice;
import com.datanumia.kata.category.CategoryStrategy;
import com.datanumia.kata.utils.ListUtils;

import java.util.List;

public abstract class AbstractNumberStrategy implements CategoryStrategy {
    private final Dice dice;

    public AbstractNumberStrategy(Dice dice) {
        this.dice = dice;
    }

    @Override
    public int calculateScore(List<Integer> diceList) {
        return ListUtils.filterByNumberAndSum(diceList, dice.getValue());
    }
}
