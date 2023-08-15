package yandex.handbook.algorithms.chapter3.part5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ATest {

    @ParameterizedTest
    @MethodSource("makeArrays")
    void shouldSortNumbers(int[] numbers, int[] expectedNumbers) {
        A.selectionSort(numbers);

        assertThat(numbers).containsExactly(expectedNumbers);
    }

    private static Stream<Arguments> makeArrays() {
        var example1 = new int[]{13, 17, 37, 73, 31, 19, 23};
        var expectedResultExample1 = new int[]{13, 17, 19, 23, 31, 37, 73};

        var example2 = new int[]{12, 18, 7, 11, 5, 17};
        var expectedResultExample2 = new int[]{5, 7, 11, 12, 17, 18};

        var example3 = new int[]{1, 2, 3};
        var expectedResultExample3 = new int[]{1, 2, 3};

        return Stream.of(
                Arguments.of(example1, expectedResultExample1),
                Arguments.of(example2, expectedResultExample2),
                Arguments.of(example3, expectedResultExample3)
        );
    }

}