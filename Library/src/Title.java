import java.util.Map;
import java.util.Stack;

public class Title {

	private String title;
	private Map<String,Book> books;
	
	public Title(String title){
		this.title = title;
	}
	public int bookCount(){
		return books.size();
	}
	private String getAvailableSerialNumber(){
		return books.keySet().iterator().next();
	}
	public Book getAvailableBook(){
		return books.get(getAvailableSerialNumber());
	}
	public void addBook(Book book){
		books.put(book.getSerialNumber(), book);
	}
	public void removeBook(Book book){
		books.remove(book.getSerialNumber());
	}
	
}
