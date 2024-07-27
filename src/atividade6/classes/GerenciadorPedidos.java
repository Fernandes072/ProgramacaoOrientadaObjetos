package atividade6.classes;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorPedidos {
	
	private List<Pedido> pedidos;
	
	public GerenciadorPedidos() {
		this.pedidos = new ArrayList<Pedido>();
	}
	
	public void adicionarPedido(Cliente cliente, List<ItemPedido> itensPedido) {
		int codigo = GeradorCodigo.getCodigoPedido();
		if(pedidos.contains(new Pedido(codigo))) {
			throw new RuntimeException("Código do pedido já existe!");
		}
		pedidos.add(new Pedido(codigo, cliente, itensPedido));
	}
	
	public String listarPedidos() {
		return pedidos.toString();
	}
}
