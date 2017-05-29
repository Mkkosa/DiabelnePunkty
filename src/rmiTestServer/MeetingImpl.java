package rmiTestServer;

import java.awt.*;
import java.awt.List;
import java.rmi.RemoteException;
import java.text.FieldPosition;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import rmiTestMeeting.IMeeting;


public class MeetingImpl extends UnicastRemoteObject implements IMeeting {

    private static final long serialVersionUID = 1L;
    private Date date = new Date();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    private ArrayList nameList = new ArrayList();
    private ArrayList statList = new ArrayList();
    private ArrayList locationXList = new ArrayList();
    private ArrayList locationYList = new ArrayList();
    private Random random = new Random();

    public MeetingImpl() throws RemoteException {

    }

    public String getDate() throws RemoteException {
        return simpleDateFormat.format(date, new StringBuffer(), new FieldPosition(0)).toString();
    }

    public void setDate(String date) throws RemoteException {
        try {
            this.date = (Date) simpleDateFormat.parse(date);
        } catch (ParseException e) {
            throw new RemoteException("zly format daty! \npoprawny format: dd-MM-yyyy");
        }
    }

    public int setName(String nickName) throws RemoteException{
        int id;
        nameList.add(nickName);
        id = nameList.indexOf(nickName);
        statList.add(id, 0);
        locationXList.add(id, random.nextInt(600));
        locationYList.add(id, random.nextInt(600));
        return id;
    }

    public int getLocationXListElement (int id) throws RemoteException{
        return (int) locationXList.get(id);
    }

    public void setLocationXListElement (int X, int id) throws RemoteException{
        locationXList.set(id,X);
    }

    public void setLocationYListElement (int Y, int id) throws RemoteException{
        locationYList.set(id,Y);
    }

    public int getCountPlayer () throws  RemoteException{
        return locationXList.size();
    }

    public int getLocationYListElement (int id) throws RemoteException{
        return (int) locationYList.get(id);
    }

    public int getStatListElement (int id) throws RemoteException{
        return (int) statList.get(id);
    }

}
