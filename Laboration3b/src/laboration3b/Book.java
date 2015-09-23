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
public class Book implements Comparable<Book>{
    private String isbn;
    private String title;
    private int edition;
    private double price;
    private ArrayList<Author> authors;
    
    public Book(String isbn, String title, int edition, double price, String name ){
        authors = new ArrayList<>();
        this.isbn = isbn;
        this.title = title;
        this.edition = edition;
        this.price = price;
        addAuthor(name);
        
        
    }
    
    public void setISBN(String isbn){
        this.isbn = isbn;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public void setEdition(int edition){
        this.edition = edition;
    }
    
    public void setPrice(Double price){
        this.price = price;
    }
    
    public String getISBN(){
        return isbn;
    }
    
    public String getTitle(){
        return title;
    }
    
    public int getEdition(){
        return edition;
    }
    
    public double getPrice(){
        return price;
    }
    @Override
    public int compareTo(Book o) {
        
        return 0; // FIXA METOD!!
    }
    
    public void addAuthor(String author){
        authors.add(new Author(author));
    }
    
    public ArrayList<Author> getAuthors(){
        return authors;
    }
    
}
