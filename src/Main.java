import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    }

    public static int sumOfPositiveElements(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0)
                    sum = sum + array[i][j];
            }

        return sum;
    }

    public static void printStars(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void zeroDiagonal(int[][] array) {
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++)
                if (i == j) {
                    array[i][j] = 0;
                }
    }

    public static int findMax(int[][] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++)
                if(array[i][j] > max) {
                    max = array[i][j];
                }

        return max;
    }

    public static int getSumSecondLine(int[][] array) {
        if(array.length < 2)
            return -1;

        int sum = 0;
        for (int j = 0; j < array[1].length; j++)
            sum = sum + array[1][j];

        return sum;
    }
}