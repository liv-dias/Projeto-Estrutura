//*************************** ATENÇÃO! ****************************
// O método main() deve ser alterado somente nos comentários TODO.
// Todas as outras instruções devem permanecer intactas e o código
// deve funcionar conforme descrito no enunciado da atividade.
//*************************** ATENÇÃO! ****************************
// arquivo: src/MainApl2.java

/*
Nome: Beatriz de Assis Siqueira                RA: 10741570
Nome: Lívia Calado de Carvalho Dias            RA: 10737709
Nome: Mateus Sarmento Machado                  RA: 10741262
*/

// TODO: Listar todas as referências consultadas para solucionar a atividade.
// Referências consultadas: 
// - Material de aula e slides sobre Estrutura de Dados e Listas Encadeadas
// - Documentação oficial do Java

import apl2.DLinkedList;
import apl2.LinkedListOriginal;
import apl2.Operation;
import apl2.Data;
import java.util.Scanner;

public class MainApl2 {
	
	public static void main(String[] args) {
		LinkedListOriginal list = new LinkedListOriginal();
		Scanner scanner = new Scanner(System.in);

		try {
			String content = Data.loadTextFileToString("dados.txt");
			String[] lines = content.split("\n");
			for (String line : lines) {
				line = line.trim();
				if (!line.isEmpty()) {
					String[] parts = line.split("#");
					int id = Integer.parseInt(parts[0]);
					String nome = parts[1];
					int inteiro = Integer.parseInt(parts[2]);
					int decimo = Integer.parseInt(parts[3]);
					list.append(id, nome, inteiro, decimo);
				}
			}
		} catch (Exception e) {
			System.err.println("Erro ao carregar dados.txt: " + e.getMessage());
		}

		// Preparando as listas que serão exibidas no menu
		DLinkedList fixedList = Operation.map(list);
		DLinkedList filteredGradedList = Operation.filterRemoveNonGraded(fixedList);
		DLinkedList filteredNonGradedList = Operation.filterRemoveGraded(fixedList);
		float average = Operation.reduce(filteredGradedList);
		DLinkedList aboveAverageList = Operation.filterRemoveBelowAverage(filteredGradedList, average);
		String contents = Operation.mapToString(fixedList);

		// Menu com as 8 opções
		int opcao = 0;
		do {
			System.out.println("\n========== Sistema Conversor de Notas ==========");
			System.out.println("1) Dados originais");
			System.out.println("2) Dados convertidos (Gera arquivo dados.csv)");
			System.out.println("3) Lista notas filtradas válidas");
			System.out.println("4) Lista notas filtradas inválidas");
			System.out.println("5) Média de notas válidas");
			System.out.println("6) Notas acima da média");
			System.out.println("7) Lista mapeada para uma única string");
			System.out.println("8) Finaliza sistema");
			System.out.print("Escolha uma opção: ");
			
			try {
				opcao = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				opcao = 0;
			}

			System.out.println();

			switch (opcao) {
				case 1:
					System.out.println(">>>>>>>>>> Dados originais (sistema legado) >>>>>>>>>>");
					System.out.println(list);
					System.out.println("<<<<<<<<<< Dados originais (sistema legado) <<<<<<<<<<\n");
					break;
				case 2:
					System.out.println(">>>>>>>>>> Dados convertidos para a nova representação dos dados >>>>>>>>>>");
					System.out.println(fixedList);
					System.out.println("<<<<<<<<<< Dados convertidos para a nova representação dos dados <<<<<<<<<<\n");
					try {
						Data.saveStringToTextFile("dados.csv", contents);
						System.out.println("-> Arquivo 'dados.csv' gerado com sucesso!");
					} catch (Exception e) {
						System.err.println("Erro ao salvar dados.csv: " + e.getMessage());
					}
					break;
				case 3:
					System.out.println(">>>>>>>>>> Lista filtrada (somente notas válidas) >>>>>>>>>>");
					System.out.println(filteredGradedList);
					System.out.println("<<<<<<<<<< Lista filtrada (somente notas válidas) <<<<<<<<<<\n");
					break;
				case 4:
					System.out.println(">>>>>>>>>> Lista filtrada (somente 'ausência de nota') >>>>>>>>>>");
					System.out.println(filteredNonGradedList);
					System.out.println("<<<<<<<<<< Lista filtrada (somente 'ausência de nota') <<<<<<<<<<\n");
					break;
				case 5:
					System.out.println(">>>>>>>>>> Média das notas válidas >>>>>>>>>>");
					System.out.println(average);
					System.out.println("<<<<<<<<<< Média das notas válidas <<<<<<<<<<\n");
					break;
				case 6:
					System.out.println(">>>>>>>>>> Lista com notas acima da média >>>>>>>>>>");
					System.out.println(aboveAverageList);
					System.out.println("<<<<<<<<<< Lista com notas acima da média <<<<<<<<<<\n");
					break;
				case 7:
					System.out.println(">>>>>>>>>> Lista mapeada para uma única string >>>>>>>>>>");
					System.out.println(contents);
					System.out.println("<<<<<<<<<< Lista mapeada para uma única string <<<<<<<<<<\n");
					break;
				case 8:
					System.out.println("Finalizando sistema...");
					break;
				default:
					System.out.println("Opção inválida. Tente novamente.");
			}
		} while (opcao != 8);

		scanner.close();


	}
}