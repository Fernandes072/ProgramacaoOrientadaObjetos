package atividade3;

import java.time.LocalDate;

public class ContaPoupanca extends Conta {

	private double taxaVariacao;
	private int diaVariacao;

	public ContaPoupanca(int numero) {
		super(numero);
		taxaVariacao = 0.05;
		diaVariacao = LocalDate.now().getDayOfMonth();
	}

	@Override
	public void saque(Double valor) {
		if(valor > getSaldo()) {
			throw new BancoException("Erro: Valor insuficiente para saque!");
		}
		setSaldo(getSaldo() - valor);
		getTransacoes().add(new Transacao("Saque", valor));
	}

	@Override
	public void transferencia(Double valor, Conta conta) {
		if(valor > getSaldo()) {
			throw new BancoException("Erro: Valor insuficiente para transferência!");
		}
		setSaldo(getSaldo() - valor);
		getTransacoes().add(new Transacao("Transferência", "enviada", valor));
		
		conta.setSaldo(conta.getSaldo() + valor);
		conta.getTransacoes().add(new Transacao("Transferência", "recebida", valor));
	}

	public double getTaxaVariacao() {
		return taxaVariacao;
	}

	public int getDiaVariacao() {
		return diaVariacao;
	}

	@Override
	public String toString() {
		return "Conta Poupança [" + super.toString() + " | Taxa Variação: " + taxaVariacao + " | Dia Variação: "
				+ diaVariacao + "]";
	}
}
