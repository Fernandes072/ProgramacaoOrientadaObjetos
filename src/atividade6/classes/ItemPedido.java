package atividade6.classes;

public class ItemPedido {
	
	private int quantidade;
	private Produto produto;
	
	public ItemPedido(int quantidade, Produto produto) {
		setQuantidade(quantidade);
		setProduto(produto);
	}

	public int getQuantidade() {
		return quantidade;
	}

	private void setQuantidade(int quantidade) {
		if (quantidade < 1) {
			throw new IllegalArgumentException("Quantidade não pode ser menor que 1!");
		}
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	private void setProduto(Produto produto) {
		if (produto == null) {
			throw new IllegalArgumentException("Produto não pode ser vazio!");
		}
		this.produto = produto;
	}
	
	public double subTotal() {
		return quantidade * produto.getPreco();
	}

	@Override
	public String toString() {
		return produto.toString2() + " | Quantidade: " + quantidade + " | SubTotal: " + this.subTotal();
	}
}
