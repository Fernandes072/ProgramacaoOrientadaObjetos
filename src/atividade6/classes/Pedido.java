package atividade6.classes;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private int codigo;
	private List<ItemPedido> itensPedido;
	private Cliente cliente;

	public Pedido(int codigo, Cliente cliente, List<ItemPedido> itensPedido) {
		setCodigo(codigo);
		setItensPedido(itensPedido);
		setCliente(cliente);
	}
	
	public Pedido(int codigo) {
		this(codigo, new Cliente("a", "a", "a"), new ArrayList<ItemPedido>());
	}

	public int getCodigo() {
		return codigo;
	}

	private void setCodigo(int codigo) {
		if (codigo <= 0) {
			throw new IllegalArgumentException("Código não pode ser menor que 1!");
		}
		this.codigo = codigo;
	}
	
	private void setItensPedido(List<ItemPedido> itensPedido) {
		if (itensPedido == null) {
			throw new IllegalArgumentException("Itens não pode ser vazio!");
		}
		if (itensPedido.isEmpty()) {
			throw new IllegalArgumentException("Itens não pode ser vazio!");
		}
		this.itensPedido = itensPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	private void setCliente(Cliente cliente) {
		if (cliente == null) {
			throw new IllegalArgumentException("Cliente não pode ser vazio!");
		}
		this.cliente = cliente;
	}

	public double total() {
		double total = 0;
		for (ItemPedido itemPedido : itensPedido) {
			total += itemPedido.subTotal();
		}
		CalculadoraImposto imposto = new CalculadoraImposto();
		imposto.alterarImposto(new ImpostoFederal());
		return total;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (ItemPedido itemPedido : itensPedido) {
			if (!sb.isEmpty()) {
				sb.append("\n");
			}
			sb.append(itemPedido);
		}
		sb.append("\n");
		sb.append("Total: " + this.total());
		return sb.toString();
	}

}
