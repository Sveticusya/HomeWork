package Homework;

public class AllTerrainVehicle extends Car {

    public AllTerrainVehicle(int gasolineVolume, int gasolineUsage) {
        super(gasolineVolume, gasolineUsage);
    }

    @Override
    protected boolean canMoveByTerrain(Terrain terrain) {
        return true;
    }

    @Override
    protected void printSuccessfulResult() {
        System.out.println("Успешно прокатились на вездеходе");
    }
}
