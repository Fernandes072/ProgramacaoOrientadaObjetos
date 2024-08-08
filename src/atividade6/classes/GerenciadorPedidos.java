package atividade6.classes;

import java.util.ArrayList;
import java.util.List;

import atividade6.controllers.EstoqueController;

public class GerenciadorPedidos {

	private List<Pedido> pedidos;

	public GerenciadorPedidos() {
		this.pedidos = new ArrayList<Pedido>();
	}

	public void adicionarPedido(Cliente cliente, List<ItemPedido> itensPedido) {
		int codigo = GeradorCodigo.getCodigoPedido();
		if (pedidos.contains(new Pedido(codigo))) {
			throw new RuntimeException("Código do pedido já existe!");
		}
		for (ItemPedido item : itensPedido) {
			EstoqueController.removerEstoque(item.getProduto().getCodigo(), item.getQuantidade());
		}
		Pedido pedido = new Pedido(codigo, cliente, itensPedido);
		System.out.println(pedido);
		pedidos.add(pedido);
		SistemaEmail.enviarNotificacao(cliente, pedido);
	}

	public String listarPedidosPorCliente(String cpf) {
		StringBuilder sb = new StringBuilder();
		for (Pedido pedido : pedidos) {
			if (pedido.getCliente().equals(new Cliente(cpf))) {
				if (!sb.isEmpty()) {
					sb.append("\n");
				}
				sb.append(pedido);
			}
		}
		return sb.toString();
	}

	public String listarPedidos() {
		return pedidos.toString();
	}
}
