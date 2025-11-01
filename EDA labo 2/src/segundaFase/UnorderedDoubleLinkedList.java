package segundaFase;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem) {
		Node<T> nuevo = new Node<T>(elem);
		if (isEmpty()) {
			last = nuevo;
			nuevo.next = nuevo;
			nuevo.prev = nuevo;
		}else {
			last.next.prev = nuevo;
			nuevo.next = last.next;
			last.next = nuevo;
			nuevo.prev = last;
		}
		count++;

	}

	public void addToRear(T elem) {
		addToFront(elem);
		last = last.next;

	}
	
	public void addAfter(T elem, T target) {
		Node<T> act = last.next;
		boolean enc = false;
		do {
			if (act.data.equals(target)) {
				enc = true;
			}else {
				act = act.next;
			}
		}while (!enc && act!=last);
		
		Node<T> nuevo = new Node<T>(elem);
		nuevo.next = act.next;
		nuevo.prev = act;
		act.next.prev = nuevo;
		act.next = nuevo;
		if (act == last) {
			last = last.next;
		}
		
		

	}

}
