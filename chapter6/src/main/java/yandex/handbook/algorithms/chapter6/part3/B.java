package yandex.handbook.algorithms.chapter6.part3;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <h1>
 * Реклама на билбордах
 * </h1>
 * <p>
 * Рассмотрим задачу менеджера рекламного агентства.
 * <p>
 * Есть n билбордов, на которых можно размещать рекламные объявления. Планирование размещения проводится на w недель
 * вперед. Модель размещения рекламы разрешает сохранить одно и тоже объявление несколько недель на одном билборде,
 * перенести объявление на следующей неделе на другой билборд. Размещать одно объявление на разных, не обязательно
 * последовательных, неделях будущего периода. Однако на одной неделе не может быть рекламных объявлений от одного
 * рекламодателя на разных билбордах.
 * <p>
 * k рекламодателей хотят разместить рекламу. Заявки подают рекламодатели в формате аукциона, но не знают заявок
 * конкурентов. Известно, что i-й рекламодатель подал заявку на размещение своей рекламы максимум на wi недель с оплатой
 * ci за каждую неделю размещения, т.е. рекламное объявление i-го рекламодателя может быть размещено от 0 до wi в
 * течение периода (при размещении рекламы в течение m недель оплата за нее составит m * ci).
 * <p>
 * Менеджеру нужно выбрать, в какие недели и на каких билбордах разместить рекламу рекламодателей.
 * <p>
 * Требуется максимизировать прибыль от размещения рекламы.
 * <p>
 * Формат ввода
 * <p>
 * Первая строка содержит три разделённых пробелами числа n,k и w (1 <= n <= 10^3, 1 <= k <= 10^5, 1 <= w <= 10^2).
 * Далее каждая из k строк содержит по два разделённых пробелом числа - ci и wi (1 <= ci <= 10^2, 1 <= wi <= w).
 * </p>
 * <p>
 * Формат вывода
 * <p>
 * Вывод должен состоять из одного значения величины max_profit - ответ на задачу.
 * </p>
 */
public class B {

    private static final String INPUT_FILE_PATH = "input.txt";

    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            var conditions = reader.readLine().split(" ");
            var billboardsCount = Integer.parseInt(conditions[0]);
            var advertisersCount = Integer.parseInt(conditions[1]);
            var weeksCount = Integer.parseInt(conditions[2]);
            Queue<Booking> bookings = new PriorityQueue<>(advertisersCount);

            for (var i = 0; i < advertisersCount; i++) {
                var priceByWeekWithWeeksCount = reader.readLine()
                        .split(" ");
                var priceByWeek = Integer.parseInt(priceByWeekWithWeeksCount[0]);
                var bookingWeeksCount = Integer.parseInt(priceByWeekWithWeeksCount[1]);

                bookings.add(new Booking(bookingWeeksCount, priceByWeek));
            }

            var maxProfit = calculateMaxProfit(billboardsCount, weeksCount, bookings);

            writer.write(String.valueOf(maxProfit));
        }
    }

    public static int calculateMaxProfit(int billboardsCount, int weeksCount, Queue<Booking> bookings) {
        var placesToBook = billboardsCount * weeksCount;
        var maxProfit = 0;

        while (!bookings.isEmpty() && placesToBook > 0) {
            var booking = bookings.poll();
            var bookingWeeksCount = Math.min(booking.weeksCount, placesToBook);
            var bookingAmount = booking.priceByWeek * bookingWeeksCount;

            maxProfit += bookingAmount;
            placesToBook -= bookingWeeksCount;
        }

        return maxProfit;
    }

    public static final class Booking implements Comparable<Booking> {

        private final int weeksCount;

        private final int priceByWeek;

        public Booking(int weeksCount, int priceByWeek) {
            this.weeksCount = weeksCount;
            this.priceByWeek = priceByWeek;
        }

        @Override
        public int compareTo(Booking o) {
            return Integer.compare(o.priceByWeek, this.priceByWeek);
        }

    }

}
