package yandex.handbook.algorithms.chapter3.part4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BTest {

    @ParameterizedTest
    @CsvSource({
            "3, 5",
            "4, 9",
            "5, 13",
            "6, 17",
            "7, 25",
            "8, 33",
            "9, 41",
            "10, 49",
    })
    void shouldCalculateStepsCount(int diskCount, int expectedStepsCount) {
        assertThat(B.calculateStepsCountForResolveHanoiTowers(diskCount))
                .isEqualTo(expectedStepsCount);
    }

}