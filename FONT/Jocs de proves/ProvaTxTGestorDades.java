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
 * The Class ProvaTxTGestorDades.
 */
public class ProvaTxTGestorDades {

	/**
	 * The main method.
	 * 
	 * @param args the args
	 */
	public static void main(String[] args) {
		Prop.CarregarTemesDeDisc();
		Prop.PS("· Fet primera part:");
		Prop.TemesToString();
		Prop.AfegirTema(new Tema("Cerumologia"));
		Prop.TemesToString();
		Prop.GuardarTemesADisc();
	}

}


