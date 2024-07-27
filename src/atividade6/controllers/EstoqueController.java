package atividade6.controllers;

import atividade6.classes.Estoque;

public class EstoqueController {
	
	private static Estoque estoque = new Estoque();
	
	public static void cadastrarProduto(String nome, String descricao, double preco, int validade) {
		estoque.cadastrarProduto(nome, descricao, preco, validade);
	}
	
	public static void adicionarEstoque(int codigo, int quantidade) {
		estoque.adicionarEstoque(codigo, quantidade);
	}
	
	public static void removerEstoque(int codigo, int quantidade) {
		estoque.removerEstoque(codigo, quantidade);
	}
	
	public static String listarProdutos() {
		return estoque.listarProdutos();
	}
	
	
}
