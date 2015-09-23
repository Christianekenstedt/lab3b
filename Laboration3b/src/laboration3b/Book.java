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
    
    public Book(String isbn, String title, int edition, double price ){
        this.isbn = isbn;
        this.title = title;
        this.edition = edition;
        this.price = price;
    }
    
    public void setISBN(String isbn){
        this.isbn = isbn;
    }
    
    public void setTitleN(String title){
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

    }
    
    public ArrayList<Author> getAuthors(){
        ArrayList<Author> authors = new ArrayList(); //hej
        return authors;
    }
    
}
