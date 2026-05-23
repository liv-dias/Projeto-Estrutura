//*************************** ATENÇÃO! *****************************
// As assinaturas dos métodos desta classe não devem ser alteradas!
//*************************** ATENÇÃO! *****************************
// arquivo: src/apl2/Operation.java

/*
Nome: Beatriz de Assis Siqueira                RA: 10741570
Nome: Lívia Calado de Carvalho Dias            RA: 10737709
Nome: Mateus Sarmento Machado                  RA: 10741262
*/

package apl2;

public class Operation {

	public static DLinkedList map(final LinkedListOriginal original) {
		DLinkedList newList = new DLinkedList();
		NodeOriginal current = original.getHead();
		
		while (current != null) {
			// Formata o novo ID usando a constante ANO da classe Node e garante 3 dígitos
			String newId = Node.ANO + "-" + String.format("%03d", current.getId());
			String nome = current.getNome();
			float nota;
			
			// Conforme PDF: se a parte inteira OU decimal for -1, é ausência de nota (99.9)
			if (current.getInteiro() == -1 || current.getDecimo() == -1) {
				nota = 99.9f;
			} else {
				// Junta o inteiro e o décimo para formar o float
				nota = current.getInteiro() + (current.getDecimo() / 10.0f);
			}
			
			newList.append(newId, nome, nota);
			current = current.getNext();
		}
		
		return newList;
	}

	public static DLinkedList filterRemoveNonGraded(final DLinkedList data) {
		DLinkedList newList = new DLinkedList();
		Node current = data.getHead();
		
		while (current != null) {
			if (current.getNota() != 99.9f) {
				newList.append(current.getID(), current.getNome(), current.getNota());
			}
			current = current.getNext();
		}
		
		return newList;
	}

	public static DLinkedList filterRemoveGraded(final DLinkedList data) {
		DLinkedList newList = new DLinkedList();
		Node current = data.getHead();
		
		while (current != null) {
			if (current.getNota() == 99.9f) {
				newList.append(current.getID(), current.getNome(), current.getNota());
			}
			current = current.getNext();
		}
		
		return newList;
	}

	public static DLinkedList filterRemoveBelowAverage(final DLinkedList data, float average) {
		DLinkedList newList = new DLinkedList();
		Node current = data.getHead();
		
		while (current != null) {
			if (current.getNota() > average && current.getNota() != 99.9f) {
				newList.append(current.getID(), current.getNome(), current.getNota());
			}
			current = current.getNext();
		}
		
		return newList;
	}
	
	public static float reduce(final DLinkedList data) {
		float sum = 0.0f;
		int count = 0;
		Node current = data.getHead();
		
		while (current != null) {
			if (current.getNota() != 99.9f) {
				sum += current.getNota();
				count++;
			}
			current = current.getNext();
		}
		
		// Retorna a média, com prevenção contra divisão por zero
		return (count > 0) ? (sum / count) : 0.0f;
	}

	public static String mapToString(final DLinkedList data) {
		StringBuilder sb = new StringBuilder();
		Node current = data.getHead();
		
		while (current != null) {
			sb.append(current.getID())
			  .append(";")
			  .append(current.getNome())
			  .append(";")
			  .append(current.getNota());
			
			if (current.getNext() != null) {
				sb.append("\n"); // Pessoas separadas por quebra de linha
			}
			current = current.getNext();
		}
		
		return sb.toString();
	}

}