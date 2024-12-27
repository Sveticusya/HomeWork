package homework;

import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        Cat[] cats = new Cat[10];
        Plate plate = new Plate(r.nextInt(100));
        for(int i = 0; i < 10; i++)
            cats[i] = new Cat(r.nextInt(10), "Name" + i);

        for(int i = 0; i < 10; i++) {
            cats[i].eat(plate);
            cats[i].printInfo();
        }
    }
}