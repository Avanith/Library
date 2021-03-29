package org.totalbeginner.tutorial;

import java.util.ArrayList;

public class MyLibrary {

	String name;
	ArrayList<Book> books;
	ArrayList<Person> people;
	
	public String getName() {
		return name;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public ArrayList<Person> getPeople() {
		return people;
	}

	// constructor
	public MyLibrary(String name) {
		this.name = name;
		books = new ArrayList<Book>();
		people = new ArrayList<Person>();
	}

	public String toString() {
		return this.getName();
	}
	
	public void addBook(Book b1) {
		this.books.add(b1);
	}

	public void removeBook(Book b1) {
		this.books.remove(b1);
	}
	
	public void addPerson(Person p1) {
		this.people.add(p1);
	}
	public void removePerson(Person p1) {
		this.people.remove(p1);
	}

	public boolean checkOut(Book b1, Person p1) {
		// make sure b1 isn't already checked out to someone
		if (b1.getPerson() == null) {
			// if it isn't checked out, set it to "p1", the person checking it outs
			b1.setPerson(p1);
			return true;
		} else { // The book is currently checked out
			return false;
		}
	}

	public boolean checkIn(Book b1) {
		// if the book is checked out
		if (b1.getPerson() != null) {
			b1.setPerson(null);
			return true;
		} else { // the book is not checked out
			return false;
		}
	}

	public ArrayList<Book> getBooksForPerson(Person p1) {
		ArrayList<Book> result = new ArrayList<Book>();
		// for each aBook (element) in this list, execute this.getBooks()
		for (Book aBook : this.getBooks()) {
			// If a book in the library is checked out to someone, and that books person name equals
			// the name of the person being passed as a parameter to this method (p1), then add
			// that book to our result ArrayList.
			if ((aBook.getPerson() != null) && (aBook.getPerson().getName().equals(p1.getName()))) {
				result.add(aBook);
			} // end if statement
		} // end for loop
		// // We now return 'result' which includes all the books that p1 has checked out.
		return result;
	}
}
