package atividade3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		List<Cliente> clientes = new ArrayList<Cliente>();
		List<Cliente> gerentes = new ArrayList<Cliente>();
		gerentes.add(new Cliente(0, "0", "0", "0"));

		menu();
		String opcao = s.next();
		while (!opcao.equals("9")) {
			try {
				if (opcao.equals("1")) {
					cadastrarCliente(s, clientes);
				} else if (opcao.equals("2")) {
					efetuarLogin(s, clientes, gerentes);
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

	private static void efetuarLogin(Scanner s, List<Cliente> clientes, List<Cliente> gerentes) {
		Cliente reserva = null;
		System.out.print("Código: ");
		int codigo = s.nextInt();
		System.out.print("Senha: ");
		String senha = s.next();

		boolean eGerente = false;

		for (Cliente gerente : gerentes) {
			if (codigo == gerente.getCodigo()) {
				gerente.login(senha);
				reserva = gerente;
				eGerente = true;
				break;
			}
		}

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

		if (eGerente) {
			opcoesGerente(s, clientes);
		} else {
			opcoesCliente(s, reserva, clientes);
		}
	}

	private static void opcoesCliente(Scanner s, Cliente cliente, List<Cliente> clientes) {
		System.out.println();
		menuCliente();
		String opcao = s.next();
		while (!opcao.equals("9")) {
			try {
				if (opcao.equals("1")) {
					criarConta(s, cliente, clientes);
				} else if (opcao.equals("2")) {
					deposito(s, cliente);
				} else if (opcao.equals("3")) {
					saque(s, cliente);
				} else if (opcao.equals("4")) {
					transferencia(s, cliente, clientes);
				} else if (opcao.equals("5")) {
					exibirContas(cliente);
				} else if (opcao.equals("6")) {
					exibirExtrato(s, cliente);
				} else if (opcao.equals("7")) {
					solicitarAumento(s, cliente);
				} else {
					throw new BancoException("Erro: Opção inválida!");
				}
			} catch (BancoException e) {
				System.out.println(e.getMessage());
			} finally {
				System.out.println();
				menuCliente();
				opcao = s.next();
			}
		}

	}

	private static void opcoesGerente(Scanner s, List<Cliente> clientes) {
		System.out.println();
		menuGerente();
		String opcao = s.next();
		while (!opcao.equals("9")) {
			try {
				if (opcao.equals("1")) {
					listarClientes(s, clientes);
				} else if (opcao.equals("2")) {
					listarPedidosAumento(s, clientes);
				} else if (opcao.equals("3")) {
					listarClientesBloqueados(s, clientes);
				} else if (opcao.equals("4")) {
					concederAumento(s, clientes);
				} else if (opcao.equals("5")) {
					desbloquearConta(s, clientes);
				} else {
					throw new BancoException("Erro: Opção inválida!");
				}
			} catch (BancoException e) {
				System.out.println(e.getMessage());
			} finally {
				System.out.println();
				menuGerente();
				opcao = s.next();
			}
		}

	}

	private static void desbloquearConta(Scanner s, List<Cliente> clientes) {
		System.out.print("Código: ");
		int codigo = s.nextInt();

		Cliente cliente = null;
		for (Cliente c : clientes) {
			if (codigo == c.getCodigo() && c.getTentativas() == 0) {
				cliente = c;
			}
		}
		if (cliente == null) {
			throw new BancoException("Erro: Código inválido!");
		}
		
		cliente.setTentativas(3);
		System.out.println("Desbloqueio realizado!");
	}

	private static void concederAumento(Scanner s, List<Cliente> clientes) {
		System.out.print("Número da conta: ");
		int numero = s.nextInt();

		Conta conta = null;
		for (Cliente cliente : clientes) {
			for (Conta c : cliente.getContas()) {
				if (numero == c.getNumero() && c instanceof ContaCorrente) {
					if (((ContaCorrente) c).getAumentoChequeEspecial() > 0) {
						conta = c;
					}
				}
			}
		}
		if (conta == null) {
			throw new BancoException("Erro: Número de conta inválido!");
		}
		
		ContaCorrente contaC = (ContaCorrente) conta;
		contaC.setChequeEspecial(contaC.getChequeEspecial() + contaC.getAumentoChequeEspecial());
		contaC.setAumentoChequeEspecial(0);
		System.out.println("Aumento realizado!");
	}

	private static void listarClientesBloqueados(Scanner s, List<Cliente> clientes) {
		for (Cliente cliente : clientes) {
			if (cliente.getTentativas() == 0) {
				System.out.println(cliente);
			}
		}
	}

	private static void listarPedidosAumento(Scanner s, List<Cliente> clientes) {
		for (Cliente cliente : clientes) {
			for (Conta conta : cliente.getContas()) {
				if (conta instanceof ContaCorrente) {
					if (((ContaCorrente) conta).getAumentoChequeEspecial() > 0) {
						System.out.println(conta);
					}
				}
			}
		}
	}

	private static void listarClientes(Scanner s, List<Cliente> clientes) {
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
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

	private static void menuCliente() {
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

	private static void menuGerente() {
		System.out.println("1 - Listar clientes");
		System.out.println("2 - Listar pedidos de aumento");
		System.out.println("3 - Listar contas bloqueadas");
		System.out.println("4 - Aceitar pedido de aumento");
		System.out.println("5 - Desbloquear conta");
		System.out.println("9 - Logout");
		System.out.print("Digite a opção: ");
	}
}