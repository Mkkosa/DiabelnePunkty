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
    int speed = 5, xj,yj;
    JLabel[] players;
    JLabel[] plus = new JLabel[10];
    JLabel[] minus = new JLabel[10];
    Random random = new Random();

    public GamePanel (MainWindow mainWindow, IMeeting meeting, JLabel[] players){
        this.mainWindow=mainWindow;
        this.meeting=meeting;
        this.players=players;
        int i =0;
        while (i<10){
            plus[i] = new JLabel("1");
            mainWindow.panel.add(plus[i]);
            try {
                plus[i].setBounds(meeting.getLocationPlusX(i),meeting.getLocationPlusY(i),10,10);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            minus[i] = new JLabel("2");
            mainWindow.panel.add(minus[i]);
            try {
                minus[i].setBounds(meeting.getLocationMinusX(i),meeting.getLocationMinusY(i),10,10);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            i++;
        }

    }

    public void run (){

        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

                mainWindow.refreshLocations();


            if (mainWindow.getChangeVector()==1){
                try {
                    mainWindow.X -= speed;
                    if (meeting.getLocationXListElement(mainWindow.id)<0) mainWindow.X=0;
                    meeting.setLocationXListElement(mainWindow.X,mainWindow.getId());
                    System.out.println(mainWindow.id);
                    System.out.println("x:"+mainWindow.X);
                    System.out.println("y:"+mainWindow.Y+"\n");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            } else if (mainWindow.getChangeVector()==0){
                try {
                    mainWindow.X += speed;
                    if (meeting.getLocationXListElement(mainWindow.id)>580) mainWindow.X=580;
                    meeting.setLocationXListElement(mainWindow.X,mainWindow.getId());
                    System.out.println(mainWindow.id);
                    System.out.println("x:"+mainWindow.X);
                    System.out.println("y:"+mainWindow.Y+"\n");

                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            } else if (mainWindow.getChangeVector()==2){
                try {
                    mainWindow.Y -= speed;
                    if (meeting.getLocationYListElement(mainWindow.id)<0) mainWindow.Y=0;
                    meeting.setLocationYListElement(mainWindow.Y,mainWindow.getId());
                    System.out.println(mainWindow.id);
                    System.out.println("x:"+mainWindow.X);
                    System.out.println("y:"+mainWindow.Y+"\n");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            } else if (mainWindow.getChangeVector()==3){
                try {
                    mainWindow.Y += speed;
                    if (meeting.getLocationYListElement(mainWindow.id)>580) mainWindow.Y=580;
                    meeting.setLocationYListElement(mainWindow.Y,mainWindow.getId());
                    System.out.println(mainWindow.id);
                    System.out.println("x:"+mainWindow.X);
                    System.out.println("y:"+mainWindow.Y+"\n");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            pluspkt();
            minuspkt();
            refresh();
        }
    }
    public int getYourLocationX (){
        try {
            return meeting.getLocationXListElement(mainWindow.getId());
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getYourLocationY (){
        try {
            return meeting.getLocationYListElement(mainWindow.getId());
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
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
                        System.out.println(mainWindow.statistic);
                        flag =false;
                    }
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            i++;
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
                        System.out.println(mainWindow.statistic);
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
