package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;



public class Main extends JFrame implements ActionListener {
    static JTable table1;
    static JButton add_Name;
    static JButton add_Age;
    static JButton add_Score;
    static JButton add_Contact;
    static JButton Save;
    static JTextField Name;
    static JTextField Age;
    static JTextField Score;
    static JTextField Contact;
    static JPasswordField jpass;
    static JLabel lab;


    JTextField cardMain,card1,card2,card3;
    JTextField score1;
    JButton btnNewGame,btnLower,btnHigher,btnStartGame;

    int main,Card_1,Card_2,Card_3;
    String card[] = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    String hint,first,second,third;
    int TRIES = 1,chances = 3,score = 0;;
    int MAX_SCORE = 100 ;

    String[] col_name = {"Name", "Age", "Contact","Score"};
    String[][] Person = {{"John", "65", "087666","12"},{"Mark", "65", "087666","13"},
            { "Sean", "75", "087666","24"},{ "Sean", "75", "087666","34"} };

    String addName;
    String addAge;
    String addScore;
    String addContact;

    String Password = "1234";

    String [][] Details;

    public Main(){


        int R = (int) (250 * Math.random());
        int G = (int) (250 * Math.random());
        int B = (int) (250 * Math.random());

        Color color = new Color(R,G,B);

        cardMain = new JTextField(20);
        cardMain.setBounds(55,30,190,220);
        cardMain.setFont(new Font("Arial",Font.BOLD,220));
        cardMain.setEditable(false);
        cardMain.setBackground(Color.lightGray);
        cardMain.setForeground(color);
        cardMain.setBorder(BorderFactory.createEtchedBorder());
        add(cardMain);

        card1 = new JTextField(20);
        card1.setBounds(260,30,190,220);
        card1.setFont(new Font("Arial",Font.BOLD,220));
        card1.setEditable(false);
        card1.setVisible(false);
        card1.setBackground(Color.lightGray);
        card1.setForeground(color);
        card1.setBorder(BorderFactory.createEtchedBorder());
        add(card1);

        card2 = new JTextField(20);
        card2.setBounds(510,30,190,220);
        card2.setFont(new Font("Arial",Font.BOLD,220));
        card2.setEditable(false);
        card2.setVisible(false);
        card2.setBackground(Color.lightGray);
        card2.setForeground(color);
        card2.setBorder(BorderFactory.createEtchedBorder());
        add(card2);

        card3 = new JTextField(20);
        card3.setBounds(760,30,190,220);
        card3.setFont(new Font("Arial",Font.BOLD,220));
        card3.setEditable(false);
        card3.setVisible(false);
        card3.setBackground(Color.lightGray);
        card3.setForeground(color);
        card3.setBorder(BorderFactory.createEtchedBorder());
        add(card3);

        btnStartGame = new JButton("Start Game");
        btnStartGame.setBounds(150,320,250,60);
        btnStartGame.setFont(new Font("Serif",Font.BOLD,24));
        btnStartGame.setForeground(Color.green);
        add(btnStartGame);

        btnNewGame = new JButton("New Game");
        btnNewGame.setBounds(150,320,250,60);
        btnNewGame.setFont(new Font("Serif",Font.BOLD,24));
        btnNewGame.setForeground(Color.green);
        btnNewGame.setVisible(false);
        add(btnNewGame);

        btnHigher = new JButton("Higher");
        btnHigher.setBounds(350,320,180,60);
        btnHigher.setFont(new Font("Serif",Font.BOLD,24));
        btnHigher.setForeground(Color.blue);
        btnHigher.setEnabled(false);
        add(btnHigher);

        btnLower = new JButton("Lower");
        btnLower.setBounds(650,320,180,60);
        btnLower.setFont(new Font("Serif",Font.BOLD,24));
        btnLower.setForeground(Color.red);
        btnLower.setEnabled(false);
        add(btnLower);

        score1 = new JTextField("Your Score: " + score);
        score1.setBounds(240,400,500,50);
        score1.setFont(new Font("Serif",Font.BOLD,24));
        score1.setBackground(Color.black);
        score1.setForeground(Color.yellow);
        score1.setEditable(false);
        score1.setBorder(BorderFactory.createEtchedBorder());
        add(score1);

        btnNewGame.requestFocus();
        btnStartGame.addActionListener(this);
        btnNewGame.addActionListener(this);
        btnHigher.addActionListener(this);
        btnLower.addActionListener(this);

        table1 = new JTable(Person,col_name);
        JPanel jp = new JPanel();
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        JPasswordField jpass = new JPasswordField();


        add_Name = new JButton("Name");
        add_Age = new JButton("Age");
        add_Score = new JButton("Score");
        add_Contact = new JButton("Contact");
        Save = new JButton("Save");

        Name = new JTextField();
        Age = new JTextField();
        Score = new JTextField();
        Contact = new JTextField();

        lab =new JLabel("Enter Password");

        jp.add(add_Name);
        jp.add(add_Age);
        jp.add(add_Score);
        jp.add(add_Contact);

        jp1.add(Name);
        jp1.add(Age);
        jp1.add(Score);
        jp1.add(Contact);


        Container c = this.getContentPane();
        jp.setLayout(new FlowLayout());
        jp1.setLayout(new FlowLayout());
        c.setLayout(new FlowLayout());//Set layout to be FlowLayout explicitly.
        add_Name.setPreferredSize(new Dimension(100,20));//use set PreferredSize
        add_Age.setPreferredSize(new Dimension(100,20));//use set PreferredSize
        add_Score.setPreferredSize(new Dimension(100,20));//use set PreferredSize
        add_Contact.setPreferredSize(new Dimension(100,20));//use set PreferredSize

        Name.setPreferredSize(new Dimension(150,20));
        Age.setPreferredSize(new Dimension(150,20));
        Score.setPreferredSize(new Dimension(150,20));
        Contact.setPreferredSize(new Dimension(150,20));
        jp.add(add_Name);
        jp.add(add_Age);
        jp.add(add_Score);
        jp.add(add_Contact);

        jp.setVisible(true);
        jp2.setSize(new Dimension(50,50));

        JScrollPane js = new JScrollPane(table1);

        jp1.setLayout(new GridBagLayout());
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
        jp1.add(add_Contact, left);
        jp1.add(Contact, right);
        jp1.add(add_Score, left);
        jp1.add(Score, right);
        jp1.add(lab, right);
        jp1.add(jpass,right);
        jp1.add(Save,left);
        jp1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.pack();

        this.add(jp2, BorderLayout.NORTH);
        this.add(js);
        this.add(jp1, BorderLayout.WEST);
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

        add_Score.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addScore = Score.getText();
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


    public void gameStart()
    {
        main = (int) (12 * Math.random());
        Card_1 = (int) (12 * Math.random());
        Card_2 = (int) (12 * Math.random());
        Card_3 = (int) (12 * Math.random());

        hint= card[main];
        first = card[Card_1];
        second = card[Card_2];
        third = card[Card_3];
        cardMain.setText(""+hint);
    }

    public void displayStat()
    {
        if(TRIES<3)
        {
            ++TRIES;
        }
        else
        {

            btnHigher.setEnabled(false);
            btnLower.setEnabled(false);
            btnNewGame.setEnabled(true);
            btnNewGame.requestFocus();

            JOptionPane.showMessageDialog(null,"YOU GOT " + score + " OUT OF " + MAX_SCORE + ".\nMAYBE NEXT TIME!!!\n");

            continueGame();

        }
    }

    public void Random_Cards()
    {
        Card_1 = (int) (12 * Math.random());
        Card_2 = (int) (12 * Math.random());
        Card_3 = (int) (12 * Math.random());

        first = card[Card_1];
        second = card[Card_2];
        third = card[Card_3];

    }
    public void guessHigher()
    {
        if (TRIES==1)
        {
            btnNewGame.setEnabled(false);
            if(Card_1>main)
            {
                card1.setVisible(true);
                card1.setText(""+first);
                JOptionPane.showMessageDialog(null,"Right Well done!\n");
                score++;
                score1.setText("Your Score: " + score);

            }
            else if(Card_1==main)
            {
                card1.setVisible(true);
                card1.setText(""+first);
                JOptionPane.showMessageDialog(null,"Draw!\nSorry, No More TRIES!");
            }
            else
            {
                card1.setVisible(true);
                card1.setText(""+first);
                JOptionPane.showMessageDialog(null,"You lose!\nYou still have " + --chances + " tries.");

            }

        }
        else if (TRIES==2)
        {
            btnNewGame.setEnabled(false);
            if(Card_2>Card_1)
            {
                card2.setVisible(true);
                card2.setText(""+second);
                JOptionPane.showMessageDialog(null,"Right Well done!\n");
                score++;
                score1.setText("Your Score: " + score);
            }
            else if(Card_2==Card_1)
            {
                card2.setVisible(true);
                card2.setText(""+second);
                JOptionPane.showMessageDialog(null,"Draw!\nSorry, No More TRIES!");
            }
            else
            {
                card2.setVisible(true);
                card2.setText(""+second);
                JOptionPane.showMessageDialog(null,"You lose!\nYou still have " + --chances + " tries.");

            }

        }
        else
        {
            btnNewGame.setEnabled(false);
            if(Card_3>Card_2)
            {
                card3.setVisible(true);
                card3.setText(""+third);
                JOptionPane.showMessageDialog(null,"Right Well done!\n");
                score++;
                score1.setText("Your Score: " + score);
                Random_Cards();
                TRIES=1;


            }
            else if(Card_3==Card_2)
            {
                card3.setVisible(true);
                card3.setText(""+third);
                JOptionPane.showMessageDialog(null,"Draw!\nSorry, No More TRIES!");
            }
            else
            {
                card3.setVisible(true);
                card3.setText(""+third);
                JOptionPane.showMessageDialog(null,"You lose!\nYou still have " + --chances + " tries.");

            }
        }
    }

    public void guessLower()
    {
        if(TRIES==1)
        {
            btnNewGame.setEnabled(false);
            if(Card_1<main)
            {
                card1.setVisible(true);
                card1.setText(""+first);
                JOptionPane.showMessageDialog(null,"You win!\n Well done.");
                score++;
                score1.setText("Your Score: " + score);
            }
            else if(Card_1==main)
            {
                card1.setVisible(true);
                card1.setText(""+first);
                JOptionPane.showMessageDialog(null,"Draw!\nYou got lucky.");
            }
            else
            {
                card1.setVisible(true);
                card1.setText(""+first);
                JOptionPane.showMessageDialog(null,"You lose!\nYou still have " + --chances + " tries.");
            }
        }
        else if (TRIES==2)
        {
            btnNewGame.setEnabled(false);
            if(Card_2<Card_1)
            {
                card2.setVisible(true);
                card2.setText(""+second);
                JOptionPane.showMessageDialog(null,"You win!\n Well done.");
                score++;
                score1.setText("Your Score: " + score);
            }
            else if(Card_2==Card_1)
            {
                card2.setVisible(true);
                card2.setText(""+second);
                JOptionPane.showMessageDialog(null,"Draw!\nYou got lucky.");
            }
            else
            {
                card2.setVisible(true);
                card2.setText(""+second);
                JOptionPane.showMessageDialog(null,"You lose!\nYou still have " + --chances + " tries.");
            }
        }
        else
        {
            btnNewGame.setEnabled(false);
            if(Card_3<Card_2)
            {
                card3.setVisible(true);
                card3.setText(""+third);
                JOptionPane.showMessageDialog(null,"You win!\nSorry, No More TRIES!");
                score++;
                score1.setText("Your Score: " + score);
                Random_Cards();
                TRIES=1;
            }
            else if(Card_3==Card_2)
            {
                card3.setVisible(true);
                card3.setText(""+third);
                JOptionPane.showMessageDialog(null,"Draw!\nSorry, No More TRIES!");
            }
            else
            {
                card3.setVisible(true);
                card3.setText(""+third);
                JOptionPane.showMessageDialog(null,"You lose!\nSorry, No More TRIES!");
            }
        }
    }


    public void newGame()
    {

        TRIES = 1;
        chances = 3;
        score = 0;
        score1.setText("Your Score: " + score);
        card1.setText("");
        card2.setText("");
        card3.setText("");

        main = (int) (12 * Math.random());
        Card_1 = (int) (12 * Math.random());
        Card_2 = (int) (12 * Math.random());
        Card_3 = (int) (12 * Math.random());

        hint = card[main];
        first = card[Card_1];
        second = card[Card_2];
        third = card[Card_3];
        cardMain.setText(""+hint);

        btnHigher.setEnabled(true);
        btnLower.setEnabled(true);

    }

    public void invisible()
    {
        card1.setVisible(false);
        card2.setVisible(false);
        card3.setVisible(false);
    }

    public void startGame()
    {
        btnStartGame.setVisible(false);
        btnNewGame.setVisible(true);
        btnNewGame.setEnabled(true);
        btnHigher.setEnabled(true);
        btnLower.setEnabled(true);
    }

    public void stopGame()
    {
        btnStartGame.setVisible(false);
        btnNewGame.setVisible(false);
        btnHigher.setVisible(false);
        btnLower.setVisible(false);
        score1.setVisible(false);
        cardMain.setVisible(false);
        card1.setVisible(false);
        card2.setVisible(false);
        card3.setVisible(false);
    }

    public void continueGame()
    {
        int n = JOptionPane.showConfirmDialog(null,"Would you like to continue?","Lower or Higher",JOptionPane.YES_NO_OPTION);
        if(n==0)
        {
            startGame();
            btnNewGame.setEnabled(true);
            btnHigher.setEnabled(false);
            btnLower.setEnabled(false);

        }
        else
        {
            stopGame();

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnStartGame)
        {
            gameStart();
            startGame();
        }

        if(e.getSource()==btnHigher)
        {
            guessHigher();
            displayStat();
            startGame();
        }

        if(e.getSource()==btnLower)
        {
            guessLower();
            displayStat();
            startGame();
        }

        if(e.getSource()==btnNewGame)
        {
            newGame();
            invisible();
        }
    }
}
