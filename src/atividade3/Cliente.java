package atividade3;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	private int codigo;
	private String nome;
	private String telefone;
	private String senha;
	private int tentativas;
	private List<Conta> contas;

	public Cliente(int codigo, String nome, String telefone, String senha) {
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.senha = senha;
		this.tentativas = 3;
		contas = new ArrayList<Conta>();
	}

	public void login(String senha) {
		if (tentativas == 0) {
			throw new BancoException("Conta bloqueada!");
		}
		if (!senha.equals(this.senha)) {
			tentativas--;
			if (tentativas == 0) {
				throw new BancoException("Erro: Senha incorreta! Conta bloqueada!");
			}
			throw new BancoException("Erro: Senha incorreta! Tentativas restantes: " + tentativas);
		}
		tentativas = 3;
	}

	public int getCodigo() {
		return codigo;
	}

	public int getTentativas() {
		return tentativas;
	}

	public void setTentativas(int tentativas) {
		this.tentativas = tentativas;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getSenha() {
		return senha;
	}

	public List<Conta> getContas() {
		return contas;
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
		return "Código: " + codigo + " | Nome: " + nome + " | Telefone: " + telefone + "]";
	}

}
