package atividade6.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import atividade6.controllers.EstoqueController;
import atividade6.controllers.GerenciadorClienteController;
import atividade6.controllers.GerenciadorPedidosController;

public class Programa {

	public static void main(String[] args) {

		EstoqueController.cadastrarProduto("Café", "Extraforte", 5, 10);
		EstoqueController.cadastrarProduto("Arroz", "Branco", 3, 15);
		EstoqueController.cadastrarProduto("Macarrão", "Parafuso", 8, 120);

		GerenciadorClienteController.cadastrarCliente("123", "joao", "joao@");
		GerenciadorClienteController.cadastrarCliente("456", "jose", "jose@");

		EstoqueController.adicionarEstoque(1, 10);
		EstoqueController.adicionarEstoque(2, 10);
		EstoqueController.adicionarEstoque(3, 10);

		Scanner s = new Scanner(System.in);

		menu();
		int opcao = s.nextInt();
		while (opcao != 9) {
			try {
				if (opcao == 1) {
					cadastrarProduto(s);
				} else if (opcao == 2) {
					cadastrarCliente(s);
				} else if (opcao == 3) {
					adicionarEstoque(s);
				} else if (opcao == 4) {
					realizarPedido(s);
				} else if (opcao == 5) {
					listarClientes();
				} else if (opcao == 6) {
					listarProdutos();
				} else if (opcao == 7) {
					listarPedidosPorCliente(s);
				} else {
					throw new RuntimeException("Opção inválida");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				System.out.println();
				menu();
				opcao = s.nextInt();
			}
		}
		s.close();
	}

	private static void listarPedidosPorCliente(Scanner s) {
		System.out.print("CPF: ");
		String cpf = s.next();
		System.out.println(GerenciadorPedidosController.listarPedidosPorCliente(cpf));
	}

	private static void listarProdutos() {
		System.out.println(EstoqueController.listarProdutos());
	}

	private static void listarClientes() {
		System.out.println(GerenciadorClienteController.listarClientes());
	}

	private static void realizarPedido(Scanner s) {
		List<ItemPedido> itens = new ArrayList<ItemPedido>();
		System.out.print("Código: ");
		int codigo = s.nextInt();
		while (codigo != -1) {
			System.out.print("Quantidade: ");
			int quantidade = s.nextInt();
			try {
				Produto produto = EstoqueController.buscarProduto(codigo);
				itens.add(new ItemPedido(quantidade, produto));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				System.out.print("Código: ");
				codigo = s.nextInt();
			}
		}
		System.out.print("CPF: ");
		String cpf = s.next();
		Cliente cliente = GerenciadorClienteController.buscarCliente(cpf);
		GerenciadorPedidosController.adicionarPedido(cliente, itens);
	}

	private static void adicionarEstoque(Scanner s) {
		System.out.print("Código: ");
		int codigo = s.nextInt();
		System.out.print("Quantidade: ");
		int quantidade = s.nextInt();
		EstoqueController.adicionarEstoque(codigo, quantidade);
	}

	private static void cadastrarCliente(Scanner s) {
		System.out.print("CPF: ");
		String cpf = s.next();
		System.out.print("Nome: ");
		String nome = s.next();
		System.out.print("Email: ");
		String email = s.next();
		GerenciadorClienteController.cadastrarCliente(cpf, nome, email);
	}

	private static void cadastrarProduto(Scanner s) {
		System.out.print("Nome: ");
		String nome = s.next();
		System.out.print("Descrição: ");
		String descricao = s.next();
		System.out.print("Preço: ");
		double preco = s.nextDouble();
		System.out.print("Validade: ");
		int validade = s.nextInt();
		EstoqueController.cadastrarProduto(nome, descricao, preco, validade);
	}

	private static void menu() {
		System.out.println("1 - Cadastrar produto");
		System.out.println("2 - Cadastrar cliente");
		System.out.println("3 - Adicionar estoque");
		System.out.println("4 - Realizar pedido");
		System.out.println("5 - Listar clientes");
		System.out.println("6 - Listar produtos");
		System.out.println("7 - Listar pedidos por cliente");
		System.out.println("9 - Sair");
		System.out.print("Digite uma opção: ");
	}

}
