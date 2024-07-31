package atividade6.classes;

public class CalculadoraImposto {
	
	private Imposto imposto;
	
	public void alterarImposto(Imposto imposto) {
		this.imposto = imposto;
	}
	
	public double calcularImposto(double valor) {
		return imposto.calcularImposto(valor);
	}
}
