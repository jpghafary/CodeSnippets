package com.codinggame;

import java.util.*;
import java.util.stream.Collectors;

public class StreamJava8 {

	public static void main(String[] args) {
		getLetterCount();
		flattenCollection();
		getOldestPerson();
		sumAllElementsUsingReduce();
		namesOfPersonsUnder18();
		partitionAdultsAndKids();
		groupByNationality();
		commaSeparatedString();
		challenge();
	}

	private static void getLetterCount() {
		System.out.println("# getLetterCount");
		String[] names = {"william", "jones", "aaron", "seppe", "frank", "gilliam"};

		double total = Arrays.stream(names)
				.filter(name -> name.length() > 5)
				.mapToInt(String::length)
				.sum();
		//should be 14
		System.out.println("total = " + total);

	}

	private static void flattenCollection() {
		System.out.println("# flattenCollection");
		List<List<String>> collection = Arrays.asList(Arrays.asList("Viktor", "Farcic"), Arrays.asList("John", "Doe", "Third"));
		List<String> flatCollection = collection.stream().flatMap(Collection::stream).collect(Collectors.toList());
		flatCollection.forEach(System.out::println);
	}

	public static void getOldestPerson() {
		System.out.println("# getOldestPerson");
		Person sara = new Person("Sara", 4);
	    Person viktor = new Person("Viktor", 40);
	    Person eva = new Person("Eva", 42);
	    List<Person> collection = Arrays.asList(sara, eva, viktor);
	    Person oldestPerson = collection.stream().max(Comparator.comparing(Person::getAge)).get();
	    System.out.println(oldestPerson.getName());
	}
	
	public static void sumAllElementsUsingReduce() {
		System.out.println("# sumAllElementsUsingReduce");
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		int total = numbers.stream().reduce(0, Integer::sum);
		System.out.println("total = " + total);
	}

	public static void namesOfPersonsUnder18() {
		System.out.println("# namesOfPersonsUnder18");
		Person sara = new Person("Sara", 4);
	    Person viktor = new Person("Viktor", 40);
	    Person eva = new Person("Eva", 42);
	    Person anna = new Person("Anna", 5);
	    List<Person> collection = Arrays.asList(sara, eva, viktor, anna);
	    Set<String> names = collection.stream().filter(p -> p.getAge() < 18).map(Person::getName).collect(Collectors.toSet());
	    names.forEach(System.out::println);
	}
	
	public static void partitionAdultsAndKids() {
		System.out.println("# partitionAdultsAndKids");
		Person sara = new Person("Sara", 4);
	    Person viktor = new Person("Viktor", 40);
	    Person eva = new Person("Eva", 42);
	    List<Person> collection = Arrays.asList(sara, eva, viktor);
	    
	    Map<Boolean, List<Person>> map = collection.stream().collect(Collectors.partitioningBy(p -> p.getAge() >=18));
	    map.forEach((key, value) -> {
	    	System.out.print("key = " + key);
	    	System.out.println(" value = " + value.stream().map(Person::getName).collect(Collectors.joining(",")));
	    });
	}

	public static void groupByNationality() {
		System.out.println("# group by nationality");
		Person sara = new Person("Sara", 4, "Norwegian");
	    Person viktor = new Person("Viktor", 40, "Serbian");
	    Person eva = new Person("Eva", 42, "Norwegian");
	    List<Person> collection = Arrays.asList(sara, eva, viktor);
	    
	    Map<String, List<Person>> map = collection.stream().collect(Collectors.groupingBy(Person::getNationality));
	    map.forEach((key, value) -> {
	    	System.out.print("key = " + key);
	    	System.out.println(" value = " + value.stream().map(Person::getName).collect(Collectors.joining(",")));
	    });
	}
	
	public static void commaSeparatedString() {
		Person sara = new Person("Sara", 4);
	    Person viktor = new Person("Viktor", 40);
	    Person eva = new Person("Eva", 42);
	    List<Person> collection = Arrays.asList(sara, viktor, eva);
	    
	    String result = collection.stream().map(Person::getName).collect(Collectors.joining(", ", "Names: ", "."));
	    System.out.println(result);
	}
	
	/**Write a method that returns a comma separated string based on a given list of integers. 
	 * Each element should be preceded by the letter 'e' if the number is even, 
	 * and preceded by the letter 'o' if the number is odd.
	 * For example, if the input list is (3,44), the output should be 'o3,e44'.
	 * 
	 * Using 1 Operator and 1 Collect
	 */
	public static void challenge() {
		System.out.println("# challenge");
		List<Integer> list = Arrays.asList(3, 44);
		String result = list.stream().map(n -> (n%2 == 0 ? "e" : "o") + n).collect(Collectors.joining(","));
		System.out.println(result);
	}
}

class Person {
	private String name;
	private int age;
	private String nationality;

	public Person(String name, int age, String nationality) {
		this.name = name;
		this.age = age;
		this.nationality = nationality;
	}

	public Person(String name, int age) {
		this(name, age, "");
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getNationality() {
		return nationality;
	}
}
