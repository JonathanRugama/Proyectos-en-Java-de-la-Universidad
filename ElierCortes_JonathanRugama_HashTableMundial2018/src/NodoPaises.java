
/**
 * Almacena en cada Nodo un pa�s en especifico
 * @author Jonathan Rugama y Elier Cortes
 *
 */
public class NodoPaises {
public Paises pais;
public NodoPaises siguiente;


/**
 * El constructor recibe datos de tipo "Pa�ses", para que puedan ser guardadas en el m�todo Insertar de la clase HashTable respectiva. En este caso la 
 * HashTable de pa�ses.
 * 
 * @param pais recibe como parametro el pais que quiere ser guardado
 */
public NodoPaises (Paises pais) {
	this.pais = pais;
	this.siguiente = null;
}


public Paises  getPais() {
	return pais;
}


public void setPais(Paises pais) {
	this.pais = pais;
}


public NodoPaises getSiguiente() {
	return siguiente;
}


public void setSiguiente(NodoPaises siguiente) {
	this.siguiente = siguiente;
}


}
