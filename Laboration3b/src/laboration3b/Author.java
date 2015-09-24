package laboration3b;

/**
 * The class Author containing a name.
 * @author Christian Ekenstedt
 */
public class Author {
    String author;
    /**
     * Constructor set the name of the author.
     * @param name 
     */
    public Author(String name){
        this.author = name;
    }
    /**
     * Set the authors name.
     * @param name 
     */
    public void setAuthor(String name){
        author = name;
    }
    /**
     * Get the author name in a string
     * @return a string with the author name.
     */
    public String getAuthor(){
        return author;
    }
}
