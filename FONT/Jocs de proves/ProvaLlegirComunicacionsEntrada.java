/* PRACTICA PROP CLUSTER 6.1
 * ===================================
 * Enunciat 1: Generador d'horaris  ==
 * ===================================
 * 
 * Rosina Garcia 
 * Clemente Tort
 * Cristian Planas
 * Oscar Camacho
 * © 2006. 
 * 
 * Implementada per 
 */
package proves2;
import capa2.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ProvaLlegirComunicacionsEntrada.
 */
public class ProvaLlegirComunicacionsEntrada {

	/**
	 * The main method.
	 * 
	 * @param args the args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prop.CarregarComunicacionsDeDisc("congres-20.jp");
		Prop.LCOMToString();
		Prop.PS("TEMES\n============");
		Prop.TemesToString();

	}

}
