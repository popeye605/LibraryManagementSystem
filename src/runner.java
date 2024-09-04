import java.awt.*;
import java.io.IOException;
import javax.swing.*;


public class runner {
    public static void main(String[] args) {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        JLabel label = new JLabel();

        label.setIcon(new ImageIcon("C:\\Users\\NR\\Desktop\\uni stuff\\oop\\OOP final lib manag gui\\labFinal\\pimcs\\s.jpg"));
        label.setSize(2000,750);
        frame.setTitle("Login");
        panel.setLayout(null);
        frame.add(label);
        frame.add(panel);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //panel.setLayout(null);

        JLabel welcomeLabel = new JLabel("Online Library System");
        welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
        welcomeLabel.setBounds(510, 100, 600, 70);
        welcomeLabel.setForeground(Color.white);
        label.add(welcomeLabel);
        panel.add(label);
        //username label

        JLabel userName = new JLabel("UserName : ");
        userName.setBounds(530, 210, 100, 40);
        userName.setFont(new Font("Tahoma",Font.BOLD,14));
        userName.setForeground(Color.WHITE);
        userName.setBackground(Color.red);
        label.add(userName);

        JTextField userText = new JTextField();
        userText.setBounds(650, 220,220 , 23);
        panel.add(userText);

        //password label

        JLabel passwordLabel = new JLabel("Password : ");
        passwordLabel.setBounds(530, 280,100, 40);
        passwordLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBackground(Color.white);
        label.add(passwordLabel);


        JPasswordField password = new JPasswordField();
        password.setBounds(650, 290, 220, 23);
        panel.add(password);

        //login label
        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(650, 350, 100, 30);
        loginBtn.setForeground(Color.black);
        loginBtn.setFont(new Font("Tahoma",Font.BOLD,14));
        loginBtn.setBackground(Color.white);
        panel.add(loginBtn);
        loginBtn.addActionListener(e->{
            // frame for HOME PAGE
            JFrame frame2 = new JFrame();
            JPanel panel2 = new JPanel();
            JLabel label2 = new JLabel();
            label2.setIcon(new ImageIcon("C:\\Users\\NR\\Desktop\\uni stuff\\oop\\OOP final lib manag gui\\labFinal\\pimcs\\s1.jpg"));
            label2.setSize(2000,750);
            frame2.add(label2);


            frame2.add(panel2);
            frame2.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame2.setTitle("Home Page");
            panel2.setLayout(null);
            if(userText.getText().equals("admin")&&password.getText().equals("ansaar")){
                JOptionPane.showMessageDialog(null,  "Login successfully");
                frame.setVisible(false); //to make it temporarily disable or hide
                frame2.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null,  "Incorrect Username or password");
            }
            //Button for add student

            JButton addStudent = new JButton("Add Student");
            addStudent.setBounds(90, 60, 200, 60);
            addStudent.setForeground(Color.white);
            addStudent.setFont(new Font("Tahoma",Font.BOLD,14));
            addStudent.setBackground(Color.blue);
            panel2.add(addStudent);


            //ActionListener for add student
            addStudent.addActionListener(a->{
                JLabel labelName = new JLabel("First name");
                JLabel lNameLabel = new JLabel("Last name");
                JLabel labelCourse = new JLabel("Course");
                JLabel labelRegNo = new JLabel("Registration Number");
                JTextField fNameText = new JTextField();
                JTextField lNameText = new JTextField();
                JTextField courseText = new JTextField();
                JTextField regNoText = new JTextField();
                JButton saveBtn = new JButton("Save");
                JButton closeBtn = new JButton("Close");
                JPanel panel3 = new JPanel();
                JFrame frame3 = new JFrame("Add Student");
                JLabel label3 = new JLabel();
                label3.setIcon(new ImageIcon("C:\\Users\\NR\\Desktop\\uni stuff\\oop\\OOP final lib manag gui\\labFinal\\pimcs\\s2.jpg"));
                label3.setSize(560, 371);
                frame3.add(label3);
                frame3.add(panel3);
                frame3.setSize(560, 430);
                frame3.setLocationRelativeTo(null);
                panel3.setLayout(null);

                labelName.setBounds(96, 71, 100, 40);
                labelName.setFont(new Font("Tahoma",Font.BOLD,14));
                labelName.setForeground(Color.white);
                label3.add(labelName);

                lNameLabel.setBounds(96, 122, 100, 40);
                lNameLabel.setFont(new Font("Tahoma",Font.BOLD,14));
                lNameLabel.setForeground(Color.white);
                label3.add(lNameLabel);

                labelCourse.setBounds(96, 170, 100, 40);
                labelCourse.setFont(new Font("Tahoma",Font.BOLD,14));
                labelCourse.setForeground(Color.white);
                label3.add(labelCourse);

                labelRegNo.setBounds(96, 217, 160, 40);
                labelRegNo.setFont(new Font("Tahoma",Font.BOLD,14));
                labelRegNo.setForeground(Color.white);
                label3.add(labelRegNo);

                fNameText.setBounds(300, 70, 160, 23);
                panel3.add(fNameText);

                lNameText.setBounds(300, 120, 160,23);
                panel3.add(lNameText);

                courseText.setBounds(300, 170, 160, 23);
                panel3.add(courseText);

                regNoText.setBounds(300, 220, 160, 23);
                panel3.add(regNoText);

                frame3.setVisible(true);
                saveBtn.setBounds(280, 290, 100, 30);
                panel3.add(saveBtn);

                // Action listener for save button

                saveBtn.addActionListener(c->{
                    String n = regNoText.getText();
                    if(n.equalsIgnoreCase("")){
                        JOptionPane.showMessageDialog(null,"Please Enter Data");
                    }
                    else {
                        try {
                            //student.java mein data jayega
                            addStudentFile s = new addStudentFile(fNameText.getText(), lNameText.getText(),
                                    courseText.getText(), regNoText.getText());
                        } catch (IOException ex) {
                            System.out.println("Some Error....");
                        } catch (ClassNotFoundException ex) {
                            System.out.println("Some Error....");
                        }
                    }

                });

                // Close button
                closeBtn.setBounds(390, 290, 100, 30);
                panel3.add(closeBtn);

                closeBtn.addActionListener(b->{
                    frame3.setVisible(false);
                    frame2.setVisible(true);
                });
            });


            JButton newBook = new JButton("New Book");
            newBook.setBounds(90, 150, 200, 60);
            newBook.setForeground(Color.white);
            newBook.setFont(new Font("Tahoma",Font.BOLD,14));
            newBook.setBackground(Color.blue);
            panel2.add(newBook);

            // Action Listener for New Book
            newBook.addActionListener(c->{
                JLabel idLabel = new JLabel("Book ID");
                JLabel bookLabel = new JLabel("Book Name");
                JLabel authorLabel = new JLabel("Author Name");
                JLabel pubLabel = new JLabel("Publisher Name");
                JLabel genreLabel = new JLabel("Genre");
                JLabel priceLabel = new JLabel("Price");
                JTextField idText = new JTextField();
                JTextField bookText = new JTextField();
                JTextField authorText = new JTextField();
                JTextField pubText = new JTextField();
                JTextField numOfBookText = new JTextField();
                JTextField priceText = new JTextField();
                JButton saveBtn = new JButton("Save");
                JButton closeBtn = new JButton("Close");
                JFrame frame4 = new JFrame("New Book");
                JPanel panel4 = new JPanel();
                JLabel label5 = new JLabel();
                label5.setIcon(new ImageIcon("C:\\Users\\NR\\Desktop\\uni stuff\\oop\\OOP final lib manag gui\\labFinal\\pimcs\\s3.jpg"));
                label5.setSize(560,560);
                frame4.add(label5);
                frame4.add(panel4);
                frame4.setSize(560, 560);
                frame4.setLocationRelativeTo(null);
                panel4.setLayout(null);

                idText.setBounds(300, 70, 200, 23);
                panel4.add(idText);

                bookText.setBounds(300, 110, 200, 23);
                panel4.add(bookText);

                authorText.setBounds(300, 150, 200, 23);
                panel4.add(authorText);

                pubText.setBounds(300, 190, 200, 23);
                panel4.add(pubText);

                numOfBookText.setBounds(300, 230, 200, 23);
                panel4.add(numOfBookText);

                priceText.setBounds(300, 270, 200, 23);
                panel4.add(priceText);


                idLabel.setBounds(130, 65, 70, 40);
                idLabel.setFont(new Font("Tahoma",Font.BOLD,14));
                idLabel.setForeground(Color.white);
                label5.add(idLabel);

                bookLabel.setBounds(130, 100, 160, 40);
                bookLabel.setFont(new Font("Tahoma",Font.BOLD,14));
                bookLabel.setForeground(Color.white);
                label5.add(bookLabel);

                authorLabel.setBounds(130, 140, 160, 40);
                authorLabel.setFont(new Font("Tahoma",Font.BOLD,14));
                authorLabel.setForeground(Color.white);
                label5.add(authorLabel);

                pubLabel.setBounds(130, 180, 160, 40);
                pubLabel.setFont(new Font("Tahoma",Font.BOLD,14));
                pubLabel.setForeground(Color.white);
                label5.add(pubLabel);

                genreLabel.setBounds(130, 220, 160, 40);
                genreLabel.setFont(new Font("Tahoma",Font.BOLD,14));
                genreLabel.setForeground(Color.white);
                label5.add(genreLabel);

                priceLabel.setBounds(130, 260, 160, 40);
                priceLabel.setFont(new Font("Tahoma",Font.BOLD,14));
                priceLabel.setForeground(Color.white);
                label5.add(priceLabel);




                frame4.setVisible(true);

                saveBtn.setBounds(300, 310, 100, 30);
                panel4.add(saveBtn);


                //Action for adding book

                saveBtn.addActionListener(g->{

                    String m = idText.getText();
                    if(m.equalsIgnoreCase("")){
                        JOptionPane.showMessageDialog(null,"Please Enter Book details");
                    }
                    else {
                        Boook b = new Boook(idText.getText());

                        b.addBook(idText.getText());
                    }
                    //try {
                    //file code
                    //addBook b = new addBook(idText.getText(),bookText.getText(),
                    //authorText.getText(),pubText.getText());
                    //} catch (IOException ex) {
                    //System.out.println("Some Error....");
                    //} catch (ClassNotFoundException ex) {
                    //System.out.println("Some Error....");
                    //}



                });

                closeBtn.setBounds(410, 310, 100, 30);
                panel4.add(closeBtn);
                closeBtn.addActionListener(d->{
                    frame4.setVisible(false);
                    frame2.setVisible(true);

                });
            });


            // New Button issue Book


            JButton issueBook = new JButton("Issue Book");
            issueBook.setBounds(90, 250,200, 60);
            issueBook.setForeground(Color.white);
            issueBook.setFont(new Font("Tahoma",Font.BOLD,14));
            issueBook.setBackground(Color.blue);
            panel2.add(issueBook);

            // Action listener for issueBook
            issueBook.addActionListener(d->{
                JLabel idLabel = new JLabel("Book ID");
                JLabel regLabel = new JLabel("Registration Number");
                JLabel issueLabel = new JLabel("Issue Date");
                JLabel dueLabel = new JLabel("Due Date");
                JTextField idText = new JTextField();
                JTextField regText = new JTextField();
                JTextField issueText = new JTextField();
                JTextField dueText = new JTextField();
                JButton saveBtn = new JButton("Save");
                JButton closeBtn = new JButton("Close");
                JFrame frame5 = new JFrame("Issue Book");
                JPanel panel5 = new JPanel();

                frame5.setSize(560, 373);
                JLabel label4 = new JLabel();
                label4.setIcon(new ImageIcon("C:\\Users\\NR\\Desktop\\uni stuff\\oop\\OOP final lib manag gui\\labFinal\\pimcs\\s4.jpg"));
                label4.setSize(560, 373);
                frame5.add(label4);
                frame5.add(panel5);
                //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame5.setLocationRelativeTo(null);
                panel5.setLayout(null);

                idLabel.setBounds(96, 68, 100, 40);
                idLabel.setFont(new Font("Tahoma",Font.BOLD,14));
                idLabel.setForeground(Color.white);
                label4.add(idLabel);

                regLabel.setBounds(96, 112, 160, 40);
                regLabel.setFont(new Font("Tahoma",Font.BOLD,14));
                regLabel.setForeground(Color.white);
                label4.add(regLabel);

                issueLabel.setBounds(96, 162, 100, 40);
                issueLabel.setFont(new Font("Tahoma",Font.BOLD,14));
                issueLabel.setForeground(Color.white);
                label4.add(issueLabel);

                dueLabel.setBounds(96, 212, 160, 40);
                dueLabel.setFont(new Font("Tahoma",Font.BOLD,14));
                dueLabel.setForeground(Color.white);
                label4.add(dueLabel);

                idText.setBounds(300, 70, 160, 23);
                panel5.add(idText);

                regText.setBounds(300, 120, 160,23);
                panel5.add(regText);

                issueText.setBounds(300, 170, 160, 23);
                panel5.add(issueText);

                dueText.setBounds(300, 220, 160, 23);
                panel5.add(dueText);

                frame5.setVisible(true);
                saveBtn.setBounds(280, 290, 100, 30);
                panel5.add(saveBtn);

                saveBtn.addActionListener(h->{
                    Boook b = new Boook(idText.getText());

                    b.issueBook(idText.getText());
                    //file code
                    //issueBook i = new issueBook(regText.getText(),idText.getText());
                    //} catch (IOException ex) {
                    //System.out.println("Some Error....");
                    // } catch (ClassNotFoundException ex) {
                    //  System.out.println("Some Error....");
                    // }


                });



                closeBtn.setBounds(390, 290, 100, 30);
                panel5.add(closeBtn);
                closeBtn.addActionListener(f->{
                    frame5.setVisible(false);
                    frame2.setVisible(true);

                });
            });

            // New Button Stats

            JButton stats = new JButton("Statistics");
            stats.setBounds(90, 350, 200, 60);
            stats.setForeground(Color.white);
            stats.setFont(new Font("Tahoma",Font.BOLD,14));
            stats.setBackground(Color.blue);
            panel2.add(stats);


            stats.addActionListener(z->{
                JFrame frame12 = new JFrame("Statistics");
                JPanel panel12 = new JPanel();
                JLabel label4 = new JLabel();
                label4.setIcon(new ImageIcon("C:\\Users\\NR\\Desktop\\uni stuff\\oop\\OOP final lib manag gui\\labFinal\\pimcs\\s5.jpg"));
                label4.setSize(560, 373);
                frame12.add(label4);
                frame12.add(panel12);
                frame12.setSize(560, 373);
                frame12.setLocationRelativeTo(null);
                panel12.setLayout(null);
                JButton numBookBtn = new JButton("Total Books");
                numBookBtn.setBounds(96, 112, 160, 40);
                panel12.add(numBookBtn);

                numBookBtn.addActionListener(x->{
                    stats s = new stats();
                    try {
                        s.numOfBooks();
                    } catch (IOException ex) {
                        System.out.println("Some Error....");
                    } catch (ClassNotFoundException ex) {
                        System.out.println("Some Error....");
                    }
                });

                JButton numStuBtn = new JButton("Total Student");
                numStuBtn.setBounds(96, 162, 160, 40);
                panel12.add(numStuBtn);
                numStuBtn.addActionListener(v->{
                    stats s = new stats();
                    try {
                        s.numOfStudent();
                    } catch (IOException ex) {
                        System.out.println("Some Error....");
                    } catch (ClassNotFoundException ex) {
                        System.out.println("Some Error....");
                    }
                });


                JButton numIssueBtn = new JButton("Total Issued");
                numIssueBtn.setBounds(96, 212, 160, 40);
                panel12.add(numIssueBtn);

                numIssueBtn.addActionListener(q->{
                    stats s = new stats();
                    try {
                        s.numOfIssued();
                    } catch (IOException ex) {
                        System.out.println("Some Error....");
                    } catch (ClassNotFoundException ex) {
                        System.out.println("Some Error....");
                    }
                });

                JButton closeBtn = new JButton("Close");
                closeBtn.setBounds(96,262,160,40);
                panel12.add(closeBtn);
                frame12.setVisible(true);
                closeBtn.addActionListener(j->{
                    frame12.setVisible(false);
                    frame2.setVisible(true);
                });

            });

            // Return Book

            JButton returnBook = new JButton("Return Book");
            returnBook.setBounds(90, 450, 200, 60);
            returnBook.setForeground(Color.white);
            returnBook.setFont(new Font("Tahoma",Font.BOLD,14));
            returnBook.setBackground(Color.blue);
            panel2.add(returnBook);

            //Action listener for return Book

            returnBook.addActionListener(i->{
                JLabel idLabel = new JLabel("Book ID");
                JLabel regLabel = new JLabel("Registration Number");
                JLabel issueLabel = new JLabel("Issue Date");
                JLabel dueLabel = new JLabel("Due Date");
                JTextField idText = new JTextField();
                JTextField regText = new JTextField();
                JTextField issueText = new JTextField();
                JTextField dueText = new JTextField();
                JButton saveBtn = new JButton("Save");
                JButton closeBtn = new JButton("Close");
                JFrame frame7 = new JFrame("Return Book");
                JPanel panel7 = new JPanel();
                frame7.setSize(560, 374);
                JLabel label4 = new JLabel();
                label4.setIcon(new ImageIcon("C:\\Users\\NR\\Desktop\\uni stuff\\oop\\OOP final lib manag gui\\labFinal\\pimcs\\s6.jpg"));
                label4.setSize(560, 374);
                frame7.add(label4);
                frame7.add(panel7);
                // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame7.setLocationRelativeTo(null);
                panel7.setLayout(null);

                idLabel.setBounds(96, 68, 100, 40);
                idLabel.setFont(new Font("Tahoma",Font.BOLD,14));
                idLabel.setForeground(Color.white);
                label4.add(idLabel);

                regLabel.setBounds(96, 112, 160, 40);
                regLabel.setFont(new Font("Tahoma",Font.BOLD,14));
                regLabel.setForeground(Color.white);
                label4.add(regLabel);

                issueLabel.setBounds(96, 162, 100, 40);
                issueLabel.setFont(new Font("Tahoma",Font.BOLD,14));
                issueLabel.setForeground(Color.white);
                label4.add(issueLabel);

                dueLabel.setBounds(96, 212, 160, 40);
                dueLabel.setFont(new Font("Tahoma",Font.BOLD,14));
                dueLabel.setForeground(Color.white);
                label4.add(dueLabel);

                idText.setBounds(300, 70, 160, 23);
                panel7.add(idText);

                regText.setBounds(300, 120, 160,23);
                panel7.add(regText);

                issueText.setBounds(300, 170, 160, 23);
                panel7.add(issueText);

                dueText.setBounds(300, 220, 160, 23);
                panel7.add(dueText);

                saveBtn.setBounds(280, 290, 100, 30);
                panel7.add(saveBtn);

                frame7.setVisible(true);
                //Action listener for savebtn
                // Return bookk

                saveBtn.addActionListener(k->{
                    Boook b = new Boook(idText.getText());

                    b.returnBook();
                // try {
                // //file code
                //returnBook b = new returnBook(idText.getText());
                // } catch (IOException ex) {
                //  System.out.println("Some Error....");
                // } catch (ClassNotFoundException ex) {
                //  System.out.println("Some Error....");
                // }
                //


                });

                closeBtn.setBounds(390, 290, 100, 30);
                panel7.add(closeBtn);

                closeBtn.addActionListener(j->{
                    frame7.setVisible(false);
                    frame2.setVisible(true);
                });

            });


            // New Button Delete Student

            JButton delStudent = new JButton("Delete Student");
            delStudent.setBounds(90, 550, 200, 60);
            delStudent.setForeground(Color.white);
            delStudent.setFont(new Font("Tahoma",Font.BOLD,14));
            delStudent.setBackground(Color.blue);
            panel2.add(delStudent);

            // Action listener for del Student
            delStudent.addActionListener(l->{
                JLabel labelName = new JLabel("First name");
                JLabel lNameLabel = new JLabel("Last name");
                JLabel labelCourse = new JLabel("Course");
                JLabel labelRegNo = new JLabel("Registration Number");
                JTextField fNameText = new JTextField();
                JTextField lNameText = new JTextField();
                JTextField courseText = new JTextField();
                JTextField regNoText = new JTextField();
                JButton saveBtn = new JButton("Delete");
                JButton closeBtn = new JButton("Close");
                JPanel panel8 = new JPanel();
                JFrame frame8 = new JFrame("Delete Student");
                JLabel label4 = new JLabel();
                label4.setIcon(new ImageIcon("C:\\Users\\NR\\Desktop\\uni stuff\\oop\\OOP final lib manag gui\\labFinal\\pimcs\\s7.jpg"));
                label4.setSize(560, 840);
                frame8.add(label4);
                frame8.add(panel8);
                frame8.setSize(560, 840);
                frame8.setLocationRelativeTo(null);
                panel8.setLayout(null);
                labelName.setBounds(96, 65, 100, 40);
                labelName.setFont(new Font("Tahoma",Font.BOLD,14));
                labelName.setForeground(Color.white);
                label4.add(labelName);

                lNameLabel.setBounds(96, 116, 100, 40);
                lNameLabel.setFont(new Font("Tahoma",Font.BOLD,14));
                lNameLabel.setForeground(Color.white);
                label4.add(lNameLabel);


                labelCourse.setBounds(96, 163, 100, 40);
                labelCourse.setFont(new Font("Tahoma",Font.BOLD,14));
                labelCourse.setForeground(Color.white);
                label4.add(labelCourse);

                labelRegNo.setBounds(96, 212, 160, 40);
                labelRegNo.setFont(new Font("Tahoma",Font.BOLD,14));
                labelRegNo.setForeground(Color.white);
                label4.add(labelRegNo);

                fNameText.setBounds(280, 70, 190, 23);
                panel8.add(fNameText);

                lNameText.setBounds(280, 120, 190,23);
                panel8.add(lNameText);

                courseText.setBounds(280, 170, 190, 23);
                panel8.add(courseText);

                regNoText.setBounds(280, 220, 190, 23);
                panel8.add(regNoText);


                saveBtn.setBounds(280, 290, 100, 30);
                panel8.add(saveBtn);

                //Action listner for save button for delete

                saveBtn.addActionListener(m->{
                    try {
                        deleteStudent del = new deleteStudent(fNameText.getText(),lNameText.getText(),courseText.getText(),regNoText.getText());
                    } catch (IOException ex) {
                        System.out.println("Some Error....");
                    } catch (ClassNotFoundException ex) {
                        System.out.println("Some Error....");
                    }


                });

                closeBtn.setBounds(390, 290, 100, 30);
                panel8.add(closeBtn);
                closeBtn.addActionListener(j->{
                    frame8.setVisible(false);
                    frame2.setVisible(true);
                });

                frame8.setVisible(true);


            });

            JButton logout = new JButton("Logout");
            logout.setBounds(1000, 550, 200, 60);
            logout.setForeground(Color.white);
            logout.setFont(new Font("Tahoma",Font.BOLD,14));
            logout.setBackground(Color.blue);
            panel2.add(logout);

            logout.addActionListener(m->{
                userText.setText("");
                password.setText("");
                frame2.setVisible(false);
                frame.setVisible(true);
            });


            //frame2.setVisible(true);
            //frame.setVisible(false);
        });

        //home screen close button
        JButton close = new JButton("Close");
        close.setBounds(770, 350, 100, 30);
        close.setForeground(Color.black);
        close.setFont(new Font("Tahoma",Font.BOLD,14));
        close.setBackground(Color.white);
        panel.add(close);

        close.addActionListener(l->{
            System.exit(0);
        });
        frame.setVisible(true);
    }

}
