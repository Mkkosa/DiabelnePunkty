package rmiTestClient.setAddres;

import rmiTestClient.setAddres.ResultsWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kosa on 23.05.2017.
 */
public class ResultWindowOkButton extends JButton implements ActionListener {

    ResultsWindow resultsWindow;
    boolean flag;

    public ResultWindowOkButton (ResultsWindow resultsWindow, boolean flag){
        this.resultsWindow = resultsWindow;
        this.flag=flag;
        addActionListener(this);
        setText("OK");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (flag) {
           resultsWindow.close();
       } else {
           resultsWindow.dispose();
       }
    }
}
