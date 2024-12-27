package homework;

public class Plate {
    private int volume;
    private int availableFood;

    public Plate(int volume) {
        this.volume = volume;
        this.availableFood = volume;
    }

    public void addFood(int food) {
        availableFood += food;
        if(availableFood > volume)
            availableFood = volume;
    }

    public boolean decreaseFood(int food) {
        if(availableFood - food < 0) {
            return false;
        }

        availableFood -= food;
        return true;
    }
}
