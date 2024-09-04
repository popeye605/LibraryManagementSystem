import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.JOptionPane;

public class stats {

    public stats() {
    }

    public void numOfBooks() throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList<Boook> bookList = new ArrayList<Boook>();
        File file = new File("books.ser");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        ListIterator li ;
        int count = 0;
        if(file.exists()){
            boolean f = false;
            boolean found = false;
//             ois = new ObjectInputStream(new FileInputStream(file));


            bookList = (ArrayList<Boook>)ois.readObject();
            ois.close();
            li = bookList.listIterator();

            while(li.hasNext()){

                Boook b = (Boook) li.next();
                count = bookList.size();
                f = true;

            }
            JOptionPane.showMessageDialog(null, count);
        }
    }
    public void numOfStudent() throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList<student> bookList = new ArrayList<student>();
        File file = new File("student.ser");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        ListIterator li ;
        int count = 0;
        if(file.exists()){
            boolean f = false;
            boolean found = false;
//             ois = new ObjectInputStream(new FileInputStream(file));


            bookList = (ArrayList<student>)ois.readObject();
            ois.close();
            li = bookList.listIterator();

            while(li.hasNext()){

                student b = (student) li.next();
                count = bookList.size();
                f = true;

            }
            JOptionPane.showMessageDialog(null, count);
        }

    }
    public void numOfIssued() throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList<Boook> bookList = new ArrayList<Boook>();
        File file = new File("issue.ser");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        ListIterator li ;
        int count = 0;
        if(file.exists()){
            boolean f = false;
            boolean found = false;
//             ois = new ObjectInputStream(new FileInputStream(file));
//             std.add((student)ois.readObject());

            bookList = (ArrayList<Boook>)ois.readObject();
            ois.close();
            li = bookList.listIterator();

            while(li.hasNext()){

                Boook b = (Boook) li.next();
                count = bookList.size();
                f = true;

            }
            JOptionPane.showMessageDialog(null, count);
        }

    }

}
