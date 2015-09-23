/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboration3b;

import java.io.*;
import java.util.*;

/**
 *
 * @author Chrille
 */
public class Laboration3b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException  {
    
        read();
        
        UserInterface start = new UserInterface();
        start.menu();
    }
    
    public static void read() throws IOException {
        String line, isbn, title, edition;
        int price;
        StringTokenizer tokenizer;
        BufferedReader buff = null;
        
        try{
            buff = new BufferedReader(new FileReader("bookList.txt"));

            line = buff.readLine(); 	// Read a line from the file...
            while (line != null) {	// ...while there's more to read.

                try {
                    tokenizer = new StringTokenizer(line);
                    isbn = tokenizer.nextToken();
                    title = tokenizer.nextToken();
                    edition = tokenizer.nextToken();
                    price = Integer.parseInt(tokenizer.nextToken());
                    
                    
                    
                    System.out.println(isbn + "\t" + title + "\t" + edition + "\t" + price + " kr");
                } catch (NumberFormatException ne) {
                    System.out.println("Input mismatch. Skipping this line.");
                }

                line = buff.readLine();  // Read another line	
            }
            
        }
        catch (FileNotFoundException fe) {
            System.out.println("Can not find the specified file. Creating a new file...");
            
            File file = new File("bookList.txt");
            file.createNewFile();
            //throw fe;  
        }
        
        finally {
            try {
                if (buff != null) {
                    buff.close();
                }
            } catch (IOException ie) {
            }
        }     
    }
}
