package yandex.handbook.algorithms.chapter3.part6;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.partitioningBy;

/**
 * <h1>
 *      Разбиение Ломуто
 * </h1>
 * <p>
 *      Постройте разбиение Ломуто относительно первого числа.
 * </p>
 * <p>
 *      Формат ввода
 * <br/>
 *      В первой строке задано одно число n (1 <= n <= 100000).
 *      Во второй строке задано n чисел ai (1 <= ai <= 10^9)
 * </p>
 * <p>
 *      Формат вывода
 * <br/>
 *      Выведите разбиение Ломуто.
 * </p>
 */
public class A {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            var n = Integer.parseInt(reader.readLine());
            List<Integer> numbers = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            var result = lomutoPartitionByFirstElement(numbers).stream()
                    .map(String::valueOf)
                    .collect(joining(" "));

            writer.write(result);
        }
    }

    public static List<Integer> lomutoPartitionByFirstElement(List<Integer> numbers) {
        var pivot = numbers.get(0);
        Map<Boolean, List<Integer>> smallestAndLargestNumbersThanPivot = numbers.stream()
                .collect(partitioningBy(number -> number <= pivot));
        List<Integer> smallestNumbersThanPivot = smallestAndLargestNumbersThanPivot.get(true);
        List<Integer> largestNumbersThanPivot = smallestAndLargestNumbersThanPivot.get(false);

        var lastSmallestElementIndex = smallestNumbersThanPivot.size() - 1;

        smallestNumbersThanPivot.addAll(largestNumbersThanPivot);

        swap(smallestNumbersThanPivot, 0, lastSmallestElementIndex);

        return smallestNumbersThanPivot;
    }

    public static void swap(List<Integer> numbers, int firstIndex, int secondIndex) {
        var prevValue = numbers.get(firstIndex);

        numbers.set(firstIndex, numbers.get(secondIndex));
        numbers.set(secondIndex, prevValue);
    }

}
