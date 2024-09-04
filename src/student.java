import java.io.EOFException;
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

public class student implements Serializable{
    private String f_Name;
    private String l_Name;
    private String course;
    private String regNo;
    public student(){}
    public student(String f_Name ,String l_Name , String course , String regNo ){
        this.f_Name = f_Name;
        this.l_Name = l_Name;
        this.course = course;
        this.regNo = regNo;


    }
    public String getF_Name() {
        return f_Name;
    }
    public void setF_Name(String f_Name) {
        this.f_Name = f_Name;
    }
    public String getL_Name() {
        return l_Name;
    }
    public void setL_Name(String l_Name) {
        this.l_Name = l_Name;
    }
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public String getRegNo() {
        return regNo;
    }
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }
}
class MyObjectStream extends ObjectOutputStream{
    public MyObjectStream () throws IOException {
        super();
    }
    public MyObjectStream (FileOutputStream x) throws IOException {
        super(x);
    }
    @Override
    public void writeStreamHeader(){}

}
//yahan pr runner sy write hoga
class addStudentFile extends student {
    public addStudentFile(String f_Name, String l_Name, String course, String regNo) throws IOException, ClassNotFoundException {
        super(f_Name, l_Name, course, regNo);
        File file = new File("student.ser");
        ObjectInputStream ois = null;
        ArrayList<student> std = new ArrayList<student>();

        if (file.isFile()) {
            ois = new ObjectInputStream(new FileInputStream(file));
            std = (ArrayList<student>) ois.readObject();
            ois.close();
        }

        std.add(this);

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(std);
            JOptionPane.showMessageDialog(null, "Student Added");
        } finally {
            if (oos != null) {
                oos.close();
            }
        }
    }
}
class deleteStudent extends student{
    public deleteStudent(String f_Name ,String l_Name , String course , String regNo) throws FileNotFoundException, IOException, ClassNotFoundException{
        super(f_Name , l_Name , course ,regNo);
        ArrayList<student> std = new ArrayList<student>();
        File file = new File("student.ser");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        ListIterator li;
        if(file.isFile()){
            boolean found = false;
            ois = new ObjectInputStream(new FileInputStream(file));
            std = (ArrayList<student>)ois.readObject();
            ois.close();
            li = std.listIterator();
            while(li.hasNext()){
                student s = (student)li.next();
                if(s.getRegNo().equals(regNo)){
                    li.remove();
                    found = true;
                }
            }
            if(found){
                oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(std);
                oos.close();
                JOptionPane.showMessageDialog(null, "Record Deleted Successfully");
            }
            else{
                JOptionPane.showMessageDialog(null, "Record Not Found");

            }
        }
    }
}