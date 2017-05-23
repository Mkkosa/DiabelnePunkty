package rmiTestClient;

import javax.swing.*;

/**
 * Created by Kosa on 23.05.2017.
 */
public class ErrorAddress extends JFrame {
    public ErrorAddress(){
        setLayout(null);
        setSize(200,200);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Nie połaczono");
        label.setBounds(0,40,200,50);
        add(label);
        setVisible(true);
    }
}
