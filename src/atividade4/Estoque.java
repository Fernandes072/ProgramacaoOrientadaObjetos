package atividade4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Estoque {

	private List<Produto> produtos;

	public Estoque() {
		produtos = new ArrayList<Produto>();
	}

	public void cadastrarProduto(Produto produto) {
		if (produtos.contains(produto)) {
			throw new RuntimeException("Código do produto já existe!");
		}
		produtos.add(produto);
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public Produto buscarProduto(int codigo) {
		return produtos.get(produtos.indexOf(new Produto(codigo)));
	}
	
	public void adicionarEstoque(int codigo, int valor) {
		Produto produto = buscarProduto(codigo);
		if (produto == null) {
			throw new RuntimeException("Produto não existe!");
		}
		produto.adicionarEstoque(valor);
	}
	
	public void removerEstoque(int codigo, int valor) {
		Produto produto = buscarProduto(codigo);
		if (produto == null) {
			throw new RuntimeException("Produto não existe!");
		}
		produto.removerEstoque(valor);
	}
	
	public void listarProdutos() {
		for (Produto produto : produtos) {
			System.out.println(produto);
		}
	}
}
