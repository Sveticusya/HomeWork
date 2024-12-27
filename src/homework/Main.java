package homework;

import java.time.Year;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User[] users = new User[10];
        for(int i=0; i < 10; i++) {
            users[i].firstName = "firstName" + i;
            users[i].lastName = "lastName" + i;
            users[i].sureName = "sureName" + i;
            users[i].yearOfBirth = getRandom(1980, 2020);
            users[i].email = "email" + i;
        }

        for(int i=0; i < users.length; i++) {
            if(Year.now().getValue() - users[i].yearOfBirth > 40)
                users[i].printUserInfo();
        }
    }

    public static int getRandom(int min, int max) {
        return (int) (min + Math.random() * (max + 1 - min));
    }
}