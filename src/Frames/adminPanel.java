/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import examSystem.admin_code;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author ubit
 */
public class adminPanel implements ActionListener {

    JFrame fr;
    JPanel p1, p2;
    JLabel img1, img2, labLogin;
    JLabel back;
    JButton login;
    JTextField user;
    JPasswordField pass;
    Connection conn;
    ResultSet rs;
    Statement s;
    String Suser, Spass;

    public void add() {
        fr = new JFrame();
        p1 = new JPanel();
        p1.setBounds(220, 150, 210, 30);
        p1.setLayout(new BorderLayout());
        p1.setBorder(new LineBorder(Color.BLACK, 1));
        img1 = new JLabel();
        img1.setIcon(new ImageIcon("C:\\Users\\ubit\\Downloads\\user2.png"));
        p1.add(img1, BorderLayout.EAST);
        user = new JTextField("");
        user.setBorder(null);
        user.setFont(new Font("Tahoma", Font.BOLD, 11));
        p1.add(user, BorderLayout.CENTER);
        fr.add(p1);
        p2 = new JPanel();
        p2.setBounds(220, 210, 210, 30);
        p2.setLayout(new BorderLayout());

        p2.setBorder(new LineBorder(Color.BLACK, 1));
        img2 = new JLabel();
        img2.setIcon(new ImageIcon("C:\\Users\\ubit\\Pictures\\password.png"));
        p2.add(img2, BorderLayout.EAST);

        pass = new JPasswordField("");
        pass.setBorder(null);
        p2.add(pass, BorderLayout.CENTER);
        fr.add(p2);

        login = new JButton("Let me in");
        login.setBounds(220, 270, 210, 30);
        login.setBackground(new Color(153, 0, 153));
        login.setForeground(new Color(240, 240, 240));
        login.setFont(new Font("Tahoma", Font.BOLD, 13));
        login.requestFocus(true);
        login.setOpaque(true);
        //login.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
        fr.add(login);

        labLogin = new JLabel("Admin Login");
        labLogin.setBounds(255, 90, 150, 30);
        labLogin.setFont(new Font("Tahoma", Font.PLAIN, 24));
        labLogin.setForeground(new Color(240, 240, 240));
        fr.add(labLogin);

        back = new JLabel("");
        back.setBounds(0, 0, 655, 410);
        back.setIcon(new ImageIcon("C:\\Users\\ubit\\Pictures\\back5.jpg"));
        fr.add(back);

        createFrame();
        login.addActionListener(this);
    }

    public void createFrame() {
        fr.setLayout(null);
        fr.setPreferredSize(new Dimension(680, 450));
        fr.setMinimumSize(new Dimension(660, 420));
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void createDataBase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/examinationsystem", "root", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            createDataBase();
            String sql = "";
            s = conn.createStatement();
            sql = "select * from admintable";
            rs = s.executeQuery(sql);
            while (rs.next()) {
                Suser = rs.getString("adminname");
                Spass = rs.getString("password");

            }
            System.out.println(Suser);
            System.out.println(Spass);
            if (user.getText().isEmpty() || pass.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "          Fill all the Fields.");
            } else if (!(user.getText().equalsIgnoreCase(Suser)) || !(pass.getText().equals(Spass))) {
                JOptionPane.showMessageDialog(null, "      Invalid username or password");

            } else {
                JOptionPane.showMessageDialog(null, "      Successfully Login");

                fr.dispose();
                new admin_code().create_AdminPanel();
            }

        } catch (SQLException ex) {
            Logger.getLogger(adminPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException ex) {
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(adminPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(adminPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
