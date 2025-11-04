package segundaFase;

public class OrderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {
	
	public void add(T elem){
		Node<T> nuevo = new Node(elem);
		if (isEmpty()) {
			last = nuevo;
			nuevo.next = nuevo;
			nuevo.prev = nuevo;
			count++;
		}else {
			Node<T> act = last.next;
			boolean enc = false;
			do {
				if (((Comparable<T>)act.data).compareTo(elem)<0) {
					act = act.next;
				}else {
					enc = true;
				}
			
			}while (!enc && act!=last.next);
			if (!enc) { //se añade al final
				nuevo.prev = last;
				nuevo.next = last.next;
				last.next.prev = nuevo;
				last.next = nuevo;
				last = nuevo;
			}else { //se encuentra donde se añade
				act.prev.next = nuevo;
				nuevo.prev = act.prev;
				act.prev = nuevo;
				nuevo.next = act;
			}
			count++;
		}
	}
	
	public OrderedDoubleLinkedList<T> intersection(OrderedDoubleLinkedList<T> lista){
		OrderedDoubleLinkedList<T> lista3 = new OrderedDoubleLinkedList<T>();
		lista3.last = null;
		Node<T> act1 = this.last.next;
		Node<T> act2 = lista.last.next;
		if (act1!=null && act2!=null) {
			do {
				if (act1.data.equals(act2.data)) {
					lista3.add(act1.data);
					act1= act1.next;
					act2=act2.next;
				}else if (((Comparable<T>)act1.data).compareTo(act2.data)>0){
					act2 = act2.next;
				}else {
					act1 = act1.next;
				}
			}while (act1!=this.last.next && act2!=lista.last.next);
		}
		
		return lista3;
	}

}


}

