public class Cat {
    boolean isFull;
    String name;
    int appetite;

    public Cat(int appetite, String name) {
        this.appetite = appetite;
        this.name = name;
        this.isFull = false;
    }

    public int GetAppetite() {
        return appetite;
    }

    public void SetFull() {
        isFull = true;
    }

    public void PrintInfo() {
        System.out.println(name + " " + (isFull ? "сыт" : "голоден"));
    }
}
