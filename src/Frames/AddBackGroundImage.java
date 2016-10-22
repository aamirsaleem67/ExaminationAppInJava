/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author ubit
 */
public class AddBackGroundImage {
    JFrame f;
    JLabel lab;
    JLabel img;
    JTextField txt;
    JButton b;
    void add()
    {
        f=new JFrame();
        lab=new JLabel();
        lab.setBounds(100,150,100,100);
        lab.setText("Email");
        lab.setForeground(Color.WHITE);
        f.add(lab);
        
        txt=new JTextField("");        
        txt.setBounds(150,150,200,50);
        f.add(txt);
       
        b=new JButton("Hello Jaan :)");
        b.setBounds(300,80,60,60);
        f.add(b);
        img=new JLabel();
        img.setBounds(1,1,550,350);
        img.setIcon(new ImageIcon("C:\\Users\\ubit\\Pictures\\s-writes.jpg"));
        f.add(img);
        
        
        createFrame();
        
    }
    void createFrame()
    {
       f.setLayout(null);
       f.setPreferredSize(new Dimension(800,800));
       f.setMinimumSize(new Dimension(700,700));
       f.setVisible(true);
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
