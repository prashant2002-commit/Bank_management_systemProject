package BMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pin,repin;
    JButton back,change;
    String pinnumber ;
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image.add(text);

        JLabel pintext = new JLabel("NEW PIN:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(165,320,180,25);
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(330,320,180,25);
        image.add(pin);

        JLabel repintext = new JLabel("Re-Enter NEW PIN:");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(165,360,180,25);
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(330,360,180,25);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
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
        if(ae.getSource() == change) {
            try {

                String npin = pin.getText();

                String rpin = repin.getText();
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN dose not match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter New PIN");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Re-Enter New PIN");
                    return;
                }

                conn Conn = new conn();
                String query1 = "update bank set pin = '" + rpin +"' where pin = '"+pinnumber+"'" ;
                String query2 = "update login set pin = '" + rpin +"' where pin = '"+pinnumber+"'" ;
                String query3 = "update signupthree set pin = '" + rpin +"' where pin = '"+pinnumber+"'" ;
                Conn.s.executeUpdate(query1);
                Conn.s.executeUpdate(query2);
                Conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN changed successfully");
                setVisible(false);
                new transaction(rpin).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new transaction(pinnumber);
        }
    }

    public static void main(String[] args) {
        new PinChange("");
    }
}
