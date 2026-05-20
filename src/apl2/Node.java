// arquivo: src/apl2/Node.java

/*
Nome: Beatriz de Assis Siqueira                RA: 10741570
Nome: Lívia Calado de Carvalho Dias        RA: 10737709
Nome: Mateus Sarmento Machado                RA: 10741262
*/

package apl2;

// -- A classe Node (que pertence ao pacote apl2) deve conter os atributos que
// representam a nova versão dos dados de uma pessoa, conforme descrito no
// enunciado da atividade Apl2.
// -- A classe deve conter os construtores apropriados, assim como os métodos
// getters e setters.
// -- A classe também representa um nó que é usado na implementação da lista
// duplamente encadeada (classe DLinkedList).
// -- A classe deve sobrescrever (override) o método public String toString()
// {...}, retornando uma string com os valores dos atributos da classe.

public class Node {
	public static final String ANO = "23.S1";
	private String id;
	private String nome;
	private float nota;
	private Node next;
	private Node previous;

	public Node() {
		this.id = "";
		this.nome = "";
		this.nota = 0.0f;
		this.next = null;
		this.previous = null;
	}

	public Node(String id, String nome, float nota, Node next, Node previous){
		this.id = id;
		this.nome = nome;
		this.nota = nota;
		this.next = next;
		this.previous = previous;
	}

	//Getter e Setter do ID
	public String getID(){
		return id;
	}

	public void setID(String id){
		this.id = id;
	}

	//Getter e Setter do Nome
	public String getNome(){
		return nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}
	
	//Getter e Setter da Nota
	public float getNota(){
		return nota;
	}

	public void setNota(float nota){
		this.nota = nota;
	}

	//Getter e Setter do Next
	public Node getNext(){
		return next;
	}

	public void setNext(Node next){
		this.next = next;
	}

	//Getter e Setter do Previous
	public Node getPrevious(){
		return previous;
	}

	public void setPrevious(Node previous){
		this.previous = previous;
	}

	@Override
	public String toString() {
		String prevID = (previous != null) ? previous.getID() : "null";
		String nextID = (next != null) ? next.getID() : "null";

		return prevID + " <- (" + id + "; " + nome + "; " + nota + ") -> " + nextID;
	}
}