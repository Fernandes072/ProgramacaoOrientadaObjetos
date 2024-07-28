package atividade6.controllers;

import atividade6.classes.Cliente;
import atividade6.classes.GerenciadorCliente;

public class GerenciadorClienteController {
	
	private static GerenciadorCliente gerenciadorCliente = new GerenciadorCliente();
	
	public static void cadastrarCliente(String cpf, String nome, String email) {
		gerenciadorCliente.cadastrarCliente(cpf, nome, email);
	}
	
	public static Cliente buscarCliente(String cpf) {
		return gerenciadorCliente.buscarCliente(cpf);
	}
	
	public static String listarClientes() {
		return gerenciadorCliente.listarClientes();
	}

}
