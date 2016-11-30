package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;



public class Main extends JFrame {
    static JTable table1;
    static JButton add_Name;
    static JButton add_Age;
    static JButton add_Address;
    static JButton add_Contact;
    static JButton Save;
    static JTextField Name;
    static JTextField Age;
    static JTextField Address;
    static JTextField Contact;
    static JPasswordField jpass;
    static JLabel lab;


    String[] col_name = {"Name", "Score", "Contact"};
    String[][] Person = {{"John", "65", "087666"},{"Mark", "65", "087666"},
            { "Sean", "75", "087666"},{ "Sean", "75", "087666"} };

    String addName;
    String addAge;
    String addAddress;
    String addContact;

    String Password = "1234";

    String [][] Details;

    public Main(){
        table1 = new JTable(Person,col_name);
        JPanel jp = new JPanel();
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        JPasswordField jpass = new JPasswordField();


        add_Name = new JButton("Name");
        add_Age = new JButton("Age");
        add_Address = new JButton("Address");
        add_Contact = new JButton("Contact");
        Save = new JButton("Save");

        Name = new JTextField();
        Age = new JTextField();
        Address = new JTextField();
        Contact = new JTextField();

        lab =new JLabel("Enter Password");

        jp.add(add_Name);
        jp.add(add_Age);
        jp.add(add_Address);
        jp.add(add_Contact);

        jp1.add(Name);
        jp1.add(Age);
        jp1.add(Address);
        jp1.add(Contact);



     //   jp.add(lab);

        Container c = this.getContentPane();
        jp.setLayout(new FlowLayout());
        jp1.setLayout(new FlowLayout());
        c.setLayout(new FlowLayout());//Set layout to be FlowLayout explicitly.
        add_Name.setPreferredSize(new Dimension(100,20));//use set PreferredSize
        add_Age.setPreferredSize(new Dimension(100,20));//use set PreferredSize
        add_Address.setPreferredSize(new Dimension(100,20));//use set PreferredSize
        add_Contact.setPreferredSize(new Dimension(100,20));//use set PreferredSize

        Name.setPreferredSize(new Dimension(150,20));
        Age.setPreferredSize(new Dimension(150,20));
        Address.setPreferredSize(new Dimension(150,20));
        Contact.setPreferredSize(new Dimension(150,20));
        jp.add(add_Name);
        jp.add(add_Age);
        jp.add(add_Address);
        jp.add(add_Contact);
        //jp.setSize(500, 500);
        jp.setVisible(true);
        jp2.setSize(new Dimension(50,50));
       //table1.setBounds(50,50,20,20);
        JScrollPane js = new JScrollPane(table1);







        jp1.setLayout(new GridBagLayout());
        //jp1.setBackground(Color.green);
        this.getContentPane().add(jp1);
        GridBagConstraints left = new GridBagConstraints();
        left.anchor = GridBagConstraints.EAST;
        GridBagConstraints right = new GridBagConstraints();
        right.weightx = 2.0;
        right.fill = GridBagConstraints.HORIZONTAL;
        right.gridwidth = GridBagConstraints.REMAINDER;
        jp1.add(add_Name, left);
        jp1.add(Name, right);
        jp1.add(add_Age, left);
        jp1.add(Age, right);
        jp1.add(add_Address, left);
        jp1.add(Address, right);
        jp1.add(add_Contact, left);
        jp1.add(Contact, right);
        jp1.add(lab, right);
        jp1.add(jpass,right);
        jp1.add(Save,left);
        jp1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.pack();






        this.add(jp2, BorderLayout.NORTH);
        this.add(js);
        this.add(jp1, BorderLayout.WEST);
       // this.add(lab);
       // this.add(add_Name);
        this.add(jp, BorderLayout.SOUTH);
        this.setSize(500,400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        add_Name.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addName = Name.getText();
            }
        });

        add_Address.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAddress = Address.getText();
            }
        });

        add_Age.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAge = Age.getText();
            }
        });

        add_Contact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addContact = Contact.getText();
            }
        });

        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pass1 = jpass.getText();
                StringBuilder Data = null;

                System.out.println("Password  " + pass1 + " the password = " + Password);
                if( Password == pass1){

                    System.out.println("Password works");
                    Data.append(add_Name + addAge + add_Contact);



                }
                else {
                    System.out.println("Password doesnt work");
                }
            }
        });
    }

    public static void main(String[] args) {

        new Main();

    }


}
