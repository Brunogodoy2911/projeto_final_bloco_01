package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.Optional;

import projeto_final_bloco_01.model.Book;
import projeto_final_bloco_01.repository.BookRepository;

public class BookController implements BookRepository {

	private ArrayList<Book> books = new ArrayList<Book>();

	int idAutomatic = 0;

	@Override
	public void create(Book book) {
		books.add(book);

		System.out.println("\n✅ Livro adicionado com sucesso!");
	}

	@Override
	public void listAll() {
		if (books.isEmpty())
			System.out.println("\n❌ Não há livros cadastrados no momento. Adicione novos livros para começar.");
		else {
			System.out.println("\n📋 Lista de todos os Livros: ");
			for (var book : books) {
				book.view();
			}
		}
	}

	@Override
	public void listById(int id) {

		Optional<Book> book = findByCollection(id);

		if (book.isPresent()) {
			System.out.printf("\n📋 Lista de todos os Livros com ID %d: \n", id);
			book.get().view();
		}

		else
			System.out.printf("\n❌ Não há livros cadastrados com o ID %d", id);
	}

	@Override
	public void update(Book newBook) {

		Optional<Book> book = findByCollection(newBook.getId());

		if (book.isPresent()) {
			books.set(books.indexOf(book.get()), newBook);
			System.out.println("\nDados do Livro Anteriores: ");
			book.get().view();
			System.out.println("\nDados do Livro Atualizados: ");
			newBook.view();
			System.out.println("\n✅ Livro atualizado com sucesso!");
		} else
			System.out.printf("\n❌ Livro com ID %d não encontrado.", newBook.getId());

	}

	@Override
	public void remove(int id) {

		boolean removed = books.removeIf(book -> book.getId() == id);

		if (removed) {
			System.out.printf("\n🗑️ Livro com ID %d removido com sucesso!", id);
		} else
			System.out.printf("\n❌ Livro com ID %d não encontrado.", id);

	}

	public int generateId() {
		return ++idAutomatic;
	}

	public Optional<Book> findByCollection(int id) {
		return books.stream().filter(book -> book.getId() == id).findFirst();
	}

}
