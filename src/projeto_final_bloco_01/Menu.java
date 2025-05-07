package projeto_final_bloco_01;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);

		int option = 0, id, typeBook;
		String name;
		float price;

		while (true) {
			System.out.println("\n************************************************");
			System.out.println("            📚 MENU E-COMMERCE DOM BOSCO      ");
			System.out.println("************************************************");
			System.out.println(" 1️⃣  - Criar Livro");
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
			case 1:
					System.out.println("📘 Criar Livro\n\n");
	
					System.out.println("Digite o TÍTULO do Livro:");
					read.skip("\\R");
					name = read.nextLine();
	
					System.out.println("Digite o TIPO do Livro (1 - TEOLOGIA | 2 - BIOGRAFIA ):");
					typeBook = read.nextInt();
	
					System.out.println("Digite o PREÇO do Livro:");
					price = read.nextFloat();
	
					switch (typeBook) {
					case 1 -> {
						System.out.println("Digite o TEMA de Teologia: ");
						read.skip("\\R");
					}
					case 2 -> {
						System.out.println("Digite o NOME do SANTO biografado: ");
						read.skip("\\R");
	
					}
				}

				keyPress();
				break;
			case 2:
				System.out.println("Listar todas os LIVROS\n\n");
				keyPress();
				break;
			case 3:
				System.out.println("Consultar dados do LIVRO - por número\n\n");

				System.out.println("Digite o ID do LIVRO: ");
				id = read.nextInt();

				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados do LIVRO\n\n");

				System.out.println("Digite o ID do LIVRO: ");
				id = read.nextInt();

				keyPress();
				break;
			case 5:
				System.out.println("Apagar o LIVRO\n\n");

				System.out.println("Digite o ID do LIVRO: ");
				id = read.nextInt();

				keyPress();
				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				keyPress();
				break;
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
