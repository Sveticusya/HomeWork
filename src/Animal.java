public class Animal {
    private static final int DEFAULT_RUN_STAMINA_USAGE = 1;

    String name;
    int swimSpeed;
    int runSpeed;
    int stamina;
    boolean isTired;

    protected int runStaminaUsage;
    protected int swimStaminaUsage;

    public Animal(String name, int swimSpeed, int runSpeed, int stamina,
                  int swimStaminaUsage) {
        this.name = name;
        this.swimSpeed = swimSpeed;
        this.runSpeed = runSpeed;
        this.stamina = stamina;
        this.swimStaminaUsage = swimStaminaUsage;
        isTired = false;
        runStaminaUsage = DEFAULT_RUN_STAMINA_USAGE;
    }

    public int run(int distance) {
        if (runSpeed == 0) {
            System.out.println(name + " не может бежать: скорость бега равна 0.");
            return -1;
        }

        int time = distance / runSpeed;
        if (stamina - time * runStaminaUsage < 0) {
            isTired = true;
            return -1;
        }

        stamina = stamina - time * runStaminaUsage;

        return time;
    }

    public int swim(int distance) {
        int time = distance / swimSpeed;
        if (stamina - time * swimStaminaUsage < 0) {
            isTired = true;
            return -1;
        }

        stamina = stamina - time * swimStaminaUsage;

        return time;
    }

    public void info() {
        System.out.println("Имя: " + name);
        System.out.println("Скорость бега: " + runSpeed);
        System.out.println("Скорость плавания: " + swimSpeed);
        if (isTired)
            System.out.println("Животное устало");
        else
            System.out.println("Выносливость: " + stamina);
    }
}
