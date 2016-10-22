/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;

/**
 *
 * @author ubit
 */
public class checkClass3 implements ActionListener{
    
   JLabel labCurrent, labNew, labRetype;
    JPasswordField pCurrent, pNew, pRetype;
    JButton butSave, butReset;
    JLabel[] staric = new JLabel[3];
    JPanel panel2;
    Connection conn = null;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst;
    JPanel create_passpanel() {
        panel2 = new JPanel();
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

       // tab.addTab("Change Password", null, panel2, "Password");
        butSave.addActionListener(this);
        return panel2;
    }
    void createDataBase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/examinationsystem", "root", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
Boolean checkCurrentPass(String pass) {
        try {
            String sql;
            String pass2 = "";
            createDataBase();
            sql = "select password from signup5 where Email='"+tabedpaneUser.user+"' ";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                pass2 = rs.getString("password");

            }

            if (pass.equals(pass2)) {

                return true;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;

    }

    void changePass() {
        String sql;
        if (pCurrent.getText().isEmpty() || pNew.getText().isEmpty() || pRetype.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "All the * fields must be filled ");
        } else if (checkCurrentPass(pCurrent.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Current password is not matched");
        } else if (pNew.getText().length() < 6) {
            JOptionPane.showMessageDialog(null, "Password should be 6 characters minimum");
        } else if (!(pNew.getText().equals(pRetype.getText()))) {
            JOptionPane.showMessageDialog(null, "New and confirm password dont match");
        } else {
            try {
                createDataBase();
                sql = "update signup5 set password=? where Email=?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, pNew.getText());
                pst.setString(2, tabedpaneUser.user);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Password succesfully changed");
                pCurrent.setText("");
                pNew.setText("");
                pRetype.setText("");

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==butSave)
        {
            changePass();
        }
        
    }
}
