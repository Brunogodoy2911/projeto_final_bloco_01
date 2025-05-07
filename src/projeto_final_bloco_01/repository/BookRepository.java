package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.Book;

public interface BookRepository {

	public void create(Book book);

	public void listAll();

	public void listById(int id);

	public void update(Book newBook);

	public void remove(int id);

}
