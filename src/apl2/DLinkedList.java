// arquivo: src/apl2/DLinkedList.java

/*
Nome: Beatriz de Assis Siqueira                RA: 10741570
Nome: Lívia Calado de Carvalho Dias        RA: 10737709
Nome: Mateus Sarmento Machado                RA: 10741262
*/

package apl2;

// -- A classe DLinkedList (que pertence ao pacote apl2) deve implementar uma
// lista duplamente encadeada. Os nós dessa lista são do tipo [da classe] Node.
// -- A classe deve possuir dois nós especiais, head e tail, que são
// referências para o primeiro e último nó da lista, respectivamente.
// -- A classe deve possuir um contador de quantos nós existem na lista.
// -- A classe deve sobrescrever (override) o método public String toString()
// {...}, retornando uma string com o conteúdo da lista.
// -- A classe deve implementar as operações a seguir, respeitando o
// comportamento descrito em cada operação.

public class DLinkedList {
	Node head = new Node();
	Node tail = new Node();
	int count;

// OPERAÇÃO:		Método construtor
// COMPORTAMENTO:	Cria uma lista vazia.
	public DLinkedList() {
		this.head = null;
		this.tail = null;
		this.count = 0;
	}


// OPERAÇÃO:		insert(<dados da pessoa>)
// COMPORTAMENTO:	Aloca um Node que contém os <dados da pessoa> e insere o
//					novo nó no início da lista.
	public void insert(String id, String nome, float nota) {
		Node node = new Node(id, nome, nota, null, null);

		if(!isEmpty()){
			node.setNext(head);
			head.setPrevious(node);
			head = node;
		}else{
		head = node;
		tail = node;
		}
		count++;
	}


// OPERAÇÃO:		append(<dados da pessoa>)
// COMPORTAMENTO:	Aloca um Node que contém os <dados da pessoa> e insere o
//					novo nó no final da lista.
	public void append(String id, String nome, float nota) {
		Node node = new Node(id, nome, nota, null, null);

		if(isEmpty()){
			head = node;
			tail = node;
		}else{
			tail.setNext(node);
			node.setPrevious(tail);
			tail = node;
		}
		count++;
	}


// OPERAÇÃO: 		removeHead()
// COMPORTAMENTO:	Remove o nó do início da lista e retorna a referência do
//					nó removido.
//					Ou retorna null caso a lista esteja vazia.
	public Node removeHead(){
		if(isEmpty()) return null;

		Node aux;
		aux = head;

		if(count == 1){
			head = null;
			tail = null;
		}else{
			head = head.getNext();
			head.setPrevious(null);
		}

		count--;
		return aux;
	}


// OPERAÇÃO:		removeTail()
// COMPORTAMENTO:	Remove o nó do final da lista e retorna a referência do
//					nó removido.
//					Ou retorna null caso a lista esteja vazia.
	public Node removeTail() {
		if(isEmpty()) return null;

		Node aux;
		aux = tail;

		if(count == 1){
			head = null;
			tail = null;
		}else{
			tail = tail.getPrevious();
			tail.setNext(null);
		}

		count--;
		return aux;
	}


// OPERAÇÃO:		removeNode(<ID da pessoa>)
// COMPORTAMENTO:	Remove o nó que contém o <ID da pessoa> da lista e retorna
//					a referência do nó removido.
//					Ou retorna null caso não exista um nó com <ID da pessoa>.
	public Node removeNode(String id) {
		if(isEmpty()) return null;

		Node pAnda = head;

		while(!id.equals(pAnda.getID()) && pAnda != tail){
			pAnda = pAnda.getNext();
		}

		if(!id.equals(pAnda.getID())){
			return null;
		}

		Node aux;
		aux = pAnda;
		if(pAnda == head){
			return removeHead();
		}else if(pAnda == tail){
			return removeTail();
		}else{
			pAnda.getPrevious().setNext(pAnda.getNext());
			pAnda.getNext().setPrevious(pAnda.getPrevious());
			pAnda.setPrevious(null);
			pAnda.setNext(null);
			count--;
			return aux;
		}
	}


// OPERAÇÃO:		getHead()
// COMPORTAMENTO:	Retorna uma referência para o nó do início da lista.
//					Ou retorna null caso a lista esteja vazia.
	public Node getHead() {
		if(isEmpty()) return null;

		return head;
	}


// OPERAÇÃO:		getTail()
// COMPORTAMENTO:	Retorna uma referência para o nó do final da lista.
//					Ou retorna null caso a lista esteja vazia.
	public Node getTail() {
		if(isEmpty()) return null;

		return tail;
	}


// OPERAÇÃO:		getNode(<ID da pessoa>)
// COMPORTAMENTO:	Retorna uma referência para o nó que contém o <ID da pessoa>
//					da lista.
//					Ou retorna null caso não exista um nó com <ID da pessoa>.
	public Node getNode(String id) {
		if(isEmpty()) return null;

		Node pAnda = head;

		while(!(id.equals(pAnda.getID())) && pAnda != tail){
			pAnda = pAnda.getNext();
		}

		if(!(id.equals(pAnda.getID()))) return null;

		return pAnda;
	}


// OPERAÇÃO:		count()
// COMPORTAMENTO:	Retorna a quantidade de nós da lista.
	public int count() {
		return count;
	}


// OPERAÇÃO:		isEmpty()
// COMPORTAMENTO:	Retorna true se a lista estiver vazia ou false, caso contrário.
	public boolean isEmpty() {
		if(head == null) return true;

		return false;
	}


// OPERAÇÃO:		clear()
// COMPORTAMENTO:	Esvazia a lista, liberando a memória de todos os nós da lista.
	public void clear() {
		while(head != null){
			removeHead();
		}
	}


// OPERAÇÃO:		toString()
// COMPORTAMENTO:	Retorna uma string com o conteúdo da lista (caso queira, use o
//					exemplo do método toString() da classe LinkedListOriginal).
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		
	}

}