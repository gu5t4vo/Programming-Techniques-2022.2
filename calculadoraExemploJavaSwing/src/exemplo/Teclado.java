package exemplo;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Teclado extends JPanel {

	public String texto;
	public JLabel label;
	
	public Teclado() {
		texto="Oioi";
		setBackground(Color.WHITE);
		add(criarTodosBotoes());
	}
	
	public JPanel criarTodosBotoes() {
		JPanel p= new JPanel();

		Botao botao=new Botao(this, label);
		p.setLayout(new GridLayout(4,4));
		p.add(botao.criarBotoes("7"));
		p.add(botao.criarBotoes("8"));
		p.add(botao.criarBotoes("9"));
		p.add(botao.criarBotoes("*"));
		p.add(botao.criarBotoes("4"));
		p.add(botao.criarBotoes("5"));
		p.add(botao.criarBotoes("6"));
		p.add(botao.criarBotoes("-"));
		p.add(botao.criarBotoes("1"));
		p.add(botao.criarBotoes("2"));
		p.add(botao.criarBotoes("3"));
		p.add(botao.criarBotoes("+"));
		p.add(botao.criarBotoes("/"));
		p.add(botao.criarBotoes("0"));
		p.add(botao.criarBotoes(","));
		p.add(botao.criarBotoes("="));
		return p;
	}
	
	
}
