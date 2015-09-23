/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboration3b;
import java.util.ArrayList;
import java.util.Collections;
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
        for(int i = 0; i < books.size(); i++){
            if(books.get(i).getISBN().equals(isbn)){
                temp.add(books.get(i));
            }
        }
        Collections.sort(temp);
        return temp;
    }
    
    public ArrayList<Book> getBooksByTitle(String title){
        ArrayList<Book> temp = new ArrayList<>();
        for(int i = 0; i < books.size(); i++){
            /*if(books.get(i).getTitle().equals(title)){
                temp.add(books.get(i));
            }*/
            if(books.get(i).getTitle().contains(title)){
                temp.add(books.get(i));
            }
        }
        
        Collections.sort(temp);
        return temp;
    }
    
    public ArrayList<Book> getBooksByAuthor(String author){
        ArrayList<Book> temp = new ArrayList<>();
        // Sök efter böcker med en viss författare lägg då till i temp-listan.
        return temp;
    }
    
    public Book getBook(int index){
        return (Book)books.get(index);
    }
    public String getBooks(ArrayList<Book> temp){
        String info = new String();
        if(temp.size()<1){
            return null;
        }else {
            for(int i = 0; i < temp.size(); i++){
            info += "[" + (i+1) + "] ISBN: " + temp.get(i).getISBN() + " Title: " 
                    + temp.get(i).getTitle() + " Author: FIXA"  + " Edition: " + temp.get(i).getEdition() + " Price: " + temp.get(i).getPrice() + "kr";
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
}
