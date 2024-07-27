package atividade6.classes;

public class GeradorCodigo {
	
	private static int codigoProduto = 1;
	private static int codigoPedido = 1;
	
	public static int getCodigoProduto() {
		codigoProduto++;
		return codigoProduto - 1;
	}
	
	public static int getCodigoPedido() {
		codigoPedido++;
		return codigoPedido - 1;
	}
}
