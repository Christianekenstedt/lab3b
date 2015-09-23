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
    public void removeBook(int index){
        books.remove(index);
    }
    
    public ArrayList<Book> getBooksByISBN(String isbn){
        ArrayList<Book> temp = new ArrayList<>();
        return temp;
    }
    
    public ArrayList<Book> getBooksByTitle(String title){
        ArrayList<Book> temp = new ArrayList<>();
        return temp;
    }
    
    public Book getBook(int index){
        Book b = books.get(index);
        return b;
    }
    public String getBooks(){
        String info = new String();
        if(books.size()>0){
            return null;
        }else {
            for(int i = 0; i < books.size(); i++){
            info += "[" + (i+1) + "] ISBN: " + books.get(i).getISBN() + " Title: " + books.get(i).getTitle() + " Edition: " + books.get(i).getEdition() + " Price: " + books.get(i).getPrice() + "kr";
            info += "\n";
            }
            return info;
        }
    }
        
    @Override
    public String toString(){
        String info = "hello";
        return info;
    }
}
