package atividade3;

import java.time.LocalDate;

public class Transacao {
	
	private String tipo;
	private LocalDate data;
	private double valor;
	
	public Transacao(String tipo, LocalDate data, double valor) {
		this.tipo = tipo;
		this.data = data;
		this.valor = valor;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Transacao [tipo: " + tipo + " | data: " + data + " | valor: " + valor + "]";
	}
}
