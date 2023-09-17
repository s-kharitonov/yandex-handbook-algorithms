package yandex.handbook.algorithms.chapter6.part2;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <h1>
 * Сувениры
 * </h1>
 * <p>
 * Турист зашел в сувенирную лавку и нашел там много привлекательных вариантов подарков друзьям и родным. Всего в лавке
 * n сувениров, стоимость i-го сувенира ci рублей. Определите, какое наибольшее количество сувениров сможет купить
 * турист, если он может потратить не более S рублей.
 * <p>
 * Формат ввода
 * <p>
 * Первая строка ввода содержит количество сувениров n и бюджет на сувениры S. Следующие n строк указывают цену
 * очередного сувенира. i-я строка включает в себя цену ci. Ограничения: 1 <= n <= 10^3, 0 <= S <= 2 * 10^6; 0 <= ci <=
 * 2 * 10^6 для всех 1 <= i <= n. Все числа целые.
 * </p>
 * <p>
 * Формат вывода
 * <p>
 * Максимальное количество сувениров, которые может купить турист.
 * </p>
 */
public class B {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            var souvenirsCountAndMoney = reader.readLine()
                    .split(" ");
            var souvenirsCount = Integer.parseInt(souvenirsCountAndMoney[0]);
            var money = Integer.parseInt(souvenirsCountAndMoney[1]);
            Queue<Integer> costs = new PriorityQueue<>(souvenirsCount);

            for (int i = 0; i < souvenirsCount; i++) {
                var cost = Integer.parseInt(reader.readLine());

                costs.add(cost);
            }

            var maxAvailableSouvenirsCount = 0;

            while (!costs.isEmpty() && money >= costs.peek()) {
                var cost = costs.poll();

                maxAvailableSouvenirsCount++;
                money -= cost;
            }

            writer.write(String.valueOf(maxAvailableSouvenirsCount));
        }
    }

}
