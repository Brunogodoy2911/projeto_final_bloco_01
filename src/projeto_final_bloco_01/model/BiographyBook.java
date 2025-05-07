package projeto_final_bloco_01.model;

public class BiographyBook extends Book {
	
	private String nameOfSaint;

	public BiographyBook(int id, String name, int typeOfBook, float price, String nameOfSaint) {
		super(id, name, typeOfBook, price);
		this.nameOfSaint = nameOfSaint;
	}

	public String getNameOfSaint() {
		return nameOfSaint;
	}

	public void setNameOfSaint(String nameOfSaint) {
		this.nameOfSaint = nameOfSaint;
	}
	
	@Override
	public void view() {
		super.view();
		System.out.println("Nome do SANTO biografado: " + this.nameOfSaint);
	}

}
