package rmiTestClient;

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

    public AddressOkButton (JTextField textField){
        this.textField = textField;
        addActionListener(this);
        setText("OK");
    }
    public void actionPerformed(ActionEvent e) {
        String addresss = textField.getText();
        String[] octAddressS = null;
        int[] octAddress = new int[5];
        pattern = Pattern.compile("[0-9][0-9]?[0-9]?.[0-9][0-9]?[0-9]?.[0-9][0-9]?[0-9]?.[0-9][0-9]?[0-9]?:[0-9][0-9][0-9][0-9]");
        matcher = pattern.matcher(addresss);
        if (matcher.matches()){

            octAddressS = addresss.split(".");
            System.out.print(octAddressS[0]);
            for (int i=0; i<5;i++) {
                octAddress[i] = Integer.parseInt(octAddressS[i]);
            }

            if (octAddress[0]<255 && octAddress[0]>0 && octAddress[1]<255 && octAddress[1]>=0 && octAddress[2]<255 && octAddress[2]>=0 && octAddress[3]<255 && octAddress[3]>=0 && octAddress[4]<255 && octAddress[4]>=0){
                System.out.println("ok");
            } else {
                System.out.println("zle");
            }
        } else {
            System.out.println("zle");
        }
        flag=true;
    }

    public boolean getFlag (){
        return flag;
    }
    public String getAddress (){
        return textField.getText();
    }
}
