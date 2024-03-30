package atividade3;

import java.time.LocalDate;

public class Transacao {

	private String tipo;
	private LocalDate data;
	private double valor;
	private String tipoTransferencia;

	public Transacao(String tipo, String tipoTransferencia, double valor) {
		this.tipo = tipo;
		this.tipoTransferencia = tipoTransferencia;
		this.valor = valor;
		this.data = LocalDate.now();
	}
	
	public Transacao(String tipo,  double valor) {
		this.tipo = tipo;
		this.valor = valor;
		this.data = LocalDate.now();
	}

	public String getTipo() {
		return tipo;
	}

	public LocalDate getData() {
		return data;
	}

	public double getValor() {
		return valor;
	}

	public String getTipoTransferencia() {
		return tipoTransferencia;
	}

	@Override
	public String toString() {
		if (tipo.equals("Transferência")) {
			return "Transação [Tipo: " + tipo + " " + tipoTransferencia + " | Data: " + data + " | Valor: " + valor + "]";
		} else {
			return "Transação [Tipo: " + tipo + " | Data: " + data + " | Valor: " + valor + "]";
		}

	}
}
