package rmiTestClient.setAddres;

import javax.swing.*;

/**
 * Created by Kosa on 23.05.2017.
 */
public class ResultsWindow extends JFrame {

    String result;
    AddressOkButton addressOkButton;
    boolean flag;

    public ResultsWindow (AddressOkButton addressOkButton,String result, boolean flag){
        this.result=result;
        this.addressOkButton =addressOkButton;
        this.flag=flag;
        setTitle("Result");
        setSize(200,150);
        setLocation(addressOkButton.getLocationX()+10, addressOkButton.getLocationY()+10);
        setLayout(null);
        ResultWindowOkButton resultWindowOkButton = new ResultWindowOkButton(this, flag);
        resultWindowOkButton.setBounds(0,50,200,40);
        add(resultWindowOkButton);
        JLabel label = new JLabel(result);
        label.setBounds(0,10,200,40);
        add(label);


        setVisible(true);

    }
    public void close (){addressOkButton.close(); this.dispose();}
}
