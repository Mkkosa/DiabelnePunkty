package rmiTestServer;

import java.rmi.registry.*;
import rmiTestMeeting.Constatns;

public class MeetingServer {
    public static void main(String[] args) throws Exception {
        System.setSecurityManager(new SecurityManager());
        MeetingImpl impl = new MeetingImpl();
        Registry registry = LocateRegistry.createRegistry(Constatns.RMI_REGISTRY_PORT);
        registry.rebind(Constatns.OBJECT_ID, impl);
        System.out.println("Serwer wystartowal !!! ");
    }
}
