package atividade6.classes;

import atividade6.controllers.EstoqueController;

public class Programa {

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
		
		


	}

}
