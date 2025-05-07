package projeto_final_bloco_01;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import projeto_final_bloco_01.controller.BookController;
import projeto_final_bloco_01.model.BiographyBook;
import projeto_final_bloco_01.model.Book;
import projeto_final_bloco_01.model.TheologyBook;

public class Menu {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);

		BookController books = new BookController();

		// Teste 1
		BiographyBook b1 = new BiographyBook(books.generateId(), "História de uma alma", 2, 33.06f,
				"Santa Teresinha do Menino Jesus");
		books.create(b1);

		// Teste 2
		TheologyBook t1 = new TheologyBook(books.generateId(), "Filotéia: Introdução à Vida Devota", 1, 39.15f,
				"Orientação a uma vida devota a Deus, e exercícios espirituais.");
		books.create(t1);

		int option = 0, id, typeOfBook;
		String name, theme, nameOfSaint, confirm;
		float price;

		while (true) {
			try {
				System.out.println("\n************************************************");
				System.out.println("            📚 MENU E-COMMERCE DOM BOSCO      ");
				System.out.println("************************************************");
				System.out.println(" 1️⃣  - Adicionar Livro");
				System.out.println(" 2️⃣  - Listar Todos os Livros");
				System.out.println(" 3️⃣  - Listar Livros por ID");
				System.out.println(" 4️⃣  - Atualizar Livro");
				System.out.println(" 5️⃣  - Deletar Livro");
				System.out.println(" 0️⃣  - Sair");
				System.out.println("************************************************");
				System.out.print("👉 Escolha uma opção: ");
				option = read.nextInt();

				if (option == 0) {
					System.out.println("\nLivraria Dom Bosco - Aqui você encontra seus santos livros!");
					about();
					read.close();
					System.exit(0);
				}

				switch (option) {
				case 1 -> {
					System.out.println("📘 Criar Livro\n\n");

					System.out.println("Digite o NOME do Livro:");
					read.skip("\\R");
					name = read.nextLine();

					System.out.println("Digite o TIPO do Livro (1 - TEOLOGIA | 2 - BIOGRAFIA ):");
					typeOfBook = read.nextInt();

					System.out.println("Digite o PREÇO do Livro:");
					price = read.nextFloat();

					switch (typeOfBook) {
					case 1 -> {
						System.out.println("Digite o TEMA de Teologia: ");
						read.skip("\\R");
						theme = read.nextLine();

						books.create(new TheologyBook(books.generateId(), name, typeOfBook, price, theme));
					}
					case 2 -> {
						System.out.println("Digite o NOME do SANTO biografado: ");
						read.skip("\\R");
						nameOfSaint = read.nextLine();

						books.create(new BiographyBook(books.generateId(), name, typeOfBook, price, nameOfSaint));
					}
					}

					keyPress();
				}

				case 2 -> {
					System.out.println("Listar todas os LIVROS\n\n");
					books.listAll();
					keyPress();

				}

				case 3 -> {
					System.out.println("Consultar dados do LIVRO - por número\n\n");

					System.out.println("Digite o ID do LIVRO: ");
					id = read.nextInt();

					books.listById(id);

					keyPress();

				}

				case 4 -> {
					System.out.println("Atualizar dados do LIVRO\n\n");

					System.out.println("Digite o ID do LIVRO: ");
					id = read.nextInt();

					Optional<Book> book = books.findByCollection(id);

					if (book.isPresent()) {
						System.out.println("Digite o NOME do Livro:");
						read.skip("\\R");
						name = read.nextLine();

						typeOfBook = book.get().getTypeOfBook();

						System.out.println("Digite o PREÇO do Livro:");
						price = read.nextFloat();

						switch (typeOfBook) {
						case 1 -> {
							System.out.println("Digite o TEMA de Teologia: ");
							read.skip("\\R");
							theme = read.nextLine();

							books.update(new TheologyBook(id, name, typeOfBook, price, theme));
						}
						case 2 -> {
							System.out.println("Digite o NOME do SANTO biografado: ");
							read.skip("\\R");
							nameOfSaint = read.nextLine();

							books.update(new BiographyBook(id, name, typeOfBook, price, nameOfSaint));
						}
						}
					} else
						System.out.printf("\n❌ Livro com ID %d não encontrado.", id);

					keyPress();

				}

				case 5 -> {
					System.out.println("Apagar o LIVRO\n\n");

					System.out.println("Digite o ID do LIVRO: ");
					id = read.nextInt();
					read.skip("\\R");

					do {
						System.out.println("Deseja realmente remover o LIVRO? (S - SIM | N - NÃO)");
						confirm = read.nextLine().trim();
					} while (!confirm.equalsIgnoreCase("S") && !confirm.equalsIgnoreCase("N"));

					if (confirm.equalsIgnoreCase("S"))
						books.remove(id);
					else
						System.out.println("❎ Remoção cancelada.");

					keyPress();

				}

				default -> {
					System.out.println("\nOpção Inválida!\n");
					keyPress();

				}

				}
			} catch (InputMismatchException e) {
				System.out.println("❌ Entrada inválida! Por favor, digite um valor numérico correto.");
				read.nextLine();
			} catch (Exception e) {
				System.out.println("❌ Ocorreu um erro inesperado: " + e.getMessage());
				read.nextLine();
			}

		}

	}

	public static void about() {
		System.out.println("\n*********************************************************");
		System.out.println("👋 Saindo do sistema... Até logo!\n");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Bruno Godoy - brunogodoy29@hotmail.com");
		System.out.println("https://github.com/Brunogodoy2911");
		System.out.println("*********************************************************");
	}

	public static void keyPress() {
		try {
			System.out.println("\n\nPressione Enter para Continuar...");

			int input;
			while ((input = System.in.read()) != '\n') {
				if (input == -1) {
					throw new IOException("Entrada encerrada inesperadamente");
				}
			}

		} catch (IOException e) {
			System.err.println("Erro de entrada/saída: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Ocorreu um erro ao processar a entrada: " + e.getMessage());
		}
	}

}
