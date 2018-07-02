
/**
 * Esta clase Nodo, es la encargada de almacenar lso jugadores en la tablaHashJugadores, es necesaria 
 * para su correcto funcionamiento.
 * @author Jonathan Rugama y Elier Cortes
 *
 */

public class NodoJugadores {

	public Jugadores jugador;
	public NodoJugadores siguiente;
	
	/**
	 * Almacena en el nodo y construye con el objeto de tipo Jugadores.
	 * @param jugador recibe como un jugador de tipo Jugadores, este objeto almacena los datos de jugador ingresados por el usuario.
	 */
	public NodoJugadores(Jugadores jugador) {
		this.jugador = jugador;
		this.siguiente = null;
	}
	public Jugadores getJugador() {
		return jugador;
	}
	public void setJugador(Jugadores jugador) {
		this.jugador = jugador;
	}
	public NodoJugadores getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(NodoJugadores siguiente) {
		this.siguiente = siguiente;
	}
	
	
	
}
