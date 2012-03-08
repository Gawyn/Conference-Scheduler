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
import java.io.*;
import capa2.Descans;
import capa2.Prop;

// TODO: Auto-generated Javadoc
/**
 * The Class ProvaDescans.
 */
public class ProvaDescans {
	
	/**
	 * The main method.
	 * 
	 * @param args the args
	 * 
	 * @throws Exception the exception
	 */
	public static void main (String args[]) throws Exception
    {
		Prop.PS("- TEST DE DESCANS\n==================\n");
		Prop.PS("Creem el descans");
		Prop.PS("Escriu el tipus de descans");
		String linea, line2, line3;
		BufferedReader teclado=new BufferedReader( new InputStreamReader(System.in));
		line2 = teclado.readLine();
		int min,x;
    	Prop.PS("Escriu la durada (minuts)");
    	line3= teclado.readLine(); 
    	min= Integer.parseInt(line3);
    	Descans des=new Descans(line2,min);
		Prop.PS("Creacio completada amb exit\n");
    	print(des);
    	menu();
		linea = teclado.readLine(); 
		for(int op = Integer.parseInt(linea); op != 0; op = Integer.parseInt(linea))
        {
			
            switch(op)
            {
            case 0: // '\0'
            default:
                break;

            case 1:
            	Prop.PS("Esriu el nou id:"); 
            	line2 = teclado.readLine();
            	x= Integer.parseInt(line2);
            	des.SetId(x);
            	Prop.PS("Id actualitzat");
               	break;
               	
            case 2:
            	Prop.PS("Id: "+des.GetId());
            	break;
            	
            case 3:
            	Prop.PS("Esriu la nova durada:"); 
            	line2 = teclado.readLine();
            	x= Integer.parseInt(line2);
            	des.SetDurada(x);
            	Prop.PS("Durada actualitzada");
            	break;
            	
            case 4:
            	Prop.PS("Durada: "+des.GetDuracio());
            	break;
            	
            case 5:
            	Prop.PS("Esriu el nou tipus:");
            	line2 = teclado.readLine();
            	des.SetTipus(line2);
            	Prop.PS("Tipus actualitzat");
            	break;
            	
            case 6:
            	Prop.PS("Tipus: "+des.GetTipus());
            	break;
            	
            case 7:
            	print(des);
            	Prop.PS("");
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
	 * Print.
	 * 
	 * @param d the d
	 */
	private static void print(Descans d){
		Prop.PS("Descans->"+ d.GetTipus()+ " ("+d.GetDuracio()+" min)"+ "id: "+d.GetId());
	}
	
	/**
	 * Menu.
	 */
	private static void menu(){
    	Prop.PS("");
		Prop.PS("1. Modificar Id");
		Prop.PS("2. Consultar Id");
		Prop.PS("3. Modificar durada");
		Prop.PS("4. Consultar durada");
		Prop.PS("5. Modificar tipus");
		Prop.PS("6. Consultar tipus");
		Prop.PS("7. Mostrar Descans complet");
		Prop.PS("-1 Mostra aquest menu");
		Prop.PS("0. Sortir");
	}

}
