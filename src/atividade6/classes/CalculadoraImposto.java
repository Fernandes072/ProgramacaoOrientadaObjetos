package atividade6.classes;

public class CalculadoraImposto {
	
	public static double calcularImposto(double valor, Imposto imposto) {
		return imposto.calcularImposto(valor);
	}
}
