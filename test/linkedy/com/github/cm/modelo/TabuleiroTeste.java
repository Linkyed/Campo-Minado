package linkedy.com.github.cm.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import linkedy.com.github.cm.excecao.ExplosaoException;

public class TabuleiroTeste {
	Tabuleiro tabuleiro;
	
	//@BeforeEach
	//void InicializarTabuleiro(int minas) {
	//	tabuleiro = new Tabuleiro(5, 5, minas);
	//}
	
	@Test
	void testeAbrirCampo() {
		tabuleiro = new Tabuleiro(5, 5, 0);
		tabuleiro.abrir(0, 0);
		assertTrue(tabuleiro.getCampo(0, 0).isAberto());
	}
	
	@Test
	void testeAlterarMarcacao() {
		tabuleiro = new Tabuleiro(5, 5, 0);
		tabuleiro.alternarMarcacao(0, 0);
		assertTrue(tabuleiro.getCampo(0, 0).isMarcado());
	}
	
	@Test
	void testeObjetivoAlcancado() {
		tabuleiro = new Tabuleiro(2, 2, 0);
		tabuleiro.abrir(0, 0);
		assertTrue(tabuleiro.objetivoAlcancado());
	}
	
	@Test
	void testeObjetivoNaoAlcancado() {
		tabuleiro = new Tabuleiro(2, 2, 0);
		assertFalse(tabuleiro.objetivoAlcancado());
	}
	
	@Test
	void testeReiniciar() {
		tabuleiro = new Tabuleiro(2, 2, 0);
		tabuleiro.abrir(0, 0);
		tabuleiro.reiniciar();
		assertTrue(tabuleiro.getCampo(0, 0).isFechado());
	}
	
	@Test
	void testarJogoPerdido() {
		tabuleiro = new Tabuleiro(1, 1, 1);
		assertThrows(ExplosaoException.class, () -> {
			tabuleiro.abrir(0, 0);
		});
	}
	
	@Test
	void testeToString() {
		tabuleiro = new Tabuleiro(2, 2, 0);
		assertEquals(tabuleiro.toString(), " ?  ? \n ?  ? \n");
	}
}
