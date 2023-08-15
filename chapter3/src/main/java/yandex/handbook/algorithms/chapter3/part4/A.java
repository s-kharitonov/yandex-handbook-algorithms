package yandex.handbook.algorithms.chapter3.part4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * <h1>
 *      Ханойские башни
 * </h1>
 * <p>
 *      Головоломка <<Ханойские башни>> состоит из трёх стержней, пронумеруем их слева направо: 1, 2 и 3.
 *      Также в головоломке используется стопка дисков с отверстием посередине. Радиус дисков уменьшается снизу вверх.
 *      Изначально диски расположены на левом стержне (стержень 1), самый большой диск находится внизу.
 *      Диски в игре перемещаются по одному со стержня на стержень.
 *      Диск можно надеть на стержень, только если он пустой или верхний диск на нём большего размера, чем перемещаемый.
 *      Цель головоломки — перенести все диски со стержня 1 на стержень 3.
 *      Требуется найти последовательность ходов, которая решает головоломку <<Ханойские башни>>.
 * </p>
 * <p>
 *      Формат ввода
 * <br/>
 *      В первой строке задано одно число (3 ≤ n ≤ 10) — количество дисков на первой башне.
 * </p>
 * <p>
 *      Формат вывода
 * <br/>
 *      В первой строке выведите количество операций k.
 *      В следующих k строках выведите по два числа в каждой xi, yi (1 <= xi, yi <= 3) — переместить верхний диск
 *      со стержня xi на стержень yi.
 * </p>
 */
public class A {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            var n = Integer.parseInt(reader.readLine());
            List<Operation> operations = new ArrayList<>();

            hanoiTowers(n, 1, 3, operations);

            var operationsResult = operations.stream()
                    .map(Operation::toString)
                    .collect(joining(System.lineSeparator()));

            writer.write(operations.size() + System.lineSeparator());
            writer.write(operationsResult);
        }
    }

    public static void hanoiTowers(int n, int fromPeg, int toPeg, List<Operation> operations) {
        if (n == 1) {
            operations.add(new Operation(fromPeg, toPeg));
            return;
        }

        var unusedPeg = 6 - fromPeg - toPeg;

        hanoiTowers(n - 1, fromPeg, unusedPeg, operations);
        operations.add(new Operation(fromPeg, toPeg));
        hanoiTowers(n - 1, unusedPeg, toPeg, operations);
    }

    public static final class Operation {
        private final int fromPeg;
        private final int toPeg;

        public Operation(int fromPeg, int toPeg) {
            this.fromPeg = fromPeg;
            this.toPeg = toPeg;
        }

        @Override
        public String toString() {
            return fromPeg + " " + toPeg;
        }

    }

}
