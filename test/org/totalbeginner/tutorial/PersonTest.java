package org.totalbeginner.tutorial;

import junit.framework.TestCase;

public class PersonTest extends TestCase {

	public void testPerson() {
		Person p1 = new Person();
		// assertEquals is a STATIC method which means
		// it doesn't depend on an object to be executed
		// static methods are italicized.
		assertEquals("unknown name", p1.getName());
		assertEquals(3, p1.getMaximumBooks());
		
		// now test the constructor when passing a string during instantiation
		Person p2 = new Person("Bob");
		assertEquals("Bob", p2.getName());
		assertEquals(3, p2.getMaximumBooks());
	}

	public void testSetName() {
		Person p1 = new Person();
		String aName = "bob";
		p1.setName(aName);
		assertEquals(aName, p1.getName());
	}

	public void testSetMaximumBooks() {
		Person p1 = new Person();
		p1.setMaximumBooks(50);
		assertEquals(50, p1.getMaximumBooks());
	}
	
	public void testToString() {
		Person p4 = new Person();
		p4.setName("Fred Flintstone");
		p4.setMaximumBooks(7);
		String testString = "Fred Flintstone (7 books)";
		assertEquals(testString, p4.toString());
	}
	
}