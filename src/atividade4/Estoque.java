package atividade4;

import java.util.ArrayList;
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
		int posicao = produtos.indexOf(new Produto(codigo));
		if (posicao == -1) {
			throw new RuntimeException("Produto não existe!");
		}
		return produtos.get(posicao);
	}

	public void adicionarEstoque(int codigo, int valor) {
		Produto produto = buscarProduto(codigo);
		produto.adicionarEstoque(valor);
	}

	public void removerEstoque(int codigo, int valor) {
		Produto produto = buscarProduto(codigo);
		produto.removerEstoque(valor);
	}

	public String listarCompleto() {
		StringBuilder sb = new StringBuilder();
		for (Produto produto : produtos) {
			if (!sb.isEmpty()) {
				sb.append("\n");
			}
			sb.append(produto);
		}
		return sb.toString();
	}

	public String listarResumido() {
		StringBuilder sb = new StringBuilder();
		for (Produto produto : produtos) {
			if (!sb.isEmpty()) {
				sb.append("\n");
			}
			sb.append("Código: " + produto.getCodigo() + " | Nome: " + produto.getNome() + " | Preço: "
					+ produto.getPreco());
		}
		return sb.toString();
	}
	
	public String listarProdutosPreco() {
		StringBuilder sb = new StringBuilder();
		List<Produto> copiaOrdenada = (List)((ArrayList) produtos).clone();
		copiaOrdenada.sort(null);
		for (Produto produto : copiaOrdenada) {
			if (!sb.isEmpty()) {
				sb.append("\n");
			}
			sb.append("Código: " + produto.getCodigo() + " | Nome: " + produto.getNome() + " | Preço: "
					+ produto.getPreco());
		}
		return sb.toString();
	}
}
