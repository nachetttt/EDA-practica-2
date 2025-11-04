package segundaFase;

public class PruebaOrderedDoubleLinkedList {	
		
		public static void main(String[] args)  {
			
			OrderedDoubleLinkedList<Integer> l = new OrderedDoubleLinkedList<Integer>();
			OrderedDoubleLinkedList<Integer> lo = new OrderedDoubleLinkedList<Integer>();
			OrderedDoubleLinkedList<Integer> lo1 = new OrderedDoubleLinkedList<Integer>();
			OrderedDoubleLinkedList<Integer> lo2 = new OrderedDoubleLinkedList<Integer>();
			
			lo.last=null;
			lo.add(1);
			lo.add(16);
			lo.add(4);
			lo.add(12);
			lo.add(8);
			lo.add(5);
			
			lo1.last=null;
			lo1.add(1);
			lo1.add(16);
			lo1.add(43);
			lo1.add(22);
			lo1.add(5);
			
			
			
			
			l.add(1);
			l.add(3);
			l.add(6);
			l.add(7);
			l.add(9);
			l.add(0);
			l.add(20);
			l.remove(new Integer(7));

			
			System.out.print(" Lista ...............");
			l.visualizarNodos();
			System.out.println(" Num elementos: " + l.size());
					
			
			System.out.println("Prueba Find ...............");
			System.out.println("20? " + l.find(20));
			System.out.println("9? " + l.find(9));
			System.out.println("9? " + l.find(9));
			System.out.println("0? " + l.find(0));
			System.out.println("7? " + l.find(7));
			System.out.println("--------------------------------------");

			
			
			OrderedDoubleLinkedList<Persona> l2 = new OrderedDoubleLinkedList<Persona>();
			l2.add(new Persona("jon", "1111"));
			l2.add(new Persona("ana", "7777"));
			l2.add(new Persona("amaia", "3333"));
			l2.add(new Persona("unai", "8888"));
			l2.add(new Persona("pedro", "2222"));
			l2.add(new Persona("olatz", "5555"));

			l2.remove(new Persona("", "8888"));

			
			System.out.print(" Lista ...............");
			l2.visualizarNodos();
			System.out.println(" Num elementos: " + l2.size());
					
			
			System.out.println("Prueba Find ...............");
			System.out.println("2222? " + l2.find(new Persona("", "2222")));
			System.out.println("5555? " + l2.find(new Persona("", "5555")));
			System.out.println("7777? " + l2.find(new Persona("", "7777")));	
			System.out.println("8888? " + l2.find(new Persona("", "8888")));	
			System.out.println("--------------------------------------");

			
			//Comprueba que el metodo intersection devuelve la intersección
			System.out.println("· Prueba intersection()");
			System.out.print(" Lista ...............");
			lo2.last=null;
			lo2 = lo.intersection(lo1);
			System.out.println("La lista debería devolver 1,16,5, y devuelve: ");
			System.out.println("1?:"+lo2.find(1));
			System.out.println("16?:"+lo2.find(16));
			System.out.println("5?:"+lo2.find(5));
			System.out.println("43?:"+lo2.find(43));
			
			
	}
	}

