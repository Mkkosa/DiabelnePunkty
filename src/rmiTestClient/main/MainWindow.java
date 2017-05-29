package rmiTestClient.main;

import rmiTestMeeting.IMeeting;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.RemoteException;

/**
 * Created by Kosa on 29.05.2017.
 */
public class MainWindow extends JFrame implements KeyListener {

    JPanel panel,help,stat;
    JLabel stat1, stat2, stat3;
    boolean left=false, right=false;
    JLabel[] players = new JLabel[10];
    int id;
    int countPlayers =0;
    IMeeting meeting;
    int X=0,Y=0;

    public MainWindow (int id, IMeeting meeting){
        this.id=id;
        this.meeting=meeting;
        setSize(1000,700);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Main game");
        createJPanels();
        addKeyListener(this);

        setVisible(true);
    }

    public void run (){

    }

    public void createJPanels (){
        createPanel();
        createHelp();
        createStat();
    }

    public void createPanel(){
        panel = new JPanel();
        panel.setBackground(Color.CYAN);
        add(panel);
        panel.setLayout(null);
        panel.setBounds(40,40,600,600);
        int i =0;
        while (i<10){
            if (id==i){
                players[i] = new JLabel("O");
            } else {
                players[i] = new JLabel("X");
            }
            players[i].setBounds(0,0,20,20);
            panel.add(players[i]);
            i++;
        }
    }

    public void createHelp (){
        help = new JPanel();
        help.setBackground(Color.GRAY);
        add(help);
        help.setLayout(null);
        help.setBounds(700,40,250,300);

        JLabel tittle = new JLabel("Pomoc");
        tittle.setBounds(80,10,100,30);
        help.add(tittle);

        JLabel help1 = new JLabel("<-  - skrec w lewo");
        JLabel help2 = new JLabel("->  - skrec w prawo");
        help1.setBounds(60,60,100,40);
        help2.setBounds(60,100,120,40);
        help.add(help1);
        help.add(help2);

        JLabel help3 = new JLabel("1 - punkty dodatnie");
        JLabel help4 = new JLabel("2 - punkty ujemne");
        help3.setBounds(60,140,120,40);
        help4.setBounds(60,180,100,40);
        help.add(help3);
        help.add(help4);

        JLabel help5 = new JLabel("X - przeciwnicy");
        JLabel help6 = new JLabel("O - Ty");
        help5.setBounds(60,220,100,40);
        help6.setBounds(60,260,100,40);
        help.add(help5);
        help.add(help6);
    }

    public void createStat (){
        stat = new JPanel();
        stat.setBackground(Color.LIGHT_GRAY);
        add(stat);
        stat.setBounds(700,360,250,280);
        stat.setLayout(null);

        JLabel stat0 = new JLabel("Statystki");
        stat1 = new JLabel("1. nobody 0pkt");
        stat2 = new JLabel("2. nobody 0pkt");
        stat3 = new JLabel("3. nobody 0pkt");

        stat0.setBounds(80,10,100,30);
        stat1.setBounds(60,60,100,40);
        stat2.setBounds(60,120,100,40);
        stat3.setBounds(60,180,100,40);

        stat.add(stat0);
        stat.add(stat1);
        stat.add(stat2);
        stat.add(stat3);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch(key) {
            case KeyEvent.VK_RIGHT:
                System.out.println("prawo");
                setYourLocation();
                refreshLocations();
                break;
            case KeyEvent.VK_LEFT:
                left = true;
                setYourLocation();
                refreshLocations();
                break;
            default:
                setYourLocation();
                refreshLocations();
                break;
        }

    }

    public void refreshLocations (){
        int i =0;
        try {
            countPlayers=meeting.getCountPlayer();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        while (i<countPlayers){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                players[i].setBounds(meeting.getLocationXListElement(i), meeting.getLocationYListElement(i),20,20);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            i++;
        }
    }

    public void setYourLocation () {
        try {
            meeting.setLocationXListElement(X,id);
            meeting.setLocationYListElement(Y,id);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}