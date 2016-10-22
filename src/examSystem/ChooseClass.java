/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.border.LineBorder;

/**
 *
 * @author ubit
 */
public class ChooseClass implements ActionListener {
  JFrame FClass;
  JLabel LClass;
  JPanel PClass;
  JRadioButton r[]=new JRadioButton[4];
  JButton next;
  int rvert=18;
  ButtonGroup g1;
  ChooseClass()
  {
        FClass=new JFrame();
        FClass.setSize(435,390);
        FClass.setTitle("Sign Up");
        //this.setBackground(Color.white);
        FClass.setLayout(null);
        FClass.setVisible(true);
        FClass.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  void create_ClassFrame()
  {
      LClass=label();
      LClass.setText("Choose the Class :");
      LClass.setBounds(19,31,191,24);
      LClass.setFont(new Font("Times New Roman",Font.BOLD,20));
      LClass.setForeground(new Color(0,0,153));
      FClass.add(LClass);
      
      PClass=new JPanel();
      PClass.setBounds(27,73,338,191);
      //PClass.setBounds(27,73,600,191);
      PClass.setBorder(new LineBorder(Color.BLACK,1,true));
      PClass.setLayout(null);
      g1=new ButtonGroup();
      for(int i=0;i<r.length;i++)
      {
          r[i]=radio();
          r[i].setBounds(12,rvert,55,23);
          
          if(i==0)
          {
              r[i].setText("9th");
              r[0].requestFocus();
          }
          else if(i==1)
          {
              r[i].setText("10th");
          }
          else if(i==2)
          {
              r[i].setText("11th");
          }
          else if(i==3)
          {
              r[i].setText("12th");
          }
          g1.add(r[i]);
          PClass.add(r[i]);
          rvert=rvert+41;
          
      }
      next=button();
      next.setText("NEXT");
      next.setBounds(265,295,100,32);
      next.setForeground(new Color(0,0,255));
      //next.disable();
      FClass.add(PClass);
      FClass.add(next);
      next.addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(r[0].isSelected())
        {
            FClass.dispose();
            ChooseSubject9th s9=new ChooseSubject9th();
            s9.create_FrameSub();
            
        }
        else if(r[1].isSelected()){
            FClass.dispose();
            ChooseSubject9th s9=new ChooseSubject9th();
            s9.create_FrameSub();
        }
        else if(r[2].isSelected())
        {
            FClass.dispose();
            ChooseSubject9th s9=new ChooseSubject9th();
            s9.create_FrameSub();
        }
        else if(r[3].isSelected())
        {
            FClass.dispose();
            ChooseSubject9th s9=new ChooseSubject9th();
            s9.create_FrameSub();
        }
        else{
            JOptionPane.showMessageDialog(null, "Please Select one option");
        }
    }
   
   
}
