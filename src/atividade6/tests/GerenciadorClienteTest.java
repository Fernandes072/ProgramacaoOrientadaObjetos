package atividade6.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import atividade6.classes.GerenciadorCliente;

class GerenciadorClienteTest {

	private static GerenciadorCliente gerenciadorCliente;

	@BeforeAll
	static void criarCliente() {
		gerenciadorCliente = new GerenciadorCliente();
		gerenciadorCliente.cadastrarCliente("123", "123", "123");
		gerenciadorCliente.cadastrarCliente("456", "456", "456");
	}

	@Test
	void cpfIgualDeveRetornarRuntimeException() {
		assertThrows(RuntimeException.class, () -> {
			gerenciadorCliente.cadastrarCliente("123", "123", "123");
		});
	}

	@Test
	public void buscarCliente456DeveRetornarCliente456() {
		assertEquals("123", gerenciadorCliente.buscarCliente("123").getCpf());
	}

	@Test
	public void buscarClienteQueNaoExisteDeveRetornarRuntimeException() {
		assertThrows(RuntimeException.class, () -> {
			gerenciadorCliente.buscarCliente("789");
		});
	}

	@Test
	public void listarProdutosCompleto() {
		assertEquals("CPF: 123 | Nome: 123 | Email: 123\n" + "CPF: 456 | Nome: 456 | Email: 456",
				gerenciadorCliente.listarClientes());
	}

}
