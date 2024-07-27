package atividade6.classes;

import java.util.ArrayList;
import java.util.List;

import atividade6.controllers.EstoqueController;

public class Teste {

	public static void main(String[] args) {
		
//		Estoque estoque = new Estoque();
//		
//		estoque.cadastrarProduto("café", "extra", 5, 10);
//		estoque.cadastrarProduto("arroz", "branco", 3, 15);
//		estoque.cadastrarProduto("arroz", "branco", 3, 15);
//		
//		estoque.adicionarEstoque(1, 3);
//		
//		
//		System.out.println(estoque.listarProdutos());
		
		EstoqueController.cadastrarProduto("café", "extra", 5, 10);
		EstoqueController.cadastrarProduto("arroz", "branco", 3, 15);
		EstoqueController.cadastrarProduto("arroz", "branco", 3, 15);
		
		EstoqueController.adicionarEstoque(1, 3);
		
		System.out.println(EstoqueController.listarProdutos());
		
		List<ItemPedido> itens = new ArrayList<ItemPedido>();
		itens.add(new ItemPedido(2, EstoqueController.buscarProduto(1)));
		itens.add(new ItemPedido(3, EstoqueController.buscarProduto(2)));
		
		List<ItemPedido> itens2 = new ArrayList<ItemPedido>();
		itens2.add(new ItemPedido(3, EstoqueController.buscarProduto(2)));
		itens2.add(new ItemPedido(4, EstoqueController.buscarProduto(3)));
		
		GerenciadorPedidos ger = new GerenciadorPedidos();
		ger.adicionarPedido(new Cliente("g"), itens);
		ger.adicionarPedido(new Cliente("h"), itens2);
		
		System.out.println(ger.listarPedidos());
		
		


	}

}
