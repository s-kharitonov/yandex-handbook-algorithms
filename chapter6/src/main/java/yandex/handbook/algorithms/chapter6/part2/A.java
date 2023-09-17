package yandex.handbook.algorithms.chapter6.part2;

import java.io.*;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <h1>
 * Специи
 * </h1>
 * <p>
 * Вор пробрался в лавку специй и нашел там n видов специй. В его рюкзак можно сложить до W фунтов, поэтому забрать все
 * он не сможет. Предположим, в лавке находится wi фунтов специй с номером i и стоимостью ci долларов.
 * <p>
 * Как унести максимально дорогую добычу? Если вор заберет u1 фунтов специй с номером 1, u2 фунтов специй с номером 2,
 * u3 фунтов специй с номером 3, и т. д., общая ценность украденного составит c1 * (u1 / w1) + c2 * (u2 / w2) + c3 * (u3
 * / w3) ... cn * (un / wn).
 * <p>
 * Вор хотел бы найти максимальное значение этого выражения при следующих ограничениях: ui <= wi, u1 + u2 + ... + un <=
 * w
 * <p>
 * Формат ввода
 * <p>
 * Первая строка ввода содержит n специй и вместимость рюкзака W. Следующие n строк указывают цену и вес специй. i-я
 * строка включает в себя цену ci и вес wi i-й специи. Ограничения: 1 <= n <= 10^3, 0 <= W <= 2 * 10^6, 0 <= ci <= 2 *
 * 10^6, 0 < wi <= 2 * 10^6 для всех 1 <= i <= n. Все числа - целые.
 * </p>
 * <p>
 * Формат вывода
 * <p>
 * Максимальное значение специй, которые вместятся в рюкзак.
 * </p>
 */
public class A {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            var spicesCountWithBagSize = reader.readLine()
                    .split(" ");
            var spicesCount = Integer.parseInt(spicesCountWithBagSize[0]);
            var bagSize = Integer.parseInt(spicesCountWithBagSize[1]);
            Queue<Spice> spices = new PriorityQueue<>(spicesCount);

            for (int i = 0; i < spicesCount; i++) {
                var spice = reader.readLine()
                        .split(" ");

                spices.add(new Spice(Integer.parseInt(spice[0]), Integer.parseInt(spice[1])));
            }

            var result = 0d;

            while (!spices.isEmpty() && bagSize > 0) {
                var spice = spices.poll();
                var amount = Math.min(spice.weight, bagSize);

                result += spice.costByItem * amount;
                bagSize -= amount;
            }

            writer.write(String.format(Locale.US, "%.3f", result));
        }
    }

    public static class Spice implements Comparable<Spice> {

        private final int cost;

        private final int weight;

        private final double costByItem;

        public Spice(int cost, int weight) {
            this.cost = cost;
            this.weight = weight;
            this.costByItem = (double) cost / weight;
        }

        @Override
        public int compareTo(Spice o) {
            return Double.compare(o.costByItem, this.costByItem);
        }

    }

}
