/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revisaodecarros;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class ClockTest extends JFrame {
    
  JLabel clock;
  Timer timer;

  public ClockTest(final JLabel clock) {
    int delay = 1000; //milliseconds
    ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            Date  data = new Date();
            if(data.getSeconds() >= 0 && data.getSeconds() < 10)
            {
                if(data.getMinutes() >= 0 && data.getMinutes() < 10)
                {
                    if(data.getHours() >= 0 && data.getHours() < 10)
                    {
                        clock.setText(data.getDay()+"/"+data.getMonth()+"/"+(data.getYear()+1900)+" "+"0"+data.getHours()+":0"+data.getMinutes()+":0"+data.getSeconds());
                    }
                    else
                    {
                        clock.setText(data.getDay()+"/"+data.getMonth()+"/"+(data.getYear()+1900)+" "+data.getHours()+":0"+data.getMinutes()+":0"+data.getSeconds());
                    }
                }
                else
                {
                    if(data.getHours() >= 0 && data.getHours() < 10)
                    {
                        clock.setText(data.getDay()+"/"+data.getMonth()+"/"+(data.getYear()+1900)+" "+"0"+data.getHours()+":"+data.getMinutes()+":0"+data.getSeconds());
                    }
                    else
                    {
                        clock.setText(data.getDay()+"/"+data.getMonth()+"/"+(data.getYear()+1900)+" "+data.getHours()+":"+data.getMinutes()+":0"+data.getSeconds());
                    }
                }
            }
            else
            {
                if(data.getMinutes() >= 0 && data.getMinutes() < 10)
                {
                    if(data.getHours() >= 0 && data.getHours() < 10)
                    {
                        clock.setText(data.getDay()+"/"+data.getMonth()+"/"+(data.getYear()+1900)+" "+"0"+data.getHours()+":0"+data.getMinutes()+":"+data.getSeconds());
                    }
                    else
                    {
                        clock.setText(data.getDay()+"/"+data.getMonth()+"/"+(data.getYear()+1900)+" "+data.getHours()+":0"+data.getMinutes()+":"+data.getSeconds());
                    }
                }
                else
                {
                    if(data.getHours() >= 0 && data.getHours() < 10)
                    {
                        clock.setText(data.getDay()+"/"+data.getMonth()+"/"+(data.getYear()+1900)+" "+"0"+data.getHours()+":"+data.getMinutes()+":"+data.getSeconds());
                    }
                    else
                    {
                        clock.setText(data.getDay()+"/"+data.getMonth()+"/"+(data.getYear()+1900)+" "+data.getHours()+":"+data.getMinutes()+":"+data.getSeconds());
                    }
                }
            }
        }
    };
    timer = new Timer(delay, taskPerformer);
    timer.start();
  }  
  public void stop(){
      timer.stop();
  }
}