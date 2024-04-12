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
		verificarSaldo(valorSaque);
		
		setSaldo(getSaldo() - valorSaque);
		adicionarTransacao(TipoTransacao.SAQUE, valor);
	}

	@Override
	public void transferencia(Double valor, Conta conta) {
		double valorTransferencia = valor * (1 + taxaMovimentacao);
		verificarSaldo(valorTransferencia);
		
		setSaldo(getSaldo() - valorTransferencia);
		adicionarTransacao(TipoTransacao.TRANSFERENCIA_ENVIADA, valor);

		conta.setSaldo(conta.getSaldo() + valor);
		conta.adicionarTransacao(TipoTransacao.TRANSFERENCIA_RECEBIDA, valor);
	}
	
	protected void verificarSaldo(double valor) {
		if (valor <= 0) {
			throw new BancoException("Erro: Valor inválido!");
		}
		if (valor > (getSaldo() + chequeEspecial)) {
			throw new BancoException("Erro: Valor insuficiente!");
		}
	}
	
	public void solicitarAumento(double valor) {
		aumentoChequeEspecial = valor;
	}
	
	public void concederAumento(double valor) {
		if (valor > 0) {
			chequeEspecial += valor;
			aumentoChequeEspecial = 0;
		}
	}

	@Override
	public String toString() {
		return "Conta Corrente [" + super.toString() + " | Taxa Movimentação: " + taxaMovimentacao * 100 + "%"
				+ " | Cheque Especial: " + chequeEspecial + " | Aumento Cheque Especial: " + aumentoChequeEspecial
				+ "]";
	}
}
