import javax.swing.*;

public class Timer extends Thread{
    public JLabel j;
    public int m = 0, s = 0;
    public boolean on = false;
    public Timer(JLabel j){
        this.j = j;
        this.setDaemon(true);
    }
    public void run(){
        try{
            while(true){
                if(on){
                    if(s <= 58){
                        s++;
                    }
                    if(s == 59){
                        s = 0;
                        m++;
                    }
                    if(m <= 9 && s <= 9){ j.setText("Temps : 0"+m+":0"+s); }
                    if(m <= 9 && s >= 10){ j.setText("Temps : 0"+m+":"+s); }
                    if(m >= 10 && s <= 9){ j.setText("Temps : "+m+":0"+s); }
                    if(m >= 10 && s >= 10){ j.setText("Temps : "+m+":"+s);}

                }
                sleep(1000);
            }
        } catch (InterruptedException e) { }
    }
}
