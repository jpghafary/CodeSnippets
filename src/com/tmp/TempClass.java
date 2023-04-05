package com.tmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TempClass {

	public static void main(String ...args) {
		TempClass temp = new TempClass();
		List<Point> points = temp.createPoints();

		//print list of points
		int sum = points.stream().mapToInt(Point::getX).sum();
		System.out.println("sum = " + sum);

		//list of points with positive x
		System.out.println("No Dist");
		points.stream().filter(p -> p.getX() > 0).forEach(System.out::println);
		//distinct
		System.out.println("With Dist");
		points.stream().filter(p -> p.getX() > 0).distinct().forEach(System.out::println);
		//Add a new point
		System.out.println("new Point each time x=2");
		List<Point> newPoints = Stream.concat(points.stream(), points.stream().filter(p -> p.getX() == 2).map(p -> new Point(100, 100))).collect(Collectors.toList());
		newPoints.forEach(System.out::println);
		//List containing only positive x
		List<Point> pointsPositiveX = points.stream().filter(p -> p.getX() > 0).collect(Collectors.toCollection(ArrayList::new));
		System.out.println("Positive Only");
		pointsPositiveX.forEach(System.out::println);
		//Comma separated string
		String str = points.stream().map(Function.identity()).map(Point::toString).collect(Collectors.joining(","));
		System.out.println("" + str);

		String[] names = {"william", "jones", "aaron", "seppe", "frank", "gilliam"};
		//		String[] names = {"aaron"};
		double total = Arrays.stream(names)
				.filter(name -> name.length() > 5)
				.mapToInt(name -> name.length())
				.sum();
		System.out.println("total = " + total);

		List<List<String>> collection = Arrays.asList(Arrays.asList("Viktor", "Farcic"), Arrays.asList("John", "Doe", "Third"));
		collection.stream().flatMap(word -> word.stream()).collect(Collectors.toList());

		Person sara = new Person("Sara", 4);
	    Person viktor = new Person("Viktor", 40);
	    Person eva = new Person("Eva", 42);
	    List<Person> persons = Arrays.asList(sara, eva, viktor);
//	    Person p = persons.stream().sorted(Comparator.comparingInt(Person::getAge).reversed()).limit(1).collect(Collectors.)
	    
	}

	private List<Point> createPoints() {
		List<Point> result = new ArrayList<Point>();
		Point p = new Point(2, 3);
		result.add(new Point(-4, -8));
		result.add(new Point(-2, 9));
		result.add(new Point(-1, -8));
		result.add(new Point(0, -7));
		result.add(new Point(1, 1));
		result.add(p);
		result.add(new Point(2, -2));
		result.add(p);
		result.add(new Point(4, -1));

		return result;
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

class Point{
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(x: "+x+", y: "+y+")";
	}

	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}
