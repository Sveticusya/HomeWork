import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        double[] array = new double[100000000];

        LocalDateTime datetimeStart = LocalDateTime.now();
        for(int i = 0; i < array.length; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }

        LocalDateTime datetimeEnd = LocalDateTime.now();
        System.out.println(ChronoUnit.MILLIS.between(datetimeStart, datetimeEnd));

        double[] arrayThread = new double[100000000];

        datetimeStart = LocalDateTime.now();
        Thread[] threads = new Thread[4];
        for(int i = 0; i < threads.length; i++) {
            ArrayFiller filler = new ArrayFiller(i * arrayThread.length / 4, (i + 1) * arrayThread.length / 4, arrayThread);
            threads[i] = new Thread(filler);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        datetimeEnd = LocalDateTime.now();
        System.out.println(ChronoUnit.MILLIS.between(datetimeStart, datetimeEnd));
    }
}