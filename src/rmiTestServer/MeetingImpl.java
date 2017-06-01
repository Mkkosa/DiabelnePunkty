package rmiTestServer;

import java.awt.*;
import java.awt.List;
import java.rmi.RemoteException;
import java.text.FieldPosition;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.sun.org.apache.regexp.internal.RE;
import rmiTestMeeting.IMeeting;


public class MeetingImpl extends UnicastRemoteObject implements IMeeting {

    private static final long serialVersionUID = 1L;
    private Date date = new Date();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    private ArrayList nameList = new ArrayList();
    private ArrayList statList = new ArrayList();
    private ArrayList locationXList = new ArrayList();
    private ArrayList locationYList = new ArrayList();
    private ArrayList locationPlusX = new ArrayList(10);
    private ArrayList locationPlusY = new ArrayList(10);
    private ArrayList locationMinusX = new ArrayList(10);
    private ArrayList locationMinusY = new ArrayList(10);

    private Random random = new Random();

    public MeetingImpl() throws RemoteException {

    }


    public synchronized String getName (int id)throws RemoteException{
        return (String) nameList.get(id);
    }

    public synchronized int getStat (int id) throws RemoteException{
        return (int) statList.get(id);
    }

    public synchronized void setStat (int id, int values) throws RemoteException{
        statList.add(id, values);
    }

    public synchronized int getLocationPlusX (int plusId) throws  RemoteException{
        return (int) locationPlusX.get(plusId);
    }

    public synchronized int getLocationPlusY (int plusId) throws  RemoteException{
        return (int) locationPlusY.get(plusId);
    }

    public synchronized int getLocationMinusX (int minusId) throws  RemoteException{
        return (int) locationMinusX.get(minusId);
    }

    public synchronized int getLocationMinusY (int minusId) throws  RemoteException{
        return (int) locationMinusY.get(minusId);
    }

    public synchronized void setLocationPlusX (int X, int plusId) throws  RemoteException{
        locationPlusX.add(plusId,X);
    }

    public synchronized void updateLocationPlusX (int X, int plusId) throws  RemoteException{
        locationPlusX.set(plusId,X);
    }

    public synchronized void updateLocationPlusY (int Y, int plusId) throws RemoteException{
        locationPlusY.set(plusId,Y);
    }

    public synchronized void setLocationPlusY (int Y, int plusId) throws  RemoteException{
        locationPlusY.add(plusId,Y);
    }

    public synchronized void setLocationMinusX (int X, int minusId) throws  RemoteException{
        locationMinusX.add(minusId,X);
    }

    public synchronized void updateLocationMinusX (int X, int minusId) throws  RemoteException{
        locationMinusX.set(minusId,X);
    }

    public synchronized void updateLocationMinusY (int Y, int minusId) throws  RemoteException{
        locationMinusY.set(minusId,Y);
    }

    public synchronized void setLocationMinusY (int Y, int minusId) throws  RemoteException{
        locationMinusY.add(minusId,Y);
    }

    public synchronized String getDate() throws RemoteException {
        return simpleDateFormat.format(date, new StringBuffer(), new FieldPosition(0)).toString();
    }

    public synchronized void setDate(String date) throws RemoteException {
        try {
            this.date = (Date) simpleDateFormat.parse(date);
        } catch (ParseException e) {
            throw new RemoteException("zly format daty! \npoprawny format: dd-MM-yyyy");
        }
    }

    public synchronized int setName(String nickName) throws RemoteException{
        int id;
        nameList.add(nickName);
        id = nameList.indexOf(nickName);
        statList.add(id, 0);
        locationXList.add(id, 0);
        locationYList.add(id, 0);
        return id;
    }

    public synchronized int getLocationXListElement (int id) throws RemoteException{
        return (int) locationXList.get(id);
    }

    public synchronized void setLocationXListElement (int X, int id) throws RemoteException{
        locationXList.add(id,X);
    }

    public synchronized void setLocationYListElement (int Y, int id) throws RemoteException{
        locationYList.add(id,Y);
    }

    public synchronized int getCountPlayer () throws  RemoteException{
        return nameList.size();
    }

    public synchronized int getLocationYListElement (int id) throws RemoteException{
        return (int) locationYList.get(id);
    }

    public synchronized int getStatListElement (int id) throws RemoteException{
        return (int) statList.get(id);
    }

}
