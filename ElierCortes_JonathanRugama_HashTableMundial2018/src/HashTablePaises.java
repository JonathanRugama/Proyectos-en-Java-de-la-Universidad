import java.math.BigInteger;

import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;

public class HashTablePaises {

private int tamTabla;
	private NodoPaises [] tabla;
	
	public HashTablePaises(int tamTabla){
		this.tamTabla = tamTabla;
		this.tabla = new NodoPaises [tamTabla];
		for (int i = 0; i<tamTabla; i++){
			this.tabla[i]= null;
		}
			
	}
	
	/**
	 * Se saca el módulo de la clave con el tamaño de la tabla, con el fin de que la posición no vaya a exceder el tamaño de la tabla. 
	 * A esto se le llama la aritmetica modular
	 * @param clave La clave es el número de cédula del jugador, en este caso es el DNI
	 * @return  retorna el módulo de la clave, en este caso el módulo se saca con el tamaño de la tabla
	 */
	public BigInteger aritmeticaModular (String clave) {
	BigInteger operacion = new BigInteger(clave);
	BigInteger modulo=new BigInteger(String.valueOf(this.tamTabla));
	BigInteger modResult=null;

	 modResult = operacion.mod(modulo);

		
		return modResult;
	}
	
	public String insertar (Paises pais) {
		long posicion;
		NodoPaises nuevo;

		nuevo = new NodoPaises(pais);
		posicion =(aritmeticaModular(pais.getClave()).longValue()); 
		if (this.tabla[(int) posicion]!=null){
			int aux= (int) posicion;
			
			posicion= exploracionLineal(posicion);
			JOptionPane.showMessageDialog(null, "Se ha detectado una colisión en la posición: " + aux + "\n Se ha resuelto asignando el dato en la posición: " +posicion ,"PRECAUCION", JOptionPane.WARNING_MESSAGE);
			
		}
		nuevo.siguiente= this.tabla[(int) posicion];
		this.tabla[(int) posicion] = nuevo;
		
		return String.valueOf(posicion);
	}
	
	public long exploracionLineal (long posicion){
		long indice = posicion;
		while (this.tabla[(int) indice]!= null){
			indice++;
			if (indice>=this.tamTabla)
				indice = indice%this.tamTabla;
		}
		return indice;
	}
	
	public NodoPaises buscar (String clave){
		NodoPaises aux = null;
		int posicion =  aritmeticaModular(clave).intValue();
		if (this.tabla[posicion]!= null) {
			aux=this.tabla[posicion];
		while (  (aux.siguiente!= null)  && aux.pais.getClave() != (clave)) {
			aux = aux.siguiente;
			
			if( aux.pais.getClave()!= (clave)){
				aux= null;
			}
		}
		
		}
		return aux;
	}
	
	public NodoPaises buscarXPosicion (String clave, int pos){
		NodoPaises aux = null;
		int posicion =  pos;
		if (this.tabla[posicion]!= null) {
			aux=this.tabla[posicion];
			
		while (  (aux.siguiente!= null)  && aux.pais.getClave() != (clave)) {
			aux = aux.siguiente;
			
			if( aux.pais.getClave()!= (clave)){
				aux= null;
			}
		}
		
		}
		return aux;
	}
	
	public void eliminar (String clave){
		
		int posicion =  aritmeticaModular (clave).intValue();
		if (this.tabla[posicion] != null){
			
			NodoPaises anterior = null;
			NodoPaises actual = tabla[posicion];
			
			while ( (actual.siguiente!= null) && actual.pais.getClave() != clave){
				
				anterior = actual;
				actual= actual.siguiente;
			}
			
			if ( actual.pais.getClave() != clave ){
				JOptionPane.showMessageDialog(null, "No se encuentra el elemento en la tabla", "ELEMENTO NO ENCONTRADO", JOptionPane.ERROR_MESSAGE);
			} else if (anterior == null ){
				this.tabla[posicion] = actual.siguiente;
			}else {
				anterior.siguiente= actual.siguiente;
				actual = null;
			}
		}
	}
}
