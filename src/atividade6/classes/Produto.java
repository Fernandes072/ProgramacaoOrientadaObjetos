package atividade6.classes;

public class Produto implements Comparable {

	private int codigo;
	private String nome;
	private String descricao;
	private double preco;
	private int validade;

	public Produto(int codigo, String nome, String descricao, double preco, int validade) {
		setCodigo(codigo);
		setNome(nome);
		setDescricao(descricao);
		setPreco(preco);
		setValidade(validade);
	}

	public Produto(int codigo) {
		this(codigo, "a", "a", 1, 1);
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

	public String getNome() {
		return nome;
	}

	private void setNome(String nome) {
		if (nome == null) {
			throw new NullPointerException("Nome não pode ser vazio!");
		}
		if (nome.length() == 0) {
			throw new IllegalArgumentException("Nome não pode ser vazio!");
		}
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	private void setDescricao(String descricao) {
		if (descricao == null) {
			throw new NullPointerException("Descrição não pode ser vazia!");
		}
		if (descricao.length() == 0) {
			throw new IllegalArgumentException("Descrição não pode ser vazia!");
		}
		this.descricao = descricao;
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

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Produto) {
			return this.codigo == ((Produto) obj).getCodigo();
		}
		return false;
	}

	@Override
	public String toString() {
		return "Código: " + codigo + " | Nome: " + nome + " | Descrição: " + descricao + " | Preço: " + preco
				+ " | Validade: " + validade;
	}

	public String toString2() {
		return "Código: " + codigo + " | Nome: " + nome + " | Preço: " + preco;
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Produto) {
			Produto outro = (Produto) o;
			if (codigo < outro.getCodigo()) {
				return -1;
			} else if (codigo > outro.getCodigo()) {
				return 1;
			}
		}
		return 0;
	}
}
