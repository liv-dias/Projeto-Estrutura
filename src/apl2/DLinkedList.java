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
	//Atributos da classe DLinkedList
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
		//Cria o nó a ser inserido
		Node node = new Node(id, nome, nota, null, null); 

		//Verifica se a lista está vazia, caso contrário, insere o nó no início da lista
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
		//Cria o nó a ser inserido
		Node node = new Node(id, nome, nota, null, null);

		//Verifica se a lista está vazia, caso contrário, insere o nó no final da lista
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
		//Se tiver vazia, retirna nulo
		if(isEmpty()) return null;

		//Cria um nó auxiliar para retornar o nó removido
		Node aux;
		aux = head;

		//Verifica se só tem um nó na lista, se sim a lista fica vazia
		//Caso contrário, o head agora é o nó seguinte
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
		//Verifica se a lista está vazia, se sim retorna nulo
		if(isEmpty()) return null;

		//Cria um nó auxiliar para retornar o nó removido
		Node aux;
		aux = tail;

		//Verifica se só tem um nó na lista, se sim a lista fica vazia
		//Caso contrário, o tail agora é o nó anterior
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
		//Verifica se a lista está vazia, se sim retorna nulo
		if(isEmpty()) return null;

		//Cria um nó para percorrer a lista
		Node pAnda = head;

		//Percorre a lista até o nó ser encontrado ou chegar no fim da lista
		while(!id.equals(pAnda.getID()) && pAnda != tail){
			pAnda = pAnda.getNext();
		}

		//Se chegou no fim da lista e não encontrou o nó, retorna nulo
		if(!id.equals(pAnda.getID())){
			return null;
		}

		//Verifica se o nó está no começo, fim ou meio
		if(pAnda == head){
			return removeHead(); //Chama o método já feito de remover o head
		}else if(pAnda == tail){
			return removeTail(); //Chama o método já feito de remover o tail
		}else{ //Ajusta os ponteiros dos nós anterior e próximo
			pAnda.getPrevious().setNext(pAnda.getNext());
			pAnda.getNext().setPrevious(pAnda.getPrevious());
			pAnda.setPrevious(null);
			pAnda.setNext(null);
			count--;
			return pAnda;
		}
	}


// OPERAÇÃO:		getHead()
// COMPORTAMENTO:	Retorna uma referência para o nó do início da lista.
//					Ou retorna null caso a lista esteja vazia.
	public Node getHead() {
		//Verifica se a lista está vazia, se sim retorna nulo
		if(isEmpty()) return null;

		//Retorna head
		return head;
	}


// OPERAÇÃO:		getTail()
// COMPORTAMENTO:	Retorna uma referência para o nó do final da lista.
//					Ou retorna null caso a lista esteja vazia.
	public Node getTail() {
		//Verifica se a lista está vazia, se sim retorna nulo
		if(isEmpty()) return null;

		//Retorna tail
		return tail;
	}


// OPERAÇÃO:		getNode(<ID da pessoa>)
// COMPORTAMENTO:	Retorna uma referência para o nó que contém o <ID da pessoa>
//					da lista.
//					Ou retorna null caso não exista um nó com <ID da pessoa>.
	public Node getNode(String id) {
		//Verifica se a lista está vazia, se sim retorna nulo
		if(isEmpty()) return null;

		//Cria um nó que vai percorrer a lista
		Node pAnda = head;

		//Percorre a lista até o nó ser encontrado ou chegar no fim da lista
		while(!(id.equals(pAnda.getID())) && pAnda != tail){
			pAnda = pAnda.getNext();
		}

		//Se chegou no fim da lista e não encontrou o nó, retorna nulo
		if(!(id.equals(pAnda.getID()))) return null;

		//Caso contrário, retorna o nó encontrado
		return pAnda;
	}


// OPERAÇÃO:		count()
// COMPORTAMENTO:	Retorna a quantidade de nós da lista.
	public int count() {
		//Retorna o contador de nós da lista
		return count;
	}


// OPERAÇÃO:		isEmpty()
// COMPORTAMENTO:	Retorna true se a lista estiver vazia ou false, caso contrário.
	public boolean isEmpty() {
		//Verifica se o head é nulo, se sim a lista está vazia
		if(head == null) return true;

		return false;
	}


// OPERAÇÃO:		clear()
// COMPORTAMENTO:	Esvazia a lista, liberando a memória de todos os nós da lista.
	public void clear() {
		//Enquanto o head não for null, remove o head da lista
		while(head != null){
			removeHead();
		}
	}


// OPERAÇÃO:		toString()
// COMPORTAMENTO:	Retorna uma string com o conteúdo da lista (caso queira, use o
//					exemplo do método toString() da classe LinkedListOriginal).
	@Override
	public String toString() {
		// Cria um acumulador de texto para construir a string de saída
		StringBuilder sb = new StringBuilder();

		// Adiciona o tamanho da lista no início
		sb.append("(");
		sb.append(count());
		sb.append(")\n");

		// Se a lista estiver vazia, retorna apenas o contador
		if(isEmpty()){
			return sb.toString(); //Retorna só o count sem o null
		}

		// Percorre todos os nós da lista, a partir do head
		Node node = head;
		while(node != null){
			// Calcula o ID do nó anterior, se existir
			String prev = (node.getPrevious() != null) ? node.getPrevious().getID() : null;
			
			// Calcula o ID do próximo nó, se existir
			String nxt = (node.getNext() != null) ? node.getNext().getID() : null;

			// Constrói a linha de saída para este nó
			sb.append(prev)
			.append("<-(")
			.append(node.getID())
			.append(";")
			.append(node.getNome())
			.append(";")
			.append(node.getNota())
			.append(") ->")
			.append(nxt)
			.append("\n");

			// Avança para o próximo nó
			node = node.getNext();
		}
		
		// Retorna a string completa
		return sb.toString();
	}
}