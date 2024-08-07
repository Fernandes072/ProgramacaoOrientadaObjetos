package atividade6.classes;

import java.util.Map;
import java.util.TreeMap;

public class Estoque {

	private Map<Produto, Integer> produtos = new TreeMap<Produto, Integer>();

	public Estoque() {

	}

	public void cadastrarProduto(String nome, String descricao, double preco, int validade) {
		int codigo = GeradorCodigo.getCodigoProduto();
		if (produtos.containsKey(new Produto(codigo))) {
			throw new RuntimeException("Código do produto já existe!");
		}
		produtos.put(new Produto(codigo, nome, descricao, preco, validade), 0);
	}

	public Produto buscarProduto(int codigo) {
		Produto p = new Produto(codigo);
		for (Produto produto : produtos.keySet()) {
			if (produto.equals(p)) {
				return produto;
			}
		}
		throw new RuntimeException("Produto não existe!");
	}

	public void adicionarEstoque(int codigo, int quantidade) {
		Produto produto = buscarProduto(codigo);
		if (quantidade < 0) {
			throw new IllegalArgumentException("Quantidade não pode ser negativa!");
		}
		int qtdEmEstoque = produtos.get(produto);
		produtos.put(produto, qtdEmEstoque + quantidade);
	}

	public void removerEstoque(int codigo, int quantidade) {
		Produto produto = buscarProduto(codigo);
		if (quantidade < 0) {
			throw new IllegalArgumentException("Quantidade não pode ser negativa!");
		}
		int qtdEmEstoque = produtos.get(produto);
		if (quantidade > qtdEmEstoque) {
			throw new RuntimeException("Quantidade superior ao estoque!");
		}
		produtos.put(produto, qtdEmEstoque - quantidade);
	}
	
	public Map<Produto, Integer> getProdutos(){
		return new TreeMap<Produto, Integer>(produtos);
	}

	public String listarProdutos() {
		StringBuilder sb = new StringBuilder();
		for (Produto produto : produtos.keySet()) {
			if (!sb.isEmpty()) {
				sb.append("\n");
			}
			sb.append(produto);
			sb.append(" | Quantidade: ");
			sb.append(produtos.get(produto));
		}
		return sb.toString();
	}
}
