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
 * The Class ProvaAutor.
 */
public class ProvaAutor {
	
	

	/**
	 * The main method.
	 * 
	 * @param args the args
	 * 
	 * @throws Exception the exception
	 */
	public static void main (String args[])throws Exception
	{
		String linea, line2;
		int x;
		BufferedReader teclado=new BufferedReader( new InputStreamReader(System.in));
		
		Prop.PS("- TEST D'AUTOR\n==================\n");
		System.out.println("Creem un autor");
		Prop.PS("Escriu el nom:");
		linea = teclado.readLine();
		System.out.println("Escriu el/s cognom/s:");
		line2 = teclado.readLine();
		Autor a = new Autor(linea,line2);
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
            	System.out.println(a.ToString());
            	break;
            
            case 2:
            	System.out.println(a.GetCognoms());
            	break;
            	
            case 3:
            	System.out.println("Escriu el/s nou/s cognom/s:");
            	line2 = teclado.readLine();
            	a.SetCognoms(line2);
            	System.out.println("Cognoms modificats correctament");
            	break;
            	
            case 4:
            	System.out.println(a.GetNom());
            	break;
            	
            case 5:
            	System.out.println("Escriu el nou nom:");
            	line2 = teclado.readLine();
            	a.SetNom(line2);
            	System.out.println("Nom modificat correctament");
            	break;
            	
            case 6:
            	System.out.println("Id: "+a.GetId());
            	break;
            	
            case 7: 
            	System.out.println("Escriu la nova Id:");
            	line2 = teclado.readLine();
            	x= Integer.parseInt(line2);
            	a.SetId(x);
            	System.out.println("Id modificada correctament");
            	break;
            case -1:
            	menu();
            	break;
            }
            
            linea = teclado.readLine();
        }
		
		System.out.println();
		System.out.println("-------");
		System.out.println("Fi del provador.");

	}
	
	/**
	 * Menu.
	 */
	private static void menu(){
    	Prop.PS("");
		Prop.PS("1. Mostrar Autor");
		Prop.PS("2. Consultar cognom/s");
		Prop.PS("3. Modificar cognom/s"); 
		Prop.PS("4. Consultar nom");
		Prop.PS("5. Modificar nom");
		Prop.PS("6. Consultar Id");
		Prop.PS("7. Modificar Id");    	
		Prop.PS("-1 Mostra aquest menu");
		Prop.PS("0. Sortir");
	}
	
}



