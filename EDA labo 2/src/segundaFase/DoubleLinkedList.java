package segundaFase;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements ListADT<T> {

	// Atributos
	protected Node<T> last;  // apuntador al �ltimo
	protected String descr;  // descripci�n
	protected int count;

	// Constructor
	public DoubleLinkedList() {
        last = null;
		descr = "";
		count = 0;
	}
	
	public void setDescr(String nom) {
	  descr = nom;
	}

	public String getDescr() {
	  return descr;
	}

	public T removeFirst() {
		// Elimina el primer elemento de la lista
        // Precondici�n: 
		Node<T> first = last.next;
		T aux = null;
		if (last!=null) {
			if (last==first) {
				aux = last.data;
				last=null;
			}else {
				aux = first.data;
				last.next=first.next;
				first.next.prev=last;
			}
			count--;
		}
		
		return aux;
	}
		
	public T removeLast() {
	// Elimina el �ltimo elemento de la lista
        // Precondici�n: 
		T aux = null;
		Node<T> first = last.next;
		if (last!=null) {
			if (last==first) {
				aux = last.data;
				last=null;
			}else {
				aux = last.data;
				last.prev.next=first;
				first.prev=last.prev;
				last=last.prev;
			}
			count--;
		}
		return aux;
	}


	public T remove(T elem) {
	//Elimina un elemento concreto de la lista
		// CALCULAR EL COSTE
		boolean enc = false;
		T dato = null;
		if (!isEmpty()) {
			Node<T> act = last.next;
		    do {
		        if (act.data.equals(elem)) {
		           enc = true;
				}else{
					act = act.next;
				}
			}while (act!=last.next && !enc);
			if (enc){
				if (act.next == act){
					dato = act.data;
					last = null;
				}else{
					dato = act.data;
					act.prev.next = act.next;
					act.next.prev = act.prev;
					if (last == act){
						last = last.prev;
					}
		        }
				count--;
			}
		}
		return dato; 
	}
	
	public void removeAll(T elem) {
	//Elimina todas las apariciones de un elemento de la lista
		// CALCULAR EL COSTE
		if (!isEmpty()) {
			Node<T> act = last.next;
			do {
				if (act.data.equals(elem)) {
					if (act == act.next) {
						last = null;
					}else {
						act.prev.next = act.next;
						act.next.prev = act.prev;
						if (act == last) {
							last = act.prev;
						}
					}
					count--;
				}else{
					act = act.next;
				}
			} while (act.prev!=last);
		}
	}

	public T first() {
	//Da acceso al primer elemento de la lista
		T first = null;
		if (!isEmpty()){
			first = last.next.data;
		}
		return first;
	}
	public T last() {
	//Da acceso al �ltimo elemento de la lista
		T ultimo = null;
		if (!isEmpty()) { 
			ultimo = last.data;
		}
		return ultimo;
	}

	public DoubleLinkedList<T> clone(){
		// Devuelve una copia de la lista (no duplica el puntero)
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		DoubleLinkedList<T> lista = new DoubleLinkedList<T>();
		lista.last = null;
		if (!isEmpty()) {
			Node<T> act = last.next;
			do {
				Node<T> nuevo = new Node<T>(act.data);
				if (lista.last == null) {
					lista.last = nuevo;
					nuevo.next = nuevo;
					nuevo.prev = nuevo;
				}else {
					nuevo.prev = lista.last;
					nuevo.next = lista.last.next;
					lista.last.next.prev = nuevo;
					lista.last.next = nuevo;
					lista.last = nuevo;
				}
				lista.count++;
				act = act.next;
			}while(act.prev!=last);
		}
		return lista;
	}

	public boolean contains(T elem) {
	//Determina si la lista contiene un elemento concreto
		boolean contiene = false;
		      if (!isEmpty() && find(elem)!=null) {
		    	  contiene=true;
		      }
		return contiene;     
	}

	public T find(T elem) {
	//Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no est�
		Node<T> act = null;
		T dato = null;
		boolean enc = false;
		if(!isEmpty()) {
			act = last.next;
			do {
				if(act.data.equals(elem)) {
					enc=true;
				}else{
					act = act.next;
				}
			}while(act.prev!=last && !enc);				
			if(enc) {
				dato = act.data; 
			}
		}
	}
	public boolean isEmpty(){ 
	//Determina si la lista est� vac�a
		boolean vacía = false;
		if (last==null) {
			vacía = true;
		}
		return vacía;
}
	
	public int size(){ 
	//Determina el n�mero de elementos de la lista
		return count;
}
	
	/** Return an iterator to the stack that iterates through the items . */ 
	public Iterator<T> iterator() {
		return new ListIterator(); 
	} 
	   // an iterator, doesn't implement remove() since it's optional 
	private class ListIterator implements Iterator<T> { 
		Node<T> act;
		int cont;
		public ListIterator() {
			cont = 0;
			if (isEmpty()) {
				act = null;
			}else {
				act = last.next;
			}
		}

		@Override
		public boolean hasNext() {
			boolean tiene = false;
			if (cont != count) {
				tiene = true;
			}
			return tiene;
		}

		@Override
		public T next() {
			T dato = act.data;
			act = act.next;
			cont++;
			return dato;
		}
	} // private class
		
    public void visualizarNodos() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		String result = new String();
		Iterator<T> it = iterator();
		while (it.hasNext()) {
			T elem = it.next();
			result = result + "[" + elem.toString() + "] \n";
		}	
		return "DoubleLinkedList " + result + "]";
	}

}







