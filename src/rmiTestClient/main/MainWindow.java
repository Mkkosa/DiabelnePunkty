package rmiTestClient.main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Kosa on 29.05.2017.
 */
public class MainWindow extends JFrame {

    public MainWindow (){
        setSize(1000,700);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Main game");

        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
        add(panel);
        panel.setBounds(40,40,600,600);

        JPanel help = new JPanel();
        help.setBackground(Color.GRAY);
        add(help);
        help.setBounds(700,40,250,300);

        JPanel stat = new JPanel();
        stat.setBackground(Color.LIGHT_GRAY);
        add(stat);
        stat.setBounds(700,360,250,280);



        setVisible(true);
    }
}
