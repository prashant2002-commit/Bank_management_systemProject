package BMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;

public class Fastcash extends JFrame implements ActionListener {

    JButton hundred,fivehundred,thousand,twoThousand,fiveThousand,tenThousand,back;
    String pinnumber;

    Fastcash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        hundred = new JButton("Rs 100");
        hundred.setBounds(170,415,150,30);
        hundred.addActionListener(this);
        image.add(hundred);

        fivehundred = new JButton("RS 500");
        fivehundred.setBounds(355,415,150,30);
        fivehundred.addActionListener(this);
        image.add(fivehundred);

        thousand = new JButton("Rs 1000");
        thousand.setBounds(170,450,150,30);
        thousand.addActionListener(this);
        image.add(thousand);

        twoThousand = new JButton("Rs 2000");
        twoThousand.setBounds(355,450,150,30);
        twoThousand.addActionListener(this);
        image.add(twoThousand);

        fiveThousand= new JButton("Rs 5000");
        fiveThousand.setBounds(170,485,150,30);
        fiveThousand.addActionListener(this);
        image.add(fiveThousand);

        tenThousand = new JButton("Rs 10000");
        tenThousand.setBounds(355,485,150,30);
        tenThousand.addActionListener(this);
        image.add(tenThousand);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new transaction(pinnumber).setVisible(true);
        }else if(!(ae.getSource() == back)) {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            conn Conn =new conn();
            try {
                ResultSet resultSet = Conn.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
                int balance = 0;
                while(resultSet.next()){
                    if(resultSet.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    }else if (resultSet.getString("type").equals("withdrawl")) {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }
                if( balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values ('" + pinnumber + "','" + date + "','withdrawl', '" + amount + "')";
                Conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs " + amount + "Debited Successfully");

                setVisible(false);
                new transaction(pinnumber).setVisible(true);
            }catch (Exception e){
                System.out.println(e);
            }

        }

    }

    public static void main(String[] args) {
        new Fastcash("");
    }
}
