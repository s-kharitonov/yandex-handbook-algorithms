package yandex.handbook.algorithms.chapter3.part5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * <h1>
 * Сортировка слиянием
 * </h1>
 * <p>
 * Реализуйте сортировку слиянием.
 * </p>
 * <p>
 * Формат ввода
 * <br/>
 * В первой строке задано одно число n (1 <= n <= 100000).
 * Во второй строке задано n чисел ai (0 <= ai <= 10^9)
 * </p>
 * <p>
 * Формат вывода
 * <br/>
 * Выведите отсортированный массив чисел.
 * </p>
 */
public class C {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            var n = Integer.parseInt(reader.readLine());
            List<Integer> numbers = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());
            List<Integer> sortedNumbers = mergeSort(numbers);
            var result = sortedNumbers.stream()
                    .map(String::valueOf)
                    .collect(joining(" "));

            writer.write(result);
        }
    }

    public static List<Integer> mergeSort(List<Integer> numbers) {
        if (numbers.size() == 1) {
            return numbers;
        }

        var middle = numbers.size() / 2;
        List<Integer> firstHalf = numbers.subList(0, middle);
        List<Integer> secondHalf = numbers.subList(middle, numbers.size());
        List<Integer> sortedFirstHalf = mergeSort(firstHalf);
        List<Integer> sortedSecondHalf = mergeSort(secondHalf);

        return merge(sortedFirstHalf, sortedSecondHalf);
    }

    public static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>(list1.size() + list2.size());
        var smallestElementIndexFromFirstList = 0;
        var smallestElementIndexFromSecondList = 0;

        while (smallestElementIndexFromFirstList < list1.size() && smallestElementIndexFromSecondList < list2.size()) {
            var smallestElementFromFirstList = list1.get(smallestElementIndexFromFirstList);
            var smallestElementFromSecondList = list2.get(smallestElementIndexFromSecondList);

            if (smallestElementFromFirstList <= smallestElementFromSecondList) {
                mergedList.add(smallestElementFromFirstList);
                smallestElementIndexFromFirstList++;
            } else {
                mergedList.add(smallestElementFromSecondList);
                smallestElementIndexFromSecondList++;
            }
        }

        while (smallestElementIndexFromFirstList < list1.size()) {
            var currentElement = list1.get(smallestElementIndexFromFirstList);

            mergedList.add(currentElement);
            smallestElementIndexFromFirstList++;
        }

        while (smallestElementIndexFromSecondList < list2.size()) {
            var currentElement = list2.get(smallestElementIndexFromSecondList);

            mergedList.add(currentElement);
            smallestElementIndexFromSecondList++;
        }

        return mergedList;
    }

}