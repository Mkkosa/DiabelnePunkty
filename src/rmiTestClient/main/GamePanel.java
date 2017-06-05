package rmiTestClient.main;

import rmiTestMeeting.IMeeting;

import javax.swing.*;
import java.rmi.RemoteException;
import java.util.Random;

/**
 * Created by Kosa on 29.05.2017.
 */
public class GamePanel extends Thread {

    MainWindow mainWindow;
    IMeeting meeting;
    int speed = 10, xj,yj;
    JLabel[] players;
    JLabel[] plus = new JLabel[10];
    JLabel[] minus = new JLabel[10];
    Random random = new Random();
    JLabel bonus;

    public GamePanel (MainWindow mainWindow, IMeeting meeting, JLabel[] players){
        this.mainWindow=mainWindow;
        this.meeting=meeting;
        this.players=players;
        int i =0;
        while (i<10){
            plus[i] = new JLabel();
            plus[i].setIcon(new ImageIcon(getClass().getResource("resource/plus.png")));
            mainWindow.panel.add(plus[i]);
            try {
                plus[i].setBounds(meeting.getLocationPlusX(i),meeting.getLocationPlusY(i),10,10);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            minus[i] = new JLabel();
            minus[i].setIcon(new ImageIcon(getClass().getResource("resource/minus.png")));
            mainWindow.panel.add(minus[i]);
            try {
                minus[i].setBounds(meeting.getLocationMinusX(i),meeting.getLocationMinusY(i),10,10);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            i++;
        }
        bonus = new JLabel();
        bonus.setIcon(new ImageIcon(getClass().getResource("resource/bonus.png")));
        try {
            bonus.setBounds(meeting.getBonusX(),meeting.getBonusY(),15,15);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        mainWindow.panel.add(bonus);

    }

    public void run (){

        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

                mainWindow.refreshLocations();

            switch (mainWindow.getChangeVector()){
                case 1:
                    mainWindow.X -= speed;
                    if (mainWindow.X<0) mainWindow.X=580;
                    break;
                case 0:
                    mainWindow.X += speed;
                    if (mainWindow.X>580) mainWindow.X=0;
                    break;
                case 2:
                    mainWindow.Y -= speed;
                    if (mainWindow.Y<0) mainWindow.Y=580;
                    break;
                case 3:
                    mainWindow.Y += speed;
                    if (mainWindow.Y>580) mainWindow.Y=0;
                    break;
            }
            setLocation();
            bonuspkt();
            pluspkt();
            minuspkt();
            refresh();
        }
    }

    public void setLocation (){

        try {
            meeting.setLocationYListElement(mainWindow.Y,mainWindow.getId());
            meeting.setLocationXListElement(mainWindow.X,mainWindow.id);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void pluspkt(){
        int i =0;
        boolean flag = true;
        while (i<10 && flag){
            try {
                if (mainWindow.X<=meeting.getLocationPlusX(i)+10 && mainWindow.X>=meeting.getLocationPlusX(i)-10 && flag){
                    if (mainWindow.Y<=meeting.getLocationPlusY(i)+10 && mainWindow.Y>=meeting.getLocationPlusY(i)-10 && flag){
                        mainWindow.statistic = meeting.getStat(mainWindow.id);
                        mainWindow.statistic += 5;
                        meeting.setStat(mainWindow.id,mainWindow.statistic);
                        xj = random.nextInt(570);
                        yj = random.nextInt(570);
                        meeting.updateLocationPlusX(xj,i);
                        meeting.updateLocationPlusY(yj,i);
                        plus[i].setBounds(meeting.getLocationPlusX(i),meeting.getLocationPlusY(i),10,10);
                        flag =false;
                    }
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            i++;
        }
    }

    public void bonuspkt(){
        int values,X,Y;

        try {
            if(mainWindow.X<=meeting.getBonusX()+10 && mainWindow.X>=meeting.getBonusX()-10){
                if(mainWindow.Y<=meeting.getBonusY()+10 && mainWindow.Y>=meeting.getBonusY()-10){
                    values = random.nextInt(200)-100;
                    mainWindow.statistic = meeting.getStat(mainWindow.id);
                    mainWindow.statistic += values;
                    meeting.setStat(mainWindow.id,mainWindow.statistic);
                    X = random.nextInt(580);
                    Y = random.nextInt(580);
                    meeting.setBonusX(X);
                    meeting.setBonusY(Y);
                    bonus.setBounds(meeting.getBonusX(),meeting.getBonusY(),15,15);
                }

            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void minuspkt(){
        int i =0;
        boolean flag = true;
        while (i<10 && flag){
            try {
                if (mainWindow.X<=meeting.getLocationMinusX(i)+10 && mainWindow.X>=meeting.getLocationMinusX(i)-10 && flag){
                    if (mainWindow.Y<=meeting.getLocationMinusY(i)+10 && mainWindow.Y>=meeting.getLocationMinusY(i)-10 && flag){
                        mainWindow.statistic = meeting.getStat(mainWindow.id);
                        mainWindow.statistic -= 5;
                        meeting.setStat(mainWindow.id,mainWindow.statistic);
                        xj = random.nextInt(570);
                        yj = random.nextInt(570);
                        meeting.updateLocationMinusX(xj,i);
                        meeting.updateLocationMinusY(yj,i);
                        minus[i].setBounds(meeting.getLocationMinusX(i),meeting.getLocationMinusY(i),10,10);
                        flag =false;
                    }
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            i++;
        }
    }

    public void refresh(){
        int i =0;
        while (i<10){
            try {
                plus[i].setBounds(meeting.getLocationPlusX(i),meeting.getLocationPlusY(i),10,10);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

            try {
                minus[i].setBounds(meeting.getLocationMinusX(i),meeting.getLocationMinusY(i),10,10);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}
