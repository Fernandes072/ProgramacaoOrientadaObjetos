package atividade6.classes;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorCliente {
	
	private List<Cliente> clientes;
	
	public GerenciadorCliente() {
		clientes = new ArrayList<Cliente>();
	}
	
	public void cadastrarCliente(String cpf, String nome, String email) {
		if (clientes.contains(new Cliente(cpf))) {
			throw new RuntimeException("Cliente já existe!");
		}
		clientes.add(new Cliente(cpf, nome, email));
	}
	
	public Cliente buscarCliente(String cpf) {
		int posicao = clientes.indexOf(new Cliente(cpf));
		if (posicao == -1) {
			throw new RuntimeException("Cliente não existe!");
		}
		return clientes.get(posicao);
	}
	
	public String listarClientes() {
		StringBuilder sb = new StringBuilder();
		for (Cliente cliente : clientes) {
			if (!sb.isEmpty()) {
				sb.append("\n");
			}
			sb.append(cliente);
		}
		return sb.toString();
	}

}
