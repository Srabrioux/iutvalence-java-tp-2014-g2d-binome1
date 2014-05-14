package fr.iutvalence.java.tp.puissance4;
import java.awt.Color; 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class Fenetre extends JFrame {
  public Fenetre(){
    this.setTitle("Puisance 4");
    this.setSize(700, 700);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel pan = new JPanel();
    pan.setBackground(Color.green);
    this.setContentPane(pan);
    this.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    //TODO finir creer panel page 233 tuto OPR
    Panel c0l0 = new Panel(0,0);
    Panel c0l1 = new Panel(0,1);
    Panel c0l2 = new Panel(0,2);
    Panel c0l3 = new Panel(0,3);
    Panel c0l4 = new Panel(0,4);
    Panel c0l5 = new Panel(0,5);
    Panel c0l6 = new Panel(0,6);
    
    Panel c1l0 = new Panel(0,0);
    Panel c1l1 = new Panel(0,0);
    Panel c1l2 = new Panel(0,0);
    Panel c1l3 = new Panel(0,0);
    Panel c1l4 = new Panel(0,0);
    Panel c1l5 = new Panel(0,0);
    Panel c1l6 = new Panel(0,0);
    
    /*Panel c0l0 = new Panel(0,0);
    Panel c0l0 = new Panel(0,0);
    Panel c0l0 = new Panel(0,0);
    Panel c0l0 = new Panel(0,0);
    Panel c0l0 = new Panel(0,0);
    Panel c0l0 = new Panel(0,0);
    Panel c0l0 = new Panel(0,0);
    
    Panel c0l0 = new Panel(0,0);
    Panel c0l0 = new Panel(0,0);
    Panel c0l0 = new Panel(0,0);
    Panel c0l0 = new Panel(0,0);
    Panel c0l0 = new Panel(0,0);
    Panel c0l0 = new Panel(0,0);
    Panel c0l0 = new Panel(0,0);
    
    Panel c0l0 = new Panel(0,0);
    Panel c0l0 = new Panel(0,0);
    Panel c0l0 = new Panel(0,0);
    Panel c0l0 = new Panel(0,0);
    Panel c0l0 = new Panel(0,0);
    Panel c0l0 = new Panel(0,0);
    Panel c0l0 = new Panel(0,0);
    
    Panel c0l0 = new Panel(0,0);
    Panel c0l0 = new Panel(0,0);
    Panel c0l0 = new Panel(0,0);
    Panel c0l0 = new Panel(0,0);
    Panel c0l0 = new Panel(0,0);
    Panel c0l0 = new Panel(0,0);
    Panel c0l0 = new Panel(0,0);*/
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridheight = 1;
    gbc.gridwidth = 1;
    this.add(c0l0, gbc);
    gbc.gridx = 1;
    this.add(c0l1, gbc);
    gbc.gridx = 2;
    this.add(c0l2, gbc);
    this.setVisible(true);
  }
}