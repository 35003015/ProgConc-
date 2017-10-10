import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.*;


public class Balles extends JPanel{
   public Vector<Balle> liste;

   public Balles(int nombre){
      liste = new Vector<Balle>();
      setBackground(Color.black);
  }
  public void ajouteBalle(){
     liste.add(new Balle((int)((getWidth()-45)*Math.random()),(int)((getHeight()-45)*Math.random())));
 }

 public void retireBalle(){
     liste.removeElementAt(0);
 }

 public void retireAllBalle(){
     liste.removeAllElements();
 }

  public void paintComponent(Graphics g){
    for(Balle b:liste){
      b.paint(g);
    }
  }
}
