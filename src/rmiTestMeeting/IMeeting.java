package rmiTestMeeting;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMeeting extends Remote {
    String getDate() throws RemoteException;

    void setDate(String data) throws RemoteException;

    int setName(String nickName) throws RemoteException;

    int getLocationXListElement(int id) throws RemoteException;

    int getLocationYListElement(int id) throws RemoteException;

    int getStatListElement(int id) throws RemoteException;

    int getCountPlayer() throws  RemoteException;

    void setLocationXListElement(int X, int id) throws RemoteException;

    void setLocationYListElement(int Y, int id) throws RemoteException;

    int getLocationPlusX(int plusId) throws  RemoteException;

    int getLocationPlusY(int plusId) throws  RemoteException;

    int getLocationMinusX(int minusId) throws  RemoteException;

    int getLocationMinusY(int minusId) throws  RemoteException;

    void setLocationPlusX(int X, int plusId) throws  RemoteException;

    void setLocationPlusY(int Y, int plusId) throws  RemoteException;

    void setLocationMinusX(int X, int minusId) throws  RemoteException;

    void setLocationMinusY(int Y, int minusId) throws  RemoteException;

    int getStat(int id) throws RemoteException;

    void setStat(int id, int values) throws RemoteException;

    void updateLocationPlusX(int X, int plusId) throws  RemoteException;

    void updateLocationPlusY(int Y, int plusId) throws RemoteException;

    void updateLocationMinusX(int X, int minusId) throws  RemoteException;

    void updateLocationMinusY(int Y, int minusId) throws  RemoteException;

    String getName(int id)throws RemoteException;
}