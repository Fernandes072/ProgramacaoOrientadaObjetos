package atividade4;

public class Produto implements Comparable{

	private int codigo;
	private String nome;
	private String descricao;
	private int quantidade;
	private double preco;
	private int validade;

	public Produto(int codigo, String nome, String descricao, double preco, int validade) {
		setCodigo(codigo);
		setNome(nome);
		setDescricao(descricao);
		quantidade = 0;
		setPreco(preco);
		setValidade(validade);
	}

	public Produto(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	private void setCodigo(int codigo) {
		if (codigo < 0) {
			throw new IllegalArgumentException("Código não pode ser negativo!");
		}
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	private void setNome(String nome) {
		if (nome.length() == 0) {
			throw new IllegalArgumentException("Nome não pode ser vazio!");
		}
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	private void setDescricao(String descricao) {
		if (descricao.length() == 0) {
			throw new IllegalArgumentException("Descrição não pode ser vazia!");
		}
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public double getPreco() {
		return preco;
	}

	private void setPreco(double preco) {
		if (preco < 0) {
			throw new IllegalArgumentException("Preço não pode ser negativo!");
		}
		this.preco = preco;
	}

	public int getValidade() {
		return validade;
	}

	private void setValidade(int validade) {
		if (validade < 0) {
			throw new IllegalArgumentException("Validade não pode ser negativa!");
		}
		this.validade = validade;
	}

	public void adicionarEstoque(int valor) {
		if (valor < 0) {
			throw new IllegalArgumentException("Valor não pode ser negativo!");
		}
		quantidade+=valor;
	}

	public void removerEstoque(int valor) {
		if (valor < 0) {
			throw new IllegalArgumentException("Valor não pode ser negativo!");
		}
		if (valor > quantidade) {
			throw new RuntimeException("Valor superior ao estoque!");
		}
		quantidade-=valor;

	}
	
	@Override
	public int compareTo(Object obj) {
		if (obj instanceof Produto) {
			Produto outro = (Produto) obj;
			if (preco < outro.getPreco()) {
				return -1;
			} else if (preco > outro.getPreco()) {
				return 1;
			} 
		}
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Produto) {
			if (this.codigo == ((Produto) obj).getCodigo()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Código: " + codigo + " | Nome: " + nome + " | Descrição: " + descricao + " | Quantidade: "
				+ quantidade + " | Preço: " + preco + " | Validade: " + validade;
	}
}