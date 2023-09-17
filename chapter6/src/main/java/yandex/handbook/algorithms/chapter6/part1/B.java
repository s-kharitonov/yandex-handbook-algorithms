package yandex.handbook.algorithms.chapter6.part1;

import java.io.*;

/**
 * <h1>
 * Размен: 1, 5, 10, 20, 50
 * </h1>
 * <p>
 * Предположим, что у кассира есть бесконечное количество монет номиналами 1, 5, 10, 20, 50. Найдите все наборы монет, с
 * суммарным номиналом money,  в котором наименьшее количество монет. Требуется вывести номиналы монет в этом наборе.
 * </p>
 * <p>
 * Формат ввода
 * <p>
 * Целое число money. Ограничения: 1 <= money <= 10^5
 * </p>
 * <p>
 * Формат вывода
 * <p>
 * В первой строке выведите количество монет в наборе m. В следующей строке выведите выбранные монеты: номиналы монет.
 * Монеты можете выводить в любом порядке.
 * </p>
 */
public class B {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            var money = Integer.parseInt(reader.readLine());
            var fifty = 0;
            var twenty = 0;
            var ten = 0;
            var five = 0;
            var one = 0;

            while (money > 0) {
                if (money >= 50) {
                    money -= 50;
                    fifty++;
                } else if (money >= 20) {
                    money -= 20;
                    twenty++;
                } else if (money >= 10) {
                    money -= 10;
                    ten++;
                } else if (money >= 5) {
                    money -= 5;
                    five++;
                } else {
                    money--;
                    one++;
                }
            }

            var coinsCount  = fifty + twenty + ten + five +one;
            var coins = "50 ".repeat(fifty) + "20 ".repeat(twenty) + "10 ".repeat(ten) + "5 ".repeat(five) + "1 ".repeat(one);

            writer.write(coinsCount + System.lineSeparator() + coins.trim());
        }
    }

}
