/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examSystem;

import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author ubit
 */
public class signup_with_database extends signup{

    String tempEmail,tempFirst_Name,tempLast_Name,tempLoc,tempPass,tempconfrmPass;
    Connection connc=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    void Register_button_action()
    {
        
        bRegister.addActionListener(new  ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                 boolean check = false;
       if(getValuesFromTextFields()==true)
       {
        check=confirmPassword();
       }
       else{
           System.out.println("Please make sure all fields are filled.");
           
       }
        if(check==true)
        {
            System.out.println("hi");
            createDataBase();
            try{
            String sql="Insert into signup5 (email,first_name,last_name,location,password) values"
                    +"(?,?,?,?,?)";
        pst=connc.prepareStatement(sql);
        pst.setString(1,tempEmail);
        pst.setString(2,tempFirst_Name);
        pst.setString(3,tempLast_Name);
        pst.setString(4,tempLoc);
        pst.setString(5,tempPass);
        int rows=pst.executeUpdate();
        if(rows>0)
        {
            System.out.println("Successfully registered");
            f.dispose();
            exam e=new exam();
            e.Login();
            
           
        }
            }
            catch(SQLIntegrityConstraintViolationException x)
            {
                System.out.println(x.getMessage());
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            finally{
                try{
                    if(connc!=null)
                    {
                        connc.close();
                    }
                    
                }
                catch(Exception w)
                {
                    
                }
            }
            
        }
        else if(check==false&&getValuesFromTextFields()==true){
            System.out.println("Your confirmation password don't match. ");
        }
            }
        } );

         
           
    }
    void createDataBase()
    {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        connc=DriverManager.getConnection("jdbc:mysql://localhost/examinationsystem","root","");
        }
        
        
        
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
    }
   /* void confirm_Email()
    {
        boolean bool=true;
        try{
        String sql="Select * from signup3 where email=?";
        pst=connc.prepareStatement(sql);
        pst.setString(1, tempEmail);
        rs=pst.executeQuery();
        while(rs.next())
        {
            bool=false;
            break;
        }
        if(bool==true)
        {
            return true;
        }
        else{
        }
    }
    catch(Exception ax)
    {
        System.out.println(ax.getMessage());
    }
    }*/

   boolean getValuesFromTextFields()
   {
       tempEmail=tEmail.getText();
       tempFirst_Name=(String)tFName.getText();
       tempLast_Name=tLName.getText();
       tempLoc=(String)tLoc.getSelectedItem();
       tempPass=tPass.getText();
       tempconfrmPass=tConfrmPass.getText();
       if(!(tempEmail.isEmpty())&&!(tempFirst_Name.isEmpty())&&!(tempLast_Name.isEmpty())&&!(tempLoc.isEmpty())&&!(tempPass.isEmpty())&&!(tempconfrmPass.isEmpty()))
       {
           
           return true;
       }
       else{
           return false;
       }
   }
   boolean confirmPassword()
   {
       if(tempPass.equals(tempconfrmPass))
       {
           return true;
       }
       else{
        return false;
       }
   }
   
    
    
    
}
