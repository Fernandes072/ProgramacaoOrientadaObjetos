package atividade3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		List<Cliente> clientes = new ArrayList<Cliente>();

		menu();
		String opcao = s.next();
		while (!opcao.equals("9")) {
			try {
				if (opcao.equals("1")) {
					cadastrarCliente(s, clientes);
				} else if (opcao.equals("2")) {
					efetuarLogin(s, clientes);
				} else {
					throw new BancoException("Erro: Opção inválida!");
				}
			} catch (BancoException e) {
				System.out.println(e.getMessage());
			} finally {
				System.out.println();
				menu();
				opcao = s.next();
			}
		}
		s.close();

	}

	private static void efetuarLogin(Scanner s, List<Cliente> clientes) {
		Cliente reserva = null;
		System.out.print("Código: ");
		int codigo = s.nextInt();
		System.out.print("Senha: ");
		String senha = s.next();
		
		for (Cliente cliente : clientes) {
			if (codigo == cliente.getCodigo()) {
				cliente.login(senha);
				reserva = cliente;
				break;
			}
		}
		
		if (reserva == null) {
			throw new BancoException("Erro: Código inválido!");
		}
		
		System.out.println();
		menuLogado();
		String opcao = s.next();
		while (!opcao.equals("9")) {
			try {
				if (opcao.equals("1")) {
					System.out.println("criar conta");
				} else if (opcao.equals("2")) {
					System.out.println("deposito");
				} else {
					throw new BancoException("Erro: Opção inválida!");
				}
			} catch (BancoException e) {
				System.out.println(e.getMessage());
			} finally {
				System.out.println();
				menuLogado();
				opcao = s.next();
			}
		}
	}

	private static void cadastrarCliente(Scanner s, List<Cliente> clientes) {
		System.out.print("Código: ");
		int codigo = s.nextInt();
		for (Cliente cliente : clientes) {
			if (codigo == cliente.getCodigo()) {
				throw new BancoException("Erro: Código já existe");
			}
		}

		System.out.print("Nome: ");
		String nome = s.next();
		System.out.print("Telefone: ");
		String telefone = s.next();
		System.out.print("Senha: ");
		String senha = s.next();

		clientes.add(new Cliente(codigo, nome, telefone, senha));
		System.out.println("Cliente cadastrado!");
	}

	private static void menu() {
		System.out.println("1 - Cadastrar cliente");
		System.out.println("2 - Login");
		System.out.println("9 - Sair");
		System.out.print("Digite a opção: ");

	}

	private static void menuLogado() {
		System.out.println("1 - Criar conta");
		System.out.println("2 - Depósito");
		System.out.println("3 - Saque");
		System.out.println("4 - Transferência");
		System.out.println("5 - Exibir contas");
		System.out.println("6 - Exibir extrato");
		System.out.println("7 - Solicitar aumento do cheque especial");
		System.out.println("9 - Logout");
		System.out.print("Digite a opção: ");
	}
}