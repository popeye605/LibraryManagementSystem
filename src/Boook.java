
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.JOptionPane;
public class Boook extends bookAbs implements Serializable {
    String id;

    public Boook() {
    }

    public Boook(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Override
    public void addBook(String id) {

        File file = new File("books.ser");
        ObjectInputStream ois = null;
        ArrayList<Boook> bookList = new ArrayList<Boook>();

        if (file.isFile()) {
            try {
                ois = new ObjectInputStream(new FileInputStream(file));
                bookList = (ArrayList<Boook>) ois.readObject();
                ois.close();
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            } catch (ClassNotFoundException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }

        ObjectOutputStream oos = null;

        try {
            if (!file.exists()) {
                // Create the file if it doesn't exist
                file.createNewFile();
            }

            oos = new ObjectOutputStream(new FileOutputStream(file));
            bookList.add(this);
            oos.writeObject(bookList);
            oos.close();

            JOptionPane.showMessageDialog(null, "Book Added");
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Override
    public void issueBook(String id) {
        ArrayList<Boook> bookList = new ArrayList<Boook>();
        File file = new File("books.ser");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            bookList = (ArrayList<Boook>) ois.readObject();
            ois.close();

            ListIterator<Boook> li = bookList.listIterator();
            boolean found = false;

            while (li.hasNext()) {
                Boook b = li.next();
                if (b.getId().equals(id)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                File f1 = new File("issue.ser");
                ArrayList<Boook> bookL = new ArrayList<Boook>();

                if (f1.isFile()) {
                    ois = new ObjectInputStream(new FileInputStream(f1));
                    bookL = (ArrayList<Boook>) ois.readObject();
                    ois.close();
                }

                ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(f1));
                bookL.add(this);
                oos1.writeObject(bookL);
                oos1.close();

                JOptionPane.showMessageDialog(null, "Book issued");
            } else {
                JOptionPane.showMessageDialog(null, "Book not found");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
        } catch (IOException e) {
            System.out.println("Error: IO exception");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class not found");
        }
    }
    @Override
    public void returnBook() {
        ArrayList<Boook> bookList = new ArrayList<Boook>();
        File file = new File("issue.ser");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li;
        if(file.isFile()){
            boolean found = false;
            try {
                ois = new ObjectInputStream(new FileInputStream(file));
            } catch (FileNotFoundException ex) {
                System.out.println("Error");
            } catch (IOException ex) {
                System.out.println("Error");
            }
            try {
                bookList = (ArrayList<Boook>)ois.readObject();
            } catch (ClassNotFoundException ex) {
                System.out.println("Error");
            } catch (IOException ex) {
                System.out.println("Error");
            }
            try {
                ois.close();
            } catch (IOException ex) {
                System.out.println("Error");
            }
            li = bookList.listIterator();
            while(li.hasNext()){
                Boook b = (Boook)li.next();
                if(b.getId().equals(id)){
                    li.remove();
                    found = true;
                }

            }
            if(found ){
                try {
                    oos = new ObjectOutputStream(new FileOutputStream(file));
                } catch (FileNotFoundException ex) {
                    System.out.println("Error");
                } catch (IOException ex) {
                    System.out.println("Error");
                }
                try {
                    oos.writeObject(bookList);
                } catch (IOException ex) {
                    System.out.println("Error");
                }
                try {
                    oos.close();
                } catch (IOException ex) {
                    System.out.println("Error");
                }
                JOptionPane.showMessageDialog(null, "Returned Successfully");
            }
            else{
                JOptionPane.showMessageDialog(null, "Record Not Found");
            }
        }

    }
}