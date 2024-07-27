package atividade6.controllers;

import java.util.List;

import atividade6.classes.Cliente;
import atividade6.classes.GerenciadorPedidos;
import atividade6.classes.ItemPedido;

public class GerenciadorPedidosController {
	
	private static GerenciadorPedidos gerenciadorPedidos = new GerenciadorPedidos();
	
	public static void adicionarPedido(Cliente cliente, List<ItemPedido> itensPedido) {
		gerenciadorPedidos.adicionarPedido(cliente, itensPedido);
	}
	
	public static String listarPedidos() {
		return gerenciadorPedidos.listarPedidos();
	}

}
