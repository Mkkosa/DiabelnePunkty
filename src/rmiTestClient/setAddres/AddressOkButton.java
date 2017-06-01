package rmiTestClient.setAddres;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kosa on 20.05.2017.
 */
public class AddressOkButton extends JButton implements ActionListener {

    JTextField textField;
    boolean flag = false;
    Pattern pattern;
    Matcher matcher;
    AdressFrame adressFrame;
    ResultsWindow resultsWindow;

    public AddressOkButton (JTextField textField, AdressFrame adressFrame){
        this.textField = textField;
        this.adressFrame = adressFrame;
        addActionListener(this);
        setText("OK");
    }
    public void actionPerformed(ActionEvent e) {
        String addresss = textField.getText();
        String[] octAddressS = null;
        int i = 0, j=0;
        int[] oct4port = new int[2];
        int[] octAddress = new int[5];
        pattern = Pattern.compile("[1-9][0-9]?[0-9]?.[0-9][0-9]?[0-9]?.[0-9][0-9]?[0-9]?.[0-9][0-9]?[0-9]?:[0-9][0-9][0-9][0-9]");
        matcher = pattern.matcher(addresss);
        if (matcher.matches()){

            octAddressS = addresss.split("\\.");

            for(String retval: octAddressS){
                if (retval.startsWith(":",1)){
                    for (String retval1: retval.split(":")){
                        oct4port[j] = Integer.parseInt(retval1);
                        j++;
                    }
                } else  if (retval.startsWith(":",2)) {
                    for (String retval1 : retval.split(":")) {
                        oct4port[j] = Integer.parseInt(retval1);
                        j++;
                    }
                } else  if (retval.startsWith(":",3)) {
                    for (String retval1 : retval.split(":")) {
                        oct4port[j] = Integer.parseInt(retval1);
                        j++;
                    }
                } else {
                    octAddress[i] = Integer.parseInt(retval);
                }
                i++;
            }
            octAddress[3]=oct4port[0];
            octAddress[4]=oct4port[1];


            if (octAddress[0]<=255 && octAddress[0]>0 && octAddress[1]<=255 && octAddress[1]>=0 && octAddress[2]<=255 && octAddress[2]>=0 && octAddress[3]<=255 && octAddress[3]>=0 && octAddress[4]<=65000 && octAddress[4]>=0){
                resultsWindow = new ResultsWindow(this,"Poprawny adres", true);
                flag = true;
            } else {
                resultsWindow = new ResultsWindow(this,"Niepoprawny adres", false);
            }
        } else {
            resultsWindow = new ResultsWindow(this,"Zły format", false);
        }
    }

    public boolean getFlag (){
        return flag;
    }
    public String getAddress (){
        return textField.getText();
    }
    public void close (){adressFrame.close();}
    public int getLocationX (){return adressFrame.getLocation().x;}
    public int getLocationY (){return adressFrame.getLocation().y;}
}
