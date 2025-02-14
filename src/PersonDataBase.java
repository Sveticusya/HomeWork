import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PersonDataBase {

    private HashMap<Long, Person> persons;
    private HashSet<Position> managerPositions = new HashSet<>(Arrays.asList(Position.MANAGER, Position.DIRECTOR,
            Position.BRANCH_DIRECTOR , Position.SENIOR_MANAGER));

    public PersonDataBase() {
        persons = new HashMap<Long, Person>();
    }

    public void add(Person person) {
        persons.put(person.id, person);
    }

    public Person findById(Long id) {
        return persons.get(id);
    }

    public boolean isManager(Person person) {
        if(person == null)
            return false;

        return managerPositions.contains(person.position);
    }

    public  boolean isEmployee(Long id) {
        Person person = findById(id);
        if(person == null)
            return false;

        return !isManager(person);
    }
}
