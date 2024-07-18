package atividade4;

import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Estoque estoque = new Estoque();

		estoque.cadastrarProduto(new Produto(1, "Arroz", "Branco", 4, 30));
		estoque.cadastrarProduto(new Produto(2, "Café", "Extra", 10, 5));
		estoque.cadastrarProduto(new Produto(3, "Amendoim", "Japonês", 7, 15));
		estoque.adicionarEstoque(3, 10);
		estoque.adicionarEstoque(2, 20);
		estoque.adicionarEstoque(1, 30);

		ControleUsuario usuarios = new ControleUsuario();
		usuarios.adicionarUsuario(new Usuario("Paulo", "Paulo12", "1234"));
		usuarios.adicionarUsuario(new Usuario("1", "1", "1"));

		menu();
		int opcao = s.nextInt();
		while (opcao != 9) {
			try {
				if (opcao == 1) {
					listarProdutos(s, estoque);
				} else if (opcao == 2) {
					login(s, usuarios, estoque);
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

	private static void login(Scanner s, ControleUsuario usuarios, Estoque estoque) {
		System.out.print("Usuário: ");
		String usuario = s.next();
		System.out.print("Senha: ");
		String senha = s.next();
		
//		Quando digita o usuário dá errado, mas quando atribui diretamente (usuario = "1";) funciona
//		System.out.println(usuarios.getUsuarios().indexOf(new Usuario(usuario)));
//		usuario = "1";
//		senha = "1";

		if (usuarios.login(usuario, senha)) {
			System.out.println();
			menuLogado();
			int opcao = s.nextInt();
			while (opcao != 9) {
				try {
					if (opcao == 1) {
						cadastrarProduto(s, estoque);
					} else if (opcao == 2) {
						adicionarEstoque(s, estoque);
					} else if (opcao == 3) {
						removerEstoque(s, estoque);
					} else if (opcao == 4) {
						listarProdutos(s, estoque);
					} else {
						throw new RuntimeException("Opção inválida");
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					System.out.println();
					menuLogado();
					opcao = s.nextInt();
				}
			}
		}
	}

	private static void listarProdutos(Scanner s, Estoque estoque) {
		System.out.println();
		menuListarProdutos();
		int opcao = s.nextInt();
		if (opcao == 1) {
			System.out.println(estoque.listarCompleto());
		} else if (opcao == 2) {
			System.out.println(estoque.listarResumido());
		} else if (opcao == 3) {
			System.out.println(estoque.listarProdutosPreco());
		} else {
			throw new RuntimeException("Opção inválida");
		}
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
		System.out.println("1 - Listar produtos");
		System.out.println("2 - Login");
		System.out.println("9 - Sair");
		System.out.print("Digite uma opção: ");
	}

	private static void menuListarProdutos() {
		System.out.println("1 - Listar completo");
		System.out.println("2 - Listar resumido");
		System.out.println("3 - Listar pelo preço");
		System.out.print("Digite uma opção: ");
	}

	private static void menuLogado() {
		System.out.println("1 - Cadastrar produto");
		System.out.println("2 - Adicionar estoque");
		System.out.println("3 - Remover estoque");
		System.out.println("4 - Listar produtos");
		System.out.println("9 - Logout");
		System.out.print("Digite uma opção: ");
	}
}