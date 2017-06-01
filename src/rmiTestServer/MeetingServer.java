package rmiTestServer;

import java.rmi.registry.*;
import java.util.Random;

import rmiTestMeeting.Constatns;

public class MeetingServer {
    public static void main(String[] args) throws Exception {
        Random random=new Random();
        int i=0;
        System.setSecurityManager(new SecurityManager());
        MeetingImpl impl = new MeetingImpl();
        Registry registry = LocateRegistry.createRegistry(Constatns.RMI_REGISTRY_PORT);
        registry.rebind(Constatns.OBJECT_ID, impl);
        System.out.println("Serwer wystartowal !!! ");
        while (i<10){
            impl.setLocationPlusY(random.nextInt(570),i);
            impl.setLocationPlusX(random.nextInt(570),i);
            impl.setLocationMinusX(random.nextInt(570),i);
            impl.setLocationMinusY(random.nextInt(570),i);
            i++;
        }
    }
}
