package segundaFase;

import java.util.Iterator;


public class PruebaDoubleLinkedList {
	
	public static void visualizarNodos(UnorderedDoubleLinkedList<Integer> l) {
		Iterator<Integer> it = l.iterator();
		System.out.println();
		while (it.hasNext()) {
			Integer num = it.next();
			System.out.println(num);
		}
	}
	
	
	public static void main(String[] args)  {
		
		UnorderedDoubleLinkedList<Integer> l = new UnorderedDoubleLinkedList<Integer>();
		UnorderedDoubleLinkedList<Integer> lc = new UnorderedDoubleLinkedList<Integer>();
		UnorderedDoubleLinkedList<Integer> lvacia = new UnorderedDoubleLinkedList<Integer>();
		UnorderedDoubleLinkedList<Integer> lfirst = new UnorderedDoubleLinkedList<Integer>();
		DoubleLinkedList<Integer> l2 = new DoubleLinkedList<Integer>();
		UnorderedDoubleLinkedList<Integer> l1 = new UnorderedDoubleLinkedList<Integer>();
		



		l.addToRear(1);
		l.addToRear(3);
		l.addToRear(6);
		l.addToRear(8);
		l.addToFront(5);
		l.addToRear(7);
		l.addAfter(9, 3);
		
	
		
		l1.addToRear(1);
		l1.addToRear(1);
		l1.addToRear(1);
		l1.addToRear(1);
		l1.addToRear(1);
		l1.addToRear(1);
		
		lfirst.addToFront(4);
		lfirst.addToRear(3);
		
		lc.addToFront(3);
		lc.addToRear(4);
		lc.addToRear(6);

		l.remove(new Integer(7));

		//Comprobar que los métodos find, addtoRear y size funcionan
		System.out.println("· Prueba find(elem), addToRear(elem), size()");

		System.out.print(" Lista ...............");
		visualizarNodos(l);
		System.out.println(" Num elementos: " + l.size());		
		System.out.println("Prueba Find ...............");
		System.out.println("9? " + l.find(9));
		System.out.println("0? " + l.find(0));
		System.out.println("7? " + l.find(7));
		System.out.println("--------------------------------------");

		
		//Comprobar que elimina el primer elemento de la lista.
		System.out.println("· Prueba removeFirst()");
		l.removeFirst();
		
		System.out.print(" Lista ...............");
		visualizarNodos(l);
		System.out.println(" Num elementos: " + l.size());
				
		System.out.println("");

		System.out.println("Prueba Find ...............");
		System.out.println("9? " + l.find(9));
		System.out.println("0? " + l.find(0));
		System.out.println("8? " + l.find(8));
		System.out.println("--------------------------------------");
		
		//Comprobar que elimina el primer elemento de la lista vacía.
		System.out.println("· Prueba removeFirst() con lista vacía");
		lvacia.last = null;
		System.out.println("Al eliminar el primer elemento de la lista vacía devuelve: "+lvacia.removeFirst());	
		System.out.println("--------------------------------------");

		
		//Comprobar que elimina el último elemento de la lista.
		System.out.println("· Prueba removeLast()");
		l.removeLast();
		
		System.out.print(" Lista ...............");
		visualizarNodos(l);
		System.out.println(" Num elementos: " + l.size());
				
		System.out.println("Prueba Find ...............");
		System.out.println("9? " + l.find(9));
		System.out.println("0? " + l.find(0));
		System.out.println("20? " + l.find(20));
		System.out.println("--------------------------------------");

		//Comprobar que elimina el ultimo elemento de la lista vacía.
		System.out.println("· Prueba removeLast() con lista vacía");
		lvacia.last = null;
		System.out.println("Al eliminar el primer elemento de la lista vacía devuelve: "+lvacia.removeLast());	
		System.out.println("--------------------------------------");
		
		//Comprobar que elimina el elemento elem de la lista.
		System.out.println("· Prueba remove(elem)");
		System.out.println("");
		l.remove(1); //Eliminar el primero
		l.remove(0); //Eliminar el último
				
		System.out.print(" Lista ...............");
		visualizarNodos(l);
		System.out.println(" Num elementos: " + l.size());
		
		System.out.println("Prueba Find ...............");
		System.out.println("9? " + l.find(9));
		System.out.println("0? " + l.find(0));
		System.out.println("20? " + l.find(20));
		System.out.println("");
		System.out.println("Si eliminamos un elemento que no está, la lista queda:");
		l.remove(50);
		visualizarNodos(l);
		System.out.println("--------------------------------------");
		
		//Comprobar que elimina todas las apariciones del elemento pasado por parametro de la lista.
		System.out.println("· Prueba removeAll(): Elemento que SI está y la lista tiene todos los elem iguales");
		System.out.println("");
		l1.removeAll(1);
						
		System.out.print(" Lista ...............");
		visualizarNodos(l1);
		System.out.println(" Num elementos: " + l1.size());
				
		System.out.println("Prueba Find ...............");
		System.out.println("9? " + l1.find(9));
		System.out.println("0? " + l1.find(0));
		System.out.println("1? " + l1.find(1));
		System.out.println("--------------------------------------");
		
		//Comprobar que elimina todas las apariciones del elemento pasado por parametro de la lista.
		System.out.println("· Prueba removeAll(): Elemento que SI está");
		System.out.println("");
		l.removeAll(5);
								
		System.out.print(" Lista ...............");
		visualizarNodos(l);
		System.out.println(" Num elementos: " + l.size());
						
		System.out.println("Prueba Find ...............");
		System.out.println("9? " + l.find(9));
		System.out.println("0? " + l.find(0));
		System.out.println("1? " + l.find(1));
		System.out.println("--------------------------------------");
		
		//Comprobar que no elimina  las apariciones del elemento pasado por parametro de la lista, porque no está.
		System.out.println("· Prueba removeAll(): Elemento que NO está");
		System.out.println("");
		l1.removeAll(50);
						
		System.out.print(" Lista ...............");
		visualizarNodos(l);
		System.out.println(" Num elementos: " + l1.size());
				
		System.out.println("Prueba Find ...............");
		System.out.println("9? " + l.find(9));
		System.out.println("0? " + l.find(0));
		System.out.println("1? " + l.find(1));
		System.out.println("--------------------------------------");
		
		//Comprobar que devuelve el data del primer nodo de la lista.
		System.out.println("· Prueba first()");
		System.out.println("");
		System.out.println("El valor del primer nodo debería ser 4, y es:"+lfirst.first());
		System.out.println("Tras eliminar los nodos y tener una lista vacía,");
		lfirst.remove(3);
		lfirst.remove(4);
		System.out.println("el valor debería ser null y es: "+lfirst.first());
		System.out.println("--------------------------------------");

	
		
		//Comprobar que devuelve el data del ultimo nodo de la lista.
		System.out.println("· Prueba last()");
		System.out.println("");
		lfirst.addToFront(4);
		lfirst.addToRear(3);
		System.out.println("El valor del último nodo debería ser 3, y es:"+lfirst.last
				());
		System.out.println("Tras eliminar los nodos y tener una lista vacía,");
		lfirst.remove(3);
		lfirst.remove(4);
		System.out.println("el valor debería ser null y es: "+lfirst.last());
		System.out.println("--------------------------------------");

						
		System.out.print(" Lista ...............");
		visualizarNodos(l);
		System.out.println(" Num elementos: " + l.size());
				
		System.out.println("Prueba Find ...............");
		System.out.println("9? " + l.find(9));
		System.out.println("0? " + l.find(0));
		System.out.println("20? " + l.find(20));
		System.out.println("--------------------------------------");
		
		//Comprobar que elimina todas las apariciones del elemento pasado por parametro de la lista.
		System.out.println("· Prueba clone()");
		System.out.println("");
		l2 = l.clone();
								//???
		System.out.print(" Lista ...............");
		System.out.println(" Num elementos: " + l2.size());
						
		System.out.println("Prueba Find ...............");
		System.out.println("9? " + l2.find(9));
		System.out.println("0? " + l2.find(0));
		System.out.println("1? " + l2.find(1));
		System.out.println("--------------------------------------");
		
		//Comprobar que la lista contiene un elemento.
		System.out.println("· Prueba contains()");
		System.out.println("");
		System.out.println("El método debería devolver true, y devuelve:"+lc.contains(6));			
		System.out.println("--------------------------------------");
		
		
		//Comprobar que la lista está vacía.
		System.out.println("· Prueba isEmpty()");
		System.out.println("");
		System.out.println("El método debería devolver true, y devuelve:"+lvacia.isEmpty());
		System.out.println("--------------------------------------");

		

			
}
}
