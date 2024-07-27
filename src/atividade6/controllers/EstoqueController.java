package atividade6.controllers;

import java.util.Map;

import atividade6.classes.Estoque;
import atividade6.classes.Produto;

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
	
	public static Produto buscarProduto(int codigo) {
		return estoque.buscarProduto(codigo);
	}
	
	public static Map<Produto, Integer> getProdutos(){
		return estoque.getProdutos();
	}
	
	public static String listarProdutos() {
		return estoque.listarProdutos();
	}
	
	
}
