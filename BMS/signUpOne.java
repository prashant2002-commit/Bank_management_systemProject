package BMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class signUpOne extends JFrame implements ActionListener {
    long random;
    JTextField Ntextfield,Ftextfield,Etextfield,Atextfield,Ctextfield,Stextfield,Ptextfield;
    JButton next;
    JRadioButton male,female,married,unmarried,others;
    JDateChooser dateChooser;
    signUpOne(){
            setLayout(null);

            Random ran = new Random();
            random = Math.abs((ran.nextLong() % 9000L)+1000L);

            JLabel Formno = new JLabel("APPLICATION FORM NO. "+ random);
            Formno.setFont(new Font("Raleway",Font.BOLD,38));
            Formno.setBounds(140,20,600,40);
            add(Formno);

            JLabel personaldetail = new JLabel("Page 1 : Personal Details");
            personaldetail.setFont(new Font("Raleway",Font.BOLD,22));
            personaldetail.setBounds(290,80,400,30);
            add(personaldetail);

            JLabel name = new JLabel("Name:");
            name.setFont(new Font("Raleway",Font.BOLD,20));
            name.setBounds(100,140,100,30);
            add(name);

            Ntextfield = new JTextField();
            Ntextfield.setFont(new Font("Raleway",Font.BOLD,14));
            Ntextfield.setBounds(300,140,400,30);
            add(Ntextfield);

            JLabel fname = new JLabel("Father's Name:");
            fname.setFont(new Font("Raleway",Font.BOLD,20));
            fname.setBounds(100,190,200,30);
            add(fname);

            Ftextfield = new JTextField();
            Ftextfield.setFont(new Font("Raleway",Font.BOLD,14));
            Ftextfield.setBounds(300,190,400,30);
            add(Ftextfield);

            JLabel dob = new JLabel("Date Of Birth:");
            dob.setFont(new Font("Raleway",Font.BOLD,20));
            dob.setBounds(100,240,200,30);
            add(dob);

            dateChooser = new JDateChooser();
            dateChooser.setForeground(new Color(105,105,105));
            dateChooser.setBounds(300,240,400,30);
            add(dateChooser);

            JLabel gender = new JLabel("Gender:");
            gender.setFont(new Font("Raleway",Font.BOLD,20));
            gender.setBounds(100,290,200,30);
            add(gender);

            male = new JRadioButton("Male");
            male.setBounds(300,290,60,30);
            male.setBackground(Color.WHITE);
            add(male);

            female = new JRadioButton("Female");
            female.setBounds(450,290,100,30);
            female.setBackground(Color.WHITE);
            add(female);

            ButtonGroup genderGroup = new ButtonGroup();
            genderGroup.add(male);
            genderGroup.add(female);

            JLabel email = new JLabel("Email Address:");
            email.setFont(new Font("Raleway",Font.BOLD,20));
            email.setBounds(100,340,200,30);
            add(email);

            Etextfield = new JTextField();
            Etextfield.setFont(new Font("Raleway",Font.BOLD,14));
            Etextfield.setBounds(300,340,400,30);
            add(Etextfield);

            JLabel Mstatus = new JLabel("Marital Status:");
            Mstatus.setFont(new Font("Raleway",Font.BOLD,20));
            Mstatus.setBounds(100,390,200,30);
            add(Mstatus);

            married = new JRadioButton("Married");
            married.setBounds(300,390,100,30);
            married.setBackground(Color.WHITE);
            add(married);

            unmarried = new JRadioButton("Unmarried");
            unmarried.setBounds(450,390,100,30);
            unmarried.setBackground(Color.WHITE);
            add(unmarried);

            others = new JRadioButton("Other");
            others.setBounds(600,390,100,30);
            others.setBackground(Color.WHITE);
            add(others);

            ButtonGroup MsGroup = new ButtonGroup();
            MsGroup.add(married);
            MsGroup.add(unmarried);
            MsGroup.add(others);

            JLabel address = new JLabel("Address:");
            address.setFont(new Font("Raleway",Font.BOLD,20));
            address.setBounds(100,440,200,30);
            add(address);

            Atextfield = new JTextField();
            Atextfield.setFont(new Font("Raleway",Font.BOLD,14));
            Atextfield.setBounds(300,440,400,30);
            add(Atextfield);

            JLabel city = new JLabel("City:");
            city.setFont(new Font("Raleway",Font.BOLD,20));
            city.setBounds(100,490,200,30);
            add(city);

            Ctextfield = new JTextField();
            Ctextfield.setFont(new Font("Raleway",Font.BOLD,14));
            Ctextfield.setBounds(300,490,400,30);
            add(Ctextfield);

            JLabel state = new JLabel("State:");
            state.setFont(new Font("Raleway",Font.BOLD,20));
            state.setBounds(100,540,200,30);
            add(state);

            Stextfield = new JTextField();
            Stextfield.setFont(new Font("Raleway",Font.BOLD,14));
            Stextfield.setBounds(300,540,400,30);
            add(Stextfield);


            JLabel pincode = new JLabel("Pin Code:");
            pincode.setFont(new Font("Raleway",Font.BOLD,20));
            pincode.setBounds(100,590,200,30);
            add(pincode);

            Ptextfield = new JTextField();
            Ptextfield.setFont(new Font("Raleway",Font.BOLD,14));
            Ptextfield.setBounds(300,590,400,30);
            add(Ptextfield);

            next = new JButton("Next");
            next.setBackground(Color.BLACK);
            next.setForeground(Color.WHITE);
            next.setBounds(620,660,80,20);
            next.addActionListener(this);
            add(next);

            getContentPane().setBackground(Color.WHITE);
            setSize(850,800);
            setVisible(true);
            setLocation(350,10);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }


        public static void main(String[] args) {
            new signUpOne();
        }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;
        String name = Ntextfield.getText();
        String fname = Ftextfield.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender ;
        if(male.isSelected()){
            gender = "male";
        }else{
            gender = "female";
        }
        String email = Etextfield.getText();
        String marital ;
        if(married.isSelected()){
            marital = "married";
        }else if(unmarried.isSelected()){
            marital = "unmarried";
        }else{
            marital = "others";
        }
        String address = Atextfield.getText();
        String city = Ctextfield.getText();
        String state = Stextfield.getText();
        String pincode = Ptextfield.getText();

        try{
            if (name.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Name");
            }else if (fname.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Father's Name");
            }else if (dob.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Date of Birth");
            }else if (gender.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Gender");
            }else if (email.equals("")){
                JOptionPane.showMessageDialog(null,"Enter EMail");
            }else if (marital.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Marrital Status");
            }else if (address.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Address");
            }else if (city.equals("")){
                JOptionPane.showMessageDialog(null,"Enter City");
            }else if (state.equals("")){
                JOptionPane.showMessageDialog(null,"Enter State");
            }else if (pincode.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Pincode");
            } else{
                conn c = new conn();
                String query = "insert into signup values('"+ formno +"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new signUpTwo(formno).setVisible(true);
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
}

