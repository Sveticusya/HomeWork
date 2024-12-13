public class Box {
    private int height;
    private int width;
    private int length;
    private String item;

    String color;

    private boolean isOpened;

    public Box(int height, int width, int length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public void Open() {
        System.out.println("Открыть");
        isOpened = true;
    }

    public void Close() {
        System.out.println("Закрыть");
        isOpened = false;
    }

    public void PrintInfo() {
        System.out.println("ШхДхВ: " + width + " " + length + " " + height);
        System.out.println("Цвет: " + color);
        System.out.println("Предмет: " + color);
    }

    public void PutItem(String item) {
        System.out.println("Положить предмет");
        if(!isOpened || !item.isEmpty())
            return;

        this.item = item;
    }

    public void RemoveItem() {
        System.out.println("Удалить предмет");
        if(!isOpened)
            return;

        item = "";
    }
}
