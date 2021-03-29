package org.totalbeginner.tutorial;

public class Main {
	
	public String titleCaseEdit(String title) {
		return title;
	}

	public static void main(String[] args) {
		Person p1 = new Person("Daniel Targonski");
		Book b1 = new Book("Fire and Blood");
		b1.setAuthor("George R.R. Martin");
		MyLibrary myLib = new MyLibrary("Library of the Seven Hells");
		
		System.out.println("b1 is: " + b1);
		System.out.println("p1 is: " + p1);
		
		b1.setPerson(p1);
		
		System.out.println("b1 is: " + b1);
		
		System.out.println("This library's name is: " + myLib);
		
		Person p2 = new Person("Gandalf the Grey");
		myLib.checkOut(b1, p2);
		myLib.getBooksForPerson(p1);
		myLib.getBooksForPerson(p2);
	} // END MAIN

} // END MAIN CLASS