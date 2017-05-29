package rmiTestClient.setNickName;

import javax.swing.*;

/**
 * Created by Kosa on 29.05.2017.
 */
public class setNameWindow extends JFrame {

    private String nickName = null;
    private boolean flag = true;

    public setNameWindow (){
        setSize(300,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setTitle("set nickname");
        setLayout(null);

        JLabel text = new JLabel("Podaj Nick");
        add(text);
        text.setBounds(50,50,200,50);

        JTextField setNick = new JTextField("nick");
        add(setNick);
        setNick.setBounds(50,100,200,50);

        setNameOk setNameOk =new setNameOk(this, setNick);
        add(setNameOk);
        setNameOk.setBounds(50,150,200,50);


        setVisible(true);
    }

    public void setNickName (String nickName){
        this.nickName=nickName;
    }

    public String getNickName (){
        return nickName;
    }

    public boolean getFlag (){
        return flag;
    }

    public void setFlag (){
        this.flag=false;
    }


}
