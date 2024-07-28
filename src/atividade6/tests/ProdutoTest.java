package atividade6.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import atividade6.classes.Produto;

class ProdutoTest {

	private static Produto produto;

	@BeforeAll static void criarProduto() {
		produto = new Produto(1, "Café", "Extra", 5, 10);
	}

	@Test
	public void codigoUmDeveRetornarUm() {
		assertEquals(1, produto.getCodigo());
	}

	@Test
	public void codigoNegativoDeveRetornarIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Produto(-11, "Café", "Extra", 5, 10);
		});
	}
	
	@Test
	public void cafeDeveRetornarCafe() {
		assertEquals("Café", produto.getNome());
	}

	@Test
	public void nomeNullDeveRetornarNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			new Produto(1, null, "Extra", 5, 10);
		});
	}
	
	@Test
	public void nomeVazioDeveRetornarIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Produto(1, "", "Extra", 5, 10);
		});
	}
	
	@Test
	public void extraDeveRetornarExtra() {
		assertEquals("Extra", produto.getDescricao());
	}

	@Test
	public void descricaoNullDeveRetornarNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			new Produto(1, "Café", null, 5, 10);
		});
	}
	
	@Test
	public void descricaoVaziaDeveRetornarIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Produto(1, "Café", "", 5, 10);
		});
	}
	
	@Test
	public void cincoDeveRetornarCinco() {
		assertEquals(5, produto.getPreco());
	}

	@Test
	public void precoNegativoDeveRetornarIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Produto(1, "Café", "Extra", -1, 10);
		});
	}
	
	@Test
	public void dezDeveRetornarDez() {
		assertEquals(10, produto.getValidade());
	}

	@Test
	public void validadeNegativaDeveRetornarIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Produto(1, "Café", "Extra", 5, -1);
		});
	}

}
