import java.util.ArrayList;

public class Box<T extends Fruit> {
    protected ArrayList<T> fruits;

    Box() {
        fruits = new ArrayList<>();
    }

    public int weight() {
        int weight = 0;

        for (T fruit : fruits)
            weight += fruit.getWeight();

        return weight;
    }

    public boolean compare(Box box) {
        return this.weight() == box.weight();
    }

    public void put(T fruit) {
        fruits.add(fruit);
    }

    public boolean sprinkleFruits(Box box) {
        fruits.addAll(box.fruits);
        return true;
    }
}
