package BMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class login extends JFrame implements ActionListener{

    JButton login,clear,signup;
    JTextField t1;
    JPasswordField t2;

    login(){                            //code is written in this constructor to get a frame
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = image.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("osward",Font.BOLD,40));
        text.setBounds(250,40,400,40);
        add(text);

        JLabel cardno = new JLabel("Card no:");
        cardno.setFont(new Font("raleway",Font.BOLD,30));
        cardno.setBounds(120,140,400,40);
        add(cardno);

        t1 = new JTextField();
        t1.setBounds(300,150,300,35);
        t1.setFont(new Font("Arial",Font.BOLD,16));
        add(t1);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("raleway",Font.BOLD,30));
        pin.setBounds(120,220,400,40);
        add(pin);

        t2 = new JPasswordField();
        t2.setBounds(300,220,300,35);
        t2.setFont(new Font("Arial",Font.BOLD,16));
        add(t2);

        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(500,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(400,350,100,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);

        setSize(800,450);
        setVisible(true);
        setLocation(350,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            t1.setText("");
            t2.setText("");
        }else if(ae.getSource() == signup) {
            setVisible(false);
            new signUpOne().setVisible(true);
        }else if(ae.getSource() == login){
            conn Conn = new conn();
            String cardnumber = t1.getText();
            String pinnumber = t2.getText();
            String query = "select * from login where CardNumber = '" +cardnumber+"'and pin = '"+ pinnumber+"'";
            try{
                ResultSet rs = Conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new transaction(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number Or PIN");
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }

    public static void main(String[] args) {
        new login();                    //making an anonymous object  so that the constructor is called.
    }

}