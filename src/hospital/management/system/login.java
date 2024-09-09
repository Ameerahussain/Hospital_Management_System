package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {

    JTextField textField;

    JPasswordField jPasswordField;

    JButton b1,b2;

    login(){

        JLabel nameLabel=new JLabel("Username");
        nameLabel.setBounds(40,20,100,30);
        nameLabel.setFont(new Font("Tahoma",Font.BOLD,16));
        nameLabel.setForeground(Color.BLACK);
        add(nameLabel);

        JLabel password=new JLabel("Password");
        password.setBounds(40,70,100,30);
        password.setFont(new Font("Tahoma",Font.BOLD,16));
        password.setForeground(Color.BLACK);
        add( password);

        textField = new JTextField();
        textField.setBounds(150,20,150,30);
        textField.setFont(new Font("Tahoma",Font.BOLD,15));
        textField.setBackground(new Color(255,179,0));
        add(textField);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(150,70,150,30);
        jPasswordField.setFont(new Font("Tahoma",Font.PLAIN,15));
        jPasswordField.setBackground(new Color(255,179,0));
        add(jPasswordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Login.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel Label = new JLabel(imageIcon1);
        Label.setBounds(300,30,400,300);
        add(Label);

        b1 = new JButton("Login");
        b1.setBounds(48,140,120,30);
        b1.setFont(new Font("Serif",Font.PLAIN,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("Serif",Font.PLAIN,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(new Color(109, 164, 170));
        setSize(750,300);
        setLocation(400,270);
        setLayout(null);
        setVisible(true);



    }
    public static  void main(String[]args){
        new login();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==b1){

            try {
                conn c = new conn();
                String User = textField.getText();
                String Pass = jPasswordField.getText();

                String q = "select * from login where ID = '"+User+"' and PW = '"+Pass+"' ";

                ResultSet resultSet = c.statement.executeQuery(q);

                if (resultSet.next()){
                    new Reception();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid");

                }

            }catch (Exception E){
                E.printStackTrace();

            }
            }else {
            System.exit(10);
        }
        }

    }
