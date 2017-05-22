package rmiTestClient;

import java.io.*;
import java.rmi.Remote;
import java.rmi.registry.*;
import rmiTestMeeting.Constatns;
import rmiTestMeeting.IMeeting;

public class MeetingClient {
    public static void main(String[] args) {
        String address;

        try {

            AdressFrame adressFrame = new AdressFrame();
            while(!adressFrame.getAddressOkButton().getFlag()){
                Thread.sleep(50);
            }
            address=adressFrame.getAddressOkButton().getAddress();
            // 1. ustawienie managera bezpieczeństwa
            System.setSecurityManager(new SecurityManager());
            Registry registry = LocateRegistry.getRegistry(address.substring(0,address.length()-5), Integer.parseInt(address.substring(address.length()-4, address.length())));

            // 2. sprawdzenie zdalnego obiektu w serwerze nazw
            Remote remote = registry.lookup(Constatns.OBJECT_ID);
            String string = null;
            IMeeting meeting;
            if (remote instanceof IMeeting) {
                meeting = (IMeeting) remote;
                // 3. wywołanie zdalnej metody
                string = meeting.getDate();
                System.out.println("Data z systemu zdalnego: " + string);
                System.out.print("\n\nPodaj Date (dzien-miesiac-rok):");
                BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
                String line = bis.readLine();
                meeting.setDate(line);
                System.out.println("\n\nDate zmieniono !!!!\n\n");
                System.out.println("Data z systemu zdalnego: " + meeting.getDate() + "\n\n");
                bis.readLine();
            }
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
    }

}
