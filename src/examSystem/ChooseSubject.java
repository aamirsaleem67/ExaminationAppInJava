/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examSystem;

/**
 *
 * @author ubit
 * 
 */
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.border.LineBorder;

public class ChooseSubject {
  JFrame FSub;
  JLabel LSub;
  JPanel PSub;
  JRadioButton rSub[]=new JRadioButton[4];
  JButton nextSub;
  int rvertSub=18;
  ButtonGroup g2;
  ChooseSubject()
  {
        FSub=new JFrame();
        FSub.setSize(435,390);
        FSub.setTitle("");
        //this.setBackground(Color.white);
        FSub.setLayout(null);
        FSub.setVisible(true);
        FSub.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  void create_FrameSub()
  {
      LSub=label();
      LSub.setText("Select the Subject :");
      LSub.setBounds(19,31,191,24);
      LSub.setFont(new Font("Times New Roman",Font.BOLD,20));
      LSub.setForeground(new Color(0,0,153));
      FSub.add(LSub);
      
      PSub=new JPanel();
      PSub.setBounds(27,73,338,191);
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
      nextSub.setText("NEXT");
      nextSub.setBounds(265,295,100,32);
      nextSub.setForeground(new Color(0,0,255));
      
      FSub.add(PSub);
      FSub.add(nextSub);
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
}

    
    

