import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Fenetre extends JFrame implements ActionListener {
  public JButton bt_start = new JButton("Start");
  public JButton bt_plus = new JButton("+");
  public JButton bt_moins = new JButton("-");
  public JLabel score = new JLabel("Score : 0");
  public JLabel temps = new JLabel("Temps : 00:00");
  public Balles panneau = new Balles(10);
  public Affichage th1 = new Affichage(panneau, score);
  public Mouvement th2 = new Mouvement(panneau);
  public Timer th3 = new Timer(temps);


  public Fenetre(){

    JPanel left_up = new JPanel();
    left_up.setLayout(new FlowLayout());
    left_up.add(score);
    JPanel right_up = new JPanel();
    right_up.setLayout(new FlowLayout());
    right_up.add(temps);
    JPanel up_pane = new JPanel();
    up_pane.setLayout(new FlowLayout());
    up_pane.add(left_up);
    up_pane.add(right_up);

    JPanel down_pane = new JPanel();
    down_pane.setLayout(new FlowLayout());
    down_pane.add(bt_start);
    bt_start.addActionListener(this);
    down_pane.add(bt_plus);
    bt_plus.addActionListener(this);
    down_pane.add(bt_moins);
    bt_moins.addActionListener(this);

    Container pane = getContentPane();
    pane.setLayout(new BorderLayout());
    pane.add(up_pane, BorderLayout.NORTH);
    pane.add(panneau, BorderLayout.CENTER);
    pane.add(down_pane, BorderLayout.SOUTH);

    pane.setVisible(true);

    this.setTitle("Balles en mouvement");
    this.setResizable(false);
    this.setBounds(200,200,500,500);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setVisible(true);

    // Thread
    th1.start();
    th3.start();
    th2.start();



  }




  public void actionPerformed(ActionEvent e){
    Object source = e.getSource();

    if(source == bt_start){
        if(th2.on && th3.on){
            th2.on = false;
            th3.on = false;
            bt_start.setText("Start");
        }
        else{
            th2.on = true;
            th3.on = true;
            bt_start.setText("Stop");
        }
    }
    if(source == bt_plus){
        if(panneau.liste.size() < 10){
            panneau.ajouteBalle();
        }
    }
    if(source == bt_moins){
        panneau.retireBalle();
    }
  }

  public static void main(String[] args){
    Fenetre f = new Fenetre();

  }
}
