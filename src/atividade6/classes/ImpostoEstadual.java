package atividade6.classes;

public class ImpostoEstadual implements Imposto{

	@Override
	public double calcularImposto(double valor) {
		return valor * 0.15;
	}

}
