/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboration3b;
import java.util.ArrayList;
/**
 *
 * @author Chrille
 */
public class CollectionOfBooks {
    private ArrayList<Book> books;
    
    public CollectionOfBooks(){
        //read
        books = new ArrayList<>();
        
    }
    
    public void addBook(Book b){
        books.add(b);
    }
    public void removeBook(Book b){
        books.remove(b);
    }
    
    public ArrayList<Book> getBooksByISBN(String isbn){
        ArrayList<Book> temp = new ArrayList<>();
        return temp;
    }
    
    public ArrayList<Book> getBooksByTitle(String title){
        ArrayList<Book> temp = new ArrayList<>();
        return temp;
    }
    
    public String getBooks(){
        String info = "hello";
        return info;
    }
    @Override
    public String toString(){
        String info = "hello";
        return info;
    }
}
