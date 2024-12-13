import java.util.Date;

public class User {
    String firstName;
    String lastName;
    String sureName;
    int yearOfBirth;
    String email;

    public User(String firstName, String lastName,
    String sureName, int yearOfBirth, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sureName = sureName;
        this.yearOfBirth = yearOfBirth;
        this.email = email;
    }

    public void printUserInfo() {
        System.out.println("ФИО: " + lastName + " " + firstName + " " + sureName);
        System.out.println("Год рождения: " + yearOfBirth);
        System.out.println("e-mail: " + email);
    }
}
