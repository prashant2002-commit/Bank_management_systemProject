package BMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class signupthree extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    signupthree(String formno) {
        this.formno = formno;
        setLayout(null);

        JLabel l1 = new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account type:");
        type.setFont(new Font("raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 150, 20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 180, 200, 20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 150, 20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 250, 20);
        add(r4);

        ButtonGroup accountgroup = new ButtonGroup();
        accountgroup.add(r1);
        accountgroup.add(r2);
        accountgroup.add(r3);
        accountgroup.add(r4);

        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4523");
        number.setFont(new Font("raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 300, 30);
        add(number);

        JLabel cartdetails = new JLabel("Your 16 digit card number");
        cartdetails.setFont(new Font("raleway", Font.BOLD, 12));
        cartdetails.setBounds(100, 330, 300, 20);
        add(cartdetails);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);

        JLabel Pnumber = new JLabel("XXXX");
        Pnumber.setFont(new Font("raleway", Font.BOLD, 22));
        Pnumber.setBounds(330, 370, 300, 30);
        add(Pnumber);

        JLabel pindetails = new JLabel("Your 4 digit password");
        pindetails.setFont(new Font("raleway", Font.BOLD, 12));
        pindetails.setBounds(100, 400, 300, 20);
        add(pindetails);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("raleway", Font.BOLD, 22));
        services.setBounds(100, 450, 300, 30);
        add(services);

        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("raleway", Font.BOLD, 16));
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("raleway", Font.BOLD, 16));
        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("raleway", Font.BOLD, 16));
        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4 = new JCheckBox("Email and SMS alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("raleway", Font.BOLD, 16));
        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("raleway", Font.BOLD, 16));
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("raleway", Font.BOLD, 16));
        c6.setBounds(350, 500, 200, 30);
        add(c6);

        c7 = new JCheckBox("I here by declared that above declared details are correct");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("raleway", Font.BOLD, 12));
        c7.setBounds(100, 680, 600, 30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 730, 100, 20);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420, 730, 100, 20);
        cancel.addActionListener(this);
        add(cancel);

        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new signupthree("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String accountType = "";
            if(r1.isSelected()){
                accountType = "Savings Account";
            }else if(r2.isSelected()){
                accountType = "Fixed Deposit Account";
            }else if(r3.isSelected()){
                accountType = "Current Account";
            }else if(r4.isSelected()){
                accountType = "Reccurring Deposit Account";
            }
            Random random = new Random();
            String cardno = "" + Math.abs((random.nextLong() % 90000000l) + 5032053000000000l);
            String pinno = "" + Math.abs((random.nextLong() % 9000l) + 1000l);
            String facility = "";
            if(c1.isSelected()){
                facility = facility + "ATM Card";
            }else if(c2.isSelected()){
                facility = facility + "InterNet Banking";
            }else if(c3.isSelected()){
                facility = facility + "Mobile Banking";
            }else if(c4.isSelected()){
                facility = facility + "Email & SMS Alerts";
            }else if(c5.isSelected()){
                facility = facility + "Cheque Book";
            }else if(c6.isSelected()){
                facility = facility + "E Statement";
            }
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                }else if(facility.equals("")){
                    JOptionPane.showMessageDialog(null,"Please select facility");
                }else if(!(c7.isSelected())){
                    JOptionPane.showMessageDialog(null,"please confirm your detail");
                }
                else{
                    conn Conn = new conn();
                    String query1 = "insert into signupthree value ('"+ formno +"','"+ accountType+"','"+ cardno+"','"+pinno+"','"+ facility +"')";
                    String query2 = "insert into login value ('"+ formno +"','"+ cardno+"','"+ pinno +"')";

                    Conn.s.executeUpdate(query1);
                    Conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card no. = " + cardno +"\nPin no =" + pinno);

                    setVisible(false);
                    new Deposit(pinno).setVisible(true);
                }

            }catch (Exception ae){
                System.out.println(ae);
            }

        } else if (e.getSource() == cancel) {

            setVisible(false);
            new login().setVisible(true);
        }
    }
}