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
import java.io.BufferedReader;
import java.io.InputStreamReader;

import capa2.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ProvaProp.
 */
public class ProvaProp {
	
	

	/**
	 * The main method.
	 * 
	 * @param args the args
	 * 
	 * @throws Exception the exception
	 */
	public static void main (String args[])throws Exception
	{
		String linea, line2, line3, line4;
		int x;
		BufferedReader teclado=new BufferedReader( new InputStreamReader(System.in));
		Prop.PS("- TEST DE PROP\n==================\n");
		Prop.PS("Creem la instancia de PROP\n");
		Prop.PS("Creacio completada amb exit\n");
		menu();
		
		linea = teclado.readLine(); 
		for(int op = Integer.parseInt(linea); op != 0; op = Integer.parseInt(linea))
        {
			
            switch(op)
            {
            case 0:
                
            default:
            	break;
            
            case 1:
            	Prop.PS("Introdueixi la cadena de caracters");
            	line2=teclado.readLine();
            	Prop.PS("Introdueixi el caracter:");
            	line3 =teclado.readLine();
            	char r = line3.charAt(0);
            	Prop.PS("Introdueixi la longitud:");
            	line4=teclado.readLine();
            	x=Integer.parseInt(line4);
            	String s = Prop.LPAD(line2,r,x);
            	Prop.PS(s);
            	break;
            
            case 2:
            	String n = teclado.readLine();
            	Prop.PS(n);
            	break;
            case -1:
            	menu();
            	break;
            	
            }
            
            linea = teclado.readLine();
        }
		
		Prop.PS("");
		Prop.PS("-------");
		Prop.PS("Fi del provador.");

	}
	
	/**
	 * Menu.
	 */
	private static void menu(){
    	Prop.PS("");
		Prop.PS("1. Afegeix un caracter a la cadena introduida fins a la longitud introuida per l'esquerra");
		Prop.PS("2. Afegeix un caracter a la cadena introduida fins a la longitud introuida per la dreta");
		Prop.PS("3. Escriu el string introduit"); 
		Prop.PS("-1 Mostra aquest menu");
		Prop.PS("0. Sortir");
	}
	
}