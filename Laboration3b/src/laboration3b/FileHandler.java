package laboration3b;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Christian
 */
@SuppressWarnings("unchecked")
public class FileHandler {
    
    public ArrayList<Book> read() throws Exception {

        ObjectInputStream ois = null;
        ArrayList<Book> books;
        try {
            FileInputStream fin = new FileInputStream("booklist.ser");
            ois = new ObjectInputStream(fin);

            books = (ArrayList<Book>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file, creating new...");
            File file = new File("booklist.ser");
            file.createNewFile();
            return null;
        } finally {
            if (ois != null) {
                ois.close();
            }

        }
        return books;
    }
    
    public void write(ArrayList<Book> books) throws Exception {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fout = new FileOutputStream("booklist.ser");
            oos = new ObjectOutputStream(fout);
            oos.writeObject(books);

        } finally {
            if (oos != null) {
                oos.close();
            }
        }
    }
}
