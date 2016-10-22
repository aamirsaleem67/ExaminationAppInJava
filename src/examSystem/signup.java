/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examSystem;

/**
 *
 * @author ubit
 */
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.border.LineBorder;


public class signup {
    JPanel PSignup;
    JLabel lEmail,lFName,lLName,lLoc,lPass,lConfrmPass,lCreate,lImage;
    JTextField tEmail,tLName;
    static JTextField tFName;
    JComboBox tLoc;
    JPasswordField tPass,tConfrmPass;
    JButton bRegister;
    JFrame f;
    void signup_model()      
    {
        f=new JFrame();
        lCreate=label();
        lCreate.setText("Create an account");
        lCreate.setBounds(176,18,278,70);
        lCreate.setFont(new Font("Verdana",Font.BOLD,24));
        lCreate.setForeground(new Color(102,204,0));
        f.add(lCreate);
        
        lImage=label();
        lImage.setIcon(new ImageIcon("C:\\Users\\ubit\\Pictures\\sign.png"));
        lImage.setBounds(30,52,128,128);
        f.add(lImage);
        
        PSignup=new JPanel();
        PSignup.setBounds(176,99,750,395);
        PSignup.setBorder(new LineBorder(Color.BLACK,1,true));
        PSignup.setLayout(null);
        
        lEmail=label();
        lEmail.setText("Email Address :");
        lEmail.setBounds(131,36,113,20);
        lEmail.setFont(new Font("Times New Roman",Font.BOLD,14));
        PSignup.add(lEmail);
        
        lFName=label();
        lFName.setText("     First Name :");
        lFName.setBounds(131,81,97,27);
        lFName.setFont(new Font("Times New Roman",Font.BOLD,14));
        PSignup.add(lFName);
        
        lLName=label();
        lLName.setText("     Last Name :");
        lLName.setBounds(131,123,95,27);
        lLName.setFont(new Font("Times New Roman",Font.BOLD,14));
        PSignup.add(lLName);
        
        lLoc=label();
        lLoc.setText("        Location :");
        lLoc.setBounds(131,165,95,27);
        lLoc.setFont(new Font("Times New Roman",Font.BOLD,14));
        PSignup.add(lLoc);
        
        lPass=label();
        lPass.setText("       Password :");
        lPass.setBounds(131,207,95,27);
        lPass.setFont(new Font("Times New Roman",Font.BOLD,14));
        PSignup.add(lPass);
        
        lConfrmPass=label();
        lConfrmPass.setText("   Confirm Password :");
        lConfrmPass.setBounds(91,249, 153,38);
        lConfrmPass.setFont(new Font("Times New Roman",Font.BOLD,14));
        PSignup.add(lConfrmPass);
        
        tEmail=text();
        tEmail.setText(null);
        tEmail.setBounds(262,36,314,27);
        PSignup.add(tEmail);
        
        tFName=text();
        tFName.setText(null);
        tFName.setBounds(262,81,246,27);
        PSignup.add(tFName);
        
        tLName=text();
        tLName.setText(null);
        tLName.setBounds(262,123,246,27);
        PSignup.add(tLName);
        
        String country[]={"Pakistan","India","Bangladesh","UAE","Srilanka","Afghanistan"};
        tLoc=new JComboBox(country);
        tLoc.setBounds(262,165,177,29);
        PSignup.add(tLoc);
        
        tPass=new JPasswordField(null);
        tPass.setBounds(262,210,246,27);
        PSignup.add(tPass);
        
        tConfrmPass=new JPasswordField(null);
        tConfrmPass.setBounds(262,256,246,27);
        PSignup.add(tConfrmPass);
        
        bRegister=button();
        bRegister.setText("Register");
        bRegister.setFont(new Font("Times New Roman",Font.BOLD,14));
        bRegister.setBackground(new Color(0,148,0));
        bRegister.setBounds(535,324,139,37);
        bRegister.setForeground(new Color(0,0,0));
        PSignup.add(bRegister);
        
        f.add(PSignup);
        frame();
        
    }
    void frame()
     {
        
        f.setSize(963,553);
        f.setTitle("Sign Up");
        //this.setBackground(Color.white);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    JButton button()
    {
        return new JButton();
        
    }
   
    JTextField text()
    {
      return new JTextField("");  
      
    }
    JLabel label()
    {
        return new JLabel();
    }
}

