
package examSystem;

import Frames.adminPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import static sun.security.jgss.GSSUtil.login;


public class exam extends JFrame implements ActionListener {
    JPanel panel1;
    JPanel panel2;
    JLabel Lsignin,Llogin,Lemail,Lpassw,Limage;
    JButton Breg;
    JTextField Temail;
    JPasswordField Tpass;
    JButton Bsignup;
    Connection conn=null;
    ResultSet rs=null;
    Statement st=null;
    static String text="";
    JLabel Lreg;
    JButton Badmin;
    
    void Login()
    {
        panel1=panel();
        panel1.setBounds(10,5,632,315);
        //panel1.setBorder(new LineBorder(Color.BLACK,1));
        panel1.setLayout(null);
        //panel1.setBackground(Color.WHITE);
        Lsignin=label();
        Lsignin.setText("Sign In!");
        Lsignin.setBounds(10,6,103,31);
        Lsignin.setFont(new Font("Times new Roman",Font.BOLD,28));
        Color c= new Color(0,153,0);
        Lsignin.setForeground(c);
        panel1.add(Lsignin);
        panel2=panel();
        panel2.setBounds(60,54,556,215);
        panel2.setBorder(new LineBorder(Color.BLACK,1));
        panel2.setLayout(null);
        //panel2.setBackground(Color);
        Llogin=label();
        Llogin.setText("Member's Login");
        Llogin.setBounds(18,11,141,30);
        Llogin.setFont(new Font("Times new Roman",Font.BOLD,20));
        Llogin.setForeground(new Color(51,0,255));
        panel2.add(Llogin);
        Limage=label();
        Limage.setBounds(22,60,128,76);
        Limage.setIcon(new ImageIcon("C:\\Users\\ubit\\Pictures\\login.png"));
        //Limage.setIcon(new ImageIcon(getClass().getResource("Pictures/login.png")));
        panel2.add(Limage);
        Lemail=label();
        Lemail.setText("Email Address:");
        

        //Lemail.setText("Email Address:");
        Lemail.setBounds(164,48,105,31);
        Lemail.setFont(new Font("Timew new Roman",Font.BOLD,14));
        Lemail.setForeground(Color.BLACK);
        panel2.add(Lemail);
        Lpassw=label();
        Lpassw.setText("           Password:"); 
        Lpassw.setBounds(164, 97, 105, 26);
        Lpassw.setFont(new Font("Times new Roman",Font.BOLD,14));
        Lpassw.setForeground(Color.BLACK);
        panel2.add(Lpassw);
        
        Temail=text();
        Temail.setBounds(273,50,237,26);
        panel2.add(Temail);
        Tpass=new JPasswordField();
        Tpass.setBounds(273,99,237,26);
        panel2.add(Tpass);
        
        Bsignup=button();
        Bsignup.setBounds(413,143,95,31);
        Bsignup.setIcon(new ImageIcon("C:\\Users\\ubit\\Pictures\\Ok.png"));
        Bsignup.setText("Sign In");
        Bsignup.setFont(new Font("Tahoma",Font.BOLD,11));
        Bsignup.setForeground(c);
        panel2.add(Bsignup);
        
        Badmin=button();
        Badmin.setText("Adminstration!");
        Badmin.setBounds(273,143,123,31);
        Badmin.setFont(new Font("Tahoma",Font.BOLD,11));
        Badmin.setForeground(c);
        panel2.add(Badmin);
        
        panel1.add(panel2);
        
        Lreg=label();
        Lreg.setBounds(60, 270, 413, 50);
        Lreg.setText("Need an Account...! Don't have an account? That's not a problem. ");
        Lreg.setForeground(Color.BLACK);
        Lreg.setFont(new Font("Tahoma",Font.BOLD,12));
        panel1.add(Lreg);
        Breg=button();
        Breg.setText("SIGN UP NOW!");
        Breg.setForeground(Color.blue);
        Breg.setBounds(485,275,130,31);
        panel1.add(Breg);
        
        this.add(panel1);
        frame();
        Bsignup.addActionListener(this);
        Breg.addActionListener(this);
        Badmin.addActionListener(this);
    }
    void frame()
    {
        
        this.setSize(670,370);
        this.setTitle("Sign In");
        //this.setBackground(Color.white);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
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
                   
    JPanel panel()
    {
        return new JPanel();
    }
    void createDatabase()
    {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost/examinationsystem","root","");
        }
        
        
        
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==Bsignup){
        createDatabase();
        
        try{
            st=conn.createStatement();
            text=Temail.getText();
            rs=st.executeQuery("Select * from signup5 where email='"+Temail.getText()+"'&& password='"+Tpass.getText()+"'");
            boolean flag=false;
            while(rs.next())
            {
                flag=true;
                
            }
            if(flag==true)
            {
                this.dispose();
                //ChooseClass c=new ChooseClass();
                //c.create_ClassFrame();
                new tabedpaneUser().prepareTabPanel();
            }
            else{
                System.out.println("invalid");
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        
        }
    }
        else if(ae.getSource()==Breg)
        {
            signup_with_database s= new signup_with_database();
       s.signup_model();
       s.Register_button_action(); 
        }
        
        else if(ae.getSource()==Badmin)
        {
            new adminPanel().add();
            
        }
        
        
    }
}


