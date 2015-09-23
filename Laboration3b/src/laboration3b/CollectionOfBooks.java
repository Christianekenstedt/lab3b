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
    public boolean removeBook(int index){
        if(index < books.size() && index >= 0){
            books.remove(index);
            return true;
        }else return false;
    }
    
    public ArrayList<Book> getBooksByISBN(String isbn){
        ArrayList<Book> temp = new ArrayList<>();
        return temp;
    }
    
    public ArrayList<Book> getBooksByTitle(String title){
        ArrayList<Book> temp = new ArrayList<>();
        return temp;
    }
    
    public ArrayList<Book> getBooksByAuthor(String author){
        ArrayList<Book> temp = new ArrayList<>();
        // Sök efter böcker med en viss författare lägg då till i temp-listan.
        return temp;
    }
    
    public Book getBook(int index){
        Book b = books.get(index);
        return b;
    }
    public String getBooks(){
        String info = new String();
        if(books.size()<1){
            return null;
        }else {
            for(int i = 0; i < books.size(); i++){
            info += "[" + (i+1) + "] ISBN: " + books.get(i).getISBN() + " Title: " 
                    + books.get(i).getTitle() + " Author: FIXA"  + " Edition: " + books.get(i).getEdition() + " Price: " + books.get(i).getPrice() + "kr";
            info += "\n";
            }
            return info;
        }
    }
    public boolean isEmpty(){
        if (books.size()>0){
            return false;
        }else return true;
    }    
    @Override
    public String toString(){
        String info = "hello";
        return info;
    }
}
