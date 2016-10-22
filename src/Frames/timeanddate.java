/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.sql.*;
import java.util.Date;
import java.text.DateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author ubit
 */
public class timeanddate {
    Connection con;
    ResultSet rs;
    Statement st;
    String s;
    DateFormat ft;
    Date date;
    timeanddate()
    {
        final Timer tm=new Timer();
        tm.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                System.out.println("aamir");
                tm.cancel();
            }
        },1000, 1000);
    }
    
    void createDataBase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/fortest", "root", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    void adddata()
    {
        createDataBase();
        try {
            s="insert into timeanddate(timing)values('"+ft.format(date)+"')";
            st=con.createStatement();
            st.executeUpdate(s);
        } catch (SQLException ex) {
            Logger.getLogger(timeanddate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
