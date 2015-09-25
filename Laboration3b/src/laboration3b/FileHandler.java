/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboration3b;
import java.io.*;
import java.lang.*;
import java.util.ArrayList;
/**
 *
 * @author Christian
 */
public class FileHandler {
    
    public ArrayList<Book> read() throws Exception{
        
        ObjectInputStream ois = null;
        ArrayList<Book> books;
        try{
            FileInputStream fin = new FileInputStream("booklist.ser");
            ois = new ObjectInputStream(fin);
            books = (ArrayList<Book>) ois.readObject();
        }
        finally{
            if(ois != null) ois.close();
        }
        return books;
    }
    public void write(ArrayList<Book> books) throws IOException{
        ObjectOutputStream oos = null;
        try{
            FileOutputStream fout = new FileOutputStream("booklist.ser");
            oos = new ObjectOutputStream(fout);
            oos.writeObject(books);
            
            
        }finally{
            if(oos != null) oos.close();
        }         
    }
}
