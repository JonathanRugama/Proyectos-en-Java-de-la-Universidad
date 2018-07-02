import java.math.BigInteger;

import javax.swing.JOptionPane;
/**
 * En la tabla HashTableJugadores se van a guardar los datos que pertenecen a los jugadores, se puede decir que cada
 * selección de un país en especifico tiene su propia tablaHash,, para buscar un jugador en especifico perteneciente a esa
 * selección. 
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
	 * Se saca el módulo de la clave con el tamaño de la tabla, con el fin de que la posición no vaya a exceder el tamaño de la tabla. 
	 * A esto se le llama la aritmetica modular
	 * @param clave La clave es el número de cédula del jugador, en este caso es el DNI
	 * @return retorna el módulo de la clave, en este caso el módulo se saca con el tamaño de la tabla
	 */
	public BigInteger aritmeticaModular (String clave) {
	BigInteger operacion = new BigInteger(clave);
	BigInteger modulo=new BigInteger(String.valueOf(this.tamTabla));
	BigInteger modResult=null;

	 modResult = operacion.mod(modulo);

		
		return modResult;
	}
	
	/**
	 * Inserta en la tabla Hash los jugadores, una vez que se obtiene el módulo de la clave, se asigna una posición especifica para guardar
	 * el objeto. Si se llega a detectar una colisión se aplica la exploración lineal para asignar otra posición.
	 * @param jugador es de la clase Jugadores, y es básicamente el tipo de objeto quien va a componer la HashTable
	 * @return retorna la posición en la que ha sido guardado el objeto, con el fin de que se pueda visualizar en el JList
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
			JOptionPane.showMessageDialog(null, "Se ha detectado una colisión en la posición: " + aux + "\n Se ha resuelto asignando el dato en la posición: " +posicion ,"PRECAUCION", JOptionPane.WARNING_MESSAGE);
			
		}
	
		nuevo.siguiente= this.tabla[(int) posicion];
		this.tabla[(int) posicion] = nuevo;
		JOptionPane.showMessageDialog(null, "Se ha ingresado un jugador", "EXITO: Jugador ingresado",JOptionPane.INFORMATION_MESSAGE);
	
		return String.valueOf(posicion);
	}
	/**
	 * Este método sirve para solventar una colisión en caso de que se llegue a dar,  Y funciona verificando si la posición que recibe por parametro esta vacia
	 * , pues si esta vacia tendrá que aumentar el indice en 1, con el fin de ver si la otra posición (indice)  esta vacio.
	 * @param posicion esta es la posición en la que hay que verificar si no esta vacia
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
	 * Este método nos ayuda a solventar situaciones en donde existan colisiones, pues si existen dos nodos con la misma clave,
	 * lo que va a poder marcar la diferencia para una busqueda efectiva, es la posición, porque va a ir a buscar lo que hay contenido
	 * en esa posición especifica, por lo tanto, no se da lugar a repeticiones en la hora de mostrar.
	 * @param clave Recibe la clave para asegurar de que el dato en especifico  sea el que se busca.
	 * @param pos Recibe la posición, con la intención de marcar una diferencia cuando existen colisiones.
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
	 * A diferencia del método buscarXPosicion, este método es menos efectivo a la hora de buscar cuando existen colisiones, sin embargo
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
	 * Al igual que el método buscarXPosición , recibe como parametros clave y posición, con el fin de que no vaya a eliminarse un elemento en la tabla
	 * que sea repetido, Pues permite verificar la clave, pero además la posición.
	 * @param clave recibe la clave que se quiere eliminar
	 * @param pos recibe la posición que se quiere eliminar
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
