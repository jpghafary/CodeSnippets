package com.codinggame.optional;

import java.util.Arrays;
import java.util.stream.Stream;

public class PhoneBookCrawler {

	private PhoneBook phoneBook;

    public PhoneBookCrawler(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }
    

    public String findPhoneNumberByNameAndPunishIfNothingFound(String name){
        return phoneBook.findNameByPhoneNumber(name).orElseThrow();
    }

    public String findPhoneNumberByNameAndPrintPhoneBookIfNothingFound(String name){
        return null;
    }

    public String findPhoneNumberByNameOrNameByPhoneNumber(String name, String phoneNumber){
        return null;
    }

    public PhoneBook getPhoneBook(){
        return phoneBook;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
