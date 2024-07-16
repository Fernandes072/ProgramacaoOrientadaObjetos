package atividade4_teste;

import java.util.Objects;

public class Produto {
	
	private int codigo;
	private String nome;
	private String descricao;
	private int quantidade;
	private double preco;
	private int validade;
	
	public Produto(int codigo, String nome, String descricao, double preco, int validade) {
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		quantidade = 0;
		this.preco = preco;
		this.validade = validade;
	}


	public Produto (int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public int getValidade() {
		return validade;
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
	public int hashCode() {
	    return Objects.hash(codigo);
	}
}