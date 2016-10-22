
package examSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class loop_pause extends JFrame{
    Connection conn;
    ResultSet rs=null;
    Statement st=null;
    JButton btn;
    static int i=8;
     void createDataBase()
    {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost/examinationsystem","root","");
        st=conn.createStatement();
           }
        
        
        
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
    }
     
     void createframe()
     {
         this.setSize(963,553);
        this.setTitle("Sign Up");
        //this.setBackground(Color.white);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
     }
     void setFrame()
     {
         btn=new JButton("Next");
         btn.setBounds(100,100,80,50);
         this.add(btn);
         createframe();
         createDataBase();
        
     }
     
     
void select_data()
{
    btn.addActionListener(new  ActionListener() {

@Override
public void actionPerformed(ActionEvent ae) {
    boolean flag=true;
    try {
        st=conn.createStatement();
        rs=st.executeQuery("Select * from signup5 where S_NO="+i+"");
        while(rs.next())
        {
            flag=true;
            String mail="";
            mail=rs.getString("email");
            System.out.println(mail);
            i++;
            //System.out.println(btn.getModel().isPressed());
          
        }
    } catch (SQLException ex) {
        Logger.getLogger(loop_pause.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
}


} );
    
}
    
    
    
}
