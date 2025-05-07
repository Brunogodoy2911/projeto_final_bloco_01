package projeto_final_bloco_01.model;

import java.text.NumberFormat;

public abstract class Book {

	NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();

	private int id;
	private String name;
	private int typeOfBook;
	private float price;

	public Book(int id, String name, int typeOfBook, float price) {
		this.id = id;
		this.name = name;
		this.typeOfBook = typeOfBook;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTypeOfBook() {
		return typeOfBook;
	}

	public void setTypeOfBook(int typeOfBook) {
		this.typeOfBook = typeOfBook;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void view() {
		System.out.println("=========================================");
		System.out.println("          LIVRO - DETALHES");
		System.out.println("=========================================");
		System.out.println("ID: " + id);
		System.out.println("Nome: " + name);
		System.out.println("Tipo: " + (typeOfBook == 1 ? "Teologia" : "Biografia"));
		System.out.println("Preço: " + nfMoeda.format(price));
		System.out.println("=========================================\n");
	}

}
