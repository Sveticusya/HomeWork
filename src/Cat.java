public class Cat extends Animal {
    public Cat(String name, int swimSpeed, int runSpeed, int stamina) {
        super(name, 0, runSpeed, stamina, 0);
    }

    @Override
    public int swim(int distance)
    {
        return -1;
    }
}
