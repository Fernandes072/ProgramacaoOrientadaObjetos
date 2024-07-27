package atividade6.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import atividade6.classes.Estoque;

class EstoqueTest {

//	private Estoque estoque;
//	
//	@BeforeEach
//	void criarEstoque() {
//		estoque = new Estoque();
//		estoque.cadastrarProduto("arroz", "branco", 5, 10);
//		estoque.cadastrarProduto("macarrão", "parafuso", 3, 15);
//		System.out.println(estoque.listarProdutos());
//	}
//	
//	@AfterEach
//	void apagarEstoque() {
//		estoque = null;
//	}

	@Test
	void adicionarDoisProdutosDeveRetornarTamanhoDois() {
		Estoque estoque = new Estoque();
		estoque.cadastrarProduto("arroz", "branco", 5, 10);
		estoque.cadastrarProduto("macarrão", "parafuso", 3, 15);
		assertTrue(estoque.getProdutos().size() == 2);
	}
	
	@Test
	public void buscarProdutoUmDeveRetornarProdutoUm() {
		Estoque estoque = new Estoque();
		estoque.cadastrarProduto("arroz", "branco", 5, 10);
		estoque.cadastrarProduto("macarrão", "parafuso", 3, 15);
		assertEquals(10, estoque.buscarProduto(10).getCodigo());
	}
	
	@Test
	public void buscarProdutoQueNaoExisteDeveRetornarRuntimeException() {
		Estoque estoque = new Estoque();
		assertThrows(RuntimeException.class, () -> {
			estoque.buscarProduto(5).getCodigo();
		});
	}
	
	@Test
	public void adicionarQuantidadeNegativaDeveRetornarIllegalArgumentException() {
		Estoque estoque = new Estoque();
		estoque.cadastrarProduto("arroz", "branco", 5, 10);
		assertThrows(IllegalArgumentException.class, () -> {
			estoque.adicionarEstoque(11, -1);
		});
	}
	
	@Test
	public void adicionarDoisETresNoEstoqueDeveRetornarCinco() {
		Estoque estoque = new Estoque();
		estoque.cadastrarProduto("arroz", "branco", 5, 10);
		estoque.adicionarEstoque(6, 2);
		estoque.adicionarEstoque(6, 3);
		assertEquals(5, estoque.getProdutos().get(estoque.buscarProduto(6)));
	}
	
	@Test
	public void adicionarQuantidadeEmProdutoQueNaoTemNoEstoqueDeveRetornarRuntimeException() {
		Estoque estoque = new Estoque();
		assertThrows(RuntimeException.class, () -> {
			estoque.adicionarEstoque(3, 3);
		});
	}
	
	@Test
	public void removerQuantidadeNegativaDeveRetornarIllegalArgumentException() {
		Estoque estoque = new Estoque();
		estoque.cadastrarProduto("arroz", "branco", 5, 10);
		assertThrows(IllegalArgumentException.class, () -> {
			estoque.removerEstoque(8, -1);
		});
	}
	
	@Test
	public void removerDoisDeCincoNoEstoqueDeveRetornarTres() {
		Estoque estoque = new Estoque();
		estoque.cadastrarProduto("arroz", "branco", 5, 10);
		estoque.adicionarEstoque(1, 5);
		estoque.removerEstoque(1, 2);
		assertEquals(3, estoque.getProdutos().get(estoque.buscarProduto(1)));
	}
	
	@Test
	public void removerValorSuperiorAoEstoqueDeveRetornarRuntimeException() {
		Estoque estoque = new Estoque();
		estoque.cadastrarProduto("arroz", "branco", 5, 10);
		estoque.adicionarEstoque(7, 3);
		assertThrows(RuntimeException.class, () -> {
			estoque.removerEstoque(7, 6);
		});
	}
	
	@Test
	public void removerQuantidadeEmProdutoQueNaoTemNoEstoqueDeveRetornarRuntimeException() {
		Estoque estoque = new Estoque();
		assertThrows(RuntimeException.class, () -> {
			estoque.removerEstoque(3, 3);
		});
	}
	
	@Test
	public void listarProdutosCompleto() {
		Estoque estoque = new Estoque();
		estoque.cadastrarProduto("arroz", "branco", 5, 10);
		estoque.cadastrarProduto("macarrão", "parafuso", 3, 15);
		estoque.adicionarEstoque(3, 20);
		estoque.adicionarEstoque(2, 30);
		assertEquals("Código: 2 | Nome: arroz | Descrição: branco | Preço: 5.0 | Validade: 10 | Quantidade: 30\n"
					+"Código: 3 | Nome: macarrão | Descrição: parafuso | Preço: 3.0 | Validade: 15 | Quantidade: 20", estoque.listarProdutos());
	}

}
