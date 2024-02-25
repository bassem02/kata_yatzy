package com.datanumia.kata.category;

import com.datanumia.kata.category.numberofakind.FourOfAKindStrategy;
import com.datanumia.kata.category.numberofakind.ThreeOfAKindStrategy;
import com.datanumia.kata.category.numbers.*;
import com.datanumia.kata.category.pairs.PairStrategy;
import com.datanumia.kata.category.pairs.TwoPairStrategy;
import com.datanumia.kata.category.straight.LargeStraightStrategy;
import com.datanumia.kata.category.straight.SmallStraightStrategy;

public class CategoryStrategyFactory {
    public static CategoryStrategy createCategoryStrategy(Category category) {
        return switch (category) {
            case CHANCE -> new ChanceStrategy();
            case YATZY -> new YatzyStrategy();
            case ONES -> new OnesStrategy();
            case TWOS -> new TwosStrategy();
            case THREES -> new ThreesStrategy();
            case FOURS -> new FoursStrategy();
            case FIVES -> new FivesStrategy();
            case SIXES -> new SixesStrategy();
            case PAIR -> new PairStrategy();
            case TWO_PAIR -> new TwoPairStrategy();
            case THREE_OF_A_KIND -> new ThreeOfAKindStrategy();
            case FOUR_OF_A_KIND -> new FourOfAKindStrategy();
            case SMALL_STRAIGHT -> new SmallStraightStrategy();
            case LARGE_STRAIGHT -> new LargeStraightStrategy();
            case FULL_HOUSE -> new FullHouseStrategy();
        };
    }
}
