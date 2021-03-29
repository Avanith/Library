package org.totalbeginner.tutorial;

import java.util.ArrayList;

import junit.framework.TestCase;

public class MyLibraryTest extends TestCase {
	private Book b1;
	private Book b2;
	private Person p1;
	private Person p2;
	private MyLibrary ml;
	
	public void testMyLibrary() {
		// test constructor
		MyLibrary ml = new MyLibrary("Test");
		
		assertEquals("Test", ml.name);
		// instanceof returns true if 'a' is of type 'b'
		assertTrue(ml.books instanceof ArrayList);
		assertTrue(ml.people instanceof ArrayList);
	}
	public void setup() {
		b1 = new Book("Book1");
		b2 = new Book("Book2");
		
		p1 = new Person("Fred");
		p2 = new Person("Sue");
		
		ml = new MyLibrary("Test");
	}
	public void testAddBook() {
		// create test objects
		setup();
		// test initial size is 0
		assertEquals(0, ml.getBooks().size());
		
		ml.addBook(b1);
		ml.addBook(b2);
		
		assertEquals(2, ml.getBooks().size());
		assertEquals(0, ml.getBooks().indexOf(b1));
		assertEquals(1, ml.getBooks().indexOf(b2));
		
		ml.removeBook(b1);
		// size should now be 1, because we removed 1 of the books
		assertEquals(1, ml.getBooks().size());
		// index of b2 should've changed to zero
		assertEquals(0, ml.getBooks().indexOf(b2));
		
		ml.removeBook(b2); // remove last book
		assertEquals(0, ml.getBooks().size());
	}
	
	public void testAddPerson() {
		// create test objects
		setup();
		
		// test initial size is 0
		assertEquals(0, ml.getPeople().size());
		
		ml.people.add(p1);
		ml.people.add(p2);
		assertEquals(2,ml.people.size());
		assertEquals(1, ml.people.indexOf(p2));
		
		ml.people.remove(p1);
		assertEquals(1,ml.people.size());
		ml.people.remove(p2);
		assertEquals(0, ml.people.size());
		
		
	}
	public void testCheckOut() {
		// set up objects
		setup();
		addItems();
		
		// if test fails, string message will display. makes it clear what failed
		assertTrue("Book did not check out correctly", ml.checkOut(b1, p1));
		
		assertEquals("Fred", b1.getPerson().getName());
		// Should fail because book b1 is already checked out to p1
		assertFalse("Book was already checked out", ml.checkOut(b1,p2));
		
		//The check-in method doesn't need the name of the person the book was
		// checked out to. We should already know this.
		assertTrue("Book check-in failed", ml.checkIn(b1));
		
		//try to check-in book that was already checked-in
		assertFalse("Book was already checked in", ml.checkIn(b1));
		
		// Try to check in a book that wasn't checked out, and make sure it fails.
		assertFalse("Book was never checked out", ml.checkIn(b2) );
		
		// test for maximum books
		setup();
		p1.setMaximumBooks(1);
		addItems();
		
		assertTrue("First book did not check out", ml.checkOut(b2, p1));
		assertFalse("Second book should not have checked out due to maxbooks cap", ml.checkOut(b1, p1));
	}
	private void addItems() {
		ml.addBook(b1);
		ml.addBook(b2);
		ml.addPerson(p1);
		ml.addPerson(p2);
	}
	
	public void testGetBooksForPerson () {
		setup();
		addItems();
		assertEquals(0, ml.getBooksForPerson(p1).size());
		
		ml.checkOut(b1, p1);
		
		ArrayList<Book> testBooks = ml.getBooksForPerson(p1);
		assertEquals(1,  testBooks.size());
		assertEquals(0, testBooks.indexOf(b1));
		
		ml.checkOut(b2, p1);
		assertEquals(2, testBooks.size());
		assertEquals(1, testBooks.indexOf(b2));
		
	}
}
