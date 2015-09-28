package laboration3b;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class UserInterface represents the UI. The user will interact with a menu
 * that in returns handles all the internal methods.
 *
 *
 * @author Christian Ekenstedt & Joachim Zetterman
 */
public class UserInterface {

    private CollectionOfBooks books;

    /**
     * The constructor. Creates a new collection of books and starts the UI.
     *
     * @throws Exception
     */
    public UserInterface() throws Exception {
        books = new CollectionOfBooks();
        menu();
    }

    /**
     * adds a book to the collection of books
     *
     * @param b , the book to be added
     */
    public void addBook(Book b) {
        books.addBook(b);
    }

    /**
     * Gets all the books in the collection of books with the specified title
     *
     * @param title
     */
    public void getBooksByTitle(String title) {
        System.out.println(books.getBooks(books.getBooksByTitle(title)));
    }

    /**
     * Gets all the books in the collection of books with the specified isbn
     *
     * @param isbn
     */
    public void getBooksByISBN(String isbn) {
        System.out.println(books.getBooks(books.getBooksByISBN(isbn)));
    }

    /**
     * Gets all the books in the collection of books with the specified
     * author(s)
     *
     * @param author
     */
    public void getBooksByAuthor(String author) {
        System.out.println(books.getBooks(books.getBooksByAuthor(author)));
    }

    /**
     * Removes a book from the collection of books with the specified index
     *
     * @param index
     */
    public void removeBook(int index) {
        if (index != -1) {
            if (!books.removeBook(index)) {
                // We have to check if the index exists!
                System.out.println("Can't find book!");
            }

        } else {
            System.out.println("Exiting");
        }
    }

    /**
     * Gets(prints) all the books of the collection of books. Prints "Empty..."
     * if the collection is empty
     */
    public void getBooks() {
        if (!books.isEmpty()) {
            System.out.println(books.toString());
        } else {
            System.out.println("Empty...");
        }
    }

    /**
     * Prints a menu and let the user do one of a certain choices. Exits if
     * character 'X' is typed.
     *
     * @throws Exception
     */
    private void menu() throws Exception {
        Scanner scan = new Scanner(System.in);
        char choice = ' ';
        String answer;

        while (choice != 'X') {
            printMenu();
            answer = scan.nextLine();
            answer = answer.toUpperCase();
            choice = answer.charAt(0); // Fˆrsta tecknet i svaret

            switch (choice) {
                case 'A':   doA();break;
                case 'B':   doB();break;
                case 'C':   doC();break;
                case 'D':   doD();break;
                case 'E':   doE();break;
                case 'F':   doF();break;
                case 'X':   System.out.println("Bye, bye!");
                    books.close();
                    break;
                default:    System.out.println("Unknown command");break;
            }

        }
    }

    /**
     * Do the action Add a new book.
     */
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

    /**
     * Do the action Get books by title.
     */
    private void doB() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the title: ");
        getBooksByTitle(scan.nextLine());
    }

    /**
     * Do the action Get books by ISBN.
     */
    private void doC() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the ISBN: ");
        getBooksByISBN(scan.nextLine());
    }

    /**
     * Do the action Get books by Author(s).
     */
    private void doD() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the author: ");
        getBooksByAuthor(scan.nextLine());
    }

    /**
     * Do the action get all books.
     */
    private void doE() {
        System.out.println("Printing all books...");
        getBooks();

    }

    /**
     * Do the action Remove a book.
     */
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

    /**
     * Prints a menu to the user.
     */
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
