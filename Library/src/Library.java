import java.util.HashMap;
import java.util.Map;

public class Library {

	static Map<String, String> validUsers = new HashMap<String, String>();
	static Map<String, Integer> availableBooks = new HashMap<String, Integer>();
	static {
		validUsers.put("Harry", "buzzing");
		availableBooks.put("How to score in August", 3);
		availableBooks.put("Connect the dots", 0);
	}

	private String userName;

	public Library(String username) {
		this.userName = username;
	}

	public static Library login(String username, String password) {

		if (password.equals(validUsers.get(username))) {
			return new Library(username);
		}
		return null;
	}

	public static String isBookAvailable(String string) {
		if (availableBooks.get(string)!=null ) {
			if( availableBooks.get(string) > 0)
			{
			return "Available";
			}
			else
			{
				return "Sorry! Out of stock";
			}
		}
		return "Sorry! No title found";
	}

	public String getLoggedInUser() {
		
		return this.userName;
	}

	public void borrow(String string) {

		if(isBookAvailable(string).equals("Available"))
		{
			Integer currentAvailability = availableBooks.get(string);
			availableBooks.put(string, currentAvailability-1);
		}
	}

	public int getBooksCount(String string) {
		return availableBooks.get(string);
	}

	public void returnBook(String string) {
		Integer currentAvailability = availableBooks.get(string);
		availableBooks.put(string, currentAvailability+1);
	}

	

}
