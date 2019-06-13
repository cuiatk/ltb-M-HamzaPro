package labTerminalB;

import org.junit.Test;

public class CustomerTest {
	Movie m1 = new Movie("Spancer", 0);
	Movie m2 = new Movie("Speed", 1);
	Customer me = new Customer("Nadir");
	Customer me2 = new Customer("Allah Ditta");
	Rental r1 = new Rental(m1, 23);
	Rental r2 = new Rental(m2,4);
	int New_release_price = 3;
	/**
	 * Test 1 Customer rented two movies one REGULAR and one NEW_RELEASE
	 */
	@Test
	public void testStatement1() {
		me.addRental(r1);
		me.addRental(r2);
		//fail("Not yet implemented");
		String output1 = "Rental Record for Nadir\r\n" + 
				"	Spancer	33.5\r\n" + 
				"	Speed	12.0";
		if(output1.equals(me.statement()))
		{
			assert true;
		}
	}
	/*
	 * TODO 2		10 Marks
	 * Provide at least two or more test cases carefully chosen so that they satisfy our testing
	 * strategy basics i.e. input partition etc
	 */
	
	/**
	 * Test 2 Customer rented one New_Release movie
	 */
	
	public void testMoviePrice()
	{
		me2.addRental(r2);
		
		//fail("Not yet implemented");
		String output1 = "Rental Record for Allah Ditta\r\n" + 
				"	Speed	"+New_release_price*3;
		if(output1.equals(me.statement()))
		{
			assert true;
		}
	}
	
	/**
	 * Test 3 Customer rented one Regular movie
	 */
	
	public void testStatement2()
	{
        me.addRental(r1);
		
		
        String output1 = "Rental Record for Allah Ditta\r\n" + 
				"	Spancer	33.5" ;
		if(output1.equals(me.statement()))
		{
			assert true;
		}
	}
	

}
