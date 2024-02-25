package com.datanumia.kata.category;

import com.datanumia.kata.utils.ListUtils;

import java.util.List;

public class ChanceStrategy implements CategoryStrategy{
    @Override
    public int calculateScore(List<Integer> dice) {
        return ListUtils.sum(dice);
    }
}
