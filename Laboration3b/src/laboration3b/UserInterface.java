package laboration3b;
import java.util.Scanner;
/**
 *
 * @author Chrille
 */
public class UserInterface {
    private CollectionOfBooks books;
    public UserInterface(){
        menu();
    }
    public void menu(){
        books = new CollectionOfBooks();
        run();
    }
    public void addBook(Book b){
        books.addBook(b);
    }
    public void getBooksByTitle(String title){
        books.getBooksByTitle(title);
    }
    
    private void run(){
        Scanner scan = new Scanner(System.in);
        char choice;
    	String answer;
    	
    	do {
    		printMenu();
    		answer = scan.nextLine();
    		answer = answer.toUpperCase();
    		choice = answer.charAt(0); // Fˆrsta tecknet i svaret
    		
    		switch(choice) {
    			case 'A':	doThis(); break;
    			case 'B':	doThat(); break;
    			case 'X':	System.out.println("Bye, bye!"); break;
    			default: 	System.out.println("Unknown command");
    		}
    		
    	} while(choice != 'X');
    }
    // Definierar ett "uppdrag"
    private void doThis() {
    	System.out.println("You choose A");
        
    }
    
    // Definierar ett annat "uppdrag"
    private void doThat() {
    	System.out.println("You choose B");
    }
    
    private void printMenu() {
    	System.out.println("---Menu---");
    	System.out.println("A Add a book");
    	System.out.println("B Get books by title");
    	System.out.println("X Exit");
    	System.out.println("----------");
    }
}
