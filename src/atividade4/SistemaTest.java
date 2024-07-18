package atividade4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;


public class SistemaTest {
	
	@Test
	public void codigoNegativoDeveRetornarIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			Produto produto = new Produto(-1, "Café", "Extra", 10, 5);
		});
	}
	
	@Test
	public void codigoDoisDeveRetornarDois() {
		Produto produto = new Produto(2, "Café", "Extra", 10, 5);
		assertEquals(2, produto.getCodigo());
	}
	
	@Test
	public void codigoIgualDeveRetornarRuntimeException() {
		Estoque estoque = new Estoque();
		estoque.cadastrarProduto(new Produto(1, "Arroz", "Branco", 4, 30));
		assertThrows(RuntimeException.class, () -> {
			estoque.cadastrarProduto(new Produto(1, "Arroz", "Branco", 4, 30));
		});
	}
	
	@Test
	public void nomeVazioDeveRetornarIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			Produto produto = new Produto(2, "", "Extra", 10, 5);
		});
	}
	
	@Test
	public void cafeDeveRetornarCafe() {
		Produto produto = new Produto(2, "Café", "Extra", 10, 5);
		assertEquals("Café", produto.getNome());
	}
	
	@Test
	public void descricaoVaziaDeveRetornarIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			Produto produto = new Produto(2, "Café", "", 10, 5);
		});
	}
	
	@Test
	public void extraDeveRetornarExtra() {
		Produto produto = new Produto(2, "Café", "Extra", 10, 5);
		assertEquals("Extra", produto.getDescricao());
	}
	
	@Test
	public void precoNegativoDeveRetornarIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			Produto produto = new Produto(2, "Café", "Extra", -1, 5);
		});
	}
	
	@Test
	public void dezDeveRetornarDez() {
		Produto produto = new Produto(2, "Café", "Extra", 10, 5);
		assertEquals(10, produto.getPreco());
	}
	
	@Test
	public void validadeNegativaDeveRetornarIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			Produto produto = new Produto(2, "Café", "Extra", 10, -1);
		});
	}
	
	@Test
	public void cincoDeveRetornarCinco() {
		Produto produto = new Produto(2, "Café", "Extra", 10, 5);
		assertEquals(5, produto.getValidade());
	}
	
	@Test
	public void adicionarDoisProdutosDeveRetornarTamanhoDois() {
		Estoque estoque = new Estoque();
		estoque.cadastrarProduto(new Produto(1, "Arroz", "Branco", 4, 30));
		estoque.cadastrarProduto(new Produto(2, "Café", "Extra", 10, 5));
		assertEquals(2, estoque.getProdutos().size());
	}
	
	@Test
	public void adicionarValorNegativoDeveRetornarIllegalArgumentException() {
		Estoque estoque = new Estoque();
		estoque.cadastrarProduto(new Produto(1, "Arroz", "Branco", 4, 30));
		assertThrows(IllegalArgumentException.class, () -> {
			estoque.adicionarEstoque(1, -1);
		});
	}
	
	@Test
	public void adicionarDoisETresNoEstoqueDeveRetornarCinco() {
		Estoque estoque = new Estoque();
		estoque.cadastrarProduto(new Produto(1, "Arroz", "Branco", 4, 30));
		estoque.adicionarEstoque(1, 2);
		estoque.adicionarEstoque(1, 3);
		assertEquals(5, estoque.buscarProduto(1).getQuantidade());
	}
	
	@Test
	public void adicionarQuantidadeEmProdutoQueNaoTemNoEstoqueDeveRetornarRuntimeException() {
		Estoque estoque = new Estoque();
		assertThrows(RuntimeException.class, () -> {
			estoque.adicionarEstoque(1, 3);
		});
	}
	
	@Test
	public void removerValorNegativoDeveRetornarIllegalArgumentException() {
		Estoque estoque = new Estoque();
		estoque.cadastrarProduto(new Produto(1, "Arroz", "Branco", 4, 30));
		assertThrows(IllegalArgumentException.class, () -> {
			estoque.removerEstoque(1, -1);
		});
	}
	
	@Test
	public void removerDoisDeCincoNoEstoqueDeveRetornarTres() {
		Estoque estoque = new Estoque();
		estoque.cadastrarProduto(new Produto(1, "Arroz", "Branco", 4, 30));
		estoque.adicionarEstoque(1, 5);
		estoque.removerEstoque(1, 2);
		assertEquals(3, estoque.buscarProduto(1).getQuantidade());
	}
	
	@Test
	public void removerValorSuperiorAoEstoqueDeveRetornarRuntimeException() {
		Estoque estoque = new Estoque();
		estoque.cadastrarProduto(new Produto(1, "Arroz", "Branco", 4, 30));
		estoque.adicionarEstoque(1, 5);
		assertThrows(RuntimeException.class, () -> {
			estoque.removerEstoque(1, 6);
		});
	}
	
	@Test
	public void removerQuantidadeEmProdutoQueNaoTemNoEstoqueDeveRetornarRuntimeException() {
		Estoque estoque = new Estoque();
		assertThrows(RuntimeException.class, () -> {
			estoque.removerEstoque(1, 3);
		});
	}

	@Test
	public void buscarProdutoUmDeveRetornarProdutoUm() {
		Estoque estoque = new Estoque();
		estoque.cadastrarProduto(new Produto(1, "Arroz", "Branco", 4, 30));
		assertEquals(1, estoque.buscarProduto(1).getCodigo());
	}
	
	@Test
	public void listarProdutosCompleto() {
		Estoque estoque = new Estoque();
		estoque.cadastrarProduto(new Produto(1, "Arroz", "Branco", 4, 30));
		estoque.cadastrarProduto(new Produto(2, "Café", "Extra", 10, 5));
		estoque.cadastrarProduto(new Produto(3, "Amendoim", "Japonês", 7, 15));
		estoque.adicionarEstoque(3, 10);
		estoque.adicionarEstoque(2, 20);
		estoque.adicionarEstoque(1, 30);
		assertEquals("Código: 1 | Nome: Arroz | Descrição: Branco | Quantidade: 30 | Preço: 4.0 | Validade: 30\n"
					+"Código: 2 | Nome: Café | Descrição: Extra | Quantidade: 20 | Preço: 10.0 | Validade: 5\n"
					+"Código: 3 | Nome: Amendoim | Descrição: Japonês | Quantidade: 10 | Preço: 7.0 | Validade: 15", estoque.listarCompleto());
	}
	
	@Test
	public void listarProdutosResumido() {
		Estoque estoque = new Estoque();
		estoque.cadastrarProduto(new Produto(1, "Arroz", "Branco", 4, 30));
		estoque.cadastrarProduto(new Produto(2, "Café", "Extra", 10, 5));
		estoque.cadastrarProduto(new Produto(3, "Amendoim", "Japonês", 7, 15));
		estoque.adicionarEstoque(3, 10);
		estoque.adicionarEstoque(2, 20);
		estoque.adicionarEstoque(1, 30);
		assertEquals("Código: 1 | Nome: Arroz | Preço: 4.0\n"
					+"Código: 2 | Nome: Café | Preço: 10.0\n"
					+"Código: 3 | Nome: Amendoim | Preço: 7.0", estoque.listarResumido());
	}
	
	@Test
	public void listarProdutosOrdemCrescentePreco() {
		Estoque estoque = new Estoque();
		estoque.cadastrarProduto(new Produto(1, "Arroz", "Branco", 4, 30));
		estoque.cadastrarProduto(new Produto(2, "Café", "Extra", 10, 5));
		estoque.cadastrarProduto(new Produto(3, "Amendoim", "Japonês", 7, 15));
		estoque.adicionarEstoque(3, 10);
		estoque.adicionarEstoque(2, 20);
		estoque.adicionarEstoque(1, 30);
		assertEquals("Código: 1 | Nome: Arroz | Preço: 4.0\n"
					+"Código: 3 | Nome: Amendoim | Preço: 7.0\n"
					+"Código: 2 | Nome: Café | Preço: 10.0", estoque.listarProdutosPreco());
	}
	
	@Test
	public void pauloDeveRetornarPaulo() {
		Usuario usuario = new Usuario("Paulo", "Paulo12", "1234");
		assertEquals("Paulo", usuario.getNome());
	}
	
	@Test
	public void paulo12DeveRetornarPaulo12() {
		Usuario usuario = new Usuario("Paulo", "Paulo12", "1234");
		assertEquals("Paulo12", usuario.getNomeUsuario());
	}
	
	@Test
	public void senha1234DeveRetornarSenha1234() {
		Usuario usuario = new Usuario("Paulo", "Paulo12", "1234");
		assertEquals("1234", usuario.getSenha());
	}
	
	@Test
	public void nomePessoaVazioDeveRetornarIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			Usuario usuario = new Usuario("", "Paulo12", "1234");
		});
	}
	
	@Test
	public void nomeUsuarioVazioDeveRetornarIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			Usuario usuario = new Usuario("Paulo", "", "1234");
		});
	}
	
	@Test
	public void senhaVaziaDeveRetornarIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			Usuario usuario = new Usuario("Paulo", "Paulo12", "");
		});
	}
}