package linkedy.com.github.cm.modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CampoTeste {
	
	private Campo campo;
	
	@BeforeEach
	void inicializarCampo() {
		campo = new Campo(3, 3);
	}
	
	@Test
	void testeVizinhoEsquerda () {
		Campo candidatoVizinho = new Campo(3, 2);
		boolean isVizinho = campo.adicionarVizinho(candidatoVizinho);
		assertTrue(isVizinho);
	}
	
	@Test
	void testeVizinhoDireita () {
		Campo candidatoVizinho = new Campo(3, 4);
		boolean isVizinho = campo.adicionarVizinho(candidatoVizinho);
		assertTrue(isVizinho);
	}
	
	@Test
	void testeVizinhoAcima () {
		Campo candidatoVizinho = new Campo(2, 3);
		boolean isVizinho = campo.adicionarVizinho(candidatoVizinho);
		assertTrue(isVizinho);
	}
	
	@Test
	void testeVizinhoEmbaixo () {
		Campo candidatoVizinho = new Campo(4, 3);
		boolean isVizinho = campo.adicionarVizinho(candidatoVizinho);
		assertTrue(isVizinho);
	}
	
	@Test
	void testeVizinhoDiagonalSuperiorEsquerda () {
		Campo candidatoVizinho = new Campo(2, 2);
		boolean isVizinho = campo.adicionarVizinho(candidatoVizinho);
		assertTrue(isVizinho);
	}
	
	@Test
	void testeVizinhoDiagonalInferiorEsquerda () {
		Campo candidatoVizinho = new Campo(4, 2);
		boolean isVizinho = campo.adicionarVizinho(candidatoVizinho);
		assertTrue(isVizinho);
	}
	
	@Test
	void testeVizinhoDiagonalSuperiorDireita () {
		Campo candidatoVizinho = new Campo(2, 4);
		boolean isVizinho = campo.adicionarVizinho(candidatoVizinho);
		assertTrue(isVizinho);
	}
	
	@Test
	void testeVizinhoDiagonalInferiorDireita () {
		Campo candidatoVizinho = new Campo(4, 4);
		boolean isVizinho = campo.adicionarVizinho(candidatoVizinho);
		assertTrue(isVizinho);
	}
	
	@Test
	void testeVizinhoFalso() {
		Campo vizinhoFalso = new Campo(1, 1);
		boolean isVizinho = campo.adicionarVizinho(vizinhoFalso);
		assertFalse(isVizinho);
	}
}
