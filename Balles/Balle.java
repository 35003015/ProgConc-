import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Balle {
  public Color couleur;
  public int posX;
  public int posY;
  public boolean backX = false;
  public boolean backY = false;
  public Color[] tab = {Color.blue,Color.cyan,Color.darkGray,Color.gray,Color.green,Color.yellow,Color.lightGray,Color.magenta,Color.orange,Color.pink,Color.red,Color.white};

  public Balle(int x, int y){
    this.couleur = tab[couleurAleatoire()];
    this.posX = x;
    this.posY = y;
  }

  public int couleurAleatoire(){
    int indice = (int)(Math.random()*12);
    return indice;
  }

  public void paint(Graphics g){
    g.setColor(couleur);
    g.fillOval(posX,posY,45,45);
  }

  public int getPosX() { return posX; }

  public void setPosX(int posX) { this.posX = posX; }

  public int getPosY() { return posY; }

  public void setPosY(int posY) { this.posY = posY; }

}
