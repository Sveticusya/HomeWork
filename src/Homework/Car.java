package Homework;

public class Car implements Transport {
    protected int gasolineVolume;
    protected int gasolineUsage;

    public Car(int gasolineVolume, int gasolineUsage) {
        this.gasolineVolume = gasolineVolume;
        this.gasolineUsage = gasolineUsage;
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (gasolineVolume <= 0) {
            System.out.println("Транспорт не может двигаться, так как нет бензина");
            return false;
        }

        if (!canMoveByTerrain(terrain)) {
            System.out.println("Транспорт не может двигаться по местности");
            return false;
        }

        if (gasolineVolume - distance * gasolineUsage < 0) {
            System.out.println("Транспорту не достаточно бензина для перемещения");
            return false;
        }

        printSuccessfulResult();
        gasolineVolume -= distance * gasolineUsage;
        return true;
    }

    protected boolean canMoveByTerrain(Terrain terrain) {
        return terrain != Terrain.SWAMP && terrain != Terrain.DENSE_FOREST;
    }

    protected void printSuccessfulResult() {
        System.out.println("Успешно прокатились на машине");
    }
}
