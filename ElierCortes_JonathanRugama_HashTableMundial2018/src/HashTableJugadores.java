import java.math.BigInteger;

import javax.swing.JOptionPane;
/**
 * En la tabla HashTableJugadores se van a guardar los datos que pertenecen a los jugadores, se puede decir que cada
 * selecci�n de un pa�s en especifico tiene su propia tablaHash,, para buscar un jugador en especifico perteneciente a esa
 * selecci�n. 
 * @author Jonathan Rugama y Elier Cortes
 *
 */
public class HashTableJugadores {

	private int tamTabla;
	private NodoJugadores [] tabla;
	
	public HashTableJugadores(int tamTabla){
		this.tamTabla = tamTabla;
		this.tabla = new NodoJugadores [tamTabla];
		for (int i = 0; i<tamTabla; i++){
			this.tabla[i]= null;
		}
			
	}
	
	/**
	 * Se saca el m�dulo de la clave con el tama�o de la tabla, con el fin de que la posici�n no vaya a exceder el tama�o de la tabla. 
	 * A esto se le llama la aritmetica modular
	 * @param clave La clave es el n�mero de c�dula del jugador, en este caso es el DNI
	 * @return retorna el m�dulo de la clave, en este caso el m�dulo se saca con el tama�o de la tabla
	 */
	public BigInteger aritmeticaModular (String clave) {
	BigInteger operacion = new BigInteger(clave);
	BigInteger modulo=new BigInteger(String.valueOf(this.tamTabla));
	BigInteger modResult=null;

	 modResult = operacion.mod(modulo);

		
		return modResult;
	}
	
	/**
	 * Inserta en la tabla Hash los jugadores, una vez que se obtiene el m�dulo de la clave, se asigna una posici�n especifica para guardar
	 * el objeto. Si se llega a detectar una colisi�n se aplica la exploraci�n lineal para asignar otra posici�n.
	 * @param jugador es de la clase Jugadores, y es b�sicamente el tipo de objeto quien va a componer la HashTable
	 * @return retorna la posici�n en la que ha sido guardado el objeto, con el fin de que se pueda visualizar en el JList
	 */
	public String insertar (Jugadores jugador) {
		long posicion;
		NodoJugadores nuevo;

		nuevo = new NodoJugadores(jugador);
		posicion =(aritmeticaModular(jugador.getClave()).longValue()); 
		System.out.println(posicion);
		if (this.tabla[(int) posicion]!=null){
			int aux= (int) posicion;
			
			posicion= exploracionLineal(posicion);
			JOptionPane.showMessageDialog(null, "Se ha detectado una colisi�n en la posici�n: " + aux + "\n Se ha resuelto asignando el dato en la posici�n: " +posicion ,"PRECAUCION", JOptionPane.WARNING_MESSAGE);
			
		}
	
		nuevo.siguiente= this.tabla[(int) posicion];
		this.tabla[(int) posicion] = nuevo;
		JOptionPane.showMessageDialog(null, "Se ha ingresado un jugador", "EXITO: Jugador ingresado",JOptionPane.INFORMATION_MESSAGE);
	
		return String.valueOf(posicion);
	}
	/**
	 * Este m�todo sirve para solventar una colisi�n en caso de que se llegue a dar,  Y funciona verificando si la posici�n que recibe por parametro esta vacia
	 * , pues si esta vacia tendr� que aumentar el indice en 1, con el fin de ver si la otra posici�n (indice)  esta vacio.
	 * @param posicion esta es la posici�n en la que hay que verificar si no esta vacia
	 * @return retorna el indice nuevo.
	 */
	public long exploracionLineal (long posicion){
		long indice = posicion;
		while (this.tabla[(int) indice]!= null){
			indice++;
			if (indice>=this.tamTabla)
				indice = indice%this.tamTabla;
		}
		return indice;
	}
	
	/**
	 * Este m�todo nos ayuda a solventar situaciones en donde existan colisiones, pues si existen dos nodos con la misma clave,
	 * lo que va a poder marcar la diferencia para una busqueda efectiva, es la posici�n, porque va a ir a buscar lo que hay contenido
	 * en esa posici�n especifica, por lo tanto, no se da lugar a repeticiones en la hora de mostrar.
	 * @param clave Recibe la clave para asegurar de que el dato en especifico  sea el que se busca.
	 * @param pos Recibe la posici�n, con la intenci�n de marcar una diferencia cuando existen colisiones.
	 * @return retorna el nodo buscado.
	 */
	public NodoJugadores buscarXPosicion (String clave, int pos){
		NodoJugadores aux = null;
		int posicion =  pos;
		if (this.tabla[posicion]!= null) {
			aux=this.tabla[posicion];
			
		while (  (aux.siguiente!= null)  && aux.jugador.getClave() != (clave)) {
			aux = aux.siguiente;
			
			if( aux.jugador.getClave()!= (clave)){
				aux= null;
			}
		}
		
		}
		return aux;
	}
	
	/**
	 * A diferencia del m�todo buscarXPosicion, este m�todo es menos efectivo a la hora de buscar cuando existen colisiones, sin embargo
	 * funciona perfectamente cuando no existen.
	 * @param clave recibe por parametro solo clave
	 * @return DE igual forma, retorna el Nodo Buscado.
	 */
	public NodoJugadores buscar (String clave){
		NodoJugadores aux = null;
		int posicion =  aritmeticaModular(clave).intValue();
		if (this.tabla[posicion]!= null) {
			aux=this.tabla[posicion];
			
		while (  (aux.siguiente!= null)  && aux.jugador.getClave() != (clave)) {
			aux = aux.siguiente;
			
			if( aux.jugador.getClave()!= (clave)){
				aux= null;
			}
		}
		
		}
		return aux;
	}
	
	/**
	 * Al igual que el m�todo buscarXPosici�n , recibe como parametros clave y posici�n, con el fin de que no vaya a eliminarse un elemento en la tabla
	 * que sea repetido, Pues permite verificar la clave, pero adem�s la posici�n.
	 * @param clave recibe la clave que se quiere eliminar
	 * @param pos recibe la posici�n que se quiere eliminar
	 */
	public void eliminar (String clave, int pos){
		
		int posicion =  pos;
		if (this.tabla[posicion] != null){
			
			NodoJugadores anterior = null;
			NodoJugadores actual = tabla[posicion];
			
			while ( (actual.siguiente!= null) && actual.jugador.getClave() != clave){
				
				anterior = actual;
				actual= actual.siguiente;
			}
			
			if ( !actual.jugador.getClave().equals(clave) ){
				JOptionPane.showMessageDialog(null, "No se encuentra el elemento en la tabla jugadores", "ELEMENTO NO ENCONTRADO", JOptionPane.ERROR_MESSAGE);
			} else if (anterior == null ){
				this.tabla[posicion] = actual.siguiente;
			}else {
				anterior.siguiente= actual.siguiente;
				actual = null;
			}
		}
	}
	
}
