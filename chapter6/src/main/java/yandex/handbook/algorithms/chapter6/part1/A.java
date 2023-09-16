package yandex.handbook.algorithms.chapter6.part1;

import java.io.*;

/**
 * <h1>
 * Размен: все варианты
 * </h1>
 * <p>
 * Предположим, что у кассира есть бесконечное количество монет номиналами 1, 5, 10
 * Найдите все наборы монет, которые в сумме даю money. Требуется вывести количество подходящих наборов монет и сами наборы.
 * Два набора считаются различными, если мультимножества монет не совпадают.
 * </p>
 * <p>
 * Формат ввода
 * <br/>
 * Целое число money.
 * Ограничения: 1 <= money <= 10^3
 * </p>
 * <p>
 * Формат вывода
 * <br/>
 * В первой строке выведите количество наборов m
 * В следующих m строк выведите сами наборы: количество монет и номиналы монет.
 * Наборы монет можете выводить в любом порядке.
 * </p>
 */
public class A {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            var money = Integer.parseInt(reader.readLine());
            var tenCoinsCount = (int) Math.floor((double) money / 10);
            var fiveCoinsCount = (int) Math.floor((double) (money % 10) / 5);
            var oneCoinsCount = money % 5;

            var setsCount = 0;
            var result = new StringBuilder();

            while (tenCoinsCount >= 0) {
                var tens = "10 ".repeat(tenCoinsCount);
                var fivesCount = fiveCoinsCount;
                var onesCount = oneCoinsCount;

                while (fivesCount >= 0) {
                    var fives = "5 ".repeat(fivesCount);
                    var ones = "1 ".repeat(onesCount);
                    var line = (fivesCount + onesCount + tenCoinsCount) + " " + ones + fives + tens;

                    setsCount++;
                    result.append(line.trim())
                            .append(System.lineSeparator());

                    fivesCount--;
                    onesCount += 5;
                }

                tenCoinsCount--;
                fiveCoinsCount += 2;
            }

            writer.write(setsCount + System.lineSeparator());
            writer.write(result.toString());
        }
    }

}
