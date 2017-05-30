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

    public int getLocationPlusX (int plusId) throws  RemoteException;

    public int getLocationPlusY (int plusId) throws  RemoteException;

    public int getLocationMinusX (int minusId) throws  RemoteException;

    public int getLocationMinusY (int minusId) throws  RemoteException;

    public void setLocationPlusX (int X, int plusId) throws  RemoteException;

    public void setLocationPlusY (int Y, int plusId) throws  RemoteException;

    public void setLocationMinusX (int X, int minusId) throws  RemoteException;

    public void setLocationMinusY (int Y, int minusId) throws  RemoteException;

    public int getStat (int id) throws RemoteException;

    public void setStat (int id, int values) throws RemoteException;

    public void updateLocationPlusX (int X, int plusId) throws  RemoteException;

    public void updateLocationPlusY (int Y, int plusId) throws RemoteException;

    public void updateLocationMinusX (int X, int minusId) throws  RemoteException;

    public void updateLocationMinusY (int Y, int minusId) throws  RemoteException;

    public String getName (int id)throws RemoteException;
}