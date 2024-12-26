public class Plate {
    int volume;
    int availableFood;

    public Plate(int volume) {
        this.volume = volume;
        this.availableFood = volume;
    }

    public void AddFood(int food) {
        availableFood += food;
        if(availableFood > volume)
            availableFood = volume;
    }

    public boolean Eat(int food) {
        if(availableFood - food < 0) {
            return false;
        }

        availableFood -= food;
        return true;
    }
}
