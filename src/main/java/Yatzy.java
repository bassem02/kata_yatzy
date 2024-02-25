import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Yatzy {

    public static int chance(List<Integer> dice) {
        return sum(dice);
    }

    public static int yatzy(List<Integer> dice) {
        var isAllSameValue = dice.stream()
            .distinct()
            .count() == 1;
        return isAllSameValue ? 50 : 0;
    }

    public static int ones(List<Integer> dice) {
        return numberCategory(dice, 1);
    }

    public static int twos(List<Integer> dice) {
        return numberCategory(dice, 2);
    }

    public static int threes(List<Integer> dice) {
        return numberCategory(dice, 3);
    }

    public static int fours(List<Integer> dice) {
        return numberCategory(dice, 4);
    }

    public static int fives(List<Integer> dice) {
        return numberCategory(dice, 5);
    }

    public static int sixes(List<Integer> dice) {
        return numberCategory(dice, 6);
    }

    public static int pair(List<Integer> dice) {
        var highestPairDice = filterPair(dice)
            .max(Comparator.naturalOrder())// highest dice
            .orElse(0); // if no pair is found
        return highestPairDice * 2;
    }

    public static int twoPair(List<Integer> dice) {
        var pairDiceList = filterPair(dice).distinct().toList(); // distinct is used to handle the case when a pair is also present 3 times
        if (pairDiceList.size() == 2) { // there is two pair
            return sum(pairDiceList) * 2;
        } else { // less than two pair
            return 0;
        }
    }

    public static int threeOfAKind(List<Integer> dice) {
        return frequencyOfKind(dice, 3);
    }

    public static int fourOfAKind(List<Integer> dice) {
        return frequencyOfKind(dice, 4);
    }

    public static int smallStraight(List<Integer> dice) {
        var isSmallStraight = sort(dice).equals(List.of(1, 2, 3, 4, 5));
        return isSmallStraight ? 15 : 0;
    }

    public static int largeStraight(List<Integer> dice) {
        var isSmallStraight = sort(dice).equals(List.of(2, 3, 4, 5, 6));
        return isSmallStraight ? 20 : 0;
    }

    public static int fullHouse(List<Integer> dice) {
        var threeOfKind = dice.stream().filter(x -> diceFrequency(dice, x) == 3).findFirst().orElse(0);
        if (threeOfKind == 0) { // stop if there is no three of a kind
            return 0;
        }
        var twoOfKind = dice.stream().filter(x -> diceFrequency(dice, x) == 2).findFirst().orElse(0);
        if (twoOfKind == 0) { // stop if there is no two of a kind
            return 0;
        }
        return sum(dice);
    }

    private static int numberCategory(List<Integer> dice, int numberCategory) {
        return dice.stream()
            .filter(x -> x == numberCategory)
            .mapToInt(Integer::intValue)
            .sum();
    }

    private static int sum(List<Integer> dice) {
        return dice.stream().reduce(0, Integer::sum);
    }

    private static int frequencyOfKind(List<Integer> dice, int frequency) {
        return dice.stream().filter(x -> diceFrequency(dice, x) >= frequency)
            .distinct()
            .findFirst()
            .orElse(0)
            * frequency;
    }

    private static Stream<Integer> filterPair(List<Integer> dice) {
        return dice.stream()
            .filter(x -> diceFrequency(dice, x) >= 2);
    }

    private static List<Integer> sort(List<Integer> dice) {
        return dice.stream().sorted().toList();
    }

    private static int diceFrequency(List<Integer> dice, int number) {
        return Collections.frequency(dice, number);
    }
}



