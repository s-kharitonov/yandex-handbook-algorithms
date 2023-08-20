package yandex.handbook.algorithms.chapter3.part6;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

/**
 * <h1>
 *      Быстрая сортировка
 * </h1>
 * <p>
 *      Реализуйте QuickSort
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
 *      Выведите отсортированный массив чисел.
 * </p>
 */
public class B {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            var n = Integer.parseInt(reader.readLine());
            List<Integer> numbers = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            quickSort(numbers, 0, numbers.size() - 1);

            var result = numbers.stream()
                    .map(String::valueOf)
                    .collect(joining(" "));

            writer.write(result);
        }
    }

    public static void quickSort(List<Integer> numbers, int left, int right) {
        if (left >= right) {
            return;
        }

        var pivot = partition(numbers, left, right);

        quickSort(numbers, left, pivot - 1);
        quickSort(numbers, pivot, right);
    }

    private static int partition(List<Integer> numbers, int left, int right) {
        var pivot = numbers.get(left + (right - left) / 2);

        while (left <= right) {
            while (numbers.get(left) < pivot) {
                left++;
            }

            while (numbers.get(right) > pivot) {
                right--;
            }

            if (left <= right) {
                swap(numbers, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    private static void swap(List<Integer> numbers, int firstIndex, int secondIndex) {
        var prevValue = numbers.get(firstIndex);

        numbers.set(firstIndex, numbers.get(secondIndex));
        numbers.set(secondIndex, prevValue);
    }

}
