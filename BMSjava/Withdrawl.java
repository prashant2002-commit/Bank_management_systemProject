package BMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdrawl,back;
    String pinnumber;
    Withdrawl(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,16));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        withdrawl = new JButton("Withdraw");
        withdrawl.setBounds(355,485,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdrawl){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount");
            }else {

                try{
                    conn Conn = new conn();

                    ResultSet resultSet = Conn.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
                    int balance = 0;
                    while(resultSet.next()){
                        if(resultSet.getString("type").equals("Deposit")){
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        }else if (resultSet.getString("type").equals("withdrawl")) {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if( balance < Integer.parseInt(number)){
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        return;
                    }
                    String query = "insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+number+"')";
                    Conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs " + number + " withdraw successfully");
                    setVisible(false);
                    new transaction(pinnumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }


            }

        }else if(ae.getSource() == back){
            setVisible(false);
            new transaction(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Withdrawl("");
    }

}
