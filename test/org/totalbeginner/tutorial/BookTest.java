package org.totalbeginner.tutorial;

import junit.framework.TestCase;

public class BookTest extends TestCase {
	
	public void testbook() {
		Book b1 = new Book("Great Expectations");
		assertEquals("Great Expectations", b1.title);
		assertEquals("unknown author", b1.author);
		//assertEquals(b1.getPerson().getName(), "unknown person");
	}
	
	public void testGetPerson() {
		Book b2 = new Book("War And Peace");	
		Person p2 = new Person();
		p2.setName("Elvis");
		
		// method to say book is loaned to this person
		b2.setPerson(p2);
		
		// get the name of the person who has the book
//		Person testPerson = b2.getPerson();
//		String testName = testPerson.getName();
		// this one line of code is doing what the above 2 are doing
		String testName = b2.getPerson().getName();
		
		assertEquals("Elvis", testName);
	}
	
	public void testToString() {
		Book b1 = new Book("Fire and Blood");
		Person p1 = new Person("GRRM");
		b1.setPerson(p1);
		String expBookOutput = "Fire and Blood";
		
		assertEquals("Fire and Blood", b1.getTitle());
		assertEquals("unknown author", b1.getAuthor());
		assertEquals("GRRM", b1.getPerson().getName());
		assertEquals(expBookOutput, b1.toString());
		
	}
	
}
