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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author ubit
 */
public class checkClass implements ActionListener /*implements ActionListener*/ {
    /*JLabel labCurrent, labNew, labRetype;
     JPasswordField pCurrent, pNew, pRetype;
     JButton butSave, butReset;
     JLabel[] staric = new JLabel[3];
     JPanel panel2;
     JPanel create_passpanel() {
     panel2=new JPanel();
     panel2.setBorder(new SoftBevelBorder(1));
     panel2.setLayout(null);
     // pie.setVisible(false);
     //pie.setBounds(null);
     labCurrent = new JLabel();
     labCurrent.setBounds(146, 44, 150, 49);
     labCurrent.setText("Current Password :");
     panel2.add(labCurrent);

     labNew = new JLabel();
     labNew.setBounds(146, 114, 150, 49);
     labNew.setText("     New Password :");
     panel2.add(labNew);

     labRetype = new JLabel();
     labRetype.setBounds(106, 185, 190, 49);
     labRetype.setText("  Confirm New Password :");
     panel2.add(labRetype);

     pCurrent = new JPasswordField();
     pCurrent.setBounds(314, 55, 240, 29);
     panel2.add(pCurrent);

     pNew = new JPasswordField();
     pNew.setBounds(314, 125, 240, 29);
     panel2.add(pNew);

     pRetype = new JPasswordField();
     pRetype.setBounds(314, 195, 240, 29);
     panel2.add(pRetype);

     butSave = new JButton();
     butSave.setBounds(314, 261, 62, 23);
     butSave.setText("Save");
     panel2.add(butSave);

     butReset = new JButton();
     butReset.setBounds(394, 261, 70, 23);
     butReset.setText("Reset");
     panel2.add(butReset);

     int yCord = 60;
     for (int i = 0; i < staric.length; i++) {
     staric[i] = new JLabel("*");
     staric[i].setBounds(570, yCord, 72, 14);
     panel2.add(staric[i]);
     yCord = yCord + 70;
     }
     //f.setSize(740, 510);


     //tab.addTab("Change Password", null, panel2, "Password");
     butSave.addActionListener(this);
     return panel2;
     }

     @Override
     public void actionPerformed(ActionEvent ae) {
        
     System.out.println("nahi choruga");
     }*/

    JPanel FClass;
    JLabel LClass;
    JPanel PClass;
    JRadioButton r[] = new JRadioButton[4];
    JButton next;
    int rvert = 18;
    ButtonGroup g1;

    void ChooseClass() {

        
        FClass.setSize(435, 390);
        FClass.setLayout(null);
        FClass.setVisible(true);
        
    }

    JPanel createClassFrame() {
        FClass=new JPanel();
        LClass = label();
        LClass.setText("Choose the Class :");
        LClass.setBounds(19, 31, 191, 24);
        LClass.setFont(new Font("Times New Roman", Font.BOLD, 20));
        LClass.setForeground(new Color(0, 0, 153));
        FClass.add(LClass);

        PClass = new JPanel();
        PClass.setBounds(27, 73, 370, 191);
        PClass.setBorder(new LineBorder(Color.BLACK, 1, true));
        PClass.setLayout(null);
        g1 = new ButtonGroup();
        for (int i = 0; i < r.length; i++) {
            r[i] = radio();
            r[i].setBounds(12, rvert, 55, 23);

            if (i == 0) {
                r[i].setText("9th");
                r[0].requestFocus();
            } else if (i == 1) {
                r[i].setText("10th");
            } else if (i == 2) {
                r[i].setText("11th");
            } else if (i == 3) {
                r[i].setText("12th");
            }
            g1.add(r[i]);
            PClass.add(r[i]);
            rvert = rvert + 41;

        }
        next = button();
        next.setText("NEXT");
        next.setBounds(297, 295, 100, 32);
        next.setForeground(new Color(0, 0, 255));
        //next.disable();
        FClass.add(PClass);
        FClass.add(next);
        next.addActionListener(this);
        ChooseClass();
        next.addActionListener(this);
        return FClass;
    }

    JButton button() {
        return new JButton();

    }

    JLabel label() {
        return new JLabel();
    }

    JRadioButton radio() {
        return new JRadioButton();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //new checkClass3().setTempPanel();
        
               
    }
    
    

}
