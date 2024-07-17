package atividade4;

import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Estoque estoque = new Estoque();

		menu();
		int opcao = s.nextInt();
		while (opcao != 9) {
			if (opcao == 1) {
				cadastrarProduto(s, estoque);
			} else if (opcao == 2) {
				adicionarEstoque(s, estoque);
			} else if (opcao == 3) {
				removerEstoque(s, estoque);
			} else if (opcao == 4) {
				listarProdutos(estoque);
			}
			
			System.out.println();
			menu();
			opcao = s.nextInt();
		}

		s.close();

	}
	
	private static void listarProdutos(Estoque estoque) {
		estoque.listarProdutos();
	}

	private static void removerEstoque(Scanner s, Estoque estoque) {
		System.out.print("Código: ");
		int codigo = s.nextInt();
		System.out.print("Quantidade: ");
		int quantidade = s.nextInt();
		estoque.removerEstoque(codigo, quantidade);
	}

	private static void adicionarEstoque(Scanner s, Estoque estoque) {
		System.out.print("Código: ");
		int codigo = s.nextInt();
		System.out.print("Quantidade: ");
		int quantidade = s.nextInt();
		estoque.adicionarEstoque(codigo, quantidade);
	}

	private static void cadastrarProduto(Scanner s, Estoque estoque) {
		System.out.print("Código: ");
		int codigo = s.nextInt();
		System.out.print("Nome: ");
		String nome = s.next();
		System.out.print("Descrição: ");
		String descricao = s.next();
		System.out.print("Preço: ");
		double preco = s.nextDouble();
		System.out.print("Validade: ");
		int validade = s.nextInt();
		estoque.cadastrarProduto(new Produto(codigo, nome, descricao, preco, validade));
	}

	private static void menu() {
		System.out.println("1 - Cadastrar produto");
		System.out.println("2 - Adicionar estoque");
		System.out.println("3 - Remover estoque");
		System.out.println("4 - Listar produtos");
		System.out.println("9 - Sair");
		System.out.print("Digite uma opção: ");
	}

}
