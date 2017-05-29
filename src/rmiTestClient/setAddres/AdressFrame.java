package rmiTestClient.setAddres;

import rmiTestClient.setAddres.AddressOkButton;

import javax.swing.*;

/**
 * Created by Kosa on 20.05.2017.
 */
public class AdressFrame extends JFrame {

    AddressOkButton addressOkButton;
    JTextField addressText;

    public AdressFrame (){

        setSize(250,250);
        setLocationByPlatform(true);

        setTitle("Connect with server.");
        setLayout(null);

        createLabel();
        createJTextAndButton();

        setVisible(true);
    }
    private void createLabel (){
        JLabel address = new JLabel("Check address");
        address.setBounds(50,10,150,40);
        add(address);
    }

    private void createJTextAndButton (){
        addressText = new JTextField("127.0.0.1:1099");
        addressText.setBounds(0,100,150,40);
        add(addressText);

        addressOkButton = new AddressOkButton(addressText, this);
        addressOkButton.setBounds(150,100,80,40);
        add(addressOkButton);
    }

    public AddressOkButton getAddressOkButton (){
        return addressOkButton;
    }
    public void close (){
        this.dispose();
        addressOkButton.resultsWindow.dispose();
    }
}
