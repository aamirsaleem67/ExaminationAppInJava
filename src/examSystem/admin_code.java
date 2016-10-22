/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * @author ubit
 */
public class admin_code implements ActionListener {

    JFrame fr;
    JButton butGen, butUser, butUpd;
    JButton but9th, but10th, but11th, but12th;
    JComboBox com9th, com10th, com11th, com12th;
    JPanel panel1, panel2;
    JLabel labClass, labSub;
    JButton newbut;
    JLabel labCurrent, labNew, labRetype;
    JPasswordField pCurrent, pNew, pRetype;
    JButton butSave, butReset;
    JLabel[] staric = new JLabel[3];
    Connection conn = null;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst;
    JTable table;
    JScrollPane jsp;

    String s;
    int c;
    JButton pie;
   public void create_AdminPanel() {
        fr = new JFrame();
        pie=new JButton("Pie Chart");

        panel1 = new JPanel();
        panel1.setBorder(new LineBorder(Color.BLACK, 1));
        panel1.setBounds(10, 11, 698, 62);
        panel1.setLayout(null);

        butGen = button();
        butGen.setBounds(18, 11, 163, 38);
        butGen.setText("General");
        //butGen.setBackground(Color.BLUE);
        panel1.add(butGen);

        butUser = button();
        butUser.setBounds(253, 11, 193, 38);
        butUser.setText("User Records");
        panel1.add(butUser);

        butUpd = button();
        butUpd.setBounds(513, 11, 173, 38);
        butUpd.setText("Update");
        panel1.add(butUpd);

        fr.add(panel1);

        panel2 = new JPanel();
        panel2.setBounds(10, 91, 698, 365);
        panel2.setBorder(new SoftBevelBorder(1));
        panel2.setLayout(null);

        //create_updatePanel();
        create_passpanel();
        frame();
        butGen.addActionListener(this);
        butUpd.addActionListener(this);
        butUser.addActionListener(this);
        
        pie.addActionListener(this);
    }

    void frame() {

        fr.setSize(740, 510);
        fr.setTitle("Admin Panel");
        //this.setBackground(Color.white);
        fr.setLayout(null);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    JButton button() {
        return new JButton();

    }

    JComboBox combo() {
        return new JComboBox();

    }

    JLabel label() {
        return new JLabel();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == butGen) {
            //butUpd.setBackground(new Color(0, 0, 204));
            //butGen.setBackground(Color.CYAN);
            //butUpd.setBackground(new Color(240, 240, 240));
            panel2.removeAll();
            create_passpanel();
            panel2.revalidate();
            panel2.repaint();
        }
        if (ae.getSource() == butSave) {
            changePass();
        }
        if (ae.getSource() == butUser) {
            panel2.removeAll();
            create_UserPanel();
            panel2.revalidate();
            panel2.repaint();

        }
        if(ae.getSource()== pie)
        {
            new CountryPieChart();
        }
        if(ae.getSource()==butUpd)
        {
            //new Admin_UpdateWithJTable().createUpdateFrame();
             // 
            panel2.removeAll();
            create_updatePanel();
            panel2.revalidate();
            panel2.repaint();

        }
        
        if(ae.getSource()==but9th)
        {
            if(com9th.getSelectedIndex()==0)
            {
               new Admin_UpdateWithJTable().setTableName(" 9th_chemistry");
               new Admin_UpdateWithJTable().createUpdateFrame();
               
            }
            else if(com9th.getSelectedIndex()==1)
            {
                new Admin_UpdateWithJTable().setTableName(" 9th_physics");
               new Admin_UpdateWithJTable().createUpdateFrame();
                
            }
            else if(com9th.getSelectedIndex()==2)
            {
                new Admin_UpdateWithJTable().setTableName(" 9th_math");
               new Admin_UpdateWithJTable().createUpdateFrame();
                
            }
            else if(com9th.getSelectedIndex()==3)
            {
                new Admin_UpdateWithJTable().setTableName(" 9th_computer");
               new Admin_UpdateWithJTable().createUpdateFrame();
                
            }
            
        }
        
        if(ae.getSource()==but10th)
        {
            if(com10th.getSelectedIndex()==0)
            {
               new Admin_UpdateWithJTable().setTableName(" 10th_chemistry");
               new Admin_UpdateWithJTable().createUpdateFrame();
               
            }
            else if(com10th.getSelectedIndex()==1)
            {
                new Admin_UpdateWithJTable().setTableName(" 10th_physics");
               new Admin_UpdateWithJTable().createUpdateFrame();
                
            }
            else if(com10th.getSelectedIndex()==2)
            {
                new Admin_UpdateWithJTable().setTableName(" 10th_math");
               new Admin_UpdateWithJTable().createUpdateFrame();
                
            }
            else if(com10th.getSelectedIndex()==3)
            {
                new Admin_UpdateWithJTable().setTableName(" 10th_computer");
               new Admin_UpdateWithJTable().createUpdateFrame();
                
            }
            
        }
        if(ae.getSource()==but11th)
        {
            if(com11th.getSelectedIndex()==0)
            {
               new Admin_UpdateWithJTable().setTableName(" 11th_chemistry");
               new Admin_UpdateWithJTable().createUpdateFrame();
               
            }
            else if(com11th.getSelectedIndex()==1)
            {
                new Admin_UpdateWithJTable().setTableName(" 11th_physics");
               new Admin_UpdateWithJTable().createUpdateFrame();
                
            }
            else if(com11th.getSelectedIndex()==2)
            {
                new Admin_UpdateWithJTable().setTableName(" 11th_math");
               new Admin_UpdateWithJTable().createUpdateFrame();
                
            }
            else if(com11th.getSelectedIndex()==3)
            {
                new Admin_UpdateWithJTable().setTableName(" 11th_computer");
               new Admin_UpdateWithJTable().createUpdateFrame();
                
            }
            
        }
        if(ae.getSource()==but12th)
        {
            if(com12th.getSelectedIndex()==0)
            {
               new Admin_UpdateWithJTable().setTableName(" 12th_chemistry");
               new Admin_UpdateWithJTable().createUpdateFrame();
               
            }
            else if(com12th.getSelectedIndex()==1)
            {
                new Admin_UpdateWithJTable().setTableName(" 12th_physics");
               new Admin_UpdateWithJTable().createUpdateFrame();
                
            }
            else if(com12th.getSelectedIndex()==2)
            {
                new Admin_UpdateWithJTable().setTableName(" 12th_math");
               new Admin_UpdateWithJTable().createUpdateFrame();
                
            }
            else if(com12th.getSelectedIndex()==3)
            {
                new Admin_UpdateWithJTable().setTableName(" 12th_computer");
               new Admin_UpdateWithJTable().createUpdateFrame();
                
            }
            
        }

    }

    void create_passpanel() {
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

        butSave = button();
        butSave.setBounds(314, 261, 62, 23);
        butSave.setText("Save");
        panel2.add(butSave);

        butReset = button();
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
                fr.setSize(740, 510);


        fr.add(panel2);
        butSave.addActionListener(this);

    }

    void create_updatePanel() {
        panel2.setLayout(null);
        
        labClass = new JLabel();
        labClass.setBounds(56, 28, 140, 37);
        labClass.setFont(new Font("Kartika", Font.BOLD, 22));
        labClass.setForeground(new Color(0, 0, 204));
        labClass.setText("CLASS");
        panel2.add(labClass);

        labSub = new JLabel();
        labSub.setBounds(334, 33, 143, 27);
        labSub.setFont(new Font("Kartika", Font.BOLD, 22));
        labSub.setForeground(new Color(0, 0, 204));
        labSub.setText("SUBJECT");
        panel2.add(labSub);

        but9th = button();
        but9th.setText("9th");
        but9th.setBounds(56, 78, 166, 36);
        panel2.add(but9th);

        but10th = button();
        but10th.setText("Matric");
        but10th.setBounds(56, 147, 166, 36);
        panel2.add(but10th);

        but11th = button();
        but11th.setText("First year");
        but11th.setBounds(56, 214, 166, 36);
        panel2.add(but11th);

        but12th = button();
        but12th.setText("Second year");
        but12th.setBounds(56, 280, 166, 36);
        panel2.add(but12th);

        String[] subject = {"Chemistry", "Physics", "Math", "Computer Science"};
        com9th = new JComboBox(subject);
        com9th.setBounds(334, 78, 209, 36);
        panel2.add(com9th);

        com10th = new JComboBox(subject);
        com10th.setBounds(334, 147, 209, 36);
        panel2.add(com10th);

        com11th = new JComboBox(subject);
        com11th.setBounds(334, 214, 209, 36);
        panel2.add(com11th);

        com12th = new JComboBox(subject);
        com12th.setBounds(334, 280, 209, 36);
        panel2.add(com12th);

        fr.add(panel2);
        
        but9th.addActionListener(this);
        
        but10th.addActionListener(this);
        
        but11th.addActionListener(this);
        
        but12th.addActionListener(this);
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
            sql = "select password from admintable where adminname='adminOfThisApp'";
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
        } else if (!pNew.getText().equals(pRetype.getText())) {
            JOptionPane.showMessageDialog(null, "New and confirm password dont match");
        } else {
            try {
                createDataBase();
                sql = "update admintable set password=? where adminname=?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, pNew.getText());
                pst.setString(2, "adminOfThisApp");
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

    DefaultTableModel get() {
        try {
            DefaultTableModel dm = new DefaultTableModel();
            createDataBase();
            st = conn.createStatement();
            s = "select S_NO,Email,First_Name,Last_Name,Location from signup5";
            rs = st.executeQuery(s);
            ResultSetMetaData rsmt = rs.getMetaData();
            c = rsmt.getColumnCount();

            System.out.println(c);
            Vector column = new Vector(c);
            for (int i = 1; i <= c; i++) {
                //System.out.println(rsmt.getColumnName(i));
                if(i==1)
                {
                     dm.addColumn("        "+rsmt.getColumnName(i));
                }
                else{
                dm.addColumn(rsmt.getColumnName(i));
                }
            }

            Vector data = new Vector();
            Vector row = new Vector();
            while (rs.next()) {
                row = new Vector(c);
                for (int i = 1; i <= c; i++) {

                    String rowdata=rs.getString(i);
                    //rowdata.toUpperCase();
                    row.add(rowdata);
                }
                dm.addRow(row);
            }

            return dm;
        } catch (SQLException ex) {
            Logger.getLogger(admin_code.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    void create_UserPanel() {
        table = new JTable();
        table.setModel(get());
        table.setShowVerticalLines(true);
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);
        table.setRowHeight(40);
        JTableHeader header = table.getTableHeader();

        TableColumn col[] = new TableColumn[c];

        for (int i = 0; i < col.length; i++) {
            col[i] = table.getColumnModel().getColumn(i);
            //col[0].setPreferredWidth(10);
            col[i].setHeaderRenderer(new HeaderRenderer());
        }
        col[0].setPreferredWidth(0);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        //table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

        JScrollPane jsp = new JScrollPane();
        header.setPreferredSize(new Dimension(jsp.getWidth(), 45));
        //header.getColumnModel().setColumnMargin(2);

        jsp.setViewportView(table);
        jsp.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel2.setLayout(new BorderLayout());
        //panel.setVisible(true);
        panel2.add(jsp, BorderLayout.CENTER);
                
               
                pie.setBounds(270,475,150,30);
                //pie.setVisible(true);
        fr.add(pie);
        fr.add(panel2);
        fr.setSize(740,570);
        //pie.addActionListener(this);

    }
    
}
