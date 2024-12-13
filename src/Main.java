import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in );
        System.out.println("������� ����� �� 1 �� 5");
        int input = scanner.nextInt();

        Random r = new Random();
        if(input == 1)
            greetings();
        else if(input == 2)
            checkSign(r.nextInt(), r.nextInt(), r.nextInt());
        else if(input == 3)
            selectColor();
        else if(input == 4)
            compareNumbers();
        else if(input == 5)
            addOrSubtractAndPrint(r.nextInt(), r.nextInt(), r.nextBoolean());
    }

    public static void greetings() {
        System.out.println("Hello");
        System.out.println("World");
        System.out.println("from");
        System.out.println("Java");
    }

    public static void checkSign(int a, int b, int c) {
        if(a+b+c >= 0)
            System.out.println("����� �������������");
        else
            System.out.println("����� �������������");
    }

    public static void selectColor() {
        int data = 22;

        if (data <= 10)
            System.out.println("�������");
        else if (data > 10 && data < 20)
            System.out.println("������");
        else
            System.out.println("�������");
    }

    public static void compareNumbers() {
        int a = 1;
        int b = 2;

        if (a >= b)
            System.out.println("a >= b");
        else
            System.out.println("a < b");
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        initValue = increment ? initValue + delta : initValue - delta;
        System.out.println(initValue);
    }
}