/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author ubit
 */
public class setIcontoTextField {
    JFrame f;
    JPanel p;
    JTextField t;
    JLabel img;
    
    
    void add()
    {
        f=new JFrame();
        p=new JPanel();
        p.setLayout(new BorderLayout());
        p.setBounds(50,150,210,30);
        p.setBorder(new LineBorder(Color.BLACK));
        img=new JLabel("");
        img.setIcon(new ImageIcon("C:\\Users\\ubit\\Downloads\\user2.png"));
        img.setOpaque(true);
        img.setBorder(null);
        img.setBackground(Color.BLUE);
        p.add(img,BorderLayout.WEST);
        t=new JTextField("");
        t.setBorder(null);
        p.add(t,BorderLayout.CENTER);
        //p.setVisible(true);
        f.add(p);
        createframe();
        
    }
   void createframe()
    {
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
