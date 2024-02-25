package com.datanumia.kata.category;

import com.datanumia.kata.utils.ListUtils;

import java.util.List;

public final class ChanceStrategy implements CategoryStrategy{
    @Override
    public int calculateScore(List<Integer> diceList) {
        return ListUtils.sum(diceList);
    }
}
