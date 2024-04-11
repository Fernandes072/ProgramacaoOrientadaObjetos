package atividade3_p2;

public class ContaCorrente extends Conta {

	private double taxaMovimentacao;
	private double chequeEspecial;
	private double aumentoChequeEspecial;

	public ContaCorrente(int numero, String senha) {
		super(numero, senha);
		taxaMovimentacao = 0.05;
		chequeEspecial = 100;
	}
	
	public ContaCorrente(int numero) {
		super(numero);
	}

	public double getTaxaMovimentacao() {
		return taxaMovimentacao;
	}

	public double getChequeEspecial() {
		return chequeEspecial;
	}

	public double getAumentoChequeEspecial() {
		return aumentoChequeEspecial;
	}

	@Override
	public void saque(Double valor) {
		double valorSaque = valor * (1 + taxaMovimentacao);
		if (valorSaque > (getSaldo() + chequeEspecial)) {
			throw new BancoException("Erro: Valor insuficiente para saque!");
		}
		setSaldo(getSaldo() - valorSaque);
		adicionarTransacao(TipoTransacao.SAQUE, valor);
	}

	@Override
	public void transferencia(Double valor, Conta conta) {
		double valorTransferencia = valor * (1 + taxaMovimentacao);
		if (valorTransferencia > (getSaldo() + chequeEspecial)) {
			throw new BancoException("Erro: Valor insuficiente para transferência!");
		}
		setSaldo(getSaldo() - valorTransferencia);
		adicionarTransacao(TipoTransacao.TRANSFERENCIA_ENVIADA, valor);

		conta.setSaldo(conta.getSaldo() + valor);
		conta.adicionarTransacao(TipoTransacao.TRANSFERENCIA_RECEBIDA, valor);
	}
	
	public void solicitarAumento(double valor) {
		aumentoChequeEspecial = valor;
	}

	@Override
	public String toString() {
		return "Conta Corrente [" + super.toString() + " | Taxa Movimentação: " + taxaMovimentacao * 100 + "%"
				+ " | Cheque Especial: " + chequeEspecial + " | Aumento Cheque Especial: " + aumentoChequeEspecial
				+ "]";
	}
}
