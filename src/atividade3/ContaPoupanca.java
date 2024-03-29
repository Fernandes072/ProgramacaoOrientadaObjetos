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
	}

	@Override
	public void transferencia(Double valor, Conta conta) {
		if(valor > getSaldo()) {
			throw new BancoException("Erro: Valor insuficiente para transferência!");
		}
		setSaldo(getSaldo() - valor);
		conta.deposito(valor);

	}

	public double getTaxaVariacao() {
		return taxaVariacao;
	}

	public int getDiaVariacao() {
		return diaVariacao;
	}

	@Override
	public String toString() {
		return "ContaPoupanca [" + super.toString() + " | taxaVariacao: " + taxaVariacao + " | diaVariacao: "
				+ diaVariacao + "]";
	}
}
