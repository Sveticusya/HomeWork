package homework;

public class Cat {
    private boolean isFull;
    private String name;
    private int appetite;

    public Cat(int appetite, String name) {
        this.appetite = appetite;
        this.name = name;
        this.isFull = false;
    }

    public void printInfo() {
        System.out.println(name + " " + (isFull ? "сыт" : "голоден"));
    }

    public void eat(Plate plate) {
        if(plate.decreaseFood(appetite))
            isFull = true;
    }
}
