package com.jeff.skillstorm.OOP;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * JavaDoc Comment = /**
 * Fully qualified class name:
 * com.jeff.skillstorm.OOP.HelloWorld
 * 
 * @author jeffrey phillips
 *
 */
public class HelloWorld {
	private static final int CONSTANT_VAR = 123;

	public static void main(String[] args) {
		/*
		lol == lol2 won't work because new String(arg) doesn't put arg in string pool
		
		String lol = new String("lol");
		String lol2 = "lol";
		
		System.out.println(lol.equals(lol2));*/
		
		// Covariant
		Animal a = new Dog();
		
		// Virtual Method Invocation
		// (only works for non-static in Java, if Animal had static speak it would call Animal.speak)
		a.speak();

		// casting
		Dog b = new Dog();
		Animal c = (Animal)b;
		// if Animal had an implemented speak function calling c.speak would
		// still call Dog.speak NOT Animal.speak
		
		int[] array = new int[5];
		for (int x : array) { //for each loop in java
			System.out.println("x: " + x);
		}		
		// For objects (like Lists) can use Iterator instead of for (type x : collection) {}
		// but for each is easy short hand

		
		int x = 0;
		switch (x) {
			default: //default not executed first. The more you know.
				System.out.println("o ok");
			case 0:
				System.out.println(x);
				break;
			case 1:
				System.out.println("!x");
				break;
		}
		
		try {
			exceptions(); //can't do this without try-catch since this method isn't declared as throws
		}
		catch (ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e) { //multi-catch
			//something
		}
		catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		/*catch (ArithmeticException ae) { //<--dead code since generic exception catch is first
			//something 
		}*/
		finally {
			System.out.println("finally block");
		}
		System.out.println("out of try-catch-finally");
		
		
		
		Book d = new Book();
		d.read();
		try {
			d.close(); //not automatically called
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try (Book book = new Book()) { //same as using in C#, called "try-with-resources"
			book.read();
			//book.close automatically called in a (basically) generated finally block
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		//throw new CustomException("lol"); // dont need to have throws declaration for run time exceptions
		
		if (a instanceof Dog) // same as "is a" in C#
		{
			//stuff
		}

		Calendar lol = Calendar.getInstance();
		lol.clear();
		//lol.set(Calendar.DAY_OF_MONTH, 5);
		//lol.set(Calendar.MONTH, 8);
		//lol.set(Calendar.YEAR, 2015);
		lol.set(2004, 2, 29);
		
		System.out.println(lol.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG_FORMAT, Locale.getDefault()).toUpperCase());
		
		System.out.println(lol.get(Calendar.DAY_OF_WEEK));
	}
	
	public static void exceptions() throws Exception { //needed for method that throws a checked exception
		throw new SQLException("lol u fucked up");
	}
}



class Book implements AutoCloseable { //AutoCloseable prty much Java version of IDisposable

	public void read() {
		System.out.println("Reading book");
	}
	
	@Override
	public void close() throws Exception { //called automatically when using try-with-resource
		System.out.println("Closing book");
	}
}