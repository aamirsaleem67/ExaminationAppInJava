/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examSystem;

/**
 *
 * @author ubit
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class tabedpaneUser implements ActionListener, ChangeListener {

    static JFrame f;
    JTabbedPane tab;
    JPanel resultPanel;
    JTable table;
    JScrollPane jsp;
    Connection con;
    ResultSet rs;
    Statement st;
    String s;
    
    JPanel FClass;
    JLabel LClass;
    JPanel PClass;
    JRadioButton r[] = new JRadioButton[4];
    JButton next;
    int rvert = 18;
    ButtonGroup g1;
    static String user="";
    
    JPanel pane;
    
    void createFrame() {
        //exam e=new exam();
        user=exam.text;
        f.setSize(700, 400);

        f.setVisible(true);
        //f.setLocation(C);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void prepareTabPanel() {
        f = new JFrame();
        f.setLayout(new BorderLayout());
        tab = new JTabbedPane();

        resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());
        //resultPanel.setBorder(new LineBorder(Color.BLACK,1));
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
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jsp.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        resultPanel.add(jsp, BorderLayout.CENTER);
        Icon c = null;
        tab.addTab("My Result", c, resultPanel, "Result");
        //create_passpanel();
        
        tab.addTab("Change Password", null, new checkClass3().create_passpanel(), "Password");
        pane=createClassFrame();
        tab.addTab("Start Paper", null, pane, "Start Paper");
        f.add(tab, BorderLayout.CENTER);

        createFrame();
        int i = tab.indexOfComponent(resultPanel);
        System.out.println(i);
        tab.addChangeListener(this);

    }

    void createDataBase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/examinationsystem", "root", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    int c;

    DefaultTableModel get() {
        try {
            DefaultTableModel dm = new DefaultTableModel();
            createDataBase();
            st = con.createStatement();
           // s = "select Subject,Class,Result from result_record where User='"+exam.text+"'";
            s= "select Subject,Class,Correct,InCorrect,Questions_Attempted from result_record2 where User='"+exam.text+"'";
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

    

    @Override
    public void actionPerformed(ActionEvent ae) {
              if(ae.getSource()==next)
              {
                 // 
                  
                  if(r[0].isSelected())
        {
           
                  JPanel subPanel=new checkClass2().create_FrameSub();
                  tab.setComponentAt(2, subPanel);
            
        }
        else if(r[1].isSelected()){
            
                  JPanel subPanel=new ChooseSubject10th().create_FrameSub();
                  tab.setComponentAt(2, subPanel);
        }
        else if(r[2].isSelected())
        {
            
           JPanel subPanel=new ChooseSubject11th().create_FrameSub();
                  tab.setComponentAt(2, subPanel);
        }
        else if(r[3].isSelected())
        {
            JPanel subPanel=new ChooseSubject12th().create_FrameSub();
                  tab.setComponentAt(2, subPanel);
        }
        else{
            JOptionPane.showMessageDialog(null, "Please Select one option");
        }
                  
              }
     }

    @Override
    public void stateChanged(ChangeEvent ce) {
        int index = tab.getSelectedIndex();
        if (index == 2) {
            
            //tab.setPreferredSize(new Dimension(435,390));
            f.setSize(467, 420);
            f.setVisible(true);
            tab.setComponentAt(2, pane);
            System.out.println(user);
            //tab.setComponentAt(2,new checkClass2().create_FrameSub());
           //tab.setComponentAt(2, null);
        }
        else if (index == 0) {
            f.setSize(700, 400);

            f.setVisible(true);
        }
        else if (index == 1) {
            f.setSize(700, 400);

            f.setVisible(true);
        }
        

    } 
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
        //next.addActionListener(this);
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
   
}
