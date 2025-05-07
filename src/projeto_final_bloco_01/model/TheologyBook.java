package projeto_final_bloco_01.model;

public class TheologyBook extends Book {

	private String theme;

	public TheologyBook(int id, String name, int typeOfBook, float price, String theme) {
		super(id, name, typeOfBook, price);
		this.theme = theme;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	@Override
	public void view() {
		super.view();
		System.out.println("Tema: " + this.theme);
	}

}
