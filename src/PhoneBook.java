import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private HashMap<String, String> _phones;

    public PhoneBook() {
        _phones = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        if(_phones.containsKey(phoneNumber))
            return;

        _phones.put(phoneNumber, name);
    }

    public ArrayList<String> find(String name) {
        ArrayList<String> result = new ArrayList<String>();
        for(Map.Entry<String, String> entry : _phones.entrySet()) {
            if(entry.getValue() == name) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public boolean containsPhoneNumber(String phoneNumber) {
        return _phones.containsKey(phoneNumber);
    }
}
