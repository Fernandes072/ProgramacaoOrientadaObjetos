package atividade3_p2;

import java.util.ArrayList;
import java.util.List;

import atividade3.BancoException;

public abstract class Conta {

	private int numero;
	private double saldo;
	private String senha;
	private int tentativas;
	private List<Transacao> transacoes;

	public Conta(int numero, String senha) {
		this.numero = numero;
		this.senha = senha;
		transacoes = new ArrayList<Transacao>();
	}

	public double getSaldo() {
		return saldo;
	}
	
	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void deposito(Double valor) {
		saldo += valor;
		adicionarTransacao(TipoTransacao.DEPOSITO, valor);
	}

	public abstract void saque(Double valor);

	public abstract void transferencia(Double valor, Conta conta);

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
	
	protected void adicionarTransacao (TipoTransacao tipo, double valor) {
		transacoes.add(new Transacao(tipo, valor));
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Conta) {
			return numero == ((Conta) obj).numero;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Número: " + numero + " | Saldo: " + saldo;
	}
}