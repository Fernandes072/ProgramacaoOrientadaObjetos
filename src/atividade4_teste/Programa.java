package atividade4_teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		List<Produto> produtos = new ArrayList<Produto>();

		criarProduto(s, produtos);
		s.close();
	}

	public static void criarProduto(Scanner s, List<Produto> produtos) {
		System.out.print("Código: ");
		int codigo = s.nextInt();
		if (codigo < 0) {
			throw new IllegalArgumentException("Código não pode ser negativo!");
		}
//		if (produtos.contains(new Produto(codigo))) {
//			throw new IllegalArgumentException("Código já existe!");
//		}
		
		System.out.print("Nome: ");
		String nome = s.next();
		System.out.print("Descrição: ");
		String descricao = s.next();
		
		System.out.print("Preço: ");
		double preco = s.nextDouble();
		if (preco < 0) {
			throw new IllegalArgumentException("Preço não pode ser negativo!");
		}
		
		System.out.print("Validade: ");
		int validade = s.nextInt();
		if (validade < 0) {
			throw new IllegalArgumentException("Validade não pode ser negativa!");
		}
	}
}
