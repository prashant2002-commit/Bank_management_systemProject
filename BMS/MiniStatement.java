package BMS;


import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    String miniStatement;

    MiniStatement(String pinnumber){
        setTitle("Mini Statement");

        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        JLabel bank = new JLabel("BANK OF INDIA");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel name = new JLabel();
        name.setBounds(20,100,300,20);
        add(name);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        ResultSet rs;
        try{
            conn c = new conn();
            rs = c.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number = " + rs.getString("CardNumber").substring(0,4) + "xxxxxxxx" + rs.getString("CardNumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try{
            int bal = 0;
            conn c = new conn();
            rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"' order by Date desc limit 10");
            miniStatement = "<html>";
            while(rs.next()){
                miniStatement += rs.getString("Date") +"      &nbsp &nbsp  &nbsp "+ rs.getString("type") +"  &nbsp &nbsp &nbsp         "+ rs.getString("amount") +"<br><hr>";
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }else if (rs.getString("type").equals("withdrawl")) {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            miniStatement += "</html>";
            balance.setText("Your current balance is Rs: " + bal);
        } catch (Exception e) {
            System.out.println(e);
        }
        mini.setForeground(Color.DARK_GRAY);
        mini.setText(miniStatement);


        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
