package yandex.handbook.algorithms.chapter3.part5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * <h1>
 * Слияние сортированных последовательностей
 * </h1>
 * <p>
 * Задано  n отсортированных по неубыванию последовательностей. Требуется найти отсортированную по неубыванию
 * конкатенацию этих последовательностей.
 * </p>
 * <p>
 * Формат ввода
 * <br/>
 * В первой строке задано одно число n (1 <= n <= 20) - количество отсортированных последовательностей.
 * Каждая из следующих последовательностей задано в формате: В первой строке mi (1 <= mi <= 10^5) - количество
 * элементов последовательности. Во второй сами элементы ai (1 <= ai <= 10^9).
 * </p>
 * <p>
 * Формат вывода
 * <br/>
 * В единственной строке выведите ответ на задачу.
 * </p>
 */
public class B {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            var n = Integer.parseInt(reader.readLine());
            List<List<Integer>> sortedNumbers = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                var length = Integer.parseInt(reader.readLine());
                List<Integer> numbers = Arrays.stream(reader.readLine().split(" "))
                        .map(Integer::parseInt)
                        .sorted()
                        .collect(toList());

                sortedNumbers.add(numbers);
            }

            List<Integer> mergedNumbers = sortedNumbers.stream()
                    .reduce(List.of(), B::merge);
            var result = mergedNumbers.stream()
                    .map(String::valueOf)
                    .collect(joining(" "));

            writer.write(result);
        }
    }

    public static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
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
            mergedList.add(list1.get(smallestElementIndexFromFirstList));
            smallestElementIndexFromFirstList++;
        }

        while (smallestElementIndexFromSecondList < list2.size()) {
            mergedList.add(list2.get(smallestElementIndexFromSecondList));
            smallestElementIndexFromSecondList++;
        }

        return mergedList;
    }

}
