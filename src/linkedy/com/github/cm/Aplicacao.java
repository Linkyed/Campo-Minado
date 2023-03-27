package linkedy.com.github.cm;

import linkedy.com.github.cm.modelo.Tabuleiro;

public class Aplicacao {
	public static void main(String[] args) {
		Tabuleiro tabuleiro = new Tabuleiro(5, 5, 5);
		
		tabuleiro.abrir(2, 2);
		tabuleiro.alternarMarcacao(3, 3);
		
		System.out.println(tabuleiro);
	}
}
