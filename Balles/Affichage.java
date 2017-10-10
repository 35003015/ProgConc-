import java.util.*;
import javax.swing.*;

public class Affichage extends Thread {
    public Balles panneau;
    public double distance;
    public Vector<Balle> disparues = new Vector<Balle>();
    public JLabel score;
    public int s = 0;
    public Affichage(Balles panneau, JLabel score){
        this.panneau = panneau;
        this.score = score;
        this.setDaemon(true);
    }
    public void run(){
        try{
            while(true){
                for(Balle b1:panneau.liste){
                    for(Balle b2:panneau.liste){
                        if(b1!=b2 && (!disparues.contains(b1) && !disparues.contains(b2))){
                            distance = Math.sqrt(Math.pow(b2.getPosX() - b1.getPosX(), 2)+Math.pow(b2.getPosY() - b1.getPosY(), 2));
                            if(distance < 45){
                                disparues.add(b1);
                                disparues.add(b2);

                                s++;
                                score.setText("Score : "+s);
                            }
                        }
                    }
                }
                for(Balle b:disparues){
                    panneau.liste.remove(b);
                }
                disparues.clear();
                panneau.repaint();
                sleep(10);
            }
        } catch (InterruptedException e) { }
    }
}
