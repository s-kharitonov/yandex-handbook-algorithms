package yandex.handbook.algorithms.chapter3.part5;

import java.io.*;
import java.util.Arrays;

import static java.util.stream.Collectors.joining;

/**
 * <h1>
 *      Сортировка выбором
 * </h1>
 * <p>
 *      Реализуйте сортировку выбором.
 * </p>
 * <p>
 *      Формат ввода
 * <br/>
 *      В первой строке задано число (1 ≤ n ≤ 1000).
 *      Во второй строке задано n чисел (1 ≤ ai ≤ 10^9).
 * </p>
 * <p>
 *      Формат вывода
 * <br/>
 *      Выведите отсортированный массив чисел.
 * </p>
 */
public class A {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            var n = Integer.parseInt(reader.readLine());
            int[] numbers = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            selectionSort(numbers);

            var result = Arrays.stream(numbers)
                    .mapToObj(String::valueOf)
                    .collect(joining(" "));

            writer.write(result);
        }
    }

    public static void selectionSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            var smallestNumber = numbers[i];
            var smallestNumberIndex = i;

            for (int j = i + 1; j < numbers.length; j++) {
                var currentNumberToCompare = numbers[j];

                if (currentNumberToCompare < smallestNumber) {
                    smallestNumber = currentNumberToCompare;
                    smallestNumberIndex = j;
                }
            }

            swap(numbers, i, smallestNumberIndex);
        }
    }

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        var prevValue = array[firstIndex];

        array[firstIndex] = array[secondIndex];
        array[secondIndex] = prevValue;
    }

}
