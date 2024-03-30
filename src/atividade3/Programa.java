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
					criarConta(s, reserva, clientes);
				} else if (opcao.equals("2")) {
					deposito(s, reserva);
				} else if (opcao.equals("3")) {
					saque(s, reserva);
				} else if (opcao.equals("4")) {
					transferencia(s, reserva, clientes);
				} else if (opcao.equals("5")) {
					exibirContas(reserva);
				} else if (opcao.equals("6")) {
					exibirExtrato(s, reserva);
				} else if (opcao.equals("7")) {
					solicitarAumento(s, reserva);
				}  else {
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

	private static void solicitarAumento(Scanner s, Cliente cliente) {
		System.out.print("Número da conta: ");
		int numero = s.nextInt();

		Conta conta = null;
		for (Conta c : cliente.getContas()) {
			if (numero == c.getNumero()) {
				conta = c;
			}
		}
		if (conta == null || conta instanceof ContaPoupanca) {
			throw new BancoException("Erro: Número de conta inválido!");
		}
		
		System.out.print("Valor: ");
		double valor = s.nextDouble();
		((ContaCorrente) conta).setAumentoChequeEspecial(valor);
		System.out.println("Pedido realizado!"); 
	}

	private static void exibirExtrato(Scanner s, Cliente cliente) {
		System.out.print("Número da conta: ");
		int numero = s.nextInt();

		Conta conta = null;
		for (Conta c : cliente.getContas()) {
			if (numero == c.getNumero()) {
				conta = c;
			}
		}
		if (conta == null) {
			throw new BancoException("Erro: Número de conta inválido!");
		}
		
		for (Transacao transacao : conta.getTransacoes()) {
			System.out.println(transacao);
		}
	}

	private static void exibirContas(Cliente cliente) {
		for (Conta conta : cliente.getContas()) {
			System.out.println(conta);
		}
	}

	private static void transferencia(Scanner s, Cliente cliente, List<Cliente> clientes) {
		System.out.print("Número da conta: ");
		int numero = s.nextInt();

		Conta conta = null;
		for (Conta c : cliente.getContas()) {
			if (numero == c.getNumero()) {
				conta = c;
			}
		}
		if (conta == null) {
			throw new BancoException("Erro: Número de conta inválido!");
		}
		
		System.out.print("Número da conta destino: ");
		int numeroDestino = s.nextInt();

		Conta contaDestino = null;
		for (Conta c : cliente.getContas()) {
			if (numeroDestino == c.getNumero()) {
				contaDestino = c;
			}
		}
		if (contaDestino == null) {
			throw new BancoException("Erro: Número de conta destino inválido!");
		}
		
		System.out.print("Valor: ");
		double valor = s.nextDouble();
		conta.transferencia(valor, contaDestino);
		System.out.println("Transferência realizada!"); 
	}

	private static void saque(Scanner s, Cliente cliente) {
		System.out.print("Número da conta: ");
		int numero = s.nextInt();

		Conta conta = null;
		for (Conta c : cliente.getContas()) {
			if (numero == c.getNumero()) {
				conta = c;
			}
		}
		if (conta == null) {
			throw new BancoException("Erro: Número de conta inválido!");
		}
		
		System.out.print("Valor: ");
		double valor = s.nextDouble();
		conta.saque(valor);
		System.out.println("Saque realizado!"); 
	}

	private static void deposito(Scanner s, Cliente cliente) {
		System.out.print("Número da conta: ");
		int numero = s.nextInt();

		Conta conta = null;
		for (Conta c : cliente.getContas()) {
			if (numero == c.getNumero()) {
				conta = c;
			}
		}
		if (conta == null) {
			throw new BancoException("Erro: Número de conta inválido!");
		}
		
		System.out.print("Valor: ");
		double valor = s.nextDouble();
		conta.deposito(valor);
		System.out.println("Depósito realizado!"); 
	}

	private static void criarConta(Scanner s, Cliente cliente, List<Cliente> clientes) {
		System.out.print("Tipo de conta (1-Poupança | 2-Corrente): ");
		String tipo = s.next();

		int contadorPoupanca = 0;
		int contadorCorrente = 0;
		for (Conta conta : cliente.getContas()) {
			if (conta instanceof ContaPoupanca) {
				contadorPoupanca++;
			} else {
				contadorCorrente++;
			}
		}
		if (contadorPoupanca == 1 && tipo.equals("1")) {
			throw new BancoException("Erro: Limite de contas poupança!");
		}
		if (contadorCorrente == 1 && tipo.equals("2")) {
			throw new BancoException("Erro: Limite de contas corrente!");
		}

		System.out.print("Número da conta: ");
		int numero = s.nextInt();
		for (Cliente c : clientes) {
			for (Conta conta : c.getContas()) {
				if (numero == conta.getNumero()) {
					throw new BancoException("Erro: Número de conta já existe!");
				}
			}
		}

		if (tipo.equals("1")) {
			cliente.getContas().add(new ContaPoupanca(numero));
		} else {
			cliente.getContas().add(new ContaCorrente(numero));
		}

		System.out.println("Conta criada!");
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