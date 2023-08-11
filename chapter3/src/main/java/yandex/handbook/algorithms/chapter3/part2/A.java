package yandex.handbook.algorithms.chapter3.part2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.util.Comparator.comparingInt;

/**
 * <h1>
 *     Бронирование переговорки
 * </h1>
 * <p>
 *     Задано n интервалов. Требуется найти максимальное количество взаимно непересекающихся интервалов. Два интервала
 *     пересекаются, если они имеют хотя бы одну общую точку.
 * </p>
 * <p>
 *     Формат ввода
 *     <br/>
 *      В первой строке задано одно число (1 ≤ n ≤ 100) — количество интервалов. В следующих n строках заданы интервалы
 *      li, ri (1 <= li <= ri <= 50)
 * </p>
 * <p>
 *     Формат вывода
 *     <br/>
 *     Выведите ответ на задачу.
 * </p>
 */
public class A {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            var intervalsCount = Integer.parseInt(reader.readLine());
            Queue<List<Integer>> intervals = new PriorityQueue<>(intervalsCount, comparingInt(thisInterval -> thisInterval.get(1)));

            for (int i = 0; i < intervalsCount; i++) {
                String[] splittedLine = reader.readLine()
                        .split(" ");
                List<Integer> interval = List.of(Integer.parseInt(splittedLine[0]), Integer.parseInt(splittedLine[1]));

                intervals.offer(interval);
            }

            List<List<Integer>> result = new ArrayList<>(intervalsCount);
            var bestInterval = intervals.poll();

            result.add(bestInterval);

            while (!intervals.isEmpty()) {
                var currentInterval = intervals.poll();
                var currentIntervalLeftBoundary = currentInterval.get(0);
                var bestIntervalRightBoundary = bestInterval.get(1);

                if (currentIntervalLeftBoundary > bestIntervalRightBoundary) {
                    bestInterval = currentInterval;

                    result.add(currentInterval);
                }
            }

            writer.write(String.valueOf(result.size()));
        }
    }

}
