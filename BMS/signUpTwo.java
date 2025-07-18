package BMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signUpTwo extends JFrame implements ActionListener {
    JTextField Atextfield,Ptextfield;
    JButton next;
    JRadioButton Eno,Eyes,Syes,Sno;
    JComboBox  category,Religion,Income,education,occupation;
    String formno;

    signUpTwo(String formno){

        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,140,100,30);
        add(religion);

        String value[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        Religion = new JComboBox(value);
        Religion.setBounds(300,140,400,30);
        Religion.setBackground(Color.WHITE);
        add(Religion);


        JLabel Category = new JLabel("Category:");
        Category.setFont(new Font("Raleway",Font.BOLD,20));
        Category.setBounds(100,190,200,30);
        add(Category);

        String CategoryValue[] = {"General","SC","ST","OBC"};
        category = new JComboBox(CategoryValue);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);


        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add(income);

        String IncomeValue[] = {"NULL","<1,50,000","<2,50,000","<5,00,000","UPTO 10,00,000"};
        Income = new JComboBox(IncomeValue);
        Income.setBounds(300,240,400,30);
        Income.setBackground(Color.WHITE);
        add(Income);


        JLabel Education = new JLabel("Educational");
        Education.setFont(new Font("Raleway",Font.BOLD,20));
        Education.setBounds(100,290,200,30);
        add(Education);



        JLabel quali = new JLabel("Qualification:");
        quali.setFont(new Font("Raleway",Font.BOLD,20));
        quali.setBounds(100,315,200,30);
        add(quali);

        String edu[] = {"Non Graduate","Graduate","Post Graduate","Doctorate"};
        education = new JComboBox(edu);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);


        JLabel occupa = new JLabel("Occupation:");
        occupa.setFont(new Font("Raleway",Font.BOLD,20));
        occupa.setBounds(100,390,200,30);
        add(occupa);

        String occu[] = {"Salaried","Self-Employeed","Student","Ritired","Business"};
        occupation = new JComboBox(occu);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);


        JLabel aadhar = new JLabel("Aadhaar Number:");
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar.setBounds(100,440,200,30);
        add(aadhar);

        Atextfield = new JTextField();
        Atextfield.setFont(new Font("Raleway",Font.BOLD,14));
        Atextfield.setBounds(300,440,400,30);
        add(Atextfield);

        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,490,200,30);
        add(pan);

        Ptextfield = new JTextField();
        Ptextfield.setFont(new Font("Raleway",Font.BOLD,14));
        Ptextfield.setBounds(300,490,400,30);
        add(Ptextfield);

        JLabel citizen = new JLabel("Senior Citizen:");
        citizen.setFont(new Font("Raleway",Font.BOLD,20));
        citizen.setBounds(100,540,200,30);
        add(citizen);

        Syes = new JRadioButton("Yes");
        Syes.setBounds(300,540,100,30);
        Syes.setBackground(Color.WHITE);
        add(Syes);

        Sno = new JRadioButton("No");
        Sno.setBounds(450,540,100,30);
        Sno.setBackground(Color.WHITE);
        add(Sno);

        ButtonGroup Sgroup = new ButtonGroup();
        Sgroup.add(Syes);
        Sgroup.add(Sno);

        JLabel Eaccount = new JLabel("Existing Account:");
        Eaccount.setFont(new Font("Raleway",Font.BOLD,20));
        Eaccount.setBounds(100,590,200,30);
        add(Eaccount);

        Eyes = new JRadioButton("Yes");
        Eyes.setBounds(300,590,100,30);
        Eyes.setBackground(Color.WHITE);
        add(Eyes);

        Eno = new JRadioButton("No");
        Eno.setBounds(450,590,100,30);
        Eno.setBackground(Color.WHITE);
        add(Eno);

        ButtonGroup Egroup = new ButtonGroup();
        Egroup.add(Eyes);
        Egroup.add(Eno);


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
        new signUpTwo("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String SReligion = (String) Religion.getSelectedItem();
        String Scategory = (String) category.getSelectedItem();
        String Sincome = (String) Income.getSelectedItem();
        String Seducation = (String) education.getSelectedItem();
        String Soccupation = (String)occupation.getSelectedItem();
        String Saadhar = Atextfield.getText();
        String Spannum = Ptextfield.getText();
        String SeniorCitizen = null;
        if(Syes.isSelected()){
            SeniorCitizen = "yes";
        }else if(Sno.isSelected()){
            SeniorCitizen = "no";
        }
        String existingAccount = null;
        if(Eyes.isSelected()){
            existingAccount = "yes";
        }else if(Eno.isSelected()){
            existingAccount = "no";
        }

        try{
            if (SReligion.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Name");
            }else if (Scategory.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Father's Name");
            }else if (Sincome.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Date of Birth");
            }else if (Seducation.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Gender");
            }else if (Soccupation.equals("")){
                JOptionPane.showMessageDialog(null,"Enter EMail");
            }else if (Saadhar.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Marrital Status");
            }else if (Spannum.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Address");
            }else if (SeniorCitizen.equals("")){
                JOptionPane.showMessageDialog(null,"Enter City");
            }else if (existingAccount.equals("")){
                JOptionPane.showMessageDialog(null,"Enter State");
            }
            else{
                conn c = new conn();
                String query = "insert into signuptwo values('"+ formno +"','"+SReligion+"','"+Scategory+"','"+Sincome+"','"+Seducation+"','"+Soccupation+"','"+Saadhar+"','"+Spannum+"','"+SeniorCitizen+"','"+existingAccount+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new signupthree(formno).setVisible(true);
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
