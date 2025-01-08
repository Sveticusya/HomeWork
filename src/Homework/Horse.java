package Homework;

public class Horse implements Transport {
    private static final int DEFAULT_STAMINA_USAGE = 1;
    private int moveStaminaUsage = DEFAULT_STAMINA_USAGE;
    private int stamina;

    @Override
    public boolean move(int distance, Terrain terrain) {
        if(stamina <= 0) {
            System.out.println("У лошади нет сил для передвижения");
            return false;
        }

        if(terrain == Terrain.SWAMP){
            System.out.println("Лошадь не может двигаться по местности");
            return false;
        }

        if(stamina - distance * moveStaminaUsage < 0) {
            System.out.println("Лошади не хватит сил для передвижения");
            return false;
        }

        stamina -= distance * moveStaminaUsage;
        System.out.println("Успешно прокатились на лошади");
        return true;
    }
}
