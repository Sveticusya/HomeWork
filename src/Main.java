import HomeWork.AppArrayDataException;
import HomeWork.AppArraySizeException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String [][] array = new String[4][4];
        try {
            System.out.println("Сумма элементов массива: " + sumElements(array));
        }
        catch (AppArraySizeException | AppArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int sumElements(String[][] array) {
        if (array.length != 4 && array[0].length != 4) {
            throw new AppArraySizeException();
        }

        int sum = 0;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException(i, j, array[i][j]);
                }
            }

        return sum;
    }
}