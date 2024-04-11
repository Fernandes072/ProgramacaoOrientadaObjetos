package atividade3_p2;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	private int codigo;
	private String nome;
	private String telefone;
	private List<Conta> contas;

	public Cliente(int codigo, String nome, String telefone) {
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		contas = new ArrayList<Conta>();
	}
	
	public Cliente(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public List<Conta> getContas() {
		return contas;
	}
	
	public void verificarLimiteContas(String tipo) {
		int contadorPoupanca = 0;
		int contadorCorrente = 0;
		for (Conta conta : contas) {
			if (conta instanceof ContaPoupanca) {
				contadorPoupanca++;
			} else {
				contadorCorrente++;
			}
		}
		if (contadorPoupanca == 1 && tipo.equals("1")) {
			throw new BancoException("Erro: Limite de contas poupança!");
		}
		if (contadorCorrente == 1 && tipo.equals("2")) {
			throw new BancoException("Erro: Limite de contas corrente!");
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Cliente) {
			return codigo == ((Cliente) obj).getCodigo();
		}
		return false;
	}

	@Override
	public String toString() {
		return "Código: " + codigo + " | Nome: " + nome + " | Telefone: " + telefone;
	}

}
