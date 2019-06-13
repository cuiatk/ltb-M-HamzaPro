package labTerminalB;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
		private String _name;
		private Vector<Rental> _rentals = new Vector<Rental>();
		public Customer (String name){
			_name = name;
		};
		public void addRental(Rental arg) {
			_rentals.addElement(arg);
		}
		public String getName (){
			return _name;
		};
		
		/*
		 * TODO 4		20 Marks
		 * Identify the bad smells in the statement method and refactor the code
		 * In case you add a new method also provide specifications for new method
		 * after refactoring all test cases must still be passed
		 * Commit after each change and include a meaningful message about the change you made
		 * e.g. Method Move methodName();
		 * 
		 */
		
		/**
		 * TODO 3		10 Marks
		 * Provide suitable specification for statement method 
		 */
		
		/**
		 * this method is constructing a statement which has name of person, movies being rented, and
		 * rental points of person.
		 * It is a method to calculate and print a statement of a customer's charges at a video store.
         * The method is told which movies a customer rented and for how long.
         * It then calculates the charges, which depend on how long the movie is rented, and
         * identifies the type movie. There are three kinds of movies: regular, children's, and new releases.
         * In addition to calculating charges, the statement also computes frequent renter points, which vary
		 * depending on whether the film is a new release.
		 * @return a statement which contain the name of person who is renting movie(s)
		 * and name of all movies which are being rented by that specific person with their
		 * calculated prices, and rental points of that person.
		 */
	
		public String statement() {
			double totalAmount = 0;
			int frequentRenterPoints = 0;
			Enumeration<Rental> rentals = _rentals.elements();
			String result = "Rental Record for " + getName() + "\n";
			while (rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental each = (Rental) rentals.nextElement();
			thisAmount = amountFor(each);
			// add frequent renter points
			frequentRenterPoints ++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
			each.getDaysRented() > 1) frequentRenterPoints ++;
			//show figures for this rental

			result += "\t" + each.getMovie().getTitle()+ "\t" +
			String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
			}
			//add footer lines
			result += "Amount owed is " + String.valueOf(totalAmount) +
			"\n";
			result += "You earned " + String.valueOf(frequentRenterPoints) +
			" frequent renter points";
			return result;
			}
			
		private double amountFor(Rental aRental) {
			double result = 0;
			switch (aRental.getMovie().getPriceCode()) {
			case Movie.REGULAR:
			result += 2;
			if (aRental.getDaysRented() > 2)
			result += (aRental.getDaysRented() - 2) * 1.5;
			break;
			case Movie.NEW_RELEASE:
			result += aRental.getDaysRented() * 3;
			break;
			case Movie.CHILDRENS:
			result += 1.5;
			if (aRental.getDaysRented() > 3)
			result += (aRental.getDaysRented() - 3) * 1.5;
			break;
			}
			return result;
}
}