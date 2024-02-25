package com.datanumia.kata;

import com.datanumia.kata.category.CategoryStrategy;

import java.util.List;

public class Yatzy {

    private CategoryStrategy categoryStrategy;

    public Yatzy(CategoryStrategy categoryStrategy) {
        this.categoryStrategy = categoryStrategy;
    }

    public int getScore(List<Integer> dice){
        return categoryStrategy.calculateScore(dice);
    }
}



