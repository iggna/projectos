package ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class ejecutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame Ventana=new JFrame();
		
		Ventana.setSize(800, 600);
		
		
		JPanel panelDerecho = new JPanel();
	
		panelDerecho.setBackground(Color.green);
		panelDerecho.setLayout(new FlowLayout());
		JButton b4=new JButton ("Hello");
		b4.setBackground(Color.black);
		b4.setForeground(Color.white);
		
	
		
		JPanel panelIzquierdo = new JPanel();
		
		panelIzquierdo.setLayout(new FlowLayout());
		JButton b3=new JButton ("Bonjour");
		b3.setBackground(Color.black);
		b3.setForeground(Color.white); 
		
		
		JPanel panelInferior = new JPanel();
		JButton b2=new JButton ("Hola");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		
		JPanel panelSuperior = new JPanel();
		JButton b1=new JButton("As-salaam-aleykum");
		JButton b5=new JButton ("Holis");
		b1.setBackground(Color.white);
		b1.setForeground(Color.black);
		
		JScrollPane scroll=new JScrollPane(new JTextArea());
		
		Ventana.setLayout(new BorderLayout()); 
		Ventana.add(b1,BorderLayout.CENTER);
		Ventana.add(b2,BorderLayout.EAST);
		Ventana.add(b3,BorderLayout.NORTH);
		Ventana.add(b4,BorderLayout.SOUTH);
		
		Ventana.setVisible(true);
		
	}

}
