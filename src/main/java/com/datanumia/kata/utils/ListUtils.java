package com.datanumia.kata.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ListUtils {
    public static int sum(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum);
    }

    public static int filterByNumberAndSum(List<Integer> list, int number) {
        return list.stream()
            .filter(x -> x == number)
            .mapToInt(Integer::intValue)
            .sum();
    }

    public static Stream<Integer> filterPairStream(List<Integer> list) {
        return list.stream()
            .filter(x -> getNumberFrequency(list, x) >= 2);
    }

    public static int getNumberFrequency(List<Integer> list, int number) {
        return Collections.frequency(list, number);
    }

    public static List<Integer> sort(List<Integer> dice) {
        return dice.stream().sorted().toList();
    }

    public static int diceFrequency(List<Integer> dice, int number) {
        return Collections.frequency(dice, number);
    }
}
