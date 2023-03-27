package linkedy.com.github.cm.visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import linkedy.com.github.cm.excecao.ExplosaoException;
import linkedy.com.github.cm.excecao.SairException;
import linkedy.com.github.cm.modelo.Tabuleiro;

public class TabuleiroConsole {
	private Tabuleiro tabuleiro;
	private Scanner entradaUsuario = new Scanner(System.in);
	
	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		
		executarJogo();
	}

	private void executarJogo() {
		try {
			boolean continuar = true;
			
			while (continuar) {
				cicloDoJogo();
				
				System.out.println("Outra partida? (S/n): ");
				String resposta = entradaUsuario.nextLine();
				if("n".equalsIgnoreCase(resposta)) {
					continuar = false;
				} else {
					tabuleiro.reiniciar();
				}
			}
		} catch (SairException e) { 
			System.out.println("Jogo Encerrado!!!");
		} finally {
			entradaUsuario.close();
		}
		
	}

	private void cicloDoJogo() {
		try {
			
			while (!tabuleiro.objetivoAlcancado()) {
				System.out.println(tabuleiro);
				
				String respostaCordenada = capturarRespostaUsuario("Digite (x, y): ");
				
				Iterator<Integer> xy = Arrays.stream(respostaCordenada.split(",")).map(n -> Integer.parseInt(n.trim())).iterator();
				
				String respostaAbrirOuMarca = capturarRespostaUsuario("Digite 1 - Abrir ou 2 - (Des)Marcar: ");
				
				if ("1".equalsIgnoreCase(respostaAbrirOuMarca)) {
					tabuleiro.abrir(xy.next(), xy.next());
				} else if ("2".equalsIgnoreCase(respostaAbrirOuMarca)) {
					tabuleiro.alternarMarcacao(xy.next(), xy.next());
				}
			}
			
			System.out.println(tabuleiro);
			System.out.println("Você ganhou!!");
		} catch (ExplosaoException e) {
			System.out.println(tabuleiro);
			System.out.println("Você perdeu!!");
		}
	}
	
	private String capturarRespostaUsuario(String texto) {
		System.out.print(texto);
		String resposta = entradaUsuario.nextLine();
		
		if ("sair".equalsIgnoreCase(resposta)) {
			throw new SairException();
		}
		
		return resposta;
	}
}
