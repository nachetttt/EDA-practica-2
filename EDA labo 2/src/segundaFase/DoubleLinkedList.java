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
		Node<T> aux = null;
		if (last!=null) {
			if (last.next==first) {
				last=null;
			}else {
				aux = first;
				last.next=first.next;
				first.next.prev=last;
			}
			count--;
		}
		
		return aux.data;
	}
		
	public T removeLast() {
	// Elimina el �ltimo elemento de la lista
        // Precondici�n: 
		Node<T> aux = null;
		Node<T> first = last.next;
		if (last!=null) {
			if (last.next==first) {
				last=null;
			}else {
				aux=last;
				last.prev.next=first;
				first=last.prev;
				last=last.prev;
			}
			count--;
		}
		return aux.data;
	}


	public T remove(T elem) {
	//Elimina un elemento concreto de la lista
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		if(find(elem)!=null) {
			//TODO hacer este método
			
		}
	}
	
	public void removeAll(T elem) {
	//Elimina todas las apariciones de un elemento de la lista
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		
		//TODO hacer este método
	}

	public T first() {
	//Da acceso al primer elemento de la lista
		Node<T> first = last.next;
			return first.data;
		}

	public T last() {
	//Da acceso al �ltimo elemento de la lista
		return last.data;
	}

	public DoubleLinkedList<T> clone(){
		// Devuelve una copia de la lista (no duplica el puntero)
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		
		//TODO hacer este método
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
		boolean enc = false;
		if(!isEmpty()) {
			act=last;
			do {
				if(act.data.equals(elem)) {
					enc=true;
				}
				
			}while(act!=last && !enc);				
		}
		if(enc) {
			return act.data; //TODO por qué me da error?
		}else {
			return null;
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

		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE

		   //TODO hacer este método

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
