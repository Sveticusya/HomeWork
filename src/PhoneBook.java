import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private HashMap<String, String> phones;

    public PhoneBook() {
        phones = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        if(phones.containsKey(phoneNumber))
            return;

        phones.put(phoneNumber, name);
    }

    public ArrayList<String> find(String name) {
        ArrayList<String> result = new ArrayList<String>();
        for(Map.Entry<String, String> entry : phones.entrySet()) {
            if(entry.getValue().equals(name)) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public boolean containsPhoneNumber(String phoneNumber) {
        return phones.containsKey(phoneNumber);
    }
}
