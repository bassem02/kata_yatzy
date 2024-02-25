import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class YatzyTest {

    @ParameterizedTest
    @MethodSource("chanceDiceParams")
    public void chance_category_shouldSumAllDice(List<Integer> dice, int expectedScore) {
        //Given
        //When
        int sum = Yatzy.chance(dice);

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
        int sum = Yatzy.yatzy(dice);

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
        int sum = Yatzy.ones(dice);

        //Then
        assertThat(sum).isEqualTo(expectedScore);
    }

    static Stream<Arguments> OnesDiceParams() {
        return Stream.of(
            Arguments.of(List.of(1, 2, 1, 4, 5), 2),
            Arguments.of(List.of(6, 2, 2, 4, 5), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("twosDiceParams")
    public void twos_category_shouldSumTwos(List<Integer> dice, int expectedScore) {
        //Given
        //When
        int sum = Yatzy.twos(dice);

        //Then
        assertThat(sum).isEqualTo(expectedScore);
    }

    static Stream<Arguments> twosDiceParams() {
        return Stream.of(
            Arguments.of(List.of(1, 2, 3, 2, 6), 4),
            Arguments.of(List.of(1, 3, 3, 3, 3), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("threesDiceParams")
    public void threes_category_shouldSumTwos(List<Integer> dice, int expectedScore) {
        //Given
        //When
        int sum = Yatzy.threes(dice);

        //Then
        assertThat(sum).isEqualTo(expectedScore);
    }

    static Stream<Arguments> threesDiceParams() {
        return Stream.of(
            Arguments.of(List.of(1, 2, 3, 2, 3), 6),
            Arguments.of(List.of(2, 1, 2, 5, 5), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("foursDiceParams")
    public void fours_category_shouldSumTwos(List<Integer> dice, int expectedScore) {
        //Given
        //When
        int sum = Yatzy.fours(dice);

        //Then
        assertThat(sum).isEqualTo(expectedScore);
    }

    static Stream<Arguments> foursDiceParams() {
        return Stream.of(
            Arguments.of(List.of(4, 4, 4, 5, 5), 12),
            Arguments.of(List.of(6, 5, 5, 5, 5), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("fivesDiceParams")
    public void fives_category_shouldSumTwos(List<Integer> dice, int expectedScore) {
        //Given
        //When
        int sum = Yatzy.fives(dice);

        //Then
        assertThat(sum).isEqualTo(expectedScore);
    }

    static Stream<Arguments> fivesDiceParams() {
        return Stream.of(
            Arguments.of(List.of(5, 4, 4, 4, 5), 10),
            Arguments.of(List.of(4, 6, 6, 6, 6), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("sixesDiceParams")
    public void sixes_category_shouldSumTwos(List<Integer> dice, int expectedScore) {
        //Given
        //When
        int sum = Yatzy.sixes(dice);

        //Then
        assertThat(sum).isEqualTo(expectedScore);
    }

    static Stream<Arguments> sixesDiceParams() {
        return Stream.of(
            Arguments.of(List.of(4, 4, 4, 5, 5), 0),
            Arguments.of(List.of(4, 4, 6, 5, 5), 6)
        );
    }

    @ParameterizedTest
    @MethodSource("onePairDiceParams")
    public void onePair_category_shouldSumHighestPair(List<Integer> dice, int expectedScore) {
        //Given
        //When
        int sum = Yatzy.pair(dice);

        //Then
        assertThat(sum).isEqualTo(expectedScore);
    }

    static Stream<Arguments> onePairDiceParams() {
        return Stream.of(
            Arguments.of(List.of(1, 2, 3, 4, 5), 0),
            Arguments.of(List.of(3, 3, 3, 4, 4), 8),
            Arguments.of(List.of(1, 1, 6, 2, 6), 12),
            Arguments.of(List.of(3, 3, 3, 4, 1), 6),
            Arguments.of(List.of(3, 3, 3, 3, 1), 6)
        );
    }

    @ParameterizedTest
    @MethodSource("twoPairDiceParams")
    public void twoPairs_category_shouldSumTheTwoPairs(List<Integer> dice, int expectedScore) {
        //Given
        //When
        int sum = Yatzy.twoPair(dice);

        //Then
        assertThat(sum).isEqualTo(expectedScore);
    }

    static Stream<Arguments> twoPairDiceParams() {
        return Stream.of(
            Arguments.of(List.of(1, 1, 2, 3, 3), 8),
            Arguments.of(List.of(1, 1, 2, 3, 4), 0),
            Arguments.of(List.of(1, 1, 2, 2, 2), 6),
            Arguments.of(List.of(3, 3, 3, 3, 1), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("threeOfAKindDiceParams")
    public void threeOfAKind_category_shouldSumTheDiceThreeTimes(List<Integer> dice, int expectedScore) {
        //Given
        //When
        int sum = Yatzy.threeOfAKind(dice);

        //Then
        assertThat(sum).isEqualTo(expectedScore);
    }

    static Stream<Arguments> threeOfAKindDiceParams() {
        return Stream.of(
            Arguments.of(List.of(3, 3, 3, 4, 5), 9),
            Arguments.of(List.of(5, 3, 5, 4, 0), 0),
            Arguments.of(List.of(3, 3, 3, 3, 5), 9)
        );
    }

    @ParameterizedTest
    @MethodSource("fourOfAKindDiceParams")
    public void fourOfAKind_category_shouldSumTheDiceFourTimes(List<Integer> dice, int expectedScore) {
        //Given
        //When
        int sum = Yatzy.fourOfAKind(dice);

        //Then
        assertThat(sum).isEqualTo(expectedScore);
    }

    static Stream<Arguments> fourOfAKindDiceParams() {
        return Stream.of(
            Arguments.of(List.of(3, 3, 3, 3, 5), 12),
            Arguments.of(List.of(5, 5, 5, 4, 0), 0),
            Arguments.of(List.of(3, 3, 3, 3, 3), 12)
        );
    }

    @ParameterizedTest
    @MethodSource("smallStraightDiceParams")
    public void smallStraight_category_shouldScores15(List<Integer> dice, int expectedScore) {
        //Given
        //When
        int sum = Yatzy.smallStraight(dice);

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
        int sum = Yatzy.largeStraight(dice
        );

        //Then
        assertThat(sum).isEqualTo(expectedScore);
    }

    static Stream<Arguments> largeStraightDiceParams() {
        return Stream.of(
            Arguments.of(List.of(2, 3, 4, 5, 6), 20),
            Arguments.of(List.of(6, 2, 3, 4, 5), 20),
            Arguments.of(List.of(1, 2, 2, 4, 5), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("fullHouseDiceParams")
    public void fullHouse_category_shouldSumAll(List<Integer> dice, int expectedScore) {
        //Given
        //When
        int sum = Yatzy.fullHouse(dice);

        //Then
        assertThat(sum).isEqualTo(expectedScore);
    }

    static Stream<Arguments> fullHouseDiceParams() {
        return Stream.of(
            Arguments.of(List.of(6, 2, 2, 2, 6), 18), //two of a kind + three of a kind
            Arguments.of(List.of(2, 3, 5, 5, 6), 0), //only two of a kind
            Arguments.of(List.of(2, 2, 2, 1, 6), 0), //only three of a kind
            Arguments.of(List.of(4, 4, 4, 4, 4), 0) //four of a kind
        );
    }
}
