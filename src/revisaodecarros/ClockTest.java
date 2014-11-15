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
            clock.setText(data.getHours()+":"+data.getMinutes()+":"+data.getSeconds());
        }
    };
    timer = new Timer(delay, taskPerformer);
    timer.start();
  }  
  public void stop(){
      timer.stop();
  }
}