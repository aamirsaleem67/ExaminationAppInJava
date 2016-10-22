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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
public class ChooseSubject12th implements ActionListener{
  
  JPanel FSub;
  JLabel LSub;
  JPanel PSub;
  JRadioButton rSub[]=new JRadioButton[4];
  JButton nextSub;
  int rvertSub=18;
  ButtonGroup g2;
  
  Connection connc;
  ResultSet rs=null;
  Statement st=null;
  Statement st2=null;
  PreparedStatement pst=null;
  String subtableName="";
   void ChooseSubject12th()
  {
        //FSub=new JPanel();
        FSub.setSize(435,390);
        //FSub.setTitle("");
        //this.setBackground(Color.white);
        FSub.setLayout(null);
        FSub.setVisible(true);
        //FSub.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  JPanel create_FrameSub()
  {
      FSub=new JPanel();
      LSub=label();
      LSub.setText("Select the Subject :");
      LSub.setBounds(19,31,191,24);
      LSub.setFont(new Font("Times New Roman",Font.BOLD,20));
      LSub.setForeground(new Color(0,0,153));
      FSub.add(LSub);
      
      PSub=new JPanel();
      PSub.setBounds(27,73,370,191);
      PSub.setBorder(new LineBorder(Color.BLACK,1,true));
      PSub.setLayout(null);
      g2=new ButtonGroup();
      for(int i=0;i<rSub.length;i++)
      {
          rSub[i]=radio();
          rSub[i].setBounds(12,rvertSub,90,23);
          
          if(i==0)
          {
              rSub[i].setText("Chemistry");
              
          }
          else if(i==1)
          {
              rSub[i].setText("Math");
          }
          else if(i==2)
          {
              rSub[i].setText("Physics");
          }
          else if(i==3)
          {
              rSub[i].setText("Computer");
          }
          g2.add(rSub[i]);
          PSub.add(rSub[i]);
          rvertSub=rvertSub+41;
          
      }
      nextSub=button();
      nextSub.setText("START");
      nextSub.setBounds(297,295,100,32);
      nextSub.setForeground(new Color(0,0,255));
      
      FSub.add(PSub);
      FSub.add(nextSub);
      ChooseSubject12th();
      
      nextSub.addActionListener(this);
      return FSub;
  }
  JButton button()
    {
        return new JButton();
        
    }
   JLabel label()
    {
        return new JLabel();
    }
   JRadioButton radio()
   {
       return new JRadioButton();
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
 void VerfityToZero(String tableName)
 {
     createDataBase();
     //String t=" 9th_chemistry";
        String sql="select *from"+tableName;
        try{
                st=connc.createStatement();
                String u="update "+tableName+" set verify=? where MCQ=?";
            pst=connc.prepareStatement(u);
            rs=st.executeQuery(sql);
            //int inc=11;
            
            while(rs.next())
            {
                
                
                
              pst.setBoolean(1,false);
                
              pst.setString(2, rs.getString("MCQ"));
              
              pst.executeUpdate();
               
             }
            pst.close();
            st.close();
            rs.close();
            connc.close();
        }catch(Exception ax)
        {
        }
 }
    @Override
    public void actionPerformed(ActionEvent ae) {
       if(rSub[0].isSelected())
       {
           String t=" 12th_chemistry";
           eventPerform_OnRadioButton(t,"Chemistry");
       }
       else if(rSub[1].isSelected())
       {
           String t=" 12th_math";
           eventPerform_OnRadioButton(t,"Math");
       }
       else if(rSub[2].isSelected())
       {
           String t=" 12th_physics";
           eventPerform_OnRadioButton(t,"Physics");
       }
       else if(rSub[3].isSelected())
       {
           String t=" 12th_computer";
           eventPerform_OnRadioButton(t,"Computer");
       }
       else{
           JOptionPane.showMessageDialog(null, "  Please Select one option");
       }
        
    } // end of actionPerform
    void eventPerform_OnRadioButton(String table,String subject)
    {
        boolean flag=false;
        
        
        try{
            
            String mcq="";
            String optA="",optB="",optC="",optD="";
            String rytc="";
            
                 //String t=" 9th_chemistry";
                 subtableName=table;
                 VerfityToZero(table);
                 createDataBase();
                 String sql="select *from"+table;
                st=connc.createStatement();
                String u="update "+table+" set verify=? where MCQ=?";
            pst=connc.prepareStatement(u);
            rs=st.executeQuery(sql);
            
            
            while(rs.next())
            {
                if(rs.getInt("verify")==0)
                {
                mcq=rs.getString("MCQ");
                optA=rs.getString("Opt_A");        
                optB=rs.getString("Opt_B");
                optC=rs.getString("Opt_C");
                optD=rs.getString("Opt_D");
              pst.setBoolean(1, true);
                
              pst.setString(2, rs.getString("MCQ"));
              rytc=rs.getString("Right_Option");
               int row=pst.executeUpdate();
               
              //System.out.println("row");
               flag=true;
               break;
                }
            } 
            
            pst.close();
            if(flag==true)
            {
                  //FSub.dispose();
                tabedpaneUser.f.dispose();
                  MCQS m=new MCQS();
                  m.create_frameMCQ();
                  m.ryt_answer(rytc);
                  m.FixClassandSubject("12th", subject);
                  m.passTableName(subtableName);
                  m.lmcq.setText   (mcq);
                  m.rmcq[0].setText(optA);
                  m.rmcq[1].setText(optB);
                  m.rmcq[2].setText(optC);
                  m.rmcq[3].setText(optD);
                  
                
            }
           
            }
            
            
          
        
        catch(Exception a)
        {
        }
        finally
                {
                    if(st!=null)
                    {
                        try {
                            st.close();
                        } catch (SQLException ex) {
                        }
                    }
                    if(rs!=null)
                    {
                        try {
                            rs.close();
                        } catch (SQLException ex) {
                        }
                    }
                    if(connc!=null)
                    {
                        try {
                            connc.close();
                        } catch (SQLException ex) {
                        }
                    }
                }
    }
    
    
}

