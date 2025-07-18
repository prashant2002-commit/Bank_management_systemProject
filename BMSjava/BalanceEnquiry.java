package BMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceEnquiry extends JFrame implements ActionListener{

    JButton back;
    String pinnumber;
    BalanceEnquiry(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        int balance = 0;
        String query = "select * from bank where pin = '"+pinnumber+"'";
        conn c = new conn();
        try {
            ResultSet resultSet = c.s.executeQuery(query);
            while(resultSet.next()){
                if(resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else if (resultSet.getString("type").equals("withdrawl")) {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        JLabel text = new JLabel("Your Current Account Balance is Rs: "+ (balance));
        text.setForeground(Color.WHITE);
        text.setBackground(Color.BLACK);
        text.setBounds(170,300,400,30);
        image.add(text);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new transaction(pinnumber).setVisible(true);

    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
