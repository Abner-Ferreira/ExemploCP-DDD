package model;

public class ProdutoModel {

	private int id, quantidade;
	private double preco;
	private String nome;
	
	public ProdutoModel() {
		
	}
	
	public ProdutoModel(int id, String nome, double preco, int quantidade) {
		this.id=id;
		this.nome=nome;
		this.preco=preco;
		this.quantidade=quantidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
