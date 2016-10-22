

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;


public class tabedpane {
    JFrame f;
    JTabbedPane tab;
    JPanel resultPanel;
    JTable table;
    JScrollPane jsp;
    Connection con;
    ResultSet rs;
    Statement st;
    String s;
    
    void createFrame()
    {
        f.setSize(600,500);
        
        f.setVisible(true);
        //f.setLocation(C);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    void prepareTabPanel()
    {
        f=new JFrame();
        f.setLayout(new BorderLayout());
        tab=new JTabbedPane();
        
        resultPanel=new JPanel();
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
        Icon c=null;
        tab.addTab("My Result",c,resultPanel,"Result");
        f.add(tab,BorderLayout.CENTER);
        createFrame();
        int i=tab.indexOfComponent(resultPanel);
        System.out.println(i);
        
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
            s = "select Subject,Class,Result from result_record where User='samaa'";
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

    
}
