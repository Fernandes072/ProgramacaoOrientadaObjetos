package atividade6.classes;

public class GeradorCodigo {
	
	private static int codigoProduto;
	private static int codigoPedido;
	
	public static int getCodigoProduto() {
		codigoProduto++;
		return codigoProduto;
	}
	
	public static int getCodigoPedido() {
		codigoPedido++;
		return codigoPedido;
	}
}
