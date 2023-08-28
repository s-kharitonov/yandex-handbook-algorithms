package yandex.handbook.algorithms.chapter4.part3;

import java.io.*;

/**
 * <h1>
 *      Максимальное произведение — контрпример
 * </h1>
 * <p>
 *      Рассмотрим псевдокод поиска двух максимальных элементов массива:
 *      <pre>{@code
 *      MaxPairwiseProduct(A[1..n]):
 *          m1 = A[1]
 *          m2 = A[2]
 *          if m2 > m1:
 *              swap(m1, m2)
 *
 *          for i from 3 to n:
 *              if A[i] > m1:
 *                  m2 = m1
 *                  m1 = A[i]
 *              else:
 *                  if A[i] > m2:
 *                      m2 = A[i]
 *          return m1 * m2
 *      }
 *      </pre>
 *      Определите, можно ли построить такой пример входных данных, чтобы количество сравнений в алгоритме
 *      MaxPairwiseProduct было больше 1.5 n.
 * </p>
 * <p>
 *      Формат ввода
 * <br/>
 *      Целое число n. Ограничения 2 <= n <= 200_000
 * </p>
 * <p>
 *      Формат вывода
 * <br/>
 *      В единственной строке выведите No, если подходящих входных данных не существует.
 *      Иначе в первой строке выведите Yes, а во второй строке n чисел a1, a2, ..., an(0 <= ai <= 200_000)
 *      - найденный контрпример.
 * </p>
 */
public class B {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            var n = Integer.parseInt(reader.readLine());

            if (n < 7) {
                writer.write("No");
                return;
            }

            var result = new StringBuilder(String.valueOf(n));

            for (int i = 1; i < n; i++) {
                result.append(" ");
                result.append(i);
            }

            writer.write("Yes" + System.lineSeparator());
            writer.write(result.toString());
        }
    }

}
