import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    }

    public static ArrayList<Integer> createArrayFromMinMax(int min, int max) {
        ArrayList<Integer> result = new ArrayList<>();

        if(min > max)
            return result;

        for(int i = min; i <= max; i++)
            result.add(i);

        return result;
    }

    public static int sumAllGreaterThen5(ArrayList<Integer> array) {
        int result = 0;
        for(Integer i : array) {
            if(i > 5)
                result += i;
        }

        return result;
    }

    public static void fillListWithValue(int value, ArrayList<Integer> array) {
        for(int i = 0; i < array.size(); i++) {
            array.set(i, value);
        }
    }

    public static ArrayList<String> getEmployeesNames(ArrayList<Employee> employees) {
        ArrayList<String> result = new ArrayList<>();
        for(Employee employee : employees) {
            result.add(employee.getName());
        }

        return result;
    }

    public static ArrayList<Employee> getEmployeesByAge(int age, ArrayList<Employee> employees) {
        ArrayList<Employee> result = new ArrayList<>();
        for(Employee employee : employees) {
            if(employee.getAge() >= age)
                result.add(employee);
        }

        return result;
    }

    public static boolean checkEmployeesByAverageAge(int averageAge, ArrayList<Employee> employees) {
        if(employees.isEmpty())
            return false;

        int totalAge = 0;
        for(Employee employee : employees) {
            totalAge += employee.getAge();
        }

        return averageAge < totalAge / employees.size();
    }

    public static Employee getYoungestEmployee(ArrayList<Employee> employees) {
        if(employees.isEmpty())
            return null;

        Employee youngestEmployee = employees.get(0);

        for(Employee employee : employees) {
            if(employee.getAge() < youngestEmployee.getAge())
                youngestEmployee = employee;
        }

        return youngestEmployee;
    }
}