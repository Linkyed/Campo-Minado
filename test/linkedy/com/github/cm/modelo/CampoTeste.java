package linkedy.com.github.cm.modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import linkedy.com.github.cm.excecao.ExplosaoException;

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
	
	@Test
	void testeValorPadraoAtributoMarcacao() {
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAlterarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAlterarMarcacaoDuasChamadas() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirCampoNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}
	
	@Test
	void testeAbrirCampoNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirCampoMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirCampoMinadoNaoMarcado() {
		campo.minar();
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});
	}
	
	@Test
	void testeAbrirComVizinho1() {
		Campo vizinhoDoVizinho1 = new Campo(1, 1);
		Campo vizinho1 = new Campo(2, 2);
		
		vizinho1.adicionarVizinho(vizinhoDoVizinho1);
		campo.adicionarVizinho(vizinho1);
		
		campo.abrir();
		
		assertTrue(vizinho1.isAberto() && vizinhoDoVizinho1.isAberto());
	}
	
	@Test
	void testeAbrirComVizinho2() {
		Campo vizinhoDoVizinho1 = new Campo(1, 1);
		Campo vizinho1 = new Campo(2, 2);
		
		vizinhoDoVizinho1.minar();
		
		vizinho1.adicionarVizinho(vizinhoDoVizinho1);
		campo.adicionarVizinho(vizinho1);
		
		campo.abrir();
		
		assertTrue(vizinho1.isAberto() && vizinhoDoVizinho1.isFechado());
	}
	
}
