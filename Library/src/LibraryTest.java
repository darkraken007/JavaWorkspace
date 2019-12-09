import static org.junit.Assert.*;

import org.junit.Test;

public class LibraryTest {

	@Test
	public void testIfLoggedInUserIsCorrect()
	{
		Library library = Library.login("Harry","buzzing");
		assertNotNull(library);
		assertEquals("Harry", library.getLoggedInUser());
	}
	@Test
	public void testIfInvalidUserLoginFails()
	{
		assertNull(Library.login("Henry", "abc123"));
	}
	@Test
	public void testIfBookIsAvailable()
	{
		assertEquals("Available" ,Library.isBookAvailable("How to score in August"));
	}
	@Test
	public void testIfUnavailableBookIsShownAsUnavailable()
	{
		assertEquals("Sorry! No title found",Library.isBookAvailable("A tale of two cities"));
	}
	@Test
	public void testIfOutOfStockBookIsShownAsOutOfStock()
	{
		assertEquals("Sorry! Out of stock",Library.isBookAvailable("Connect the dots"));
	}
	
	@Test
	public void testIfBorrowWorks()
	{
		Library library = Library.login("Harry", "buzzing");
		library.borrow("How to score in August");
		assertEquals(2, library.getBooksCount("How to score in August"));
	}
	
	@Test
	public void testIfReturnWorks()
	{
		Library library = Library.login("Harry", "buzzing");
		library.returnBook("How to score in August");
		assertEquals(3, library.getBooksCount("How to score in August"));
	}
	
	
	
	
	

}
