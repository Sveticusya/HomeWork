package homework;

public class Box {
    private int height;
    private int width;
    private int length;
    private String item;

    private String color;

    private boolean isOpened;

    public Box(int height, int width, int length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public void open() {
        System.out.println("Открыть");
        isOpened = true;
    }

    public void close() {
        System.out.println("Закрыть");
        isOpened = false;
    }

    public void printInfo() {
        System.out.println("ШхДхВ: " + width + " " + length + " " + height);
        System.out.println("Цвет: " + color);
        System.out.println("Предмет: " + color);
    }

    public void putItem(String item) {
        System.out.println("Положить предмет: " + item);
        if(!isOpened || item.isEmpty()) {
            System.out.println("Не удалось положить предмет");
            return;
        }

        this.item = item;
    }

    public void removeItem() {
        System.out.println("Удалить предмет");
        if(!isOpened) {
            System.out.println("Не удалось удалить предмет");
            return;
        }
        System.out.println("Предмет:" + item + " удален");
        item = "";
    }
}
