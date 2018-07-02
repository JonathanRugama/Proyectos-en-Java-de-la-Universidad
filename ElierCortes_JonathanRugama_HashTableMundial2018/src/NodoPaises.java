
/**
 * Almacena en cada Nodo un país en especifico
 * @author Jonathan Rugama y Elier Cortes
 *
 */
public class NodoPaises {
public Paises pais;
public NodoPaises siguiente;


/**
 * El constructor recibe datos de tipo "Países", para que puedan ser guardadas en el método Insertar de la clase HashTable respectiva. En este caso la 
 * HashTable de países.
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
