import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    @ParameterizedTest
    @MethodSource("chanceDiceParams")
    public void chance_category_shouldSumAllDice(List<Integer> dice, int expectedScore) {
        //Given
        //When
        int sum = Yatzy.chance(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4));

        //Then
        assertThat(sum).isEqualTo(expectedScore);
    }

    static Stream<Arguments> chanceDiceParams() {
        return Stream.of(
            Arguments.of(List.of(2, 3, 4, 5, 1), 15),
            Arguments.of(List.of(3, 3, 4, 5, 1), 16)
        );
    }

    @ParameterizedTest
    @MethodSource("yatzyDiceParams")
    public void yatzy_category_shouldScores50(List<Integer> dice, int expectedScore) {
        //Given
        //When
        int sum = Yatzy.yatzy(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4));

        //Then
        assertThat(sum).isEqualTo(expectedScore);
    }

    static Stream<Arguments> yatzyDiceParams() {
        return Stream.of(
            Arguments.of(List.of(4, 4, 4, 4, 4), 50),
            Arguments.of(List.of(6, 6, 6, 6, 6), 50),
            Arguments.of(List.of(4, 6, 6, 6, 3), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("OnesDiceParams")
    public void ones_category_shouldSumOnes(List<Integer> dice, int expectedScore) {
        //Given
        //When
        int sum = Yatzy.ones(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4));

        //Then
        assertThat(sum).isEqualTo(expectedScore);
    }

    static Stream<Arguments> OnesDiceParams() {
        return Stream.of(
            Arguments.of(List.of(1, 2, 1, 4, 5), 2),
            Arguments.of(List.of(6, 2, 2, 4, 5), 0),
            Arguments.of(List.of(1, 2, 1, 1, 1), 4)
        );
    }

    @ParameterizedTest
    @MethodSource("twosDiceParams")
    public void twos_category_shouldSumTwos(List<Integer> dice, int expectedScore) {
        //Given
        //When
        int sum = Yatzy.twos(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4));

        //Then
        assertThat(sum).isEqualTo(expectedScore);
    }

    static Stream<Arguments> twosDiceParams() {
        return Stream.of(
            Arguments.of(List.of(1, 2, 3, 2, 6), 4),
            Arguments.of(List.of(2, 2, 2, 2, 2), 10)
        );
    }

    @ParameterizedTest
    @MethodSource("threesDiceParams")
    public void threes_category_shouldSumTwos(List<Integer> dice, int expectedScore) {
        //Given
        //When
        int sum = Yatzy.threes(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4));

        //Then
        assertThat(sum).isEqualTo(expectedScore);
    }

    static Stream<Arguments> threesDiceParams() {
        return Stream.of(
            Arguments.of(List.of(1, 2, 3, 2, 3), 6),
            Arguments.of(List.of(2, 3, 3, 3, 3), 12)
        );
    }

    @ParameterizedTest
    @MethodSource("foursDiceParams")
    public void fours_category_shouldSumTwos(List<Integer> dice, int expectedScore) {
        //Given
        //When
        int sum = new Yatzy(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4)).fours();

        //Then
        assertThat(sum).isEqualTo(expectedScore);
    }

    static Stream<Arguments> foursDiceParams() {
        return Stream.of(
            Arguments.of(List.of(4, 4, 4, 5, 5), 12),
            Arguments.of(List.of(4, 4, 5, 5, 5), 8),
            Arguments.of(List.of(4, 5, 5, 5, 5), 4)
        );
    }

    @ParameterizedTest
    @MethodSource("fivesDiceParams")
    public void fives_category_shouldSumTwos(List<Integer> dice, int expectedScore) {
        //Given
        //When
        int sum = new Yatzy(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4)).fives();

        //Then
        assertThat(sum).isEqualTo(expectedScore);
    }

    static Stream<Arguments> fivesDiceParams() {
        return Stream.of(
            Arguments.of(List.of(4, 4, 4, 5, 5), 10),
            Arguments.of(List.of(4, 4, 5, 5, 5), 15),
            Arguments.of(List.of(4, 5, 5, 5, 5), 20)
        );
    }

    @ParameterizedTest
    @MethodSource("sixesDiceParams")
    public void sixes_category_shouldSumTwos(List<Integer> dice, int expectedScore) {
        //Given
        //When
        int sum = new Yatzy(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4)).sixes();

        //Then
        assertThat(sum).isEqualTo(expectedScore);
    }

    static Stream<Arguments> sixesDiceParams() {
        return Stream.of(
            Arguments.of(List.of(4, 4, 4, 5, 5), 0),
            Arguments.of(List.of(4, 4, 6, 5, 5), 6),
            Arguments.of(List.of(6, 5, 6, 6, 5), 18)
        );
    }

    @ParameterizedTest
    @MethodSource("onePairDiceParams")
    public void onePair_category_shouldSumHighestPair(List<Integer> dice, int expectedScore) {
        //Given
        //When
        int sum = Yatzy.score_pair(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4));

        //Then
        assertThat(sum).isEqualTo(expectedScore);
    }

    static Stream<Arguments> onePairDiceParams() {
        return Stream.of(
            Arguments.of(List.of(3, 4, 3, 5, 6), 6),
            Arguments.of(List.of(5, 3, 3, 3, 5), 10),
            Arguments.of(List.of(5, 3, 6, 6, 5), 12)
        );
    }

    @Test
    public void two_Pair() {
        assertEquals(16, Yatzy.two_pair(3, 3, 5, 4, 5));
        assertEquals(16, Yatzy.two_pair(3, 3, 5, 5, 5));
    }

    @ParameterizedTest
    @MethodSource("twoPairDiceParams")
    public void twoPairs_category_shouldSumTheTwoPairs(List<Integer> dice, int expectedScore) {
        //Given
        //When
        int sum = Yatzy.two_pair(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4));

        //Then
        assertThat(sum).isEqualTo(expectedScore);
    }

    static Stream<Arguments> twoPairDiceParams() {
        return Stream.of(
            Arguments.of(List.of(3, 3, 5, 4, 5), 16),
            Arguments.of(List.of(3, 3, 5, 5, 5), 16)
        );
    }

    @ParameterizedTest
    @MethodSource("threeOfAKindDiceParams")
    public void threeOfAKind_category_shouldSumTheDiceThreeTimes(List<Integer> dice, int expectedScore) {
        //Given
        //When
        int sum = Yatzy.three_of_a_kind(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4));

        //Then
        assertThat(sum).isEqualTo(expectedScore);
    }

    static Stream<Arguments> threeOfAKindDiceParams() {
        return Stream.of(
            Arguments.of(List.of(3, 3, 3, 4, 5), 9),
            Arguments.of(List.of(5, 3, 5, 4, 5), 15),
            Arguments.of(List.of(3, 3, 3, 3, 5), 9)
        );
    }

    @ParameterizedTest
    @MethodSource("fourOfAKindDiceParams")
    public void fourOfAKind_category_shouldSumTheDiceFourTimes(List<Integer> dice, int expectedScore) {
        //Given
        //When
        int sum = Yatzy.four_of_a_kind(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4));

        //Then
        assertThat(sum).isEqualTo(expectedScore);
    }

    static Stream<Arguments> fourOfAKindDiceParams() {
        return Stream.of(
            Arguments.of(List.of(3, 3, 3, 3, 5), 12),
            Arguments.of(List.of(5, 5, 5, 4, 5), 20),
            Arguments.of(List.of(3, 3, 3, 3, 3), 12)
        );
    }

    @ParameterizedTest
    @MethodSource("smallStraightDiceParams")
    public void smallStraight_category_shouldScores15(List<Integer> dice, int expectedScore) {
        //Given
        //When
        int sum = Yatzy.smallStraight(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4));

        //Then
        assertThat(sum).isEqualTo(expectedScore);
    }

    static Stream<Arguments> smallStraightDiceParams() {
        return Stream.of(
            Arguments.of(List.of(1, 2, 3, 4, 5), 15),
            Arguments.of(List.of(2, 3, 4, 5, 1), 15),
            Arguments.of(List.of(1, 2, 2, 4, 5), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("largeStraightDiceParams")
    public void largeStraight_category_shouldScores20(List<Integer> dice, int expectedScore) {
        //Given
        //When
        int sum = Yatzy.largeStraight(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4));

        //Then
        assertThat(sum).isEqualTo(expectedScore);
    }

    static Stream<Arguments> largeStraightDiceParams() {
        return Stream.of(
            Arguments.of(List.of(6, 2, 3, 4, 5), 20),
            Arguments.of(List.of(2, 3, 4, 5, 6), 20),
            Arguments.of(List.of(1, 2, 2, 4, 5), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("fullHouseDiceParams")
    public void fullHouse_category_shouldSumAll(List<Integer> dice, int expectedScore) {
        //Given
        //When
        int sum = Yatzy.fullHouse(dice.get(0), dice.get(1), dice.get(2), dice.get(3), dice.get(4));

        //Then
        assertThat(sum).isEqualTo(expectedScore);
    }

    static Stream<Arguments> fullHouseDiceParams() {
        return Stream.of(
            Arguments.of(List.of(6, 2, 2, 2, 6), 18),
            Arguments.of(List.of(2, 3, 4, 5, 6), 0)
        );
    }
}
