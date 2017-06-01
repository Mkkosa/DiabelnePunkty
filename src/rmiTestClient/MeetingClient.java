package rmiTestClient;

import java.io.*;
import java.rmi.Remote;
import java.rmi.registry.*;
import java.util.Random;

import rmiTestClient.main.MainWindow;
import rmiTestClient.setAddres.AdressFrame;
import rmiTestClient.setNickName.setNameWindow;
import rmiTestMeeting.Constatns;
import rmiTestMeeting.IMeeting;

import javax.swing.*;

public class MeetingClient {
    public static void main(String[] args) {
        String address, nickName;
        int id;
        Random random =new Random();

        try {

            AdressFrame adressFrame = new AdressFrame();
            while(!adressFrame.getAddressOkButton().getFlag()){
                Thread.sleep(50);
            }
            address=adressFrame.getAddressOkButton().getAddress();
            // 1. ustawienie managera bezpieczeństwa
            System.setSecurityManager(new SecurityManager());
            System.out.println(Integer.parseInt(address.substring(address.length()-4, address.length())));
            Registry registry = LocateRegistry.getRegistry(address.substring(0,address.length()-5), Integer.parseInt(address.substring(address.length()-4, address.length())));


            adressFrame.close();
            // 2. sprawdzenie zdalnego obiektu w serwerze nazw

            Remote remote = registry.lookup(Constatns.OBJECT_ID);

            String string = null;
            IMeeting meeting;
            if (remote instanceof IMeeting) {
                meeting = (IMeeting) remote;
                // 3. wywołanie zdalnej metody
               // int i=0;
               /* while (i<10){
                    meeting.setLocationPlusY(random.nextInt(570),i);
                    meeting.setLocationPlusX(random.nextInt(570),i);
                    meeting.setLocationMinusX(random.nextInt(570),i);
                    meeting.setLocationMinusY(random.nextInt(570),i);
                    i++;
                }*/

                setNameWindow setNameWindow = new setNameWindow();

                while (setNameWindow.getFlag()){
                    Thread.sleep(50);
                }
                nickName = setNameWindow.getNickName();
                id = meeting.setName(nickName);
                System.out.println("Nadano id numer: " + id);
                System.out.println("Nadano nick: " +nickName);

                MainWindow mainWindow = new MainWindow(id, meeting);
              //  mainWindow.run();



               /* string = meeting.getDate();
                System.out.println("Data z systemu zdalnego: " + string);
                System.out.print("\n\nPodaj Date (dzien-miesiac-rok):");
                BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
                String line = bis.readLine();
                meeting.setDate(line);
                System.out.println("\n\nDate zmieniono !!!!\n\n");
                System.out.println("Data z systemu zdalnego: " + meeting.getDate() + "\n\n");
                bis.readLine();*/
            }
        } catch (Exception ioe) {
            ioe.printStackTrace();

            //ErrorAddress errorAddress = new ErrorAddress();
        }
    }

}
