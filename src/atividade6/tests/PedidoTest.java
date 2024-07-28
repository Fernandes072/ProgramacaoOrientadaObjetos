package atividade6.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import atividade6.classes.Cliente;
import atividade6.classes.ItemPedido;
import atividade6.classes.Pedido;
import atividade6.classes.Produto;

class PedidoTest {
	
	private static Pedido pedido;

	@BeforeAll
	static void criarPedido() throws Exception {
		List<ItemPedido> itens = new ArrayList<ItemPedido>();
		itens.add(new ItemPedido(3, new Produto(1, "a", "a", 4, 15)));
		itens.add(new ItemPedido(5, new Produto(2, "a", "a", 3, 15)));
		pedido = new Pedido(1, new Cliente("123", "123", "123"), itens);
	}

	@Test
	void codigo1DeveRetornar1() {
		assertEquals(1, pedido.getCodigo());
	}
	
	@Test
	void codigo0DeveRetornarIllegalArgumentException() {
		List<ItemPedido> itens = new ArrayList<ItemPedido>();
		itens.add(new ItemPedido(3, new Produto(1, "a", "a", 4, 15)));
		assertThrows(IllegalArgumentException.class, () -> {
			new Pedido(0, new Cliente("123", "123", "123"), itens);
		});
	}
	
	@Test
	void cliente123DeveRetornar123() {
		assertEquals("123", pedido.getCliente().getCpf());
	}
	
	@Test
	void clienteNullDeveRetornarIllegalArgumentException() {
		List<ItemPedido> itens = new ArrayList<ItemPedido>();
		itens.add(new ItemPedido(3, new Produto(1, "a", "a", 4, 15)));
		assertThrows(IllegalArgumentException.class, () -> {
			new Pedido(2, null, itens);
		});
	}
	
	@Test
	void itensNullDeveRetornarIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Pedido(2, new Cliente("123", "123", "123"), null);
		});
	}
	
	@Test
	void itensVazioDeveRetornarIllegalArgumentException() {
		List<ItemPedido> itens = new ArrayList<ItemPedido>();
		assertThrows(IllegalArgumentException.class, () -> {
			new Pedido(2, new Cliente("123", "123", "123"), itens);
		});
	}
	
	@Test
	void total27DeveRetornar27() {
		assertEquals(27, pedido.total());
	}

}
