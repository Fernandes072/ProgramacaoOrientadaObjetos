package atividade3_p2;

import java.time.LocalDate;

public class ContaPoupanca extends Conta {

	private double taxaVariacao;
	private int diaVariacao;

	public ContaPoupanca(int numero, String senha) {
		super(numero, senha);
		taxaVariacao = 0.05;
		diaVariacao = LocalDate.now().getDayOfMonth();
	}

	public double getTaxaVariacao() {
		return taxaVariacao;
	}

	public int getDiaVariacao() {
		return diaVariacao;
	}

	@Override
	public void saque(Double valor) {
		if (valor > getSaldo()) {
			throw new BancoException("Erro: Valor insuficiente para saque!");
		}
		setSaldo(getSaldo() - valor);
		adicionarTransacao(TipoTransacao.SAQUE, valor);
	}

	@Override
	public void transferencia(Double valor, Conta conta) {
		if (valor > getSaldo()) {
			throw new BancoException("Erro: Valor insuficiente para transferência!");
		}
		setSaldo(getSaldo() - valor);
		adicionarTransacao(TipoTransacao.TRANSFERENCIA_ENVIADA, valor);

		conta.setSaldo(conta.getSaldo() + valor);
		conta.adicionarTransacao(TipoTransacao.TRANSFERENCIA_RECEBIDA, valor);
	}

	@Override
	public String toString() {
		return "Conta Poupança [" + super.toString() + " | Taxa Variação: " + taxaVariacao + " | Dia Variação: "
				+ diaVariacao + "]";
	}
}
