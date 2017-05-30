package rmiTestClient.main;

import java.rmi.RemoteException;

/**
 * Created by Kosa on 30.05.2017.
 */
public class StatPanel extends Thread {

    MainWindow mainWindow;

    int first=0, second=0, third=0, idFirst, idSecond, idThird;
    int i;

    public StatPanel (MainWindow mainWindow){
        this.mainWindow=mainWindow;
    }
    public void run (){
        while (true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                i=0;
                while (i<10 && mainWindow.meeting.getCountPlayer()>=1){
                    if (first<mainWindow.meeting.getStat(i)){
                        first=mainWindow.meeting.getStat(i);
                        idFirst=i;
                    }
                }
                i=0;
                while (i<10 && mainWindow.meeting.getCountPlayer()>=2){
                    if (second<mainWindow.meeting.getStat(i)&&first!=second){
                        second=mainWindow.meeting.getStat(i);
                        idSecond=i;
                    }
                }
                i=0;
                while (i<10 && mainWindow.meeting.getCountPlayer()>=3){
                    if (third<mainWindow.meeting.getStat(i)&&first!=third&&second==third){
                        third=mainWindow.meeting.getStat(i);
                        idThird=i;
                    }
                }
                if (mainWindow.meeting.getCountPlayer() >= 1) {
                    mainWindow.stat1.setText("1. " + mainWindow.meeting.getName(idFirst) + ":" + first + " pkt");
                    if (mainWindow.meeting.getCountPlayer() >= 2) {
                        mainWindow.stat2.setText("2. " + mainWindow.meeting.getName(idSecond) + ":" + second + " pkt");
                        if (mainWindow.meeting.getCountPlayer() >= 3)
                        mainWindow.stat3.setText("3. " + mainWindow.meeting.getName(idThird) + ":" + third + " pkt");

                    }
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
