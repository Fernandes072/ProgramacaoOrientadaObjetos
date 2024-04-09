package atividade3_p2;

import java.time.LocalDate;

public class Transacao {

	private TipoTransacao tipoTransacao;
	private LocalDate data;
	private double valor;

	public Transacao(TipoTransacao tipoTransacao, double valor) {
		this.tipoTransacao = tipoTransacao;
		this.valor = valor;
		this.data = LocalDate.now();
	}

	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public LocalDate getData() {
		return data;
	}

	public double getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "Transação [Tipo: " + tipoTransacao + " | Data: " + data + " | Valor: " + valor + "]";
	}

}
