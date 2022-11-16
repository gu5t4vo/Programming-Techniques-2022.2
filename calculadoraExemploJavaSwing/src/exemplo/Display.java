package exemplo;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Display  extends JPanel{

	public Teclado teclado;
	public JLabel label;
	
	public Display(Teclado teclado) {
	  	this.setBackground(Color.LIGHT_GRAY);
	 	label = new JLabel();
	 	label.setText(teclado.texto);
	  
	  	this.teclado = teclado;
	  	this.teclado.label=label;
	  
	  	setLayout(new BorderLayout());
	  	add(label, BorderLayout.NORTH);
	  	add(teclado, BorderLayout.SOUTH);
	  
	  
	}
}
