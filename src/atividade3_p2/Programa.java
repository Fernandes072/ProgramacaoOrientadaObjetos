package atividade3_p2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		List<Cliente> clientes = new ArrayList<Cliente>();
		List<Cliente> gerentes = new ArrayList<Cliente>();
		gerentes.add(new Cliente(0, "0", "0"));
		gerentes.get(gerentes.indexOf(new Cliente(0))).getContas().add(new ContaPoupanca(0, "0"));

		menu();
		String opcao = s.next();
		while (!opcao.equals("9")) {
			try {
				if (opcao.equals("1")) {
					cadastrarCliente(s, clientes);
				} else if (opcao.equals("2")) {
					criarConta(s, clientes);
				} else if (opcao.equals("3")) {
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
		Conta contaReserva = null;
		System.out.print("Número: ");
		int numero = s.nextInt();
		System.out.print("Senha: ");
		String senha = s.next();

		boolean eGerente = false;

		for (Cliente gerente : gerentes) {
			int posicao = gerente.getContas().indexOf((Conta) (new ContaCorrente(numero)));
			if (posicao != -1) {
				gerente.getContas().get(posicao).login(senha);
				contaReserva = gerente.getContas().get(posicao);
				eGerente = true;
				break;
			}
		}

		if (!eGerente) {
			for (Cliente cliente : clientes) {
				int posicao = cliente.getContas().indexOf((Conta) (new ContaCorrente(numero)));
				if (posicao != -1) {
					cliente.getContas().get(posicao).login(senha);
					contaReserva = cliente.getContas().get(posicao);
					break;
				}
			}
		}

		if (contaReserva == null) {
			throw new BancoException("Erro: Número inválido!");
		}

		if (eGerente) {
			opcoesGerente(s, clientes);
		} else {
			opcoesConta(s, contaReserva, clientes);
		}
	}

	private static void opcoesGerente(Scanner s, List<Cliente> clientes) {
		System.out.println();
		menuGerente();
		String opcao = s.next();
		while (!opcao.equals("9")) {
			try {
				if (opcao.equals("1")) {
					listarClientes(clientes);
				} else if (opcao.equals("2")) {
					listarContas(clientes);
				} else if (opcao.equals("3")) {
					listarPedidosAumento(clientes);
				} else if (opcao.equals("4")) {
					listarContasBloqueadas(clientes);
				} else if (opcao.equals("5")) {
					concederAumento(s, clientes);
				} else if (opcao.equals("6")) {
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
		System.out.print("Número da conta: ");
		int numero = s.nextInt();

		Conta conta = null;
		for (Cliente cliente : clientes) {
			for (Conta c : cliente.getContas()) {
				if (numero == c.getNumero() && c.getTentativas() == 0) {
					conta = c;
				}
			}
		}
		if (conta == null) {
			throw new BancoException("Erro: Número de conta inválido!");
		}
		
		conta.desbloquear();
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

		System.out.print("Valor: ");
		double valor = s.nextInt();
		((ContaCorrente) conta).concederAumento(valor);
		System.out.println("Aumento realizado!");
	}

	private static void listarContasBloqueadas(List<Cliente> clientes) {
		for (Cliente cliente : clientes) {
			for (Conta c : cliente.getContas()) {
				if (c.getTentativas() == 0) {
					System.out.println(c);
				}
			}
		}
	}

	private static void listarPedidosAumento(List<Cliente> clientes) {
		for (Cliente cliente : clientes) {
			for (Conta c : cliente.getContas()) {
				if (c instanceof ContaCorrente) {
					if (((ContaCorrente) c).getAumentoChequeEspecial() > 0) {
						System.out.println(c);
					}
				}
			}
		}
	}

	private static void listarContas(List<Cliente> clientes) {
		for (Cliente cliente : clientes) {
			for (Conta c : cliente.getContas()) {
				System.out.println(c);
			}
		}
	}

	private static void listarClientes(List<Cliente> clientes) {
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}

	private static void opcoesConta(Scanner s, Conta conta, List<Cliente> clientes) {
		System.out.println();
		menuConta(conta);
		String opcao = s.next();
		while (!opcao.equals("9")) {
			try {
				if (opcao.equals("1")) {
					deposito(s, conta);
				} else if (opcao.equals("2")) {
					saque(s, conta);
				} else if (opcao.equals("3")) {
					transferencia(s, conta, clientes);
				} else if (opcao.equals("4")) {
					exibirExtrato(conta);
				} else if (opcao.equals("5")) {
					if (conta instanceof ContaPoupanca) {
						throw new BancoException("Erro: Opção inválida!");
					}
					solicitarAumento(s, conta);
				} else {
					throw new BancoException("Erro: Opção inválida!");
				}
			} catch (BancoException e) {
				System.out.println(e.getMessage());
			} finally {
				System.out.println();
				menuConta(conta);
				opcao = s.next();
			}
		}

	}

	private static void solicitarAumento(Scanner s, Conta conta) {
		System.out.print("Valor: ");
		double valor = s.nextDouble();
		((ContaCorrente) conta).solicitarAumento(valor);
		System.out.println("Pedido realizado!");
	}

	private static void exibirExtrato(Conta conta) {
		List<Transacao> transacoes = conta.getTransacoes();
		for (int i = transacoes.size() - 1; i >= 0; i--) {
			System.out.println(transacoes.get(i));
		}
	}

	private static void transferencia(Scanner s, Conta conta, List<Cliente> clientes) {
		System.out.print("Número da conta destino: ");
		int numeroDestino = s.nextInt();

		Conta contaDestino = null;
		for (Cliente cliente : clientes) {
			int posicao = cliente.getContas().indexOf((Conta) (new ContaCorrente(numeroDestino)));
			if (posicao != -1) {
				contaDestino = cliente.getContas().get(posicao);
				break;
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

	private static void saque(Scanner s, Conta conta) {
		System.out.print("Valor: ");
		double valor = s.nextDouble();
		conta.saque(valor);
		System.out.println("Saque realizado!");
	}

	private static void deposito(Scanner s, Conta conta) {
		System.out.print("Valor: ");
		double valor = s.nextDouble();
		conta.deposito(valor);
		System.out.println("Depósito realizado!");
	}

	private static void criarConta(Scanner s, List<Cliente> clientes) {
		System.out.print("Código do cliente: ");
		int codigo = s.nextInt();

		int posicao = clientes.indexOf(new Cliente(codigo));
		if (posicao == -1) {
			throw new BancoException("Erro: Código de cliente não existe");
		}
		Cliente cliente = clientes.get(posicao);

		System.out.print("Tipo de conta (1-Poupança | 2-Corrente): ");
		String tipo = s.next();
		cliente.verificarLimiteContas(tipo);

		System.out.print("Número da conta: ");
		int numero = s.nextInt();

		for (Cliente c : clientes) {
			if (c.getContas().contains((Conta) (new ContaCorrente(numero)))) {
				throw new BancoException("Erro: Número de conta já existe!");
			}
		}

		System.out.print("Senha: ");
		String senha = s.next();

		if (tipo.equals("1")) {
			cliente.getContas().add(new ContaPoupanca(numero, senha));
		} else {
			cliente.getContas().add(new ContaCorrente(numero, senha));
		}

		System.out.println("Conta criada!");
	}

	private static void cadastrarCliente(Scanner s, List<Cliente> clientes) {
		System.out.print("Código: ");
		int codigo = s.nextInt();

		if (clientes.contains(new Cliente(codigo))) {
			throw new BancoException("Erro: Código já existe");
		}

		System.out.print("Nome: ");
		String nome = s.next();
		System.out.print("Telefone: ");
		String telefone = s.next();

		clientes.add(new Cliente(codigo, nome, telefone));
		System.out.println("Cliente cadastrado!");
	}

	private static void menu() {
		System.out.println("1 - Cadastrar cliente");
		System.out.println("2 - Criar conta");
		System.out.println("3 - Login");
		System.out.println("9 - Sair");
		System.out.print("Digite a opção: ");

	}

	private static void menuConta(Conta conta) {
		System.out.println("1 - Depósito");
		System.out.println("2 - Saque");
		System.out.println("3 - Transferência");
		System.out.println("4 - Extrato");
		if (conta instanceof ContaCorrente) {
			System.out.println("5 - Solicitar aumento do cheque especial");
		}
		System.out.println("9 - Logout");
		System.out.print("Digite a opção: ");
	}

	private static void menuGerente() {
		System.out.println("1 - Listar clientes");
		System.out.println("2 - Listar contas");
		System.out.println("3 - Listar pedidos de aumento");
		System.out.println("4 - Listar contas bloqueadas");
		System.out.println("5 - Aceitar pedido de aumento");
		System.out.println("6 - Desbloquear conta");
		System.out.println("9 - Logout");
		System.out.print("Digite a opção: ");
	}
}
