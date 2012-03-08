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
 * The Class ProvaTemps.
 */
public class ProvaTemps {

	/**
	 * The main method.
	 * 
	 * @param args the args
	 * 
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception
	{
		Prop.PS("TEST DE LA CLASSE TEMPS:\n===========================\n\n");
		
		String linea, line2;
		int h,m;
		BufferedReader teclado=new BufferedReader( new InputStreamReader(System.in));

		Prop.PS("Creem un nou Temps");
		Prop.PS("Escriu la Hora (0-23):");
		line2 = teclado.readLine();
    	h= Integer.parseInt(line2);
    	while(h>23 || h<0)
    			{
    				Prop.PS("ERROR! Format d'hora erroni! Torni a intoduir l'Hora (entre 0 i 23):");
    				line2 = teclado.readLine();
    		    	h= Integer.parseInt(line2);
    			}
		Prop.PS("Escriu els Minuts (0-59):");
		linea = teclado.readLine();
		m= Integer.parseInt(linea);
		while(m>59 || m<0)
		{
			Prop.PS("ERROR! Format de minuts erroni! Torni a introduir els Minuts (entre 0 i 59):");
			linea = teclado.readLine();
	    	m= Integer.parseInt(linea);
		}
		Temps t = new Temps(h,m);
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
            	Prop.PS(t.ToString());
            	break;
            	
            case 2:
            	Prop.PS("Hora: " + t.GetHora());
            	break;
            	
            case 3:
            	Prop.PS("Escriu la nova Hora:");
            	line2 = teclado.readLine();
            	h= Integer.parseInt(line2);
            	while(h>23 || h<0)
    			{
    				Prop.PS("ERROR! Format d'hora erroni! Torni a posar l'Hora (entre 0 i 23):");
    				line2 = teclado.readLine();
    		    	h= Integer.parseInt(line2);
    			}
            	t.SetHora(h);
            	Prop.PS("Hora actualitzada correctament");
            	break;
            	
            case 4:
            	Prop.PS("Minuts: " + t.GetMinuts());
            	break;
        
            case 5:
            	Prop.PS("Escriu els nous Minuts:");
            	line2 = teclado.readLine();
            	m= Integer.parseInt(line2);
            	while(m>59 || m<0)
        		{
        			Prop.PS("ERROR! Format de minuts erroni! Torni a introduir els Minuts (entre 0 i 59):");
        			line2 = teclado.readLine();
        	    	m= Integer.parseInt(line2);
        		}
            	t.SetMinuts(m);
            	Prop.PS("Minuts actualitzats correctament");
            	break;
            	
            case 6:
            	Prop.PS("La transformacio de la instancia temps al format PES es: "+t.TempsToPes());
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
		Prop.PS("1. Mostrar Temps");
		Prop.PS("2. Consultar Hora");
		Prop.PS("3. Modificar Hora"); 
		Prop.PS("4. Consultar Minuts");
		Prop.PS("5. Modificar Minuts");
		Prop.PS("6. Transformacio de la instancia Temps al format PES");
		Prop.PS("-1 Mostra aquest menu");
		Prop.PS("0. Sortir");
	}
}
