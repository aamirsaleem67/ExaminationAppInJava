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
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.border.LineBorder;

/**
 *
 * @author ubit
 */
public class MCQS implements ActionListener {
    
    JFrame fmcq;
    JLabel lmcq;
    JRadioButton rmcq[] = new JRadioButton[4];
    ButtonGroup gmcq;
    JButton bmcq;
    int rvertmcq = 119;
    Statement stm = null;
    Connection connm = null;
    ResultSet rsm = null;
    PreparedStatement pstm;
    int score = 0;
    static String right = null;
    int i = 1;
    static String className = null;
    String subName = null;
    static String tableName = null;
    
    void passTableName(String tempTableName) {
        tableName = tempTableName;
    }
    
    void ryt_answer(String ryt) {
        MCQS.right = ryt;
    }
    
    MCQS() {
        
        fmcq = new JFrame();
        fmcq.setSize(868, 490);
        fmcq.setTitle("");
        //this.setBackground(Color.white);
        fmcq.setLayout(null);
        fmcq.setVisible(true);
        fmcq.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    void create_frameMCQ() {
        lmcq = label();
        lmcq.setBounds(61, 33, 700, 56);
        lmcq.setText(" ");
        lmcq.setFont(new Font("Tahoma", Font.BOLD, 11));
        lmcq.setBorder(new LineBorder(Color.BLACK, 1, true));
        fmcq.add(lmcq);
        
        gmcq = new ButtonGroup();
        for (int i = 0; i < rmcq.length; i++) {
            rmcq[i] = new JRadioButton();
            rmcq[i] = radio();
            rmcq[i].setBounds(61, rvertmcq, 669, 55);
            
            gmcq.add(rmcq[i]);
            fmcq.add(rmcq[i]);
            rvertmcq = rvertmcq + 65;
            
        }
        
        bmcq = button();
        bmcq.setBounds(625, 402, 125, 40);
        bmcq.setText("NEXT");
        bmcq.setFont(new Font("Tahoma", Font.BOLD, 14));
        bmcq.setForeground(new Color(0, 51, 51));
        fmcq.add(bmcq);
        bmcq.addActionListener(this);
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
        
        String j = null;
        DataBase();
        //rmcq[0].setSelected(false);
        try {
            if (rmcq[0].isSelected()) {
                System.out.println(right);
                j = "A";
            } else if (rmcq[1].isSelected()) {
                System.out.println(right);
                j = "B";
            } else if (rmcq[2].isSelected()) {
                System.out.println(right);
                j = "C";
            } else if (rmcq[3].isSelected()) {
                System.out.println(right);
                j = "D";
            }
            if (right.equals(j)) {
                score++;
            }
            
            gmcq.clearSelection();
            //String t=" 9th_chemistry";
            String sql = "select *from" + tableName;
            stm = connm.createStatement();
            String u = "update " + tableName + " set verify=? where MCQ=?";
            pstm = connm.prepareStatement(u);
            rsm = stm.executeQuery(sql);
            boolean flag = false;
            while (rsm.next()) {
                
                if (rsm.getInt("verify") == 0) {
                    
                    pstm.setBoolean(1, true);
                    
                    pstm.setString(2, rsm.getString("MCQ"));
                    
                    int row = pstm.executeUpdate();
                    ryt_answer(rsm.getString("Right_Option"));
                    flag = true;
                    i++;
                    break;
                }
            }
            if (flag == true) {
                 
                
               
                lmcq.setText(rsm.getString("MCQ"));
                rmcq[0].setText(rsm.getString("Opt_A"));
                rmcq[1].setText(rsm.getString("Opt_B"));
                if (rsm.getString("Opt_C").isEmpty()) {
                    rmcq[2].setVisible(false);
                } else {
                    rmcq[2].setVisible(true);
                    rmcq[2].setText(rsm.getString("Opt_C"));
                    
                }
                if (rsm.getString("Opt_D").isEmpty()) {
                    rmcq[3].setVisible(false);
                } else {
                    rmcq[3].setVisible(true);
                    rmcq[3].setText(rsm.getString("Opt_D"));
                    
                }
                
            } else {
                
                fmcq.dispose();
                rsm = stm.executeQuery(sql);
                pstm = connm.prepareStatement(u);
                while (rsm.next()) {
                    
                    pstm.setBoolean(1, false);
                    pstm.setString(2, rsm.getString("MCQ"));
                    pstm.executeUpdate();
                    
                }
                //exam a = new exam();
                System.out.println(exam.text);
                System.out.println(score);
                JOptionPane.showMessageDialog(null, "Your result is " + score + "/" + i);
                System.out.println(i);
                closeDB();
                PassIntoResult_DB(MCQS.className, subName, score, exam.text);
                new tabedpaneUser().prepareTabPanel();
            }
            
            closeDB();
        } catch (Exception e) {
        }
    }    
    
    void closeDB() {
        try {
            stm.close();
            pstm.close();
            connm.close();
            rsm.close();
            
        } catch (Exception ex) {
        }
    }
    
    void DataBase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connm = DriverManager.getConnection("jdbc:mysql://localhost/examinationsystem", "root", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    void FixClassandSubject(String tempClass, String tempSub) {
        MCQS.className = tempClass;
        subName = tempSub;
        //System.err.println(tempSub);
        
    }
    
    void PassIntoResult_DB(String tempClass, String tempSub, int tempResult, String tempUser) {
        DataBase();
        String sql = "insert into result_record2(User,Subject,Class,Correct,InCorrect,Questions_Attempted) values"
                + "(?,?,?,?,?,?)";
        try {
            pstm = connm.prepareStatement(sql);
            pstm.setString(1, tempUser);
            pstm.setString(2, tempSub);
            pstm.setString(3, tempClass);
            pstm.setInt(4, tempResult);
            pstm.setInt(6, i);
            int wrongques=i-tempResult;
            pstm.setInt(5,wrongques);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MCQS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
