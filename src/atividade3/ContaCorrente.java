package atividade3;

public class ContaCorrente extends Conta {

	private double taxaMovimentacao;
	private double chequeEspecial;
	private double aumentoChequeEspecial;

	public ContaCorrente(int numero) {
		super(numero);
		taxaMovimentacao = 0.05;
		chequeEspecial = 100;
	}

	@Override
	public void saque(Double valor) {
		if ((valor + valor * taxaMovimentacao) > (getSaldo() + chequeEspecial)) {
			throw new BancoException("Erro: Valor insuficiente para saque!");
		}
		setSaldo(getSaldo() - (valor + valor * taxaMovimentacao));
		getTransacoes().add(new Transacao("Saque", (valor + valor * taxaMovimentacao)));
	}

	@Override
	public void transferencia(Double valor, Conta conta) {
		if ((valor + valor * taxaMovimentacao) > (getSaldo() + chequeEspecial)) {
			throw new BancoException("Erro: Valor insuficiente para transferência!");
		}
		setSaldo(getSaldo() - (valor + valor * taxaMovimentacao));
		getTransacoes().add(new Transacao("Transferência", "enviada", valor));

		conta.setSaldo(conta.getSaldo() + valor);
		conta.getTransacoes().add(new Transacao("Transferência", "recebida", valor));
	}

	public double getTaxaMovimentacao() {
		return taxaMovimentacao;
	}

	public void setTaxaMovimentacao(double taxaMovimentacao) {
		this.taxaMovimentacao = taxaMovimentacao;
	}

	public double getChequeEspecial() {
		return chequeEspecial;
	}

	public void setChequeEspecial(double chequeEspecial) {
		this.chequeEspecial = chequeEspecial;
	}

	public double getAumentoChequeEspecial() {
		return aumentoChequeEspecial;
	}

	public void setAumentoChequeEspecial(double aumentoChequeEspecial) {
		this.aumentoChequeEspecial = aumentoChequeEspecial;
	}

	@Override
	public String toString() {
		return "Conta Corrente [" + super.toString() + " | Taxa Movimentação: " + taxaMovimentacao * 100 + "%"
				+ " | Cheque Especial: " + chequeEspecial + " | Aumento Cheque Especial: " + aumentoChequeEspecial
				+ "]";
	}
}
