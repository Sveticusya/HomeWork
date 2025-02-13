import java.util.HashMap;

public class PersonDataBase {

    private HashMap<Long, Person> _persons;

    public PersonDataBase() {
        _persons = new HashMap<Long, Person>();
    }

    public void add(Person person) {
        _persons.put(person.id, person);
    }

    public Person findById(Long id) {
        return _persons.get(id);
    }

    public boolean isManager(Person person) {
        if(person == null)
            return false;

        return person.position == Position.MANAGER || person.position == Position.DIRECTOR
        || person.position == Position.BRANCH_DIRECTOR || person.position == Position.SENIOR_MANAGER;
    }

    public  boolean isEmployee(Long id) {
        Person person = findById(id);
        if(person == null)
            return false;

        return !isManager(person);
    }
}
