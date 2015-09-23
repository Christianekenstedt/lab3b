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
    
    public Book(){

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
