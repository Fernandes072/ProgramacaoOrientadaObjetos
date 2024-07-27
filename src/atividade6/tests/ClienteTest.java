package atividade6.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import atividade6.classes.Cliente;

class ClienteTest {
	
	private static Cliente cliente;
	
	@BeforeAll
	static void criarCliente() throws Exception {
		cliente = new Cliente("123", "joao", "joao@");
	}

	@Test
	void cpf123DeveRetornar123() {
		assertEquals("123", cliente.getCpf());
	}
	
	@Test
	void cpfNullDeveRetornarNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			new Cliente(null, "joao", "joao@");
		});
	}
	
	@Test
	public void cpfVazioDeveRetornarIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Cliente("", "joao", "joao@");
		});
	}
	
	@Test
	void nomeJoaoDeveRetornarJoao() {
		assertEquals("joao", cliente.getNome());
	}
	
	@Test
	void nomeNullDeveRetornarNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			new Cliente("123", null, "joao@");
		});
	}
	
	@Test
	public void nomeVazioDeveRetornarIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Cliente("123", "", "joao@");
		});
	}
	
	@Test
	void emailJoaoDeveRetornarJoao() {
		assertEquals("joao@", cliente.getEmail());
	}
	
	@Test
	void emailNullDeveRetornarNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			new Cliente("123", "joao", null);
		});
	}
	
	@Test
	void emailVazioDeveRetornarIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Cliente("123", "joao", "");
		});
	}
	
	@Test
	void equalsCertoDeveRetornarTrue() {
		Cliente cliente2 = new Cliente("123", "jose", "jose@");
		assertTrue(cliente.equals(cliente2));
	}
	
	@Test
	void toStringCliente() {
		assertEquals("CPF: 123 | Nome: joao | Email: joao@", cliente.toString());
	}
}
