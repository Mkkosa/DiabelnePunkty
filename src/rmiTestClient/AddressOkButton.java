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
        pattern = Pattern.compile("[0-9][0-9]?[0-9]?.[0-9][0-9]?[0-9]?.[0-9][0-9]?[0-9]?.[0-9][0-9]?[0-9]?:[0-9][0-9][0-9][0-9]");
        matcher = pattern.matcher(textField.getText());
        if (matcher.matches()){
            System.out.println("ok");
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
