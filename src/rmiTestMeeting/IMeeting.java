package rmiTestMeeting;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMeeting extends Remote {
    public String getDate() throws RemoteException;

    public void setDate(String data) throws RemoteException;

    public int setName(String nickName) throws RemoteException;

    public int getLocationXListElement (int id) throws RemoteException;

    public int getLocationYListElement (int id) throws RemoteException;

    public int getStatListElement (int id) throws RemoteException;

    public int getCountPlayer () throws  RemoteException;

    public void setLocationXListElement (int X, int id) throws RemoteException;

    public void setLocationYListElement (int Y, int id) throws RemoteException;
}