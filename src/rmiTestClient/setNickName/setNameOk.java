package rmiTestClient.setNickName;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kosa on 29.05.2017.
 */
public class setNameOk extends JButton implements ActionListener {

    private setNameWindow setNameWindow;
    private JTextField text;

    public setNameOk (setNameWindow setNameWindow, JTextField text){
        this.text=text;
        this.setNameWindow=setNameWindow;
        setText("Ok");
        addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setNameWindow.setNickName(text.getText());
        setNameWindow.setFlag();
        setNameWindow.dispose();
    }
}
