package com.knoldus.kup;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PhoneBook {

     Map<String, String> phoneMap = new HashMap<>();

    public PhoneBook() {
        phoneMap.put("Shivam","8960475145");
        phoneMap.put("Rohan","1234567891");
    }

    public Map<String, String> getPhoneMap() {
        return phoneMap;
    }

    public void setPhoneMap(Map<String, String> phoneMap) {
        this.phoneMap = phoneMap;
    }

    public Optional<String> findPhoneNumberByName(String name){
        if(phoneMap.containsKey(name)){
            return Optional.of(phoneMap.get(name)) ;
        }
        return Optional.empty();
    }

    public Optional<String> findNameByPhoneNumber(String phoneNumber) {
        for (Map.Entry<String, String> entry : phoneMap.entrySet()) {
            if (entry.getValue() == phoneNumber) {
                return Optional.of(entry.getKey());
            }
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return "PhoneBook{ PhoneBook = "+phoneMap+"}";
    }
}
