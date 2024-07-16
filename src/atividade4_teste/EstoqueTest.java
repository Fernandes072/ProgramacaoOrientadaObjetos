package atividade4_teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class EstoqueTest {
	
	@Test
	public void codigoNegativoDeveRetornarIllegalArgumentException() {
		String dados = "-1 Cafe Extra 10 5";
		byte[] dadosByte = dados.getBytes();
		InputStream entrada = new ByteArrayInputStream(dadosByte);
		System.setIn(entrada);
		Scanner scanner = new Scanner(System.in);
		assertThrows(IllegalArgumentException.class, () -> {
			Programa.criarProduto(scanner, null);
		});
	}
	
	@Test
	public void codigoDoisDeveRetornarDois() {
		Produto produto = new Produto(2, "Cafe", "Extra", 10, 5);
		assertEquals(2, produto.getCodigo());
	}
	
	@Test
	public void codigoIgualDeveRetornarIllegalArgumentException() {
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(new Produto(2));
		System.setIn(new ByteArrayInputStream("2 Cafe Extra 10 5".getBytes()));
		Scanner scanner = new Scanner(System.in);
		assertThrows(IllegalArgumentException.class, () -> {
			Programa.criarProduto(scanner, produtos);
		});
	}
	
	@Test
	public void cafeDeveRetornarCafe() {
		Produto produto = new Produto(2, "Cafe", "Extra", 10, 5);
		assertEquals("Cafe", produto.getNome());
	}
	
	@Test
	public void extraDeveRetornarExtra() {
		Produto produto = new Produto(2, "Cafe", "Extra", 10, 5);
		assertEquals("Extra", produto.getDescricao());
	}
	
	@Test
	public void precoNegativoDeveRetornarIllegalArgumentException() {
		System.setIn(new ByteArrayInputStream("2 Cafe Extra -1 5".getBytes()));
		Scanner scanner = new Scanner(System.in);
		assertThrows(IllegalArgumentException.class, () -> {
			Programa.criarProduto(scanner, null);
		});
	}
	
	@Test
	public void dezDeveRetornarDez() {
		Produto produto = new Produto(2, "Cafe", "Extra", 10, 5);
		assertEquals(10, produto.getPreco());
	}
	
	@Test
	public void validadeNegativaDeveRetornarIllegalArgumentException() {
		System.setIn(new ByteArrayInputStream(" 2 Cafe Extra 10 -1".getBytes()));
		Scanner scanner = new Scanner(System.in);
		assertThrows(IllegalArgumentException.class, () -> {
			Programa.criarProduto(scanner, null);
		});
	}
	
	@Test
	public void cincoDeveRetornarCinco() {
		Produto produto = new Produto(2, "Cafe", "Extra", 10, 5);
		assertEquals(5, produto.getValidade());
	}
}
