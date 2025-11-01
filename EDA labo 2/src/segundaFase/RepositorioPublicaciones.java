package segundaFase;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class RepositorioPublicaciones {
	
	private HashMap<String, UnorderedDoubleLinkedList<String>> citas; //ID Publicación # Publi citada
	private HashMap<String, Publicacion> publicaciones; //ID Publicación # Objeto Publicación
	private HashMap<String, OrderedDoubleLinkedList<String>> autores; //ID publicación # Autores que la han realizado 
	
	public RepositorioPublicaciones() {
		citas = new HashMap<>();
		publicaciones = new HashMap<>();
		autores = new HashMap<>();
	}
	
	public void readCitas(String nom) { //CAMBIO
		try {
			Scanner entrada = new Scanner(new FileReader(nom));
			String linea;
			while(entrada.hasNextLine()) {
				linea = entrada.nextLine();
				String[] datos = linea.split(" # ");
				if (!citas.containsKey(datos[0])) {
					citas.put(datos[0], new UnorderedDoubleLinkedList<String>());
				}
				citas.get(datos[0]).addToFront(datos[1]);
			}
			entrada.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readAutores(String nom) {
		try {
			Scanner entrada = new Scanner(new FileReader(nom));
			String linea;
			while(entrada.hasNextLine()) {
				linea = entrada.nextLine();
				String[] datos = linea.split(" # ");
				if (!autores.containsKey(datos[0])) {
					autores.put(datos[0], new OrderedDoubleLinkedList<String>());
				}
				if(datos.length == 2) {
					autores.get(datos[0]).add(datos[1]);
				}
			}
			entrada.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readPublicaciones(String nom) {
		try {
			Scanner entrada = new Scanner(new FileReader(nom));
			String linea;
			while(entrada.hasNextLine()) {
				linea = entrada.nextLine();
				String[] datos = linea.split(" # ");
				Publicacion publi = new Publicacion(datos[0], datos[1]);
				publicaciones.put(datos[0], publi);
			}
			entrada.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Publicacion buscarPubliPorId(String pId) {
		Publicacion publi = publicaciones.get(pId);
		return publi;
	}
	
	public void insertarPubli(String pId, String pTítulo) {
		Publicacion publi = new Publicacion(pId, pTítulo);
		publicaciones.put(pId, publi);
	}
	
	public void anadirCitaAPubli(String pId, String pCita) { //CAMBIO
		if (!citas.containsKey(pId)) {
			citas.put(pId, new UnorderedDoubleLinkedList<String>());
		}
		citas.get(pId).addToFront(pCita);
	}
	
	public void anadirAutorAPubli(String pIdPubli, String pIdAutor) {
		if (!autores.containsKey(pIdPubli)) {
			autores.put(pIdPubli, new OrderedDoubleLinkedList<String>());
		}
		autores.get(pIdPubli).add(pIdAutor);
	}
	
	public void eliminarPubli(String pIdPubli) {
		publicaciones.remove(pIdPubli);
	}
	
	public ArrayList<Publicacion> listaPublisCitadas(String pId) { //CAMBIO
			ArrayList<Publicacion> lPC = new ArrayList<>();
			Iterator<String> itr = citas.get(pId).iterator();
			while (itr.hasNext()) {
					String idCita = itr.next();
					Publicacion publi = publicaciones.get(idCita);
					lPC.add(publi);
			}
			return lPC;
	}
	
	public OrderedDoubleLinkedList<String> listaAutoresPubli(Publicacion p) { //CAMBIO
		OrderedDoubleLinkedList<String> lA = autores.get(p.getId());
		return lA;
	}
	
	public ArrayList<Publicacion> listaPublicacionesAutor(Autor a){ //CAMBIO
		ArrayList<Publicacion> lista = new ArrayList<>();
		for(String pIdPubli: autores.keySet()) {
			if (autores.get(pIdPubli)!=null) {
				OrderedDoubleLinkedList<String> lA = autores.get(pIdPubli);
				if(lA.contains(a.getId())){
					lista.add(publicaciones.get(pIdPubli));
				}
			}
		}
		return lista;
	}
	
	
	public ArrayList<Publicacion> ordenarAlfabeticamente(){
		ArrayList<Publicacion> lista = new ArrayList<>();
		for(Publicacion publi: publicaciones.values()) {
			if(lista.size()==0) {
				lista.add(publi);
			} else {
				int posInicial=0, posFinal=lista.size()-1, posMitad=0;
				boolean enc=false;
				while(posInicial<=posFinal && !enc) {
					posMitad = (posInicial+posFinal)/2;
					Publicacion p = lista.get(posMitad);
					if(p.getId().compareTo(publi.getId())<0) {
						posInicial = posMitad + 1;
					}else {
						if(posMitad==0 || lista.get(posMitad - 1).getId().compareTo(publi.getId())<0) {
							enc = true;
						}else {
							posFinal = posMitad - 1;
						}
					}
				}
				if(!enc) {
					lista.add(publi);
				}else {
					lista.add(posMitad,publi);
				}
			}
		}
		return lista;
	}
	
	public void loadCitas(String nom) { //CAMBIO
		try {
			PrintWriter salida = new PrintWriter(new File(nom));
			for (String pId: citas.keySet()) {
				Iterator<String> itr = citas.get(pId).iterator();
				while (itr.hasNext()) {
					String pCita = itr.next();
					salida.println(pId+" # "+pCita);
				}
			}
			salida.flush();
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadAutores(String nom) {
		try {
			PrintWriter salida = new PrintWriter(new File(nom));
			for (String pId: autores.keySet()) {
				Iterator<String> itr = autores.get(pId).iterator();
				while (itr.hasNext()) {
					String pAutor = itr.next();
					salida.println(pId+" # "+pAutor);
				}
			}
			salida.flush();
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadPublicaciones(String nom) {
		try {
			PrintWriter salida = new PrintWriter(new File(nom));
			for (String pId: publicaciones.keySet()) {
				salida.println(pId+" # "+publicaciones.get(pId).getTitulo());
			}
			salida.flush();
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public HashMap<String, Publicacion> getPublicaciones(){
		return publicaciones;
	}
	public HashMap<String, UnorderedDoubleLinkedList<String>> getCitas(){
		return citas;
	}
	
	public HashMap<String, OrderedDoubleLinkedList<String>> getAutores(){
		return autores;
	}
}