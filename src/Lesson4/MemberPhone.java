package Lesson4;

import java.util.HashMap;

public class MemberPhone {
    private HashMap<String, String> hashPhone = new HashMap<>();

    public void add(String key, String value) {
        hashPhone.put(key, value);
    }

    public String getMemberPhone(String name){
        if(hashPhone.containsValue(name)){
            String result = "Phone numbers: ";
            for(String key: hashPhone.keySet()){
                if(hashPhone.get(key).equals(name)) result += key + "; ";
            }
            return result;
        } else return "Can't find";

    }
}
