package yandex.handbook.algorithms.chapter6.part3;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.util.stream.Collectors.toCollection;

/**
 * <h1>
 * Рекламная кампания
 * </h1>
 * <p>
 * У вас есть популярная страница в интернете, на которой есть n рекламных мест. Вы хотите продать их рекламодателям.
 * Аналитики рассчитывают на clicks1, clicks2, ..., clicksn кликов в день, соответственно.
 * <p>
 * С вами связались n рекламодателей, которые готовы заплатить price1, price2, ..., pricen за клик.
 * <p>
 * Как подобрать пары рекламных мест и рекламодателей так, чтобы получить максимальную прибыль?
 * <p>
 * Формат ввода
 * <p>
 * В первой строке приведено целое число n, во второй — последовательность целых чисел price1, ..., pricen, в третьей -
 * последовательность целых чисел clicks1, ..., clicksn. Ограничения: 1 <= n <= 10^3; 0 <= pricei, clicksi, <= 10^5 для
 * всех 1 <= i <= n
 * </p>
 * <p>
 * Формат вывода
 * <p>
 * Максимальное значение (price1 * c1 + ... + pricen * cn), где c1, ..., cn - это перестановка clicks1, ..., clicksn
 * </p>
 */
public class A {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            var advertisersCount = Integer.parseInt(reader.readLine());
            Queue<Long> prices = Arrays.stream(reader.readLine().split(" "))
                    .map(Long::parseLong)
                    .collect(toCollection(() -> new PriorityQueue<>(advertisersCount)));
            Queue<Long> clicks = Arrays.stream(reader.readLine().split(" "))
                    .map(Long::parseLong)
                    .collect(toCollection(() -> new PriorityQueue<>(advertisersCount)));
            var revenue = 0L;

            while (!clicks.isEmpty() && !prices.isEmpty()) {
                var price = prices.poll();
                var click = clicks.poll();

                revenue += price * click;
            }

            writer.write(String.valueOf(revenue));
        }
    }

}
