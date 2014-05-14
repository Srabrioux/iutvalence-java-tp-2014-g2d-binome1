package fr.iutvalence.java.tp.puissance4;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class Panel extends JPanel
{
	public Panel(int col, int lgn)
	{
		this.setPreferredSize(new Dimension(60, 40));
		this.setBackground(Color.red);
	}
}
