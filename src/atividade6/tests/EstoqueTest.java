package atividade6.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import atividade6.classes.Estoque;

class EstoqueTest {

	private static Estoque estoque;
	
	@BeforeAll
	static void criarEstoque() {
		estoque = new Estoque();
		estoque.cadastrarProduto("arroz", "branco", 5, 10);
		estoque.cadastrarProduto("macarrão", "parafuso", 3, 15);
	}
	

	@Test
	void adicionarDoisProdutosDeveRetornarTamanhoDois() {
		assertTrue(estoque.getProdutos().size() == 2);
	}
	
	@Test
	public void buscarProdutoUmDeveRetornarProdutoUm() {
		assertEquals(1, estoque.buscarProduto(1).getCodigo());
	}
	
	@Test
	public void buscarProdutoQueNaoExisteDeveRetornarRuntimeException() {
		assertThrows(RuntimeException.class, () -> {
			estoque.buscarProduto(10).getCodigo();
		});
	}
	
	@Test
	public void adicionarQuantidadeNegativaDeveRetornarIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			estoque.adicionarEstoque(1, -1);
		});
	}
	
	@Test
	public void adicionarDoisETresNoEstoqueDeveRetornarCinco() {
		estoque.adicionarEstoque(1, 2);
		estoque.adicionarEstoque(1, 3);
		assertEquals(5, estoque.getProdutos().get(estoque.buscarProduto(1)));
	}
	
	@Test
	public void adicionarQuantidadeEmProdutoQueNaoTemNoEstoqueDeveRetornarRuntimeException() {
		assertThrows(RuntimeException.class, () -> {
			estoque.adicionarEstoque(10, 1);
		});
	}
	
	@Test
	public void removerQuantidadeNegativaDeveRetornarIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			estoque.removerEstoque(1, -1);
		});
	}
	
	@Test
	public void removerDoisDeCincoNoEstoqueDeveRetornarTres() {
		estoque.adicionarEstoque(2, 5);
		estoque.removerEstoque(2, 2);
		assertEquals(3, estoque.getProdutos().get(estoque.buscarProduto(2)));
	}
	
	@Test
	public void removerValorSuperiorAoEstoqueDeveRetornarRuntimeException() {
		assertThrows(RuntimeException.class, () -> {
			estoque.removerEstoque(2, 10);
		});
	}
	
	@Test
	public void removerQuantidadeEmProdutoQueNaoTemNoEstoqueDeveRetornarRuntimeException() {
		assertThrows(RuntimeException.class, () -> {
			estoque.removerEstoque(10, 2);
		});
	}
	
	@Test
	public void listarProdutosCompleto() {
		assertEquals("Código: 1 | Nome: arroz | Descrição: branco | Preço: 5.0 | Validade: 10 | Quantidade: 0\n"
					+"Código: 2 | Nome: macarrão | Descrição: parafuso | Preço: 3.0 | Validade: 15 | Quantidade: 3", estoque.listarProdutos());
	}

}
