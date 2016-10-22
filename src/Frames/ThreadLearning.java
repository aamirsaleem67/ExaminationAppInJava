/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import javax.swing.*;
import java.util.Timer;

/**
 *
 * @author ubit
 */
public class ThreadLearning implements ActionListener {

    int time = 3;
    int c = 10;
    Thread thr = new Thread();
    JFrame f;
    JButton b;
    JLabel lab1,lab2,lab3;

    void timing() {
        final Timer tm = new Timer();
         //final int c1=10;
        //final int time1 = 3;
        TimerTask task = new TimerTask() {
            int c1 = 60;
            int time1 = 3;

            @Override
            public void run() {

                if (time1 == 0) {
                    tm.cancel();
                    f.dispose();
                }
                else{
                //System.err.println(c1);
                    String sec=null;
                    sec=""+c1;
                    lab3.setText(sec);
                if (c1 == 0) {
                    time1 = time1 - 1;
                    String mins=""+time1;
                   lab1.setText("    "+mins);
                    //System.err.println("time :" + time1);
                    c1 = 60;

                } else {
                    c1--;
                }

            }
            }

        };

        tm.scheduleAtFixedRate(task, 0, 1000);

    }

    void frame() {

        f = new JFrame();
        b = new JButton("Start");
        b.setBounds(50, 50, 75, 75);
        
        f.add(b);
        lab1=new JLabel("");
        lab1.setBounds(50,200,30,50);
        f.add(lab1);
        
        lab2=new JLabel(":");
        lab2.setBounds(82,200,20,50);
        f.add(lab2);
        
        lab3=new JLabel("");
        lab3.setBounds(105,200,100,50);
        f.add(lab3);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.addActionListener(this);
    }

    void threading() throws InterruptedException {

        for (int c = 10; c >= 0; c--) {
            thr.sleep(1000);
            if (time == 0) {
                break;
            }
           String sec=""+c;
           lab1.setText(sec);

            if (c == 0) {
                time = time - 1;
               String mins=""+time;
               lab3.setText(mins);
                //System.err.println("time :" + time);
                c = 11;
                continue;
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        timing();
        lab1.setText("   3");
        b.setText("Hum na ho hamare bad");
        
        //f.setSize(400,400);
        //f.setVisible(true);
        b.enable(false);

    }

}
