package rmiTestClient;

/**
 * Created by Kosa on 20.05.2017.
 */
public class Interface extends Thread{

    AdressFrame adressFrame;

    public Interface (){
        adressFrame = new AdressFrame();
    }

    public void run (){
        while (true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
         adressFrame =new AdressFrame();

        }
    }
}
