public class Cat extends Animal {
    public Cat(String name, int swimSpeed, int runSpeed, int stamina) {
        super(name, swimSpeed, runSpeed, stamina);
    }

    @Override
    public int swim(int distance)
    {
        return -1;
    }
}
