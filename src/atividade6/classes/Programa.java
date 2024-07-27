package atividade6.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import atividade6.controllers.EstoqueController;
import atividade6.controllers.GerenciadorPedidosController;

public class Programa {

	public static void main(String[] args) {

		EstoqueController.cadastrarProduto("café", "extra", 5, 10);
		EstoqueController.cadastrarProduto("arroz", "branco", 3, 15);
		EstoqueController.cadastrarProduto("arroz", "branco", 3, 15);

		EstoqueController.adicionarEstoque(1, 3);
		EstoqueController.adicionarEstoque(2, 4);

		Scanner s = new Scanner(System.in);

		menu();
		int opcao = s.nextInt();
		while (opcao != 9) {
			if (opcao == 1) {
				cadastrarProduto();
			} else if (opcao == 2) {
				realizarPedido(s);
			} else if (opcao == 3) {
				listarPedidos(s);
			} else {
				throw new RuntimeException("Opção inválida");
			}
			
			System.out.println();
			menu();
			opcao = s.nextInt();
		}

		s.close();

	}

	private static void listarPedidos(Scanner s) {
		System.out.println(GerenciadorPedidosController.listarPedidos());
		
	}

	private static void realizarPedido(Scanner s) {
		List<ItemPedido> itens = new ArrayList<ItemPedido>();
		System.out.print("Código: ");
		int codigo = s.nextInt();
		while (codigo != -1) {
			System.out.print("Quantidade: ");
			int quantidade = s.nextInt();
			itens.add(new ItemPedido(quantidade, EstoqueController.buscarProduto(codigo)));

			System.out.print("Código: ");
			codigo = s.nextInt();
		}
		GerenciadorPedidosController.adicionarPedido(new Cliente("h"), itens);
	}

	private static void cadastrarProduto() {
		// TODO Auto-generated method stub

	}

	private static void menu() {
		System.out.println("1 - Cadastrar produto");
		System.out.println("2 - Realizar pedido");
		System.out.println("9 - Sair");
		System.out.print("Digite uma opção: ");
	}

}
