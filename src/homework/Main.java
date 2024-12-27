package homework;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    }

    public static void printString(String string, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(string);
        }
    }

    public static void calculateMoreThen5Sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 5)
                sum += array[i];
        }

        System.out.println(sum);
    }

    public static void fillArray(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    public static void increaseArray(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            array[i] += value;
        }
    }

    public static void compareHalfs(int[] array) {
        int firstHalf = 0;
        int secondHalf = 0;
        for (int i = 0; i < array.length / 2; i++) {
            firstHalf += array[i];
        }

        for (int i = array.length / 2; i < array.length; i++) {
            secondHalf += array[i];
        }

        if (firstHalf > secondHalf)
            System.out.println("Сумма элементов первой половины массива больше");
        else
            System.out.println("Сумма элементов второй половины массива больше");
    }
}