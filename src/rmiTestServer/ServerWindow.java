package rmiTestServer;

import javax.swing.*;

/**
 * Created by Kosa on 05.06.2017.
 */
public class ServerWindow extends JFrame {

    public ServerWindow(){
        setSize(250,250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setLayout(null);

        JLabel label = new JLabel();
        add(label);
        label.setBounds(50,50,200,100);
        label.setText("Serwer wystartowal");

        setVisible(true);
    }

}
