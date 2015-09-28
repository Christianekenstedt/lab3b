package laboration3b;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Chrille
 */
public class UserInterface {

    private CollectionOfBooks books;
    private boolean runi;

    public UserInterface() throws Exception{
        //read
        menu();
    }

    public void menu() throws Exception {
        books = new CollectionOfBooks();
        runi = true;
        run();
    }

    public void addBook(Book b) {
        books.addBook(b);
    }

    public void getBooksByTitle(String title) {
        System.out.println(books.getBooks(books.getBooksByTitle(title)));
    }

    public void getBooksByISBN(String isbn) {
        System.out.println(books.getBooks(books.getBooksByISBN(isbn)));
    }

    public void getBooksByAuthor(String author) {
        System.out.println(books.getBooks(books.getBooksByAuthor(author)));
    }

    public void removeBook(int index) {
        if(index != -1){
            if(!books.removeBook(index)) {
                // We have to check if the index exists!
                System.out.println("Can't find book!");
            }
            
        }else System.out.println("Exiting");
    }

    public void getBooks() {
        String temp = books.toString();
        if (temp != null) {
            System.out.println(temp);
        } else {
            System.out.println("Empty...");
        }
    }

    private void run() throws Exception{
        Scanner scan = new Scanner(System.in);
        char choice = ' ';
        String answer;
        

        while(runi){
            System.out.println(runi);
            printMenu();
            answer = scan.nextLine();
            answer = answer.toUpperCase();
            choice = answer.charAt(0); // Fˆrsta tecknet i svaret

            switch (choice) {
                case 'A':
                    doA();
                    break;
                case 'B':
                    doB();
                    break;
                case 'C':
                    doC();
                    break;
                case 'D':
                    doD();
                    break;
                case 'E':
                    doE();
                    break;
                case 'F':
                    doF();
                    break;
                case 'X':
                    System.out.println("Bye, bye!");
                    books.close();
                    runi = false;
                    System.out.println("nu blev den satt till " + runi);
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
        System.out.println("vad händer " + runi);
    }

    // Definierar ett "uppdrag"

    private void doA() {
        Scanner scan = new Scanner(System.in);
        String isbn, title, edition, price;
        ArrayList<String> names = new ArrayList<>();
        String temp = "yes";
        System.out.println("Please add the following information: ");
        System.out.println("Add ISBN: ");
        isbn = scan.nextLine();
        System.out.println("Add title: ");
        title = scan.nextLine();
        System.out.println("Add author: ");
        names.add(scan.nextLine());
        while (!"no".equals(temp)) {
            System.out.print("Are there anymore authors? (yes/no): ");
            temp = scan.nextLine();
            if (temp.contains("yes") || temp.contains("Yes")) {
                System.out.print("Please add another author: ");
                names.add(scan.nextLine());
            } else {
                temp = "no";
            }
        }
        System.out.println("Add edition: ");
        edition = scan.nextLine();
        System.out.println("Add price: ");
        price = scan.nextLine();
        addBook(new Book(isbn, title, Integer.parseInt(edition), Double.parseDouble(price), names));
    }

    // Definierar ett annat "uppdrag"
    private void doB() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the title: ");
        getBooksByTitle(scan.nextLine());
    }

    private void doE() {
        System.out.println("Printing all books...");
        getBooks();

    }

    private void doC() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the ISBN: ");
        getBooksByISBN(scan.nextLine());
    }

    private void doD() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the author: ");
        getBooksByAuthor(scan.nextLine());
    }

    private void doF() {
        Scanner scan = new Scanner(System.in);
        if (!books.isEmpty()) {
            System.out.println("Remove one of the following books: ");
            getBooks();
            System.out.print("by typing the nr (or 0 to go back): ");
            removeBook((scan.nextInt()) - 1);
        } else {
            System.out.println("Empty list...");
        }
    }

    private void printMenu() {
        System.out.println("---Menu---");
        System.out.println("A Add a book");
        System.out.println("B Get books by title");
        System.out.println("C Get books by ISBN");
        System.out.println("D Get books by author");
        System.out.println("E Print all books");
        System.out.println("F Remove a book");
        System.out.println("X Exit");
        System.out.println("----------");
    }
}
