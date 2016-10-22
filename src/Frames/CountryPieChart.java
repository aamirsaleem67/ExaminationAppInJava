/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;


public class CountryPieChart {
    ResultSet rs;
    Connection conn;
    Statement st;
    static int sri=0,afg=0,pak=0,uae=0,ind=0,bang=0;
    void createDataBase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/examinationsystem", "root", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
    CountryPieChart()
    {
        
        try {
            createDataBase();
            String sql="select Location from signup5";
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next())
            {
                String  s=rs.getString("Location");
                System.out.println(s);
                if(s.equals("Srilanka"))
                {
                    sri++;
                }
                else if(s.equals("Afghanistan"))
                {
                    afg++;
                }
                else if(s.equals("Pakistan"))
                {
                    //System.err.println("pak");
                    pak=pak+1;
                }
                else if(s.equals("UAE"))
                {
                    uae++;
                }
                else if(s.equals("Bangladesh"))
                {
                    bang++;
                }
                
            }
            
            //System.out.println(pak+","+uae
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Pakistan", pak);
        dataset.setValue("UAE", uae);
        dataset.setValue("Srilanka", sri);
        dataset.setValue("Afghanistan", afg);
        dataset.setValue("India", ind);
        JFreeChart chart = ChartFactory.createPieChart("Number Of Users by Country", dataset);
        PiePlot p = (PiePlot) chart.getPlot();
        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} {1}");
        
        
        p.setLabelGenerator(labelGenerator);
        //p.setSimpleLabels(true);
        ChartFrame frame = new ChartFrame("Pie Chart", chart);
        frame.setVisible(true);
        frame.setSize(450, 550);
        } catch (SQLException ex) {
            Logger.getLogger(CountryPieChart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
