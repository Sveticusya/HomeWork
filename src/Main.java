import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[3];
        char[] chars = new char[] {'A', 'B', 'C'};
        CommonResource sync = new CommonResource();

        for(int i = 0; i < threads.length; i++) {
            LetterPrinter printer = new LetterPrinter(chars[i], sync);
            threads[i] = new Thread(printer);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}