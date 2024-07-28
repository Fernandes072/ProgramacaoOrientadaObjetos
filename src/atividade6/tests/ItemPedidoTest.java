package atividade6.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import atividade6.classes.ItemPedido;
import atividade6.classes.Produto;

class ItemPedidoTest {
	
	private static ItemPedido itemPedido;

	@BeforeAll
	static void criarItemPedido() {
		itemPedido = new ItemPedido(3, new Produto(1, "a", "a", 4, 15));
	}

	@Test
	void quantidade3DeveRetornar3() {
		assertEquals(3, itemPedido.getQuantidade());
	}
	
	@Test
	void quantidadeNegativaDeveRetornarIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new ItemPedido(-1, new Produto(1));
		});
	}
	
	@Test
	void produto1DeveRetornarProduto1() {
		assertEquals(1, itemPedido.getProduto().getCodigo());
	}
	
	@Test
	void produtoVazioDeveRetornarIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new ItemPedido(5, null);
		});
	}
	
	@Test
	void subTotal12DeveRetornar12() {
		assertEquals(12, itemPedido.subTotal());
	}

}
