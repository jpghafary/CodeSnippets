package com.codinggame.optional;

import java.util.HashMap;
import java.util.Optional;

public class PhoneBook {
	
	 private static final HashMap<String, String> PHONE_NUMBERS = new HashMap<String, String>() {
	        {
	            put("Jos de Vos", "016/161616");
	            put("An de Toekan", "016/161617");
	            put("Kris de Vis", "016/161618");
	        }
	    };

	    private HashMap<String, String> phoneBookEntries = PHONE_NUMBERS;

	    PhoneBook() { }

	    public HashMap<String, String> getPhoneBookEntries() {
	        return phoneBookEntries;
	    }

	    public Optional<String> findPhoneNumberByName(String name){
	    	return getPhoneBookEntries().keySet().stream()
	    		.filter( key -> key.equals(name) )
	    		.findFirst();
	    }

	    public Optional<String> findNameByPhoneNumber(String phoneNumber){
	        return getPhoneBookEntries().values().stream()
	        		.filter(value -> value.equals(phoneNumber))
	        		.findFirst();
	    }
	    
	    

	    @Override
	    public String toString() {
	        System.out.println("Hello from PhoneBook's toString method");
	        return "PhoneBook{" +
	                "phoneBookEntries=" + phoneBookEntries +
	                '}';
	    }
	    
	    public static void main(String ...args) {
	    	PhoneBook phoneBook = new PhoneBook();
	    	Optional<String> phoneNumber = Optional.empty();
	    	
	    	phoneNumber = phoneBook.findPhoneNumberByName("Jos de Vos");
	    	System.out.println(phoneNumber.isEmpty() ? "No Result" : phoneNumber.get());
	    	
	    	phoneNumber = phoneBook.findPhoneNumberByName("Jos de Voss");
	    	System.out.println(phoneNumber.isEmpty() ? "No Result" : phoneNumber.get());
	    	
	    	phoneNumber = phoneBook.findNameByPhoneNumber("016/161616");
	    	System.out.println(phoneNumber.isEmpty() ? "No Result" : phoneNumber.get());
	    	
	    	phoneNumber = phoneBook.findPhoneNumberByName("016/161619");
	    	System.out.println(phoneNumber.isEmpty() ? "No Result" : phoneNumber.get());
	    }
}
