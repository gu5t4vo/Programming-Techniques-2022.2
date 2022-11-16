package exemplo;

import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) {

		Teclado teclado = new Teclado();
		Display display = new Display(teclado);
		Janela j = new Janela(display);
	}

}
