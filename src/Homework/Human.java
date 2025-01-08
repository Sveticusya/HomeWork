package Homework;

public class Human {
    private String name;
    private Transport currentTransport;

    public Human(String name) {
        this.name = name;
    }

    public void setCurrentTransport(Transport currentTransport) {
        this.currentTransport = currentTransport;
    }

    public void leaveCurrentTransport() {
        currentTransport = null;
    }

    public boolean move(int distance, Terrain terrain) {
        if(currentTransport == null) {
            System.out.println("Человек прошелся пешком");
            return true;
        }

        return currentTransport.move(distance, terrain);
    }
}
