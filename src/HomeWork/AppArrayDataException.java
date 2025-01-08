package HomeWork;

public class AppArrayDataException extends RuntimeException {
    public  AppArrayDataException(int i, int j, String value) {
        super("Некорректное значение: " + value + " в ячейке с индексом (" + i + "," + j +")");
    }
}
