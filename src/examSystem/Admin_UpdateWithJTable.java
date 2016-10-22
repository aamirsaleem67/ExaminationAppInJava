/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * @author ubit
 */
public class Admin_UpdateWithJTable implements MouseListener, ActionListener {

    JFrame f;
    JPanel p;
    JTable table;
    JButton butAdd, butUpd, butDEL, butRet;
    JLabel labMCQ, labA, labB, labC, labD;
    JTextField tMCQ, tA, tB, tC, tD;
    JRadioButton[] right = new JRadioButton[4];
    JScrollPane jsp;
    static String tableName=" ";
    Connection con = null;
    ResultSet rs = null;
    Statement st = null;
    String s;
    PreparedStatement pst;
    ButtonGroup grp;
    int c;
    String tempMcq=null;
    

    void createUpdateFrame() {
        f = new JFrame();
        p = new JPanel();
        p.setBounds(22, 17, 800, 429);
        p.setLayout(new BorderLayout());
        p.setBorder(new LineBorder(Color.BLACK, 1));

        butRet = button();
        butRet.setBounds(50, 486, 118, 32);
        butRet.setText("Retrieve");
        f.add(butRet);

        butAdd = button();
        butAdd.setBounds(186, 486, 118, 32);
        butAdd.setText("Add");
        f.add(butAdd);

        butDEL = button();
        butDEL.setBounds(339, 486, 118, 32);
        butDEL.setText("Delete");
        f.add(butDEL);

        butUpd = button();
        butUpd.setBounds(498, 486, 118, 32);
        butUpd.setText("Update");
        f.add(butUpd);

        labMCQ = label();
        labMCQ.setBounds(840, 17, 178, 14);
        labMCQ.setText("MCQ'S :");
        f.add(labMCQ);

        tMCQ = text();
        tMCQ.setBounds(840, 37, 260, 52);
        f.add(tMCQ);

        labA = label();
        labA.setBounds(840, 89, 178, 14);
        labA.setText("Option A");
        f.add(labA);

        tA = text();
        tA.setBounds(840, 110, 260, 52);
        f.add(tA);

        labB = label();
        labB.setBounds(840, 164, 178, 14);
        labB.setText("Option B");
        f.add(labB);

        tB = text();
        tB.setBounds(840, 189, 260, 52);
        f.add(tB);

        labC = label();
        labC.setBounds(840, 245, 178, 14);
        labC.setText("Option C");
        f.add(labC);

        tC = text();
        tC.setBounds(840, 270, 260, 52);
        f.add(tC);

        labD = label();
        labD.setBounds(840, 336, 178, 14);
        labD.setText("Option D");
        f.add(labD);

        tD = text();
        tD.setBounds(840, 361, 260, 52);
        f.add(tD);

        int xCord = 840;
        grp = new ButtonGroup();
        for (int i = 0; i < right.length; i++) {
            right[i] = new JRadioButton();
            right[i].setBounds(xCord, 441, 33, 23);
            if (i == 0) {
                right[i].setText("A");
            } else if (i == 1) {
                right[i].setText("B");
            } else if (i == 2) {
                right[i].setText("C");
            } else if (i == 3) {
                right[i].setText("D");
            }
            right[i].setActionCommand(right[i].getText());
            grp.add(right[i]);
            f.add(right[i]);
            xCord = xCord + 55;
        }
        table = new JTable();
        table.setModel(get());
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

        JScrollPane jsp = new JScrollPane();
        header.setPreferredSize(new Dimension(jsp.getWidth(), 45));
        jsp.setViewportView(table);

        jsp.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        p.add(jsp, BorderLayout.CENTER);
        f.add(p);

        frame();
        table.addMouseListener(this);
        butAdd.addActionListener(this);
        butRet.addActionListener(this);
        butDEL.addActionListener(this);
        butUpd.addActionListener(this);
    }

    void frame() {

        f.setSize(1150, 600);
        f.setTitle("Admin Update");
        //this.setBackground(Color.white);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    JButton button() {
        return new JButton();

    }

    JTextField text() {
        return new JTextField("");

    }

    JLabel label() {
        return new JLabel();
    }

    void setTableName(String t) {
        Admin_UpdateWithJTable.tableName = t;
    }

    void createDataBase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/examinationsystem", "root", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    

    DefaultTableModel get() {
        try {
            DefaultTableModel dm = new DefaultTableModel();
            createDataBase();
            st = con.createStatement();
            //s = "select MCQ,Opt_A,Opt_B,Opt_C,Opt_D,Right_Option from 9th_Chemistry";
            s = "select MCQ,Opt_A,Opt_B,Opt_C,Opt_D,Right_Option from "+tableName+" ";
            rs = st.executeQuery(s);
            ResultSetMetaData rsmt = rs.getMetaData();
            c = rsmt.getColumnCount();

            System.out.println(c);
            Vector column = new Vector(c);
            for (int i = 1; i <= c; i++) {
                System.out.println(rsmt.getColumnName(i));

                dm.addColumn(rsmt.getColumnName(i));
            }

            Vector data = new Vector();
            Vector row = new Vector();
            while (rs.next()) {
                row = new Vector(c);
                for (int i = 1; i <= c; i++) {

                    row.add(rs.getString(i));
                }
                dm.addRow(row);
            }

            return dm;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    void close() {
        try {
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
            if (rs != null) {
                rs.close();
            }

        } catch (Exception c) {

        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        String mcq = table.getValueAt(table.getSelectedRow(), 0).toString();
        tempMcq=mcq;
        String optA = table.getValueAt(table.getSelectedRow(), 1).toString();
        String optB = table.getValueAt(table.getSelectedRow(), 2).toString();
        String optC = table.getValueAt(table.getSelectedRow(), 3).toString();
        String optD = table.getValueAt(table.getSelectedRow(), 4).toString();
        String ryt = table.getValueAt(table.getSelectedRow(), 5).toString();
        System.err.println(tempMcq);
        
        tMCQ.setText(mcq);
        tA.setText(optA);
        tB.setText(optB);
        tC.setText(optC);
        tD.setText(optD);

        if (ryt.equals("A")) {
            right[0].setSelected(true);
        } else if (ryt.equals("B")) {
            right[1].setSelected(true);
        } else if (ryt.equals("C")) {
            right[2].setSelected(true);
        } else if (ryt.equals("D")) {
            right[3].setSelected(true);
        }

    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    void retrieve() {
        table.setModel(get());

    }

    Boolean insert(String mcq, String optA, String optB, String optC, String optD, String tempRyt) {
        try {
            createDataBase();
            s = "insert into "+ tableName+ " (MCQ,Opt_A,Opt_B,Opt_C,Opt_D,Right_Option,verify) values"
                    + "(?,?,?,?,?,?,?)";
            pst = con.prepareStatement(s);
            pst.setString(1, mcq);
            pst.setString(2, optA);
            pst.setString(3, optB);
            pst.setString(4, optC);
            pst.setString(5, optD);
            pst.setString(6, tempRyt);
            pst.setBoolean(7, false);
            pst.executeUpdate();
            pst.close();
            return true;
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
        }
        return false;
    }
Boolean update(String mcq, String optA, String optB, String optC, String optD, String tempRyt) {
    //String sql="update "+tableName+" set opt_A=?";
    try{
        createDataBase();
        String sql="update "+ tableName+ " set MCQ=?, opt_A=? , opt_B=? , opt_C=? , opt_D=? ,Right_Option=? where MCQ=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, mcq);
            pst.setString(2, optA);
            pst.setString(3, optB);
            pst.setString(4, optC);
            pst.setString(5, optD);
            pst.setString(6, tempRyt);
            //pst.setBoolean(7, false);
            pst.setString(7, tempMcq);
            pst.executeUpdate();
            pst.close();
            return true;
    }
    catch(Exception upd)
    {
        System.err.println(upd.getMessage());
    }
    return false;
}
Boolean delete()
{
    try
    {
        if(tempMcq==null)
        {
            return false;
        }
        createDataBase();
        String sql="Delete from "+ tableName+ " where MCQ=? ";
        pst=con.prepareStatement(sql);
        pst.setString(1, tMCQ.getText());
        pst.executeUpdate();
            pst.close();
            return true;
    }
    catch(Exception del){
        System.out.println(del.getMessage());
    }
    return false;
}
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == butAdd) {
            if (tMCQ.getText().isEmpty() || tA.getText().isEmpty() || tB.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Make sure all the * fields are filled");

            } else if (!(right[0].isSelected()) && !(right[1].isSelected()) && !(right[2].isSelected()) && !(right[3].isSelected())) {
                JOptionPane.showMessageDialog(null, "Select the Right Answer");
            } 
            else {
                if (insert(tMCQ.getText(), tA.getText(), tB.getText(),
                        tC.getText(), tD.getText(), grp.getSelection().getActionCommand())) 
                {
                    JOptionPane.showMessageDialog(null, "Successfully Inserted");
                    tMCQ.setText("");
                    tA.setText("");
                    tB.setText("");
                    tC.setText("");
                    tD.setText("");
                    for(int j=0;j<right.length;j++)
                    {
                        right[j].setSelected(false);
                    }
                    retrieve();
                }
                     
                     else{
                             JOptionPane.showMessageDialog(null, "Not Inserted");
                             }
            }
        }
        else if(ae.getSource()==butRet)
        {
            retrieve();
            tMCQ.setText("");
                    tA.setText("");
                    tB.setText("");
                    tC.setText("");
                    tD.setText("");
                    right[0].setSelected(false);
        }
        if(ae.getSource()==butDEL)
        {
            if(delete())
            {
                    JOptionPane.showMessageDialog(null, "Successfully Deleted");
                    tMCQ.setText("");
                    tA.setText("");
                    tB.setText("");
                    tC.setText("");
                    tD.setText("");
                    for(int j=0;j<right.length;j++)
                    {
                        right[j].setSelected(false);
                    }
                    retrieve();
            }
            else{
                JOptionPane.showMessageDialog(null, "Not Deleted");
            }
        }
        else if(ae.getSource()==butUpd)
        {
           if( update(tMCQ.getText(), tA.getText(), tB.getText(),
                        tC.getText(), tD.getText(), grp.getSelection().getActionCommand()))
           {
               JOptionPane.showMessageDialog(null, "Successfully Updated");
                    tMCQ.setText("");
                    tA.setText("");
                    tB.setText("");
                    tC.setText("");
                    tD.setText("");
                    for(int j=0;j<right.length;j++)
                    {
                        right[j].setSelected(false);
                    }
                    retrieve();
               
           }
           else{
               JOptionPane.showMessageDialog(null, "Not Updated");
               
           }
        }
    }

}
