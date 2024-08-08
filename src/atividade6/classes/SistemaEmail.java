package atividade6.classes;

public class SistemaEmail {
	
	public static void enviarNotificacao(Cliente cliente, Pedido pedido) {
		System.out.println("Informações do pedido " + pedido.getCodigo() + " enviadas para " + cliente.getEmail() + "!");
	}
}
