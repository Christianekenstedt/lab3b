package laboration3b;

import java.io.*;
import java.util.ArrayList;

/**
 * The class FileHandler contains read and write methods. The class read and
 * writes to a specific file called "booklist.ser", if the file is not found it
 * will create a new file with that specific name.
 *
 * @author Christian Ekenstedt & Joachim Zetterman
 */
@SuppressWarnings("unchecked")
public class FileHandler {

    /**
     * The method read reads the file "booklist.ser" and deserializes the data.
     * If the file is not found, it create a new .ser file and returns null.
     *
     * @return books, a reference to a temporary list of the type Book. Returns
     * null if the file is not found.
     * @throws Exception
     */
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

    /**
     * The method write serializes data to the file booklist.ser
     *
     * @param books , is an ArrayList of the type Book.
     * @throws Exception
     */
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
