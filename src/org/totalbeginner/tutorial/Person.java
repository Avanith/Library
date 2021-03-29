/* Packages avoid problem of duplicate Class names
 * If you need a class from another package, import the package
 * org.totalbeginner.tutorial.Person i think would be how you access
 * this class outside of this package?*/

package org.totalbeginner.tutorial;

public class Person {
	// fields
	private String name; // name of the person
	private int maximumBooks; // most books the person checkout
	
	// constructors
	public Person() {
		name = "unknown name";
		maximumBooks = 3;
	}
	
	public Person(String aName) {
		name = aName;
		maximumBooks = 3;
	}


	// methods
	public String getName() {
		return name;
	}
	
	public void setName(String anyName) {
		name = anyName;
	}

	public int getMaximumBooks() {
		return maximumBooks;
	}

	public void setMaximumBooks(int maximumBooks) {
		// this = the current object
		this.maximumBooks = maximumBooks;
	}
	
	public String toString() {
		return this.getName() + " (" + this.getMaximumBooks() + 
				" books)";
	}
}
