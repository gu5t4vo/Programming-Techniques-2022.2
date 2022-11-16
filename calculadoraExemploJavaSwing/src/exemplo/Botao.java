package exemplo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Botao implements ActionListener {

    Teclado teclado;
	public Botao(Teclado teclado, JLabel label) {
		this.teclado=teclado;
		// TODO Auto-generated constructor stub
	}
	public JButton criarBotoes(String nomeBotao) {
		JButton botao = new JButton();
		botao.setText(nomeBotao);
		
		botao.addActionListener(this);
		return botao;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		b.setIcon(new ImageIcon("withdraw.png"));
		teclado.label.setText(b.getText());
		teclado.label.setFont(new Font("arial", Font.BOLD, 40));
	   System.out.println(" fui clicado:  "+ b.getText());
	}
}
