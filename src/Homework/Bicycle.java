package Homework;

public class Bicycle implements Transport {
    @Override
    public boolean move(int distance, Terrain terrain) {
        if(terrain == Terrain.SWAMP){
            System.out.println("Велосипед не может двигаться по местности");
            return false;
        }

        System.out.println("Успешно прокатились на велосипеде");
        return true;
    }
}
