package atividade3;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta {

	private int numero;
	private double saldo;
	private List<Transacao> transacoes;

	public Conta(int numero) {
		this.numero = numero;
		transacoes = new ArrayList<Transacao>();
	}

	public void deposito(Double valor) {
		saldo += valor;
		transacoes.add(new Transacao("Depósito", valor));
	}

	public abstract void saque(Double valor);

	public abstract void transferencia(Double valor, Conta conta);

	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
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