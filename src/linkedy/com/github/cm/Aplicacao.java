package linkedy.com.github.cm;

import linkedy.com.github.cm.modelo.Tabuleiro;
import linkedy.com.github.cm.visao.TabuleiroConsole;

public class Aplicacao {
	public static void main(String[] args) {
		Tabuleiro tabuleiro = new Tabuleiro(5, 5, 2);
		
		new TabuleiroConsole(tabuleiro);
	}
}
