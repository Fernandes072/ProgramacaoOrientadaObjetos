package atividade6.classes;

public class ImpostoFederal implements Imposto{

	@Override
	public double calcularImposto(double valor) {
		return valor * 0.25;
	}

}
