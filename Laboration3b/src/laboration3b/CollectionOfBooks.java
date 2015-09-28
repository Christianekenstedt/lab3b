package laboration3b;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This is a class CollectionOfBooks.
 *
 * @author Christian Ekenstedt
 */
public class CollectionOfBooks implements Serializable {

    private ArrayList<Book> books;
    private FileHandler f;
    /**
     * Constructor creates a new ArrayList<Book>
     */
    public CollectionOfBooks() throws Exception{
        f = new FileHandler();
        books = f.read();
        if(books == null){
            books = new ArrayList<>();
        }
        

    }

    /**
     * Adds a new book.
     *
     * @param b the book to be added in the CollectionOfBooks list.
     */
    public void addBook(Book b) {
        books.add(b);
    }

    /**
     * Removes a book from the list given by the specified object.
     *
     * @param b the object Book to be removed from the list.
     */
    public void removeBook(Book b) {
        books.remove(b);

    }

    /**
     * Removes a book given by the index and return if succeeded or not.
     *
     * @param index in the ArrayList
     * @return true if succeeded otherwise false.
     */
    public boolean removeBook(int index) {
        if (index < books.size() && index >= 0) {
            books.remove(index);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Searches the CollectionOfBooks books for a specified ISBN and returns an
     * ArrayList<Book> with all the books containing the specified ISBN.
     *
     * @param isbn the author to be searched for
     * @return an ArrayList<Book> containg all the books with the given isbn.
     */
    public ArrayList<Book> getBooksByISBN(String isbn) {
        ArrayList<Book> temp = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getISBN().contains(isbn)) {
                temp.add(books.get(i));
            }
        }
        for (int i = 0; i < books.size(); i++) {
            books.get(i).setSortingBy("isbn");
        }
        Collections.sort(temp);
        return temp;
    }

    /**
     * Searches the CollectionOfBooks books for a specified title and returns an
     * ArrayList<Book> with all the books containing the specified title.
     *
     * @param title the author to be searched for
     * @return an ArrayList<Book> containg all the books with the given title.
     */
    public ArrayList<Book> getBooksByTitle(String title) {
        ArrayList<Book> temp = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            /*if(books.get(i).getTitle().equals(title)){
             temp.add(books.get(i));
             }*/
            if (books.get(i).getTitle().contains(title)) {
                temp.add(books.get(i));
            }
        }
        for (int i = 0; i < books.size(); i++) {
            books.get(i).setSortingBy("title");
        }
        Collections.sort(temp);
        return temp;
    }

    /**
     * Searches the CollectionOfBooks books for a specified author and returns
     * an ArrayList<Book> with all the books containing the specified author.
     *
     * @param author the author to be searched for
     * @return an ArrayList<Book> containg all the books with the given author.
     */
    public ArrayList<Book> getBooksByAuthor(String author) {
        ArrayList<Book> temp = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            /*if(books.get(i).getTitle().equals(title)){
             temp.add(books.get(i));
             }*/
            for (int j = 0; j < books.get(i).getAuthors().size(); j++) {
                if (books.get(i).getAuthors().get(j).getAuthor().contains(author)) {
                    temp.add(books.get(i));
                }
            }
        }
        for (int i = 0; i < books.size(); i++) {
            books.get(i).setSortingBy("author");
        }
        Collections.sort(temp);
        return temp;
    }

    /**
     * Takes a index and returns the book at the given index.
     *
     * @param index
     * @return a object Book.
     */
    public Book getBook(int index) {
        return (Book) books.get(index);
    }

    /**
     * getBooks takes an ArrayList<Book> and converts it to a string.
     *
     * @param temp is the list to be converted to a string.
     * @return a printable string
     */
    public String getBooks(ArrayList<Book> temp) {
        String info = new String();
        if (temp.size() < 1) {
            return null;
        } else {
            for (int i = 0; i < temp.size(); i++) {
                info += "[" + (i + 1) + "] ISBN: " + temp.get(i).getISBN() + "\tTitle: "
                        + temp.get(i).getTitle() + "\tAuthor(s): ";
                for (int j = 0; j < temp.get(i).getAuthors().size(); j++) {
                    info += " " + temp.get(i).getAuthors().get(j).getAuthor();
                    if (!(j == temp.get(i).getAuthors().size() - 1)) {
                        info += " &";
                    }
                }
                info += "\tEdition: " + temp.get(i).getEdition() + "\tPrice: " + temp.get(i).getPrice() + "kr";
                info += "\n";
            }
            return info;
        }
    }

    /**
     * Checks if the CollectionOfBooks is empty.
     *
     * @return true if empty, false if not empty.
     */
    public boolean isEmpty() {
        if (books.size() > 0) {
            return false;
        } else {
            return true;
        }
    }
    public void close() throws Exception{
        f.write(books);
    }

    /**
     * Returns a string with all the books in the CollectionOfBooks.
     *
     * @return a string with all the books in the CollectionOfBooks.
     */
    @Override
    public String toString() {
        String info = new String();
        if (books.size() < 1) {
            return null;
        } else {
            for (int i = 0; i < books.size(); i++) {
                info += "[" + (i + 1) + "]\tISBN: " + books.get(i).getISBN() + "\tTitle: "
                        + books.get(i).getTitle() + "\tAuthor(s): ";
                for (int j = 0; j < books.get(i).getAuthors().size(); j++) {
                    info += " " + books.get(i).getAuthors().get(j).getAuthor();
                    if (!(j == books.get(i).getAuthors().size() - 1)) {
                        info += " &";
                    }
                }
                info += "\tEdition: " + books.get(i).getEdition() + "\tPrice: " + books.get(i).getPrice() + "kr";
                info += "\n";
            }
            return info;
        }
    }
}
