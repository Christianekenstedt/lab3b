package laboration3b;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The class Book represents a book object. A book can contain an isbn number, a
 * title, a edition number, a price and one or more Author objects.
 *
 *
 * @author Christian Ekenstedt & Joachim Zetterman
 */
public class Book implements Comparable<Book>, Serializable {

    private String isbn;
    private String title;
    private int edition;
    private double price;
    private ArrayList<Author> authors;

    /**
     * Constructor set all the attributes.
     *
     * @param isbn, isbn to be set.
     * @param title, title to be set.
     * @param edition, edition to be set.
     * @param price, price to be set.
     * @param names, names to be set.
     */
    public Book(String isbn, String title, int edition, double price, ArrayList<String> names) {

        authors = new ArrayList<>();
        this.isbn = isbn;
        this.title = title;
        this.edition = edition;
        this.price = price;
        addAuthor(names);

    }

    /**
     * Set the ISBN
     *
     * @param isbn to be set.
     */
    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Sets the title.
     *
     * @param title, the title to be set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the edition.
     *
     * @param edition, the edition to be set.
     */
    public void setEdition(int edition) {
        this.edition = edition;
    }

    /**
     * Sets the price.
     *
     * @param price, the price to be set.
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Returns the isbn.
     *
     * @return the isbn.
     */
    public String getISBN() {
        return isbn;
    }

    /**
     * Returns the title.
     *
     * @return the title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the edition.
     *
     * @return the edition.
     */
    public int getEdition() {
        return edition;
    }

    /**
     * Returns the price.
     *
     * @return the price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns a list with all authors.
     *
     * @return a list with all authors.
     */
    public ArrayList<Author> getAuthors() {
        return authors;
    }

    /**
     * Adds a new author with the given string.
     *
     * @param author, name to be set.
     */
    public void addAuthor(String author) {
        authors.add(new Author(author));
    }

    /**
     * Adds new authors if there are more authors.
     *
     * @param author
     */
    public void addAuthor(ArrayList<String> author) {
        for (int i = 0; i < author.size(); i++) {
            authors.add(new Author(author.get(i)));
        }
    }

    /**
     * Compare diffrent books by title, isbn or author.
     *
     * @param b the other book to be compared with.
     * @return
     */
    @Override
    public int compareTo(Book b) {
        return this.title.compareTo(b.getTitle());
    }

    /**
     * Returns a printable string of the book.
     *
     * @return a string containing info of the book.
     */
    @Override
    public String toString() {
        String info;
        info = "Title: " + getTitle() + "Edition: " + getEdition() + "ISBN: " + getISBN() + "Price: " + getPrice();
        for (int i = 0; i < authors.size(); i++) {
            info += " " + authors.get(i).getAuthor();
            if (!(i == authors.size() - 1)) {
                info += " &";
            }
        }
        return info;
    }
}
